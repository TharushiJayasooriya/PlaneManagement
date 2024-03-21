import javax.xml.namespace.QName;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    private String row;
    private int seat;
    private double price;
    private Person person;

    public Ticket(String row, int seat, double price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person= person;

    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public String ticket_print_info() {
        return "Ticket: \n" +
                "row='" + row + '\'' +
                ", seat=" + seat +
                ", price=" + price +
                ",\n person=" + person.print_info()
                ;
    }

    void save(){
        try{
            File file = new File(row+seat+".txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write("Row: "+row);
            writer.write("\nSeat: "+seat);
            writer.write("\nPrice: "+price);
            writer.write("\nPerson info: "+ person.print_info());
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
