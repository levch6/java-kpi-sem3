package ua.kpi.lab2;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        // === 1. Array of parent class — holds both Classroom and Laboratory ===
        Classroom[] classrooms = new Classroom[5];
        classrooms[0] = new Classroom(101, 60, "lecture hall", 1, true);
        classrooms[1] = new Classroom(202, 30, "seminar room", 2);
        classrooms[2] = new Laboratory(301, 20, 3, "computers", 1);
        classrooms[3] = new Laboratory(302, 15, 3, true, "chemistry", 3);
        classrooms[4] = new Classroom(103, 40, "lecture hall", 1, false);

        // Polymorphism — getInfo() calls the right version per object type
        System.out.println("=== All classrooms (polymorphism) ===");
        for (Classroom c : classrooms) {
            System.out.println(c.getInfo());
        }

        // instanceof check
        System.out.println("\n=== instanceof check ===");
        for (Classroom c : classrooms) {
            if (c instanceof Laboratory lab) {
                System.out.println("Classroom #" + c.getNumber()
                        + " is a Laboratory with equipment: " + lab.getEquipmentType());
            }
        }

        // === 2. Array operations ===
        System.out.println("\n=== Sorted by capacity (ascending) ===");
        Classroom[] sorted = Arrays.copyOf(classrooms, classrooms.length); // array copy
        Arrays.sort(sorted, Comparator.comparingInt(Classroom::getCapacity));
        for (Classroom c : sorted) {
            System.out.println("  #" + c.getNumber() + " capacity=" + c.getCapacity());
        }

        // Find max capacity
        Classroom maxCap = sorted[sorted.length - 1];
        System.out.println("\nLargest classroom: #" + maxCap.getNumber()
                + " with " + maxCap.getCapacity() + " seats");

        // Search by number
        System.out.println("\n=== Search classroom #302 ===");
        Classroom found = null;
        for (Classroom c : classrooms) {
            if (c.getNumber() == 302) { found = c; break; }
        }
        System.out.println(found != null ? found.getInfo() : "Not found");

        // === 3. Schedule — aggregation + nested class + local class ===
        System.out.println("\n=== Schedule ===");
        Schedule schedule = new Schedule(classrooms);
        schedule.addBooking("Monday", 1, 101);
        schedule.addBooking("Monday", 1, 302);
        schedule.addBooking("Monday", 2, 202);

        System.out.println("All bookings:");
        schedule.printBookings();

        // Variant 2.5 — free classrooms on Monday period 1
        System.out.println("\nFree classrooms on Monday, period 1:");
        Classroom[] free = schedule.findFreeClassrooms(1, "Monday");
        for (Classroom c : free) {
            System.out.println("  " + c.getInfo(true));
        }

        // Static field — total count
        System.out.println("\nTotal classrooms created: " + Classroom.getTotalClassrooms());
    }
}
