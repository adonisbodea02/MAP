package Controller;

import Model.ADTs.MyIDictionary;
import Model.PrgState;
import Repository.Repository;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Ctrl {

    private Repository repo;

    private ExecutorService executor;

    public Ctrl(Repository repo){
        this.repo = repo;
    }

    private List<PrgState> removeCompletedPrg(List<PrgState> inPrgList){
        return inPrgList.stream().filter(p->!p.isCompleted()).collect(Collectors.toList());
    }

    private Map<Integer, Integer> conservativeGarbageCollector(Collection<Integer> symTable, MyIDictionary<Integer, Integer> heap){
        return heap.entrySet().stream()
                .filter(e->symTable.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public void allSteps(){
        executor = Executors.newFixedThreadPool(2);
        List<PrgState> prgList = removeCompletedPrg(repo.getPrgList());
        prgList.forEach(prg->repo.logPrgStateExec(prg));
        while(prgList.size() > 0){
            oneStepForAllPrg(prgList);
            boolean ok = true;
            for(PrgState p: prgList){
                Map<Integer, Integer> m = conservativeGarbageCollector(p.getSymTable().getValues(), p.getHeap());
                if(p.getHeap().size() == m.size()) {
                    ok = false;
                    break;
                }
            }
            if(ok) {
                prgList.forEach(p -> {
                    Map<Integer, Integer> m = conservativeGarbageCollector(p.getSymTable().getValues(), p.getHeap());
                    p.getHeap().clear();
                    p.getHeap().putAll(m);
                });
            }
            prgList = removeCompletedPrg(repo.getPrgList());
        }

        executor.shutdownNow();
        repo.getPrgList().get(0).getFileTable().entrySet().forEach(k->{
                try{
                    k.getValue().getFileDescriptor().close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            });
        repo.getPrgList().get(0).getFileTable().clear();
        repo.getPrgList().forEach(prg->repo.logPrgStateExec(prg));
        repo.setPrgList(prgList);
    }

    private void oneStepForAllPrg(List<PrgState> prgList) {
        //prgList.forEach(prg -> repo.logPrgStateExec(prg));

        List<Callable<PrgState>> callList = prgList.stream()
                .map((PrgState p) -> (Callable<PrgState>) (p::oneStep))
                .collect(Collectors.toList());

        List<PrgState> newPrgList = null;

        try {
            newPrgList = executor.invokeAll(callList).stream().map(future -> {
                try {
                    return future.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }).filter(Objects::nonNull).collect(Collectors.toList());
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        if(newPrgList != null) {
            prgList.addAll(newPrgList);
            prgList.forEach(prg->repo.logPrgStateExec(prg));
            repo.setPrgList(prgList);
        }
    }
}

