package by.itacademy;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int area;
    private int windows;
    private List<Furniture> listFurniture = new ArrayList<Furniture>();
    private List<Light> listLight = new ArrayList<Light>();

    public Room(int area, int windows) {
        this.area = area;
        this.windows = windows;
    }

    public void addFurniture(Furniture furniture) throws SpaceLimitException {
        double areaFurniture = getAreaFurniture() + furniture.getArea();
        if (areaFurniture/getArea()*100 > 70)
            throw new SpaceLimitException("Превышенна площадь заполнения комнаты!");
        else listFurniture.add(furniture);
    }

    public void addLight(Light light) throws IlluminanceLimitException {

        if (getIllumination()+ light.getIllumination() > 4000)
            throw new IlluminanceLimitException("Освещенность превышена!");
        else listLight.add(light);
    }

    public int getIllumination() {
        int allIllumination = 0;

        for (Light light : listLight) {
            allIllumination += light.getIllumination();
        }
        allIllumination += this.windows * 700;

        return allIllumination;
    }

    public int getAreaFurniture() {
        int areaFurniture = 0;

        for (Furniture furniture : listFurniture) {
            areaFurniture += furniture.getArea();
        }

        return areaFurniture;
    }

    public List<Furniture> getListFurniture() {
        return this.listFurniture;
    }

    public List<Light> getListLight() {
        return this.listLight;
    }

    public int getArea() {
        return this.area;
    }

    public int getWindows() {
        return this.windows;
    }
}
