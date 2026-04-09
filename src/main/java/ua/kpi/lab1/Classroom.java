package ua.kpi.lab1;

public class Classroom {

    // Class fields (encapsulation - all private)
    private int number;
    private int capacity;
    private String type;
    private int floor;
    private boolean hasProjector;

    // Class fields (encapsulation - all private)
    private static int totalClassrooms = 0;

    // The default constructor
    public Classroom() {
        this.number = 0;
        this.capacity = 0;
        this.type = "невідомий";
        this.floor = 1;
        this.hasProjector = false;
        totalClassrooms++;
    }

    // Designer with parameters (without projector)
    public Classroom(int number, int capacity, String type, int floor) {
        this.number = number;
        this.capacity = capacity;
        this.type = type;
        this.floor = floor;
        this.hasProjector = false;
        totalClassrooms++;
    }

    // Constructor with all parameters
    public Classroom(int number, int capacity, String type, int floor, boolean hasProjector) {
        this.number = number;
        this.capacity = capacity;
        this.type = type;
        this.floor = floor;
        this.hasProjector = hasProjector;
        totalClassrooms++;
    }

    // Accessor methods (getters/setters)
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getFloor() { return floor; }
    public void setFloor(int floor) { this.floor = floor; }

    public boolean isHasProjector() { return hasProjector; }
    public void setHasProjector(boolean hasProjector) { this.hasProjector = hasProjector; }

    // Static method - does not require an instance of the class
    public static int getTotalClassrooms() {
        return totalClassrooms;
    }

    // Method overloading - displays info differently
    public String getInfo() {
        return "Аудиторія №" + number + ", тип: " + type +
                ", місць: " + capacity + ", поверх: " + floor +
                ", проектор: " + (hasProjector ? "так" : "ні");
    }

    public String getInfo(boolean shortFormat) {
        if (shortFormat) {
            return "Аудиторія №" + number + " (" + type + ")";
        }
        return getInfo();
    }
}
