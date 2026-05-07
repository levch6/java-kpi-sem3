package ua.kpi.lab4;

/**
 * Represents a specialized room for experiments.
 * Inherits from the Classroom class.
 */
public class Laboratory extends Classroom {
    private String equipmentType;

    public Laboratory(int number, int capacity, int floor, String equipmentType) {
        // Calls the parent (Classroom) constructor to initialize shared fields
        // The type is hardcoded as "лабораторія" and availability as true
        super(number, capacity, "лабораторія", floor, true);
        this.equipmentType = equipmentType;
    }

    public String getEquipmentType() { return equipmentType; }

    /**
     * Overrides the parent method to include equipment-specific details.
     * Uses super.getInfo() to reuse the base string logic.
     */
    @Override
    public String getInfo() {
        return super.getInfo() + ", equipment: " + equipmentType;
    }
}