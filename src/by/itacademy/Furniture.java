package by.itacademy;

public class Furniture {
    private String name;
    private int area;

    public Furniture(String name, int area) {
        this.name = name;
        this.area = area;
    }

    public String getName(){
     return this.name;
    }

    public int getArea(){
        return this.area;
    }
}
