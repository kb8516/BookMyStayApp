import java.util.*;

// ----------------------------
// Room Abstract Class (v2.0 reused)
// ----------------------------
abstract class Room {

    private int numberOfBeds;
    private int size;
    private double price;

    public Room(int numberOfBeds, int size, double price) {
        this.numberOfBeds = numberOfBeds;
        this.size = size;
        this.price = price;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getRoomType();

    public void displayRoomDetails() {
        System.out.println("Room Type: " + getRoomType());
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + size + " sq ft");
        System.out.println("Price per night: $" + price);
    }
}

// ----------------------------
// Concrete Room Classes (v2.0 reused)
// ----------------------------
class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 200, 100.0);
    }

    public String getRoomType() {
        return "Single Room";
    }
}

class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 350, 180.0);
    }

    public String getRoomType() {
        return "Double Room";
    }
}

class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 500, 350.0);
    }

    public String getRoomType() {
        return "Suite Room";
    }
}

// ----------------------------
// RoomInventory (v3.0 reused)
// ----------------------------
class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 0);   // Example: unavailable
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

// ----------------------------
// Search Service (NEW - v4.0)
// ----------------------------
class RoomSearchService {

    public void searchAvailableRooms(List<Room> rooms, RoomInventory inventory) {

        System.out.println("===== Available Rooms =====\n");

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getRoomType());

            // Defensive programming: show only available rooms
            if (available > 0) {

                room.displayRoomDetails();
                System.out.println("Available Rooms: " + available);
                System.out.println();
            }
        }
    }
}

// ----------------------------
// Main Class (v4.1 Refactored)
// ----------------------------
public class BookMyStayApp {

    public static void main(String[] args) {

        // Initialize room objects
        List<Room> rooms = new ArrayList<>();

        rooms.add(new SingleRoom());
        rooms.add(new DoubleRoom());
        rooms.add(new SuiteRoom());

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Initialize search service
        RoomSearchService searchService = new RoomSearchService();

        // Guest performs search
        searchService.searchAvailableRooms(rooms, inventory);
    }
}