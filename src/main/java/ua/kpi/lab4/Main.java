package ua.kpi.lab4;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Task 1: Initialize a list to store different types of rooms (polymorphism in action)
        List<Classroom> allRooms = new ArrayList<>();
        allRooms.add(new Classroom(101, 30, "lecture hall", 1, true));
        allRooms.add(new Laboratory(202, 15, 2, "Chemical reagents"));

        // Task 2: Demonstrating a Generic Method
        // The findFirst method works with any type T that satisfies the predicate
        System.out.println("Task 2: Generic Method Usage");
        Optional<Classroom> found = GenericUtils.findFirst(allRooms, c -> c.getNumber() == 202);
        found.ifPresent(c -> System.out.println("Found via generic method: " + c.getInfo()));


        // Task 3: Demonstrating a Generic Class
        // RoomManager is restricted to handle only Laboratory objects or its subclasses
        System.out.println("\nTask 3: Generic Class (RoomManager)");
        RoomManager<Laboratory> labManager = new RoomManager<>();
        labManager.addRoom(new Laboratory(305, 20, 3, "Computers"));

        System.out.println("Listing laboratories in the manager:");
        labManager.printAll();

        // Task 4: Demonstrating Wildcards (<?>)
        // The printListSize method can accept a list of ANY type due to the unbounded wildcard
        System.out.println("\nTask 4: Wildcard (<?>) usage");

        // Passing a List<Classroom>
        GenericUtils.printListSize(allRooms);

        // Passing a List<Laboratory>
        GenericUtils.printListSize(labManager.getAllRooms());
    }
}