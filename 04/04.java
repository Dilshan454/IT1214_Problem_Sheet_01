class Ticket{
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    Ticket(int ticketNumber,String customerName,int seatNumber){
        this.ticketNumber=ticketNumber;
        this.customerName=customerName;
        this.seatNumber=seatNumber;
    }

    int getTicketNumber(){
        return ticketNumber;
    }
    String getCustomerName() {
        return customerName;
    }
    int getSeatNumber(){
        return seatNumber;
    }

}

class BookingSystem {
    private Ticket[] tickets;     // Array to store tickets
    private int ticketCount;      // Number of tickets booked

    // Constructor
    public BookingSystem() {
        tickets = new Ticket[10]; // Maximum 10 seats
        ticketCount = 0;
    }

    public void bookTicket(int ticketNumber, String customerName, int seatNumber) {
    if (ticketCount >= tickets.length) {
        System.out.println("Booking failed: Theater is full.");
        return;
    }

    // Check if seat is already taken
    for (int i = 0; i < ticketCount; i++) {
        if (tickets[i].getSeatNumber() == seatNumber) {
            System.out.println("Booking failed: Seat " + seatNumber + " is already booked.");
            return;
        }
    }

    // Book the ticket
    tickets[ticketCount] = new Ticket(ticketNumber, customerName, seatNumber);
    ticketCount++;
    System.out.println("Ticket booked successfully for " + customerName + " at seat " + seatNumber + ".");
    }

    public void cancelTicket(int ticketNumber) {
    boolean found = false;
    for (int i = 0; i < ticketCount; i++) {
        if (tickets[i].getTicketNumber() == ticketNumber) {
            // Shift tickets to remove the cancelled one
            for (int j = i; j < ticketCount - 1; j++) {
                tickets[j] = tickets[j + 1];
            }
            tickets[ticketCount - 1] = null; // Clear last slot
            ticketCount--;
            System.out.println("Ticket number " + ticketNumber + " has been cancelled.");
            return;
        }
    }
        System.out.println("Cancellation failed: Ticket number " + ticketNumber + " not found.");
}

public void displayAllTickets() {
    if (ticketCount == 0) {
        System.out.println("No tickets booked.");
        return;
    }

    System.out.println("Current Bookings:");
    for (int i = 0; i < ticketCount; i++) {
        Ticket t = tickets[i];
        System.out.println("Ticket Number: " + t.getTicketNumber() +
                           ", Customer: " + t.getCustomerName() +
                           ", Seat: " + t.getSeatNumber());
    }
}
}
class Main {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        // Book 3 tickets
        system.bookTicket(1, "Alice", 1);
        system.bookTicket(2, "Bob", 2);
        system.bookTicket(3, "Charlie", 3);

        // Cancel ticket number 2
        system.cancelTicket(2);

        // Try booking a new ticket at seat 2 (now free)
        system.bookTicket(4, "David", 2);

        // Display all booked tickets
        system.displayAllTickets();
    }
}

   