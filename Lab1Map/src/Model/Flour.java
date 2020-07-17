package Model;

public class Flour implements Aliment{

    private int price;
    private String producer;

    public Flour(int price, String producer)
    {
        this.price = price;
        this.producer = producer;
    }

    @Override
    public String toString()
    {
        return "Flour producer: " + this.producer + " ,Price: " + this.price + "\n";
    }

    @Override
    public int get_price() { return this.price; }
}

//mosteneste runtime expception