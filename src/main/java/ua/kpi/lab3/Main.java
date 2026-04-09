package ua.kpi.lab3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Setup
        Classroom c1 = new Classroom(101, 60, "lecture hall", 1, true);
        Classroom c2 = new Classroom(202, 30, "seminar room", 2, false);
        Classroom c3 = new Classroom(103, 60, "lecture hall", 1, false); // same capacity as c1
        Laboratory l1 = new Laboratory(301, 20, 3, "computers", 1);
        Laboratory l2 = new Laboratory(302, 15, 3, true, "chemistry", 3);

        // ===========================
        // PART 1 — Collection (List)
        // ===========================
        ClassroomCollection col = new ClassroomCollection();
        col.add(c1); col.add(c2); col.add(c3); col.add(l1); col.add(l2);

        System.out.println("=== Find by number 202 ===");
        col.findByNumber(202).ifPresentOrElse(
                c -> System.out.println("Found: " + c.getInfo()),
                () -> System.out.println("Not found")
        );

        System.out.println("\n=== Unique by capacity ===");
        col.getUniqueByCapacity().forEach(c -> System.out.println("  " + c.getInfo(true)));

        System.out.println("\n=== Filter by floor 3 ===");
        col.filterByFloor(3).forEach(c -> System.out.println("  " + c.getInfo(true)));

        System.out.println("\n=== Average capacity ===");
        System.out.printf("  %.1f seats%n", col.averageCapacity());

        System.out.println("\n=== Sort by capacity: anonymous class ===");
        col.sortByCapacityAnonymous()
                .forEach(c -> System.out.println("  #" + c.getNumber() + " cap=" + c.getCapacity()));

        System.out.println("\n=== Sort by capacity: lambda ===");
        col.sortByCapacityLambda()
                .forEach(c -> System.out.println("  #" + c.getNumber() + " cap=" + c.getCapacity()));

        System.out.println("\n=== Sort by capacity: method reference ===");
        col.sortByCapacityMethodRef()
                .forEach(c -> System.out.println("  #" + c.getNumber() + " cap=" + c.getCapacity()));

        // ===========================
        // PART 2 — Map
        // ===========================
        ClassroomMap map = new ClassroomMap();
        map.add(c1); map.add(c2); map.add(c3); map.add(l1); map.add(l2);

        System.out.println("\n=== Filter map by type 'lecture hall' ===");
        map.filterByType("lecture hall")
                .values().forEach(c -> System.out.println("  " + c.getInfo(true)));

        System.out.println("\n=== Total capacity (sum reduction) ===");
        System.out.println("  " + map.totalCapacity() + " seats total");

        System.out.println("\n=== Sort by number then floor: anonymous ===");
        map.sortByNumberThenFloorAnonymous()
                .forEach(c -> System.out.println("  #" + c.getNumber() + " floor=" + c.getFloor()));

        System.out.println("\n=== Sort by number then floor: lambda ===");
        map.sortByNumberThenFloorLambda()
                .forEach(c -> System.out.println("  #" + c.getNumber() + " floor=" + c.getFloor()));

        System.out.println("\n=== Sort by number then floor: method reference ===");
        map.sortByNumberThenFloorMethodRef()
                .forEach(c -> System.out.println("  #" + c.getNumber() + " floor=" + c.getFloor()));

        System.out.println("\n=== Remove classrooms without projector ===");
        map.removeWithoutProjector();
        System.out.println("Remaining after removal:");
        map.getAll().values().forEach(c -> System.out.println("  " + c.getInfo(true)));
    }
}