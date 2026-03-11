public class BookMyStayApp {
    public static void main(String[] args){
        System.out.println("Welcome to the Hotel Booking Management System");
        System.out.println("System initialized successfully.");
    }
}
// Version 2.1

// Abstract class representing a general Room
abstract class Room {

    private int beds;
    private int size;
    private double price;

    // Constructor
    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    // Method to display common room details
    public void displayRoomDetails() {
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sq ft");
        System.out.println("Price: $" + price);
    }

    // Abstract method
    public abstract String getRoomType();
}


// Single Room class
class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 200, 100);
    }

    public String getRoomType() {
        return "Single Room";
    }
}


// Double Room class
class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 300, 150);
    }

    public String getRoomType() {
        return "Double Room";
    }
}


// Suite Room class
class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 500, 300);
    }

    public String getRoomType() {
        return "Suite Room";
    }
}


// Main Application Class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Hotel Room Information\n");

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability variables
        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 2;

        // Display Single Room details
        System.out.println(single.getRoomType());
        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailability);
        System.out.println();

        // Display Double Room details
        System.out.println(doubleRoom.getRoomType());
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailability);
        System.out.println();

        // Display Suite Room details
        System.out.println(suite.getRoomType());
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailability);

        System.out.println("\nApplication Terminated");
    }
}
