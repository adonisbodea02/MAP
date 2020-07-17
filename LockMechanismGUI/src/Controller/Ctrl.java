package Controller;

import Model.ADTs.MyIDictionary;
import Model.PrgState;
import Repository.Repository;
import sample.AlertBox;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Ctrl {

    private Repository repo;

    private String originalProgram;

    public String getOriginalProgram() {
        return originalProgram;
    }

    public void setOriginalProgram(String originalProgram) {
        this.originalProgram = originalProgram;
    }

    public Repository getRepo() {
        return repo;
    }

    private ExecutorService executor = Executors.newFixedThreadPool(2);

    public ExecutorService getExecutor() {
        return executor;
    }

    public Ctrl(Repository repo){
        this.repo = repo;
    }

    public List<PrgState> removeCompletedPrg(List<PrgState> inPrgList){
        return inPrgList.stream().filter(p->!p.isCompleted()).collect(Collectors.toList());
    }

    public Map<Integer, Integer> conservativeGarbageCollector(Collection<Integer> symTable, MyIDictionary<Integer, Integer> heap){
        return heap.entrySet().stream()
                .filter(e->symTable.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public void oneStepForAllPrg(List<PrgState> prgList) {
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
                    AlertBox.display("Exception", e.getMessage());
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

