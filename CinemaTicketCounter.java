import java.util.Scanner;

public class CinemaTicketCounter {
     
    static char[][] seats = new char[5][6];

     
    public static void initializeSeats() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                seats[i][j] = 'A';
            }
        }
    }

    
    public static void displaySeats() {
        
        System.out.println("       Seat 1 Seat 2 Seat 3 Seat 4 Seat 5 Seat 6");
        System.out.println("       -----------------------------------------");

         
        for (int i = 0; i < 5; i++) {
            System.out.print("Row " + (i + 1) + " |   ");   
            for (int j = 0; j < 6; j++) {
                System.out.print(seats[i][j] + "      ");   
            }
            System.out.println();   
        }
    }

     
    public static void bookSeat(int row, int col) {
        if (seats[row][col] == 'A') {  
            seats[row][col] = 'B';     
            System.out.println("Seat booked successfully!");
        } else {
            System.out.println("Seat already booked.");
        }
    }

    // Cancel a booking
    public static void cancelSeat(int row, int col) {
        if (seats[row][col] == 'B') {  
            seats[row][col] = 'A';     
            System.out.println("Booking canceled successfully!");
        } else {
            System.out.println("Seat is not booked.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        initializeSeats();   

        while (true) {
             
            System.out.println("\n1. Display seats");
            System.out.println("2. Book a seat");
            System.out.println("3. Cancel a booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = input.nextInt();  

            if (choice == 1) {
                displaySeats();   
            } else if (choice == 2) {
                System.out.print("Enter row (0-4): ");
                int row = input.nextInt();
                System.out.print("Enter column (0-5): ");
                int col = input.nextInt();
                bookSeat(row, col);   
            } else if (choice == 3) {
                System.out.print("Enter row (0-4): ");
                int row = input.nextInt();
                System.out.print("Enter column (0-5): ");
                int col = input.nextInt();
                cancelSeat(row, col);  
            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;   
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        input.close();  
    }
}
