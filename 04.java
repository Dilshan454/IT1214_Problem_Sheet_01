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
    int getSeatNumber(){
        return seatNumber;
    }

    public String toString() {
        return "Ticket #" + ticketNumber + " | Name: " + customerName + " | Seat: " + seatNumber;
    }
}

class BookingSystem{
    Ticket[] tickets=new Ticket[10];
    int count=0;

    boolean isSeatBooked(int seatNumber) {
        for (int i = 0; i < count; i++) {
            if (tickets[i].getSeatNumber() == seatNumber) {
                return true;
            }
        }
        return false;
    }


    void book(int ticketNumber,String customerName,int seatNumber){
        if (isSeatBooked(seatNumber)) {
            System.out.println("Seat " + seatNumber + " is already booked.");
            return;
        }

        if (count >= tickets.length) {
            System.out.println("All seats are booked.");
            return;
        }

        tickets[count++] = new Ticket(ticketNumber, customerName, seatNumber);

    }
    public void displayTickets() {
        if (count == 0) {
            System.out.println("No tickets booked yet.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(tickets[i]);
        }
    }
    
}
class TicketSystem {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        system.book(1, "Alice", 1);


        system.displayTickets();
    }
}