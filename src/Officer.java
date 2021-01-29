import java.io.FileWriter;
import java.io.IOException;

public class Officer extends Personnel {
    // This class is sub class of Personnel Class, for officers

    public Officer(String name, String surname, String ID, String position, Integer year_of_start) {
        // Construcor
        super(name, surname, ID, position, year_of_start);
    }

    public Officer() {
        // Other Constructor
    }

    public void writeofficer() throws IOException {
        // This method for write officers payroll txt
        for (String[] strings : data_personnel){
            if (strings[1].equals(Write.currentID)) {
                Officer officer1 = new Officer(strings[0].split(" ")[0], strings[0].split(" ")[1],
                        strings[1], strings[2], Integer.valueOf(strings[3]));
                Double ssbenefit = (base_salary * 65) / 100;
                Double severencepay = (2020 - officer1.getYear_of_start()) * 20 * 0.8;
                FileWriter writer = new FileWriter(officer1.getID() + ".txt");
                writer.write("Name : " + officer1.getName() + "\n");
                writer.write("Surname : " + officer1.getSurname() + "\n");
                writer.write("Registiration Number : " + officer1.getID() + "\n");
                writer.write("Position : " + officer1.getPosition() + "\n");
                writer.write("Year of Start : " + officer1.getYear_of_start() + "\n");
                writer.write("Total Salary : " + String.valueOf(base_salary + ssbenefit + severencepay
                        + Write.extrasalary) + "0 TL");
                writer.close();
            }
        }
    }
}
