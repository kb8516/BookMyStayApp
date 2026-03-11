import java.util.LinkedList;
import java.util.Queue;

// ----------------------------
// Reservation Class (v5.0)
// Represents a guest booking request
// ----------------------------
class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayReservation() {
        System.out.println("Guest: " + guestName + " | Requested Room: " + roomType);
    }
}

// ----------------------------
// BookingRequestQueue Class (v5.0)
// Manages booking requests using FIFO Queue
// ----------------------------
class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
        System.out.println("Booking request added for " + reservation.getGuestName());
    }

    // Display all queued requests
    public void displayRequests() {

        System.out.println("\n===== Booking Request Queue =====");

        if (requestQueue.isEmpty()) {
            System.out.println("No booking requests in queue.");
            return;
        }

        for (Reservation reservation : requestQueue) {
            reservation.displayReservation();
        }
    }

    // Peek first request (FIFO check)
    public Reservation getNextRequest() {
        return requestQueue.peek();
    }
}

// ----------------------------
// Main Class (v5.1 Refactored)
// ----------------------------
public class BookMyStayApp {

    public static void main(String[] args) {

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Guests submit booking requests
        Reservation r1 = new Reservation("Alice", "Single Room");
        Reservation r2 = new Reservation("Bob", "Double Room");
        Reservation r3 = new Reservation("Charlie", "Suite Room");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Display queued booking requests
        bookingQueue.displayRequests();

        // Show next request to be processed (FIFO)
        Reservation next = bookingQueue.getNextRequest();

        if (next != null) {
            System.out.println("\nNext request to process:");
            next.displayReservation();
        }
    }
}