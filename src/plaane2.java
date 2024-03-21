//import java.util.Scanner;
//
//public class plaane2 {
//    private static final int NUMBER_OF_ROWS = 4;
//    private static final int NUMBER_OF_SEATS_PER_ROW = 12;
//    private static final char[] ROWS = {'A', 'B', 'C', 'D'};
//    private static boolean[][] seats;
//    private static Scanner scanner;
//
//    public static void main(String[] args) {
//        scanner = new Scanner(System.in);
//        seats = new boolean[NUMBER_OF_ROWS][];
//        seats[0] = new boolean[14];
//        seats[1] = new boolean[12];
//        seats[2] = new boolean[12];
//        seats[3] = new boolean[14];
//        int choice;
//        do {
//            displayMenu();
//            choice = getUserChoice();
//            switch (choice) {
//                case 1:
//                    bookSeat();
//                    break;
//                case 2:
//                    cancelBooking();
//                    break;
//                case 3:
//                    findFirstAvailable();
//                    break;
//                case 4:
//                    showSeatingPlan();
//                    break;
//                case 5:
//                    System.out.println("Exiting...");
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//            waitForEnter();
//        } while (choice != 5);
//    }
//
//    private static void displayMenu() {
//        System.out.println("\nCinema Seating Plan:");
//        System.out.println("1. Book Seat");
//        System.out.println("2. Cancel Booking");
//        System.out.println("3. Find First Available Seat");
//        System.out.println("4. Display Seating Plan");
//        System.out.println("5. Exit");
//        System.out.print("Enter your choice: ");
//    }
//
//    private static int getUserChoice() {
//        return scanner.nextInt();
//    }
//
//    private static void bookSeat() {
//        System.out.print("Enter row number (A-D): ");
//        char row = scanner.next().charAt(0);
//        int rowIndex = row - 'A'; // Convert row character to index
//        System.out.print("Enter seat number (1-" + NUMBER_OF_SEATS_PER_ROW + "): ");
//        int seat = scanner.nextInt() - 1; // Adjusting input to start from 0
//        if (isValidSeat(rowIndex, seat) && !seats[rowIndex][seat]) {
//            seats[rowIndex][seat] = true;
//            System.out.println("Seat booked successfully.");
//        } else {
//            System.out.println("Invalid seat or seat already booked. Please try again.");
//        }
//    }
//
//    private static void cancelBooking() {
//        System.out.print("Enter row number (A-D): ");
//        char row = scanner.next().charAt(0);
//        int rowIndex = row - 'A'; // Convert row character to index
//        System.out.print("Enter seat number (1-" + NUMBER_OF_SEATS_PER_ROW + "): ");
//        int seat = scanner.nextInt() - 1; // Adjusting input to start from 0
//        if (isValidSeat(rowIndex, seat) && seats[rowIndex][seat]) {
//            seats[rowIndex][seat] = false;
//            System.out.println("Booking cancelled successfully.");
//        } else {
//            System.out.println("Invalid seat or seat not booked. Please try again.");
//        }
//    }
//
//    private static void findFirstAvailable() {
//        System.out.println("\nFinding first available seat...");
//        for (char row : ROWS) {
//            int rowIndex = row - 'A'; // Convert row character to index
//            for (int seat = 0; seat < NUMBER_OF_SEATS_PER_ROW; seat++) {
//                if (!seats[rowIndex][seat]) {