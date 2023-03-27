import java.util.ArrayList;
import java.util.Scanner;

public class MovieTicket {
    
    static ArrayList<Ticket> bookingRecords = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to the movie theater! ");
        
        while (true) {
            System.out.println("\nplease select the option below :\n 1. Book a ticket\n 2. Cancel a ticket\n 3. View existing booking records\n 4. Exit , have a good day :) ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    viewBookingRecords();
                    break;
                case 4:
                    System.out.println("Thank you for using the Movie Ticket Booking System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! go for choises above !");
            }
        }
    }
    
    static void bookTicket() {
        System.out.println("\n Enter movie name:");
        String movieName = scanner.next(); 
        System.out.println("Enter number of tickets to book:");
        int numTickets = scanner.nextInt();
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();
        
        Ticket ticket = new Ticket(movieName, numTickets, customerName);
        bookingRecords.add(ticket);
        System.out.println("Ticket's booked successfully!");
    }
    
    static void cancelTicket() {
        System.out.println("\nEnter booking ID:");
        int bookingID = scanner.nextInt();
        
        for (Ticket ticket : bookingRecords) {
            if (ticket.bookingID == bookingID) {
                bookingRecords.remove(ticket);
                System.out.println("Ticket cancelled successfully!");
                return;
            }
        }
        
        System.out.println("Invalid booking ID!");
    }
    
    static void viewBookingRecords() {
        if (bookingRecords.size() == 0) {
            System.out.println("\n Sorry , No booking records found!");
        } else {
            System.out.println("\nBooking Records:");
            System.out.println("ID\tMovie Name\tCustomer Name\tNumber of Tickets");
            for (Ticket ticket : bookingRecords) {
                System.out.println(ticket.bookingID + "\t" + ticket.movieName + "\t" + ticket.customerName + "\t" + ticket.numTickets);
            }
        }
    }
}

class Ticket {
    static int nextBookingID = 1;
    
    int bookingID;
    String movieName;
    int numTickets;
    String customerName;
    
    Ticket(String movieName, int numTickets, String customerName) {
        this.bookingID = nextBookingID++;
        this.movieName = movieName;
        this.numTickets = numTickets;
        this.customerName = customerName;
    }
}
