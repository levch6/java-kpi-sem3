package ua.kpi.lab1;

public class Main {
    public static void main(String[] args) {

        // Array of class objects
        Classroom[] classrooms = new Classroom[4];

        classrooms[0] = new Classroom();                                        // default constructor
        classrooms[1] = new Classroom(101, 30, "лекційна", 1);                 // without a projector
        classrooms[2] = new Classroom(205, 20, "лабораторна", 2, false);       // with all parameters
        classrooms[3] = new Classroom(312, 15, "комп'ютерний клас", 3, true);

        // We display information about all audiences
        System.out.println("=== Список аудиторій ===");
        for (Classroom c : classrooms) {
            System.out.println(c.getInfo());
        }

        //Method overloading
        System.out.println("\n=== Короткий формат ===");
        for (Classroom c : classrooms) {
            System.out.println(c.getInfo(true));
        }

        //Static method - called via class name, not object name
        System.out.println("\nВсього створено аудиторій: " + Classroom.getTotalClassrooms());

        //Encapsulation demo - changing a field via a setter
        System.out.println("\n=== Зміна даних через setter ===");
        classrooms[1].setCapacity(50);
        classrooms[1].setHasProjector(true);
        System.out.println(classrooms[1].getInfo());
    }
}
