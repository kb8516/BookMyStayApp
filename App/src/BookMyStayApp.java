// Abstract Class - Version 2.0
abstract class Room {

    // Encapsulated attributes
    private int numberOfBeds;
    private int size;
    private double price;

    // Constructor
    public Room(int numberOfBeds, int size, double price) {
        this.numberOfBeds = numberOfBeds;
        this.size = size;
        this.price = price;
    }

    // Getters
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method
    public abstract String getRoomType();

    // Display method
    public void displayRoomDetails() {
        System.out.println("Room Type: " + getRoomType());
        System.out.println("Number of Beds: " + numberOfBeds);
        System.out.println("Room Size: " + size + " sq ft");
        System.out.println("Price per Night: $" + price);
    }
}


// Single Room Class - Version 2.0
class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 200, 100.0);
    }

    @Override
    public String getRoomType() {
        return "Single Room";
    }
}


// Double Room Class - Version 2.0
class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 350, 180.0);
    }

    @Override
    public String getRoomType() {
        return "Double Room";
    }
}


// Suite Room Class - Version 2.0
class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 500, 350.0);
    }

    @Override
    public String getRoomType() {
        return "Suite Room";
    }
}


// Main Application Class - Version 2.1
public class BookMyStayApp {

    public static void main(String[] args) {

        // Create room objects using polymorphism
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability variables
        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability = 2;

        System.out.println("===== Hotel Room Availability =====\n");

        // Display Single Room details
        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + singleRoomAvailability);
        System.out.println();

        // Display Double Room details
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleRoomAvailability);
        System.out.println();

        // Display Suite Room details
        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteRoomAvailability);
    }
}
