package by.itacademy;

import java.util.ArrayList;
import java.util.List;

public class Building implements BuildingInterface {
    private int index;
    private List<Room> listRooms = new ArrayList<Room>();

    public Building(int index) {
        this.index = index;
    }

    @Override
    public void addRoom(int index, int area, int windows) {
        Room room = new Room(area, windows);
        listRooms.add(index - 1, room);
    }

    @Override
    public boolean add(int index, Furniture furniture) {
        Room room = listRooms.get(index - 1);
        boolean resalt = true;
        try {
            room.addFurniture(furniture);
        } catch (SpaceLimitException e) {
            System.out.println(e.getMessage());
            resalt = false;
        }
        return resalt;
    }

    @Override
    public boolean add(int index, Light light) {
        Room room = listRooms.get(index - 1);
        boolean resalt = true;
        try {
            room.addLight(light);
        } catch (IlluminanceLimitException e) {
            System.out.println(e.getMessage());
            resalt = false;
        }
        return resalt;
    }

    public void information() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String info = "Здание " + this.index;

        for (int i = 0; i < listRooms.size(); i++) {
            Room room = listRooms.get(i);

            info += "\nКомната " + (i + 1) + "\n"
                    + "Освещённость = " + room.getIllumination() + " (" + room.getWindows() + " окна по 700 лк";

            List<Light> listLight = room.getListLight();
            if (listLight.size() != 0) info += ", лампочки ";

            for (int j = 0; j < listLight.size(); j++) {
                info += listLight.get(j).getIllumination() + " лк";
                if (j < listLight.size() - 1) info += " и ";
            }
            info += ")";

            double freeArea = room.getArea() - room.getAreaFurniture();

            info += "\nПлощадь = " + room.getArea() + " м^2 (занято " + room.getAreaFurniture() + " м^2, свободно " + (room.getArea() - room.getAreaFurniture()) + " м^2 или " +
                    (freeArea / room.getArea() * 100) + "% площади)";

            List<Furniture> listFurniture = room.getListFurniture();
            if (listFurniture.size() == 0) {
                info += "\nМебели нет";
            } else {
                info += "\nМебель:";
            }
            for (Furniture furniture : listFurniture) {
                info += "\n" + furniture.getName() + " (площадь " + furniture.getArea() + " м^2)";
            }

        }

        return info;
    }
}
