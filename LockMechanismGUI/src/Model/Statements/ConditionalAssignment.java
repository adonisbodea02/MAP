package Model.Statements;

import Model.Expressions.Exp;
import Model.PrgState;

public class ConditionalAssignment implements IStmt {

    private Exp e1;
    private Exp e2;
    private Exp e3;
    private String variable;

    public ConditionalAssignment(Exp e1, Exp e2, Exp e3, String variable){
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
        this.variable = variable;
    }

    @Override
    public PrgState execute(PrgState state) {
        IfStmt s = new IfStmt(e1, new AssignStmt(variable, e2), new AssignStmt(variable, e3));
        state.getStack().push(s);
        return null;
    }

    @Override
    public String toString() {
        return variable + "=" + e1.toString() + "?" + e2.toString() + ":" + e3.toString() + ";";
    }
}
