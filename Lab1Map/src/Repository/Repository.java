package Repository;

import Model.Aliment;

public interface Repository {
    void add(Aliment a);
    void delete(int pos);
    String filter();
}
