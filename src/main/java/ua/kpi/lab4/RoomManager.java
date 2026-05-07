package ua.kpi.lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic manager class for handling rooms.
 * <T extends Classroom> means this class can only be used with Classroom
 * or any of its subclasses (like Laboratory).
 */
public class RoomManager<T extends Classroom> {
    // Internal list to store objects of type T
    private List<T> rooms = new ArrayList<>();

    /**
     * Adds a room to the collection.
     * Type safety is guaranteed by the generic parameter T.
     */
    public void addRoom(T room) {
        rooms.add(room);
    }

    /**
     * Retrieves a room by its index in the list.
     */
    public T getRoom(int index) {
        return rooms.get(index);
    }

    /**
     * Returns the entire list of managed rooms.
     */
    public List<T> getAllRooms() {
        return rooms;
    }

    /**
     * Returns the total number of rooms currently managed.
     */
    public int getCount() {
        return rooms.size();
    }

    /**
     * Iterates through the list and prints information for each room.
     * Because T extends Classroom, we can safely call .getInfo() on any item.
     */
    public void printAll() {
        for (T room : rooms) {
            System.out.println(room.getInfo());
        }
    }
}