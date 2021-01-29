import java.io.FileWriter;
import java.io.IOException;

public class Security extends Personnel {
    // This class is sub class of Personnel Class, for securities

    public Security(String name, String surname, String ID, String position, Integer year_of_start) {
        // Constructor
        super(name, surname, ID, position, year_of_start);
    }

    public Security() {
        // Other Constructor
    }

    public void writesecurity() throws IOException {
        // This method for write securities payroll txt
        for (String[] strings : data_personnel) {
            if (strings[1].equals(Write.currentID)) {
                Security security1 = new Security(strings[0].split(" ")[0], strings[0].split(" ")[1],
                        strings[1], strings[2], Integer.valueOf(strings[3]));
                Double severencepay = (2020 - security1.getYear_of_start()) * 20 * 0.8;
                FileWriter writer = new FileWriter(security1.getID() + ".txt");
                writer.write("Name : " + security1.getName() + "\n");
                writer.write("Surname : " + security1.getSurname() + "\n");
                writer.write("Registiration Number : " + security1.getID() + "\n");
                writer.write("Position : " + security1.getPosition() + "\n");
                writer.write("Year of Start : " + security1.getYear_of_start() + "\n");
                writer.write("Total Salary : " + String.valueOf(Write.extrasalary + severencepay) + "0 TL");
                writer.close();
            }
        }
    }
}
