package sample;

import Model.ADTs.*;
import Model.Expressions.*;
import Model.FileTuple;
import Model.PrgState;
import Model.Statements.*;
import Repository.*;
import Controller.Ctrl;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main extends Application {

    private Stage window;
    private Scene s1, s2;
    private Ctrl selectedCtrl;
    private ObservableList<Ctrl> programs;
    private ListView<String> programsStrings;
    private TextField programsNumber;
    private TableView<HeapPair> heap;
    private TableView<TablePair> filetable;
    private TableView<TablePair> symTable;
    private ListView<String> stack;
    private ListView<String> output;
    private ListView<String> programStates;
    private Label fileTableLabel = new Label();
    private Label heapLabel = new Label();
    private Label symTableLabel = new Label();
    private Label stackLabel = new Label();
    private Label outputLabel = new Label();
    private Label programStatesLabel = new Label();

    @Override
    public void start(Stage primaryStage){

        IStmt example1 = new CompStmt(new AssignStmt("v",
                new ConstExp(2)), new PrintStmt(new VarExp("v")));

        MyIStack<IStmt> stack1 = new MyStack<>();
        stack1.push(example1);
        MyIDictionary<String, Integer> table1 = new MyDictionary<>();
        MyIQueue<Integer> output1 = new MyQueue<>();
        MyIDictionary<Integer, FileTuple> filetable1 = new MyDictionary<>();
        MyIDictionary<Integer, Integer> heap1 = new MyDictionary<>();
        PrgState program1 = new PrgState(stack1, table1, output1, filetable1, heap1, 1);

        Repository r1 = new SingleRepository(program1, "A:\\UBB\\2nd_Year\\MAP\\Labs\\program1.txt");
        Ctrl c1 = new Ctrl(r1);
        c1.setOriginalProgram(example1.toString());

        IStmt example2 = new CompStmt(new AssignStmt("a",
                new ArithExp(new ConstExp(2), new ArithExp(new ConstExp(3),
                        new ConstExp(5), 4), 1)),
                new CompStmt(new AssignStmt("b", new ArithExp(new VarExp("a"),
                        new ConstExp(1), 1)), new PrintStmt(new VarExp("b"))));

        MyIStack<IStmt> stack2 = new MyStack<>();
        stack2.push(example2);
        MyIDictionary<String, Integer> table2 = new MyDictionary<>();
        MyIQueue<Integer> output2 = new MyQueue<>();
        MyIDictionary<Integer, FileTuple> filetable2 = new MyDictionary<>();
        MyIDictionary<Integer, Integer> heap2 = new MyDictionary<>();
        PrgState program2 = new PrgState(stack2, table2, output2, filetable2, heap2, 2);

        Repository r2 = new SingleRepository(program2, "A:\\UBB\\2nd_Year\\MAP\\Labs\\program2.txt");
        Ctrl c2 = new Ctrl(r2);
        c2.setOriginalProgram(example2.toString());

        IStmt example3 = new CompStmt(new AssignStmt("a", new ArithExp(new ConstExp(2),
                new ConstExp(2), 2)), new CompStmt(new IfStmt(new VarExp("a"),
                new AssignStmt("v", new ConstExp(3)), new AssignStmt("v",
                new ConstExp(2))), new PrintStmt(new VarExp("v"))));

        MyIStack<IStmt> stack3 = new MyStack<>();
        stack3.push(example3);
        MyIDictionary<String, Integer> table3 = new MyDictionary<>();
        MyIQueue<Integer> output3 = new MyQueue<>();
        MyIDictionary<Integer, FileTuple> filetable3 = new MyDictionary<>();
        MyIDictionary<Integer, Integer> heap3 = new MyDictionary<>();
        PrgState program3 = new PrgState(stack3, table3, output3, filetable3, heap3, 3);

        Repository r3 = new SingleRepository(program3, "A:\\UBB\\2nd_Year\\MAP\\Labs\\program3.txt");
        Ctrl c3 = new Ctrl(r3);
        c3.setOriginalProgram(example3.toString());

        IStmt example4 = new CompStmt(new OpenReadFile("A:\\UBB\\2nd_Year\\MAP\\Labs\\test.in", "f"),
                new CompStmt(new ReadFile(new VarExp("f"), "c"), new CompStmt(new PrintStmt(
                        new VarExp("c")), new CompStmt(new IfStmt(new VarExp("c"), new CompStmt(
                        new ReadFile(new VarExp("f"), "c"), new PrintStmt(new VarExp("c"))),
                        new PrintStmt(new ConstExp(0))), new CloseReadFile(new VarExp("f"))))));


        MyIStack<IStmt> stack4 = new MyStack<>();
        stack4.push(example4);
        MyIDictionary<String, Integer> table4 = new MyDictionary<>();
        MyIQueue<Integer> output4 = new MyQueue<>();
        MyIDictionary<Integer, FileTuple> filetable4 = new MyDictionary<>();
        MyIDictionary<Integer, Integer> heap4 = new MyDictionary<>();
        PrgState program4 = new PrgState(stack4, table4, output4, filetable4, heap4, 4);

        Repository r4 = new SingleRepository(program4, "A:\\UBB\\2nd_Year\\MAP\\Labs\\program4.txt");
        Ctrl c4 = new Ctrl(r4);
        c4.setOriginalProgram(example4.toString());

        IStmt example5 = new CompStmt(new OpenReadFile("A:\\UBB\\2nd_Year\\MAP\\Labs\\test.in", "f"),
                new CompStmt(new ReadFile(new ArithExp(new VarExp("f"), new ConstExp(2), 1), "c"),
                        new CompStmt(new PrintStmt(new VarExp("c")), new CompStmt(new IfStmt(new VarExp("c"),
                                new CompStmt(new ReadFile(new VarExp("f"), "c"),
                                        new PrintStmt(new VarExp("c"))), new PrintStmt(new ConstExp(0))),
                                new CloseReadFile(new VarExp("f"))))));


        MyIStack<IStmt> stack5 = new MyStack<>();
        stack5.push(example5);
        MyIDictionary<String, Integer> table5 = new MyDictionary<>();
        MyIQueue<Integer> output5 = new MyQueue<>();
        MyIDictionary<Integer, FileTuple> filetable5 = new MyDictionary<>();
        MyIDictionary<Integer, Integer> heap5 = new MyDictionary<>();
        PrgState program5 = new PrgState(stack5, table5, output5, filetable5, heap5, 5);

        Repository r5 = new SingleRepository(program5, "A:\\UBB\\2nd_Year\\MAP\\Labs\\program5.txt");
        Ctrl c5 = new Ctrl(r5);
        c5.setOriginalProgram(example5.toString());

        IStmt example6 = new CompStmt(new AssignStmt("v", new ConstExp(10)), new CompStmt(
                new AllocHeap("v", new ConstExp(20)), new CompStmt(new AllocHeap("a",
                new ConstExp(22)), new CompStmt(new WriteHeap("a", new ConstExp(30)),
                new CompStmt(new PrintStmt(new VarExp("a")), new PrintStmt(new ReadHeapExp("a")))))));

        MyIStack<IStmt> stack6 = new MyStack<>();
        stack6.push(example6);
        MyIDictionary<String, Integer> table6 = new MyDictionary<>();
        MyIQueue<Integer> output6 = new MyQueue<>();
        MyIDictionary<Integer, FileTuple> filetable6 = new MyDictionary<>();
        MyIDictionary<Integer, Integer> heap6 = new MyDictionary<>();
        PrgState program6 = new PrgState(stack6, table6, output6, filetable6, heap6, 6);

        Repository r6 = new SingleRepository(program6, "A:\\UBB\\2nd_Year\\MAP\\Labs\\program6.txt");
        Ctrl c6 = new Ctrl(r6);
        c6.setOriginalProgram(example6.toString());

        IStmt example7 = new CompStmt(new AssignStmt("v", new ConstExp(10)), new CompStmt(
                new AllocHeap("v", new ConstExp(20)), new CompStmt(new AllocHeap("a",
                new ConstExp(22)), new CompStmt(new WriteHeap("a", new ConstExp(30)),
                new CompStmt(new PrintStmt(new VarExp("a")), new CompStmt(new PrintStmt(new ReadHeapExp("a")),
                        new AssignStmt("a", new ConstExp(0))))))));

        MyIStack<IStmt> stack7 = new MyStack<>();
        stack7.push(example7);
        MyIDictionary<String, Integer> table7 = new MyDictionary<>();
        MyIQueue<Integer> output7 = new MyQueue<>();
        MyIDictionary<Integer, FileTuple> filetable7 = new MyDictionary<>();
        MyIDictionary<Integer, Integer> heap7 = new MyDictionary<>();
        PrgState program7 = new PrgState(stack7, table7, output7, filetable7, heap7, 7);

        Repository r7 = new SingleRepository(program7, "A:\\UBB\\2nd_Year\\MAP\\Labs\\program7.txt");
        Ctrl c7 = new Ctrl(r7);
        c7.setOriginalProgram(example7.toString());

        IStmt example8 = new CompStmt(new AssignStmt("v", new ArithExp(new ConstExp(5),
                new Greater(new ConstExp(10), new ConstExp(8), 1), 1)), new CompStmt(new WhileStmt(
                new CompStmt(new PrintStmt(new VarExp("v")), new AssignStmt("v",
                        new ArithExp(new VarExp("v"), new ConstExp(1), 2))),
                new ArithExp(new VarExp("v"), new ConstExp(4), 2)), new PrintStmt(new VarExp("v"))));

        MyIStack<IStmt> stack8 = new MyStack<>();
        stack8.push(example8);
        MyIDictionary<String, Integer> table8 = new MyDictionary<>();
        MyIQueue<Integer> output8 = new MyQueue<>();
        MyIDictionary<Integer, FileTuple> filetable8 = new MyDictionary<>();
        MyIDictionary<Integer, Integer> heap8 = new MyDictionary<>();
        PrgState program8 = new PrgState(stack8, table8, output8, filetable8, heap8, 8);

        Repository r8 = new SingleRepository(program8, "A:\\UBB\\2nd_Year\\MAP\\Labs\\program8.txt");
        Ctrl c8 = new Ctrl(r8);
        c8.setOriginalProgram(example8.toString());

        IStmt example9 = new CompStmt(new AssignStmt("v", new ConstExp(10)), new CompStmt(
                new AllocHeap("a", new ConstExp(22)), new CompStmt(new ForkStmt(new CompStmt(
                new AssignStmt("v",
                        new ConstExp(32)), new CompStmt(new WriteHeap("a", new ConstExp(30)), new CompStmt(new PrintStmt(new VarExp("v")), new PrintStmt(
                new ReadHeapExp("a")))))), new CompStmt(new PrintStmt(new VarExp("v")),
                new PrintStmt(new ReadHeapExp("a"))))));

        MyIStack<IStmt> stack9 = new MyStack<>();
        stack9.push(example9);
        MyIDictionary<String, Integer> table9 = new MyDictionary<>();
        MyIQueue<Integer> output9 = new MyQueue<>();
        MyIDictionary<Integer, FileTuple> filetable9 = new MyDictionary<>();
        MyIDictionary<Integer, Integer> heap9 = new MyDictionary<>();
        PrgState program9 = new PrgState(stack9, table9, output9, filetable9, heap9, 1);

        Repository r9 = new SingleRepository(program9, "A:\\UBB\\2nd_Year\\MAP\\Labs\\program9.txt");
        Ctrl c9 = new Ctrl(r9);
        c9.setOriginalProgram(example9.toString());

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ToyLanguageGUI");

        //initial configuration
        programsStrings = new ListView<>();

        programs = FXCollections.observableArrayList();
        programs.addAll(c1,c2,c3,c4,c5,c6,c7,c8,c9);

        for (Ctrl c: programs) {
            programsStrings.getItems().add(c.getOriginalProgram());
        }

        window = primaryStage;

        //configure scene1
        Button forth = new Button();
        forth.setText("Run program");

        VBox layout1 = new VBox();
        layout1.getChildren().addAll(programsStrings, forth);

        s1 = new Scene(layout1, 500, 500);

        //configure scene2
        heapLabel.setText("Heap");
        fileTableLabel.setText("File Table");
        symTableLabel.setText("Symbol Table");

        //configure heap table
        heap = new TableView<>();

        TableColumn<HeapPair, Integer> columnHeapAddress = new TableColumn<>("Address");
        columnHeapAddress.setMinWidth(50);
        columnHeapAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<HeapPair, Integer> columnHeapValue = new TableColumn<>("Value");
        columnHeapValue.setMinWidth(50);
        columnHeapValue.setCellValueFactory(new PropertyValueFactory<>("value"));

        heap.getColumns().addAll(columnHeapAddress, columnHeapValue);

        //configure symbol table
        symTable = new TableView<>();

        TableColumn<TablePair, String> columnSymTableVariable = new TableColumn<>("Variable");
        columnSymTableVariable.setMinWidth(50);
        columnSymTableVariable.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<TablePair, Integer> columnSymTableValue = new TableColumn<>("Value");
        columnSymTableValue.setMinWidth(50);
        columnSymTableValue.setCellValueFactory(new PropertyValueFactory<>("number"));

        symTable.getColumns().addAll(columnSymTableVariable, columnSymTableValue);

        //configure file table
        filetable = new TableView<>();

        TableColumn<TablePair, String> columnFileTableIdentifier = new TableColumn<>("Identifier");
        columnFileTableIdentifier.setMinWidth(50);
        columnFileTableIdentifier.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<TablePair, Integer> columnFileTableFileName = new TableColumn<>("File name");
        columnFileTableFileName.setMinWidth(50);
        columnFileTableFileName.setCellValueFactory(new PropertyValueFactory<>("name"));

        filetable.getColumns().addAll(columnFileTableIdentifier, columnFileTableFileName);

        //configure exeStack
        stack = new ListView<>();
        stackLabel.setText("Execution Stack");

        //configure outQueue
        output = new ListView<>();
        outputLabel.setText("Output Queue");

        programStates = new ListView<>();
        programStatesLabel.setText("Program States");

        programsNumber = new TextField();

        Button step = new Button();
        step.setText("One Step");

        Button back = new Button();
        back.setText("Back");

        VBox layout2 = new VBox();
        layout2.setMaxSize(100,100);
        layout2.getChildren().addAll(programsNumber,stackLabel,stack,programStatesLabel,programStates,heapLabel,heap,symTableLabel,symTable,fileTableLabel,filetable,outputLabel,output,step,back);

        s2 = new Scene(layout2, 400, 600);

        forth.setOnAction(actionEvent -> runProgramButton());
        step.setOnAction(actionEvent -> runOneStepButton());
        back.setOnAction(actionEvent -> window.setScene(s1));
        programStates.setOnMouseClicked(actionEvent -> setProgramState());

        window.setScene(s1);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void runProgramButton(){
        window.setScene(s2);
        filetable.getItems().clear();
        symTable.getItems().clear();
        heap.getItems().clear();
        stack.getItems().clear();
        output.getItems().clear();
        programStates.getItems().clear();
        selectedCtrl = getSelectedController();
        if(selectedCtrl == null)
            AlertBox.display("Warning","No program selected!");
        else {
            if (selectedCtrl.getRepo().getPrgList().size() == 0)
                AlertBox.display("Warning", "This program was already executed!");
            else {
                Repository r = selectedCtrl.getRepo();
                MyIStack<IStmt> exeStack = r.getPrgList().get(0).getStack();
                MyIStack<IStmt> stack2 = new MyStack<>();
                while (!exeStack.isEmpty()) {
                    IStmt stmt = exeStack.pop();
                    stack.getItems().add(stmt.toString());
                    stack2.push(stmt);
                }
                while (!stack2.isEmpty()) {
                    exeStack.push(stack2.pop());
                }
                for (PrgState ps : r.getPrgList())
                    programStates.getItems().add(ps.toString());

                programsNumber.setText(String.valueOf(r.getPrgList().get(0).getID()));
            }
        }
    }

    private Ctrl getSelectedController(){
        for(Ctrl c: programs) {
            if(c.getOriginalProgram().equals(programsStrings.getSelectionModel().getSelectedItem()))
                return c;
        }
        return null;
    }

    private void runOneStepButton(){
        List<PrgState> prgList = selectedCtrl.removeCompletedPrg(selectedCtrl.getRepo().getPrgList());
        prgList.forEach(prg->selectedCtrl.getRepo().logPrgStateExec(prg));
        if(prgList.size() > 0){
            selectedCtrl.oneStepForAllPrg(prgList);
            boolean ok = true;
            for(PrgState p: prgList){
                Map<Integer, Integer> m = selectedCtrl.conservativeGarbageCollector(p.getSymTable().getValues(), p.getHeap());
                if(p.getHeap().size() == m.size()) {
                    ok = false;
                    break;
                }
            }
            if(ok) {
                prgList.forEach(p -> {
                    Map<Integer, Integer> m = selectedCtrl.conservativeGarbageCollector(p.getSymTable().getValues(), p.getHeap());
                    p.getHeap().clear();
                    p.getHeap().putAll(m);
                });
            }

            filetable.getItems().clear();
            symTable.getItems().clear();
            heap.getItems().clear();
            stack.getItems().clear();
            output.getItems().clear();
            programStates.getItems().clear();

            Repository r = selectedCtrl.getRepo();
            MyIStack<IStmt> exeStack = r.getPrgList().get(0).getStack();
            MyIStack<IStmt> stack2 = new MyStack<>();
            while(!exeStack.isEmpty()){
                IStmt stmt = exeStack.pop();
                stack.getItems().add(stmt.toString());
                stack2.push(stmt);
            }

            while(!stack2.isEmpty()){
                exeStack.push(stack2.pop());
            }

            MyIQueue<Integer> out = r.getPrgList().get(0).getOutput();
            MyIQueue<Integer> out2 = new MyQueue<>();
            while(!out.isEmpty()){
                int s = out.deque();
                output.getItems().add(String.valueOf(s));
                out2.enqueue(s);
            }

            while(!out2.isEmpty()){
                out.enqueue(out2.deque());
            }

            for(PrgState ps : r.getPrgList())
                programStates.getItems().add(ps.toString());

            ObservableList<HeapPair> hps = FXCollections.observableArrayList();
            for(int key : r.getPrgList().get(0).getHeap().getKeys()){
                hps.add(new HeapPair(key, r.getPrgList().get(0).getHeap().lookup(key)));
            }
            heap.setItems(hps);

            ObservableList<TablePair> sts = FXCollections.observableArrayList();
            for(String key : r.getPrgList().get(0).getSymTable().getKeys()){
                sts.add(new TablePair(r.getPrgList().get(0).getSymTable().lookup(key), key));
            }

            symTable.setItems(sts);

            ObservableList<TablePair> fts = FXCollections.observableArrayList();
            for(int key : r.getPrgList().get(0).getFileTable().getKeys()){
                fts.add(new TablePair(key, r.getPrgList().get(0).getFileTable().lookup(key).getFilename()));
            }
            filetable.setItems(fts);

            prgList = selectedCtrl.removeCompletedPrg(selectedCtrl.getRepo().getPrgList());

            if(prgList.size() == 0){
                selectedCtrl.getExecutor().shutdownNow();
                selectedCtrl.getRepo().getPrgList().get(0).getFileTable().entrySet().forEach(k -> {
                    try {
                        k.getValue().getFileDescriptor().close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                selectedCtrl.getRepo().getPrgList().get(0).getFileTable().clear();
                selectedCtrl.getRepo().getPrgList().forEach(prg -> selectedCtrl.getRepo().logPrgStateExec(prg));
                selectedCtrl.getRepo().setPrgList(prgList);
            }
            selectedCtrl.getRepo().setPrgList(prgList);
        }
        else {
            AlertBox.display("Warning", "Program is finished!");
        }
    }

    private PrgState getSelectedPrgState(){
        for(PrgState p: selectedCtrl.getRepo().getPrgList()) {
            if(p.toString().equals(programStates.getSelectionModel().getSelectedItem()))
                return p;
        }
        return null;
    }

    private void setProgramState(){
        if(getSelectedPrgState() == null)
            AlertBox.display("Error", "The thread already finished!");
        else {
            programsNumber.setText(String.valueOf(getSelectedPrgState().getID()));

            filetable.getItems().clear();
            symTable.getItems().clear();
            heap.getItems().clear();
            stack.getItems().clear();
            output.getItems().clear();

            MyIStack<IStmt> exeStack = getSelectedPrgState().getStack();
            MyIStack<IStmt> stack2 = new MyStack<>();
            while (!exeStack.isEmpty()) {
                IStmt stmt = exeStack.pop();
                stack.getItems().add(stmt.toString());
                stack2.push(stmt);
            }

            while (!stack2.isEmpty()) {
                exeStack.push(stack2.pop());
            }

            MyIQueue<Integer> out = getSelectedPrgState().getOutput();
            MyIQueue<Integer> out2 = new MyQueue<>();
            while (!out.isEmpty()) {
                int s = out.deque();
                output.getItems().add(String.valueOf(s));
                out2.enqueue(s);
            }

            while (!out2.isEmpty()) {
                out.enqueue(out2.deque());
            }

            ObservableList<HeapPair> hps = FXCollections.observableArrayList();
            for (int key : getSelectedPrgState().getHeap().getKeys()) {
                hps.add(new HeapPair(key, getSelectedPrgState().getHeap().lookup(key)));
            }
            heap.setItems(hps);

            ObservableList<TablePair> sts = FXCollections.observableArrayList();
            for (String key : getSelectedPrgState().getSymTable().getKeys()) {
                sts.add(new TablePair(getSelectedPrgState().getSymTable().lookup(key), key));
            }

            symTable.setItems(sts);

            ObservableList<TablePair> fts = FXCollections.observableArrayList();
            for (int key : getSelectedPrgState().getFileTable().getKeys()) {
                fts.add(new TablePair(key, getSelectedPrgState().getFileTable().lookup(key).getFilename()));
            }
            filetable.setItems(fts);
        }
    }
}
