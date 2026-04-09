package ua.kpi.lab3;

import java.util.*;
import java.util.stream.*;

public class ClassroomCollection {

    private Collection<Classroom> classrooms = new ArrayList<>();

    public void add(Classroom c) { classrooms.add(c); }

    // Find first classroom matching a condition (using lambda)
    public Optional<Classroom> findByNumber(int number) {
        return classrooms.stream()
                .filter(c -> c.getNumber() == number)
                .findFirst();
    }

    // Create collection with only unique capacities (unique elements by capacity)
    public Collection<Classroom> getUniqueByCapacity() {
        return classrooms.stream()
                .collect(Collectors.toMap(
                        Classroom::getCapacity,
                        c -> c,
                        (existing, replacement) -> existing
                ))
                .values();
    }

    // Filter by floor
    public List<Classroom> filterByFloor(int floor) {
        return classrooms.stream()
                .filter(c -> c.getFloor() == floor)
                .collect(Collectors.toList());
    }

    // Average capacity
    public double averageCapacity() {
        return classrooms.stream()
                .mapToInt(Classroom::getCapacity)
                .average()
                .orElse(0);
    }

    // === Sort with anonymous class ===
    public List<Classroom> sortByCapacityAnonymous() {
        List<Classroom> list = new ArrayList<>(classrooms);
        list.sort(new Comparator<Classroom>() {
            @Override
            public int compare(Classroom a, Classroom b) {
                return Integer.compare(a.getCapacity(), b.getCapacity());
            }
        });
        return list;
    }

    // === Sort with lambda ===
    public List<Classroom> sortByCapacityLambda() {
        List<Classroom> list = new ArrayList<>(classrooms);
        list.sort((a, b) -> Integer.compare(a.getCapacity(), b.getCapacity()));
        return list;
    }

    // === Sort with method reference ===
    public List<Classroom> sortByCapacityMethodRef() {
        List<Classroom> list = new ArrayList<>(classrooms);
        list.sort(Comparator.comparingInt(Classroom::getCapacity));
        return list;
    }

    public Collection<Classroom> getAll() { return classrooms; }
}
