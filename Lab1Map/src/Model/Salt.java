package Model;

public class Salt implements Aliment{

    private int price;
    private String producer;

    public Salt(int price, String producer)
    {
        this.price = price;
        this.producer = producer;
    }

    @Override
    public String toString()
    {
        return "Salt producer: " + this.producer + " ,Price: " + this.price + "\n";
    }

    @Override
    public int get_price() { return this.price; }
}
