import java.io.FileWriter;
import java.io.IOException;

public class Academician extends Personnel{
    // This class is sub class of Personnel Class, for academicians

    public Academician(String name, String surname, String ID, String position, Integer year_of_start) {
        // Constructor
        super(name, surname, ID, position, year_of_start);
    }

    public Academician() {
        // Other Constructor
    }

    public void writeassistant() throws IOException {
        // This method for write assistants payroll txt
        for (String[] strings : data_personnel) {
            if (strings[1].equals(Write.currentID)) {
                Academician assistant = new Academician(strings[0].split(" ")[0], strings[0].split(" ")[1],
                        strings[1], strings[2], Integer.valueOf(strings[3]));
                Double ssbenefit = (base_salary * 105) / 100;
                Double severencepay = (2020 - assistant.getYear_of_start()) * 20 * 0.8;
                FileWriter writer = new FileWriter(assistant.getID() + ".txt");
                writer.write("Name : " + assistant.getName() + "\n");
                writer.write("Surname : " + assistant.getSurname() + "\n");
                writer.write("Registiration Number : " + assistant.getID() + "\n");
                writer.write("Position : " + assistant.getPosition() + "\n");
                writer.write("Year of Start : " + assistant.getYear_of_start() + "\n");
                writer.write("Total Salary : " + String.valueOf(base_salary + ssbenefit + severencepay) + "0 TL");
                writer.close();
            }
        }
    }

    public void writefacultymember() throws IOException {
        // This method for write faculty members payroll txt
        for (String[] strings : data_personnel){
            if (strings[1].equals(Write.currentID)) {
                Academician f_member = new Academician(strings[0].split(" ")[0], strings[0].split(" ")[1],
                        strings[1], strings[2], Integer.valueOf(strings[3]));
                Double ssbenefit = (base_salary * 135) / 100;
                Double severencepay = (2020 - f_member.getYear_of_start()) * 20 * 0.8;
                FileWriter writer = new FileWriter(f_member.getID() + ".txt");
                writer.write("Name : " + f_member.getName() + "\n");
                writer.write("Surname : " + f_member.getSurname() + "\n");
                writer.write("Registiration Number : " + f_member.getID() + "\n");
                writer.write("Position : " + f_member.getPosition() + "\n");
                writer.write("Year of Start : " + f_member.getYear_of_start() + "\n");
                writer.write("Total Salary : " + String.valueOf(base_salary + ssbenefit + severencepay
                        + Write.extrasalary) + "0 TL");
                writer.close();
            }
        }
    }

}
