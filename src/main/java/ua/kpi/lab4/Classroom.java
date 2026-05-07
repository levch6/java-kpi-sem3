package ua.kpi.lab4;

public class Classroom {
    private int number;
    private int capacity;
    private String type;
    private int floor;
    private boolean hasProjector;

    public Classroom(int number, int capacity, String type, int floor, boolean hasProjector) {
        this.number = number;
        this.capacity = capacity;
        this.type = type;
        this.floor = floor;
        this.hasProjector = hasProjector;
    }

    public int getNumber() { return number; }
    public int getCapacity() { return capacity; }
    public String getType() { return type; }
    public int getFloor() { return floor; }
    public boolean isHasProjector() { return hasProjector; }

    public String getInfo() {
        return "Аудиторія №" + number + " (" + type + "), місць: " + capacity;
    }
}