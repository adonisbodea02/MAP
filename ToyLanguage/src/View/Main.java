package View;
import Model.*;
import Model.ADTs.*;
import Model.Expressions.*;
import Model.Statements.*;
import Repository.Repository;
import Repository.SingleRepository;
import Controller.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ints = ints.stream().filter(e -> (e % 2 == 0) || (e % 3 == 0)).collect(Collectors.toList());
        List<String> ss = ints.stream().map(e -> "a" + String.valueOf(e+1) + "b").collect(Collectors.toList());
        System.out.println(ss.stream().collect(Collectors.joining()));

        System.out.println("Hello World!\n\n");

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

        IStmt example9 = new CompStmt(new AssignStmt("v", new ConstExp(10)), new CompStmt(
                new AllocHeap("a", new ConstExp(22)), new CompStmt(new ForkStmt(new CompStmt(
                        new WriteHeap("a", new ConstExp(30)), new CompStmt(new AssignStmt("v",
                        new ConstExp(32)), new CompStmt(new PrintStmt(new VarExp("v")), new PrintStmt(
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

        List<IStmt> ps = new ArrayList<>();
        ps.add(example1);
        ps.add(example2);
        ps.add(example3);
        ps.add(example5);
        ps.add(example6);
        ps.add(example7);
        ps.add(example8);
        ps.add(example9);
        String message = example7.toString();
        for(IStmt s : ps){
            if(s.toString().equals(message))
                System.out.println("Found it!\n");
        }

        //System.out.println(table1.getID());
        //System.out.println(table2.getID());
        //System.out.println(table3.getID());
        /*
        String men = "1.Input a program\n" +
                "2.One-step evaluation\n" +
                "3.Complete evaluation of program\n";

        String inputMenu = "1. v=2;Print(v)\n" +
                "2. a=2+3*5;b=a+1;Print(b)\n" +
                "3. a=2-2;(If a Then v=2 Else v=3);Print(v)\n";
        */
        String command4 = "openRFile(f,\"test.in\");\n" +
                "\t   readFile(f,c);print(c);\n" +
                "\t   (if c then readFile(f,c);print(c)\n" +
                "\t   else print(0));\n" +
                "\t   closeRFile(f)";
        String command5 = "openRFile(f,\"test.in\");\n" +
                "\t   readFile(f+2,c);print(c);\n" +
                "\t   (if c then readFile(f,c);print(c)\n" +
                "\t   else print(0));\n" +
                "\t   closeRFile(f)";

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "Exit"));
        menu.addCommand(new RunExample("1", "v=2;Print(v)", c1));
        menu.addCommand(new RunExample("2", "a=2+3*5;b=a+1;Print(b)", c2));
        menu.addCommand(new RunExample("3", "a=2-2;(If a Then v=2 Else v=3);Print(v)", c3));
        menu.addCommand(new RunExample("4", command4, c4));
        menu.addCommand(new RunExample("5", command5, c5));
        menu.addCommand(new RunExample("6", "v=10;new(v,20);new(a,22);wH(a,30);print(a);print(rH(a))", c6));
        menu.addCommand(new RunExample("7", "v=10;new(v,20);new(a,22);wH(a,30);print(a);print(rH(a));a=0", c7));
        menu.addCommand(new RunExample("8", "v=5+(10>8); (while (v-4) print(v);v=v-1);print(v)", c8));
        menu.addCommand(new RunExample("9", "v=10; new(a,22);\n\t   fork(wH(a,30); v=32; print(v); print(rH(a)));\n\t   print(v); print(rH(a))", c9));
        menu.show();

        /*
        Scanner reader = new Scanner(System.in);
        Scanner reader2 = new Scanner(System.in);
        int option;
        int option2 = 1;
        boolean running = true;
        while(running) {
            try {
                System.out.println(menu);
                System.out.println("Choose an option: ");
                option = reader.nextInt();
                if(option == 1)
                {
                    System.out.println(inputMenu);
                    System.out.println("Choose an option: ");
                    option2 = reader.nextInt();
                }
                if(option == 2)
                {
                    if(option2 == 1)
                        c1.oneStep();
                    else
                        if(option2 == 2)
                            c2.oneStep();
                        else
                            if(option2 == 3)
                                c3.oneStep();
                            else
                                if(option2 == 4)
                                    c4.oneStep();
                                else
                                    if(option2 == 5)
                                        c5.oneStep();
                }
                if(option == 3)
                {
                    if(option2 == 1)
                        c1.allSteps();
                    else
                        if(option2 == 2)
                            c2.allSteps();
                        else
                            if(option2 == 3)
                                c3.allSteps();
                            else
                                if(option2 == 4)
                                    c4.allSteps();
                                else
                                    if(option2 == 5)
                                        c5.allSteps();
                }
                if(option == 0)
                    running = false;
            }
            catch (MyDictionaryException|MyQueueException|MyStackException|MyArithmeticException|MyStmtExecException|MyOpenReadFileException e){
                System.out.println(e.getMessage());
            }
        }
        reader.close();
        reader2.close();
     */
    }
}
