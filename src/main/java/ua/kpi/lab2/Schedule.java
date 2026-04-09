package ua.kpi.lab2;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private Classroom[] classrooms;

    // === NESTED CLASS — accessible from outside as Schedule.Booking ===
    public static class Booking {
        private String day;
        private int period;      // lesson number (1-6)
        private int classroomNumber;

        public Booking(String day, int period, int classroomNumber) {
            this.day = day;
            this.period = period;
            this.classroomNumber = classroomNumber;
        }

        public String getDay() { return day; }
        public int getPeriod() { return period; }
        public int getClassroomNumber() { return classroomNumber; }

        @Override
        public String toString() {
            return day + ", period " + period + ", classroom #" + classroomNumber;
        }
    }

    private List<Booking> bookings = new ArrayList<>();

    // Constructor — aggregation: Schedule contains array of Classrooms
    public Schedule(Classroom[] classrooms) {
        this.classrooms = classrooms;
    }

    // Add a booking
    public void addBooking(String day, int period, int classroomNumber) {
        bookings.add(new Booking(day, period, classroomNumber));
    }

    // Variant 2.5 — find all free classrooms for given period and day
    public Classroom[] findFreeClassrooms(int period, String day) {

        // === LOCAL CLASS — defined inside a method, invisible outside ===
        class BookingChecker {
            boolean isBooked(int classroomNumber) {
                for (Booking b : bookings) {
                    if (b.getClassroomNumber() == classroomNumber
                            && b.getPeriod() == period
                            && b.getDay().equalsIgnoreCase(day)) {
                        return true;
                    }
                }
                return false;
            }
        }

        BookingChecker checker = new BookingChecker();
        List<Classroom> free = new ArrayList<>();

        for (Classroom c : classrooms) {
            if (!checker.isBooked(c.getNumber())) {
                free.add(c);
            }
        }

        return free.toArray(new Classroom[0]);
    }

    // Print all bookings
    public void printBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }
        for (Booking b : bookings) {
            System.out.println("  " + b);
        }
    }
}
