import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class w2052211_PlaneManagement {

    private static int[] aSeats = new int[14];
    private static int[] bSeats = new int[12];
    private static int[] cSeats = new int[12];
    private static int[] dSeats = new int[14];
    private static Ticket[] tickets = new Ticket[52];

    public static void main(String[] args) {

        System.out.println("Welcome to the Plane Management application");
        selectOption();


    }


    private static int option;

    private static void selectOption() {
        Scanner scanner = new Scanner(System.in);
        try {
            do {
                System.out.println("*******************************************");
                System.out.println("*              Menu option               *");
                System.out.println("*******************************************");
                System.out.println("1) Buy a seat");
                System.out.println("2) Cancel a seat");
                System.out.println("3) Find first available seat");
                System.out.println("4) Show seating plan");
                System.out.println("5) Print tickets information and total sales");
                System.out.println("6) Search ticket");
                System.out.println("0) Quit");
                System.out.println("********************************************");
                System.out.println("Please select an option:");

                option = scanner.nextInt();
                if (option == 1) {
                    buy_seat();
                    ticket.save();
                } else if (option == 4) {
                    show_seating_plan();
                } else if (option == 2) {
                    cancel_seat();
                } else if (option == 3) {
                    System.out.println(find_first_available());
                } else if (option == 5) {
                    print_tickets_info();
                } else if (option == 6) {
                    System.out.println(search_ticket());
                }

            } while (option != 0);
        }catch (InputMismatchException ex){
            selectOption();
        }

    }
    private static void print_tickets_info(){
        double total = 0;
        for (Ticket ticketDetails: tickets){
            if(ticketDetails != null){
                System.out.println(ticketDetails.ticket_print_info());
                total = total + ticketDetails.getPrice();
            }
        }
        System.out.println("Total sales: £"+total);
    }
    private static void show_seating_plan() {
        for (int i=0; i<aSeats.length; i++){
            if (aSeats[i]==0) System.out.print("O ");
            else System.out.print("X ");
        }
        System.out.println();

        for (int j=0; j<bSeats.length; j++){
            if (bSeats[j]==0) System.out.print("O ");
            else System.out.print("X ");
        }
        System.out.println();

        for (int k=0; k<cSeats.length; k++){
            if (cSeats[k]==0) System.out.print("O ");
            else System.out.print("X ");
        }
        System.out.println();

        for (int l=0; l<dSeats.length; l++){
            if (dSeats[l]==0) System.out.print("O ");
            else System.out.print("X ");
        }
        System.out.println();
    }
private  static String row;
private static  int seat ;

    private static void buy_seat() {
        isValid();
        registerSeat();
        getUserInfo();
    }

    private static String name;
    private static String surname;
    private static String email;
    private static double price;

    private static  Ticket ticket;
    private static void getUserInfo(){
        seat++;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        name = sc.nextLine();
        System.out.println("Enter surname");
        surname = sc.nextLine();
        System.out.println("Enter email");
        email = sc.nextLine();

        // allocate price
        if (seat <= 5){
            price = 200;
        } else if (seat<=9) {
            price = 150;
        }else{
            price = 180;
        }

        ticket = new Ticket(row,seat,price,new Person(name,surname,email));

        tickets[ticketPointer] = ticket;
        ticketPointer++;
    }

    private static int ticketPointer = 0;
    private static void isValid() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the row (A- D): ");
            row = sc.nextLine();
            row = row.toLowerCase();
            do {
                if ((row.equals("a") || row.equals("d") || (row.equals("b") || row.equals("c")))) {
                    System.out.println("Enter seat rows A and D have 14 and rows C and B have 12:");
                    seat = sc.nextInt();

                } else {
                    if (option == 1){
                        buy_seat();
                    }

                }

            } while (((row.equals("a") || row.equals("d")) && seat > 14) || (row.equals("b") || row.equals("c")) && seat > 12 || seat < 1);


        }catch (InputMismatchException e){
            isValid();
        }

    }

    private static void cancel_seat(){
        isValid();
        registerSeat();
        for (int i = 0; i<tickets.length; i++){
            if (tickets[i]!=null && tickets[i].getRow().equals(row) && tickets[i].getSeat()==seat ){
                tickets[i]=null;
            }
        }
    }

    private static String find_first_available(){

        for (int i =0; i<aSeats.length; i++){
            if (aSeats[i]==0){
                return "First seat is available at row A seat "+(i+1);
            }
        }
        for (int i =0; i<aSeats.length; i++){
            if (bSeats[i]==0){
                return "First seat is available at row B seat "+(i+1);
            }
        }
        for (int i =0; i<aSeats.length; i++){
            if (cSeats[i]==0){
                return "First seat is available at row C seat "+(i+1);
            }
        }
        for (int i =0; i<aSeats.length; i++){
            if (dSeats[i]==0){
                return "First seat is available at row D seat "+(i+1);
            }
        }
        return "";
    }

    private static String search_ticket(){
        isValid();
        seat--;
        switch (row){
            case "a":
                if (aSeats[seat]== 0){
                    return "That Seat is available";
                } else{
                    print_tickets_info();
                    return "that seat is taken";
                }
            case "b":
                if (bSeats[seat]== 0){
                    return "That Seat is available";
                } else{
                    print_tickets_info();
                    return "that seat is taken";
                }
            case "c":
                if (cSeats[seat]== 0){
                    return "That Seat is available";
                } else{
                    print_tickets_info();
                    return "that seat is taken";
                }
            case "d":
                if (dSeats[seat]== 0){
                    return "That Seat is available";
                } else{
                    print_tickets_info();
                    return "that seat is taken";
                }


        }return "";
    }

    private static  void registerSeat(){
        seat--;
        switch (row){
            case "a":
                if (option ==1) {
                    aSeats[seat]=1;
                }
                else if (option ==2) {
                    aSeats[seat]=0;
                }

                break;

            case "b":
                if (option ==1) {
                    bSeats[seat]=1;

                }
                else if (option ==2) {
                    bSeats[seat]=0;
                }
                break;

            case "c":
                if (option ==1) {
                    cSeats[seat]=1;

                }
                else if (option ==2) {
                    cSeats[seat]=0;
                }
                break;

            case "d":
                if (option ==1) {
                    dSeats[seat]=1;

                }
                else if (option ==2) {
                    dSeats[seat]=0;
                }
                break;
        }
    }
}
