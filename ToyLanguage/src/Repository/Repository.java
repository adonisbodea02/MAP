package Repository;

import Model.PrgState;
import java.util.List;

public interface Repository {
    List<PrgState> getPrgList();
    void setPrgList(List<PrgState> states);
    void logPrgStateExec(PrgState state);
}
