package ua.kpi.lab3;

public class Classroom {

    // Fields
    private int number;
    private int capacity;
    private String type;
    private int floor;
    private boolean hasProjector;

    private static int totalClassrooms = 0;

    // Default constructor
    public Classroom() {
        this.number = 0;
        this.capacity = 0;
        this.type = "unknown";
        this.floor = 1;
        this.hasProjector = false;
        totalClassrooms++;
    }

    // Constructor without projector
    public Classroom(int number, int capacity, String type, int floor) {
        this.number = number;
        this.capacity = capacity;
        this.type = type;
        this.floor = floor;
        this.hasProjector = false;
        totalClassrooms++;
    }

    // Full constructor
    public Classroom(int number, int capacity, String type, int floor, boolean hasProjector) {
        this.number = number;
        this.capacity = capacity;
        this.type = type;
        this.floor = floor;
        this.hasProjector = hasProjector;
        totalClassrooms++;
    }

    // Getters and setters
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

    public static int getTotalClassrooms() { return totalClassrooms; }

    // Overrideable method — will be redefined in subclass
    public String getInfo() {
        return "Classroom #" + number + ", type: " + type +
                ", capacity: " + capacity + ", floor: " + floor +
                ", projector: " + (hasProjector ? "yes" : "no");
    }

    // Overloaded method
    public String getInfo(boolean shortFormat) {
        if (shortFormat) return "Classroom #" + number + " (" + type + ")";
        return getInfo();
    }
}
