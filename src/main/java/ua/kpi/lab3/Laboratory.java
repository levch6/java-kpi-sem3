package ua.kpi.lab3;

public class Laboratory extends Classroom {

    // Additional fields specific to laboratory
    private String equipmentType;
    private int safetyLevel; // 1 = low, 2 = medium, 3 = high

    // Constructor calling parent constructor via super()
    public Laboratory(int number, int capacity, int floor,
                      String equipmentType, int safetyLevel) {
        super(number, capacity, "laboratory", floor, false);
        this.equipmentType = equipmentType;
        this.safetyLevel = safetyLevel;
    }

    // Full constructor
    public Laboratory(int number, int capacity, int floor, boolean hasProjector,
                      String equipmentType, int safetyLevel) {
        super(number, capacity, "laboratory", floor, hasProjector);
        this.equipmentType = equipmentType;
        this.safetyLevel = safetyLevel;
    }

    // Getters and setters
    public String getEquipmentType() { return equipmentType; }
    public void setEquipmentType(String equipmentType) { this.equipmentType = equipmentType; }

    public int getSafetyLevel() { return safetyLevel; }
    public void setSafetyLevel(int safetyLevel) { this.safetyLevel = safetyLevel; }

    // Overriding parent method — @Override marks it for compiler
    @Override
    public String getInfo() {
        return super.getInfo() +
                ", equipment: " + equipmentType +
                ", safety level: " + safetyLevel;
    }
}