import java.util.HashMap;
import java.util.Map;

// RoomInventory Class - Version 3.0
class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor initializes room availability
    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Retrieve availability
    public int getAvailability(String roomType) {
        if (inventory.containsKey(roomType)) {
            return inventory.get(roomType);
        }
        return 0;
    }

    // Update availability in a controlled manner
    public void updateAvailability(String roomType, int newCount) {
        if (inventory.containsKey(roomType)) {
            inventory.put(roomType, newCount);
        } else {
            System.out.println("Room type not found in inventory.");
        }
    }

    // Display current inventory
    public void displayInventory() {
        System.out.println("===== Current Room Inventory =====");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " Available: " + entry.getValue());
        }
    }
}


// Main Class - Version 3.1 (Refactored)
public class BookMyStayApp {

    public static void main(String[] args) {

        // Initialize inventory system
        RoomInventory inventory = new RoomInventory();

        // Display current inventory
        inventory.displayInventory();

        System.out.println();

        // Retrieve availability example
        System.out.println("Checking availability for Single Room...");
        int availableSingleRooms = inventory.getAvailability("Single Room");
        System.out.println("Single Rooms Available: " + availableSingleRooms);

        System.out.println();

        // Update inventory example
        System.out.println("Updating Single Room availability...");
        inventory.updateAvailability("Single Room", 4);

        System.out.println();

        // Display updated inventory
        inventory.displayInventory();
    }
}