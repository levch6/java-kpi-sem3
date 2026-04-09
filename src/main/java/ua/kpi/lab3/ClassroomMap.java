package ua.kpi.lab3;

import java.util.*;
import java.util.stream.*;

public class ClassroomMap {

    // Key = classroom number, Value = Classroom object
    private Map<Integer, Classroom> classrooms = new HashMap<>();

    public void add(Classroom c) {
        classrooms.put(c.getNumber(), c);
    }

    // Filter by type — returns new map with matching entries
    public Map<Integer, Classroom> filterByType(String type) {
        return classrooms.entrySet().stream()
                .filter(e -> e.getValue().getType().equalsIgnoreCase(type))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // Remove classrooms that don't have a projector
    public void removeWithoutProjector() {
        classrooms.entrySet().removeIf(e -> !e.getValue().isHasProjector());
    }

    // Sum of all capacities (reduction operation)
    public int totalCapacity() {
        return classrooms.values().stream()
                .mapToInt(Classroom::getCapacity)
                .sum();
    }

    // === Sort by number then by floor (anonymous class) ===
    public List<Classroom> sortByNumberThenFloorAnonymous() {
        List<Classroom> list = new ArrayList<>(classrooms.values());
        list.sort(new Comparator<Classroom>() {
            @Override
            public int compare(Classroom a, Classroom b) {
                int byNumber = Integer.compare(a.getNumber(), b.getNumber());
                if (byNumber != 0) return byNumber;
                return Integer.compare(a.getFloor(), b.getFloor());
            }
        });
        return list;
    }

    // === Sort by number then by floor (lambda) ===
    public List<Classroom> sortByNumberThenFloorLambda() {
        List<Classroom> list = new ArrayList<>(classrooms.values());
        list.sort((a, b) -> {
            int byNumber = Integer.compare(a.getNumber(), b.getNumber());
            if (byNumber != 0) return byNumber;
            return Integer.compare(a.getFloor(), b.getFloor());
        });
        return list;
    }

    // === Sort by number then by floor (method reference + thenComparing) ===
    public List<Classroom> sortByNumberThenFloorMethodRef() {
        List<Classroom> list = new ArrayList<>(classrooms.values());
        list.sort(Comparator.comparingInt(Classroom::getNumber)
                .thenComparingInt(Classroom::getFloor));
        return list;
    }

    public Map<Integer, Classroom> getAll() { return classrooms; }
}