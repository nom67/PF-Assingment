import java.util.Scanner;

public class CinemaTicketCounter {
    // Create a 5x6 array for the seats
    static char[][] seats = new char[5][6];

    // Initialize all seats as 'A' (available)
    public static void initializeSeats() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                seats[i][j] = 'A';
            }
        }
    }

    // Display the seating chart
    public static void displaySeats() {
        // Print seat numbers (header)
        System.out.println("       Seat 1 Seat 2 Seat 3 Seat 4 Seat 5 Seat 6");
        System.out.println("       -----------------------------------------");

        // Print rows with seat statuses
        for (int i = 0; i < 5; i++) {
            System.out.print("Row " + (i + 1) + " |   ");  // Display row number
            for (int j = 0; j < 6; j++) {
                System.out.print(seats[i][j] + "      ");  // Display seat status (A or B)
            }
            System.out.println();  // Move to the next line for the next row
        }
    }

    // Book a seat
    public static void bookSeat(int row, int col) {
        if (seats[row][col] == 'A') { // If seat is available
            seats[row][col] = 'B';    // Book the seat
            System.out.println("Seat booked successfully!");
        } else {
            System.out.println("Seat already booked.");
        }
    }

    // Cancel a booking
    public static void cancelSeat(int row, int col) {
        if (seats[row][col] == 'B') { // If seat is booked
            seats[row][col] = 'A';    // Cancel the booking
            System.out.println("Booking canceled successfully!");
        } else {
            System.out.println("Seat is not booked.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        initializeSeats();  // Set all seats to available

        while (true) {
            // Show menu options
            System.out.println("\n1. Display seats");
            System.out.println("2. Book a seat");
            System.out.println("3. Cancel a booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = input.nextInt();  // Get user choice

            if (choice == 1) {
                displaySeats();  // Show seating chart
            } else if (choice == 2) {
                System.out.print("Enter row (0-4): ");
                int row = input.nextInt();
                System.out.print("Enter column (0-5): ");
                int col = input.nextInt();
                bookSeat(row, col);  // Book the seat
            } else if (choice == 3) {
                System.out.print("Enter row (0-4): ");
                int row = input.nextInt();
                System.out.print("Enter column (0-5): ");
                int col = input.nextInt();
                cancelSeat(row, col);  // Cancel the booking
            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;  // Exit the loop
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        input.close();  // Close the scanner
    }
}
