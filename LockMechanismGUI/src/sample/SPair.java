package sample;

import java.util.List;

public class SPair {
    private int address;
    private int value;
    private List<Integer> content;

    public SPair(int address, int value, List<Integer> content){
        this.address = address;
        this.content = content;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public List<Integer> getContent() {
        return content;
    }

    public void setContent(List<Integer> content) {
        this.content = content;
    }
}
