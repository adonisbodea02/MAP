package View;

import Exceptions.My_Exception;
import Model.Aliment;
import Model.Flour;
import Model.Salt;
import Model.Sugar;
import Repository.Repository;
import Repository.Repo_Static_Array;
import Controller.Controller;

public class mainut {
    public static void main(String[] args)
    {
        Repository r = new Repo_Static_Array(10);
        Controller ctrl = new Controller(r);
        Aliment a1 = new Sugar(25, "Flanco");
        Aliment a2 = new Salt(19, "Metro");
        Aliment a3 = new Flour(21, "Selgros");
        Aliment a4 = new Salt(23, "Cora");
        Aliment a5 = new Flour(17, "Kaufland");
        try {
            ctrl.add(a1);
            ctrl.add(a2);
            ctrl.add(a3);
            ctrl.add(a4);
            ctrl.add(a5);
            System.out.print(ctrl.filter());
            System.out.print("\nNew filter: \n");
            ctrl.delete(0);
            System.out.print(ctrl.filter());
            System.out.print("\nNew filter: \n");
            ctrl.delete(19);
            System.out.print(ctrl.filter());
        }
        catch (My_Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
}
