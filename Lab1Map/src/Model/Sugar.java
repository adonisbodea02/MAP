package Model;

public class Sugar implements Aliment{

    private int price;
    private String producer;

    public Sugar(int price, String producer)
    {
        this.price = price;
        this.producer = producer;
    }

    @Override
    public String toString()
    {
        return "Sugar producer: " + this.producer + " ,Price: " + this.price + "\n";
    }

    @Override
    public int get_price() { return this.price; }
}
