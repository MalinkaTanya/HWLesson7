package by.itacademy;
import by.itacademy.IlluminanceLimitException;

public class Main {

    public static void main(String[] args) {

        Building building = new Building(1);
        building.addRoom(1,100,3);
        building.addRoom(2, 5,2);
        if(building.add(1, new Light(150))){} else return;;
        if(building.add(1, new Light(250))){} else return;;
        if(building.add(1, new Furniture("Стол письменный", 3))) {} else return;
        if(building.add(1, new Furniture("Кресло мягкое и пушистое", 10))){} else return;
        building.information();

    }
}
