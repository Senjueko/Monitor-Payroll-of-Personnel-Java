import java.io.FileWriter;
import java.io.IOException;

public class Employee extends Personnel{
    // This class is sub class of Personnel Class, for workers,chiefs and part time employees

    public Employee(String name, String surname, String ID, String position, Integer year_of_start) {
        // Constructor
        super(name, surname, ID, position, year_of_start);

    }

    public Employee() {
        // Other Constructor
    }

    public void writeworker() throws IOException {
        // This method for write workers payroll txt
        for (String[] strings : data_personnel){
            if (strings[1].equals(Write.currentID)){
                Employee worker = new Employee(strings[0].split(" ")[0], strings[0].split(" ")[1],
                        strings[1], strings[2], Integer.valueOf(strings[3]));
                Double dayOfWork = 105.0 * 20;
                Double severencepay = (2020 - worker.getYear_of_start()) * 20 * 0.8;
                FileWriter writer = new FileWriter(worker.getID() +".txt");
                writer.write("Name : " + worker.getName() + "\n");
                writer.write("Surname : " + worker.getSurname() + "\n");
                writer.write("Registiration Number : " + worker.getID() + "\n");
                writer.write("Position : " + worker.getPosition() + "\n");
                writer.write("Year of Start : " + worker.getYear_of_start() + "\n");
                writer.write("Total Salary : " + String.valueOf(dayOfWork + severencepay + Write.extrasalary) + "0 TL");
                writer.close();
            }
        }
    }

    public void writechief() throws IOException {
        // This method for write chiefs payroll txt
        for (String[] strings : data_personnel){
            if (strings[1].equals(Write.currentID)){
                Employee chief1 = new Employee(strings[0].split(" ")[0], strings[0].split(" ")[1],
                        strings[1], strings[2], Integer.valueOf(strings[3]));
                Double dayOfWork = 125.0 * 20;
                Double severencepay = (2020 - chief1.getYear_of_start()) * 20 * 0.8;
                FileWriter writer = new FileWriter(chief1.getID() +".txt");
                writer.write("Name : " + chief1.getName() + "\n");
                writer.write("Surname : " + chief1.getSurname() + "\n");
                writer.write("Registiration Number : " + chief1.getID() + "\n");
                writer.write("Position : " + chief1.getPosition() + "\n");
                writer.write("Year of Start : " + chief1.getYear_of_start() + "\n");
                writer.write("Total Salary : " + String.valueOf(dayOfWork + severencepay + Write.extrasalary) + "0 TL");
                writer.close();
            }
        }
    }

    public void writeparttime() throws IOException {
        // This method for write part time employees payroll txt
        for (String[] strings : data_personnel) {
            if (strings[1].equals(Write.currentID)) {
                Employee parttime1 = new Employee(strings[0].split(" ")[0], strings[0].split(" ")[1],
                        strings[1], strings[2], Integer.valueOf(strings[3]));
                Double severencepay = (2020 - parttime1.getYear_of_start()) * 20 * 0.8;
                FileWriter writer = new FileWriter(parttime1.getID() + ".txt");
                writer.write("Name : " + parttime1.getName() + "\n");
                writer.write("Surname : " + parttime1.getSurname() + "\n");
                writer.write("Registiration Number : " + parttime1.getID() + "\n");
                writer.write("Position : " + parttime1.getPosition() + "\n");
                writer.write("Year of Start : " + parttime1.getYear_of_start() + "\n");
                writer.write("Total Salary : " + String.valueOf(Write.extrasalary + severencepay) + "0 TL");
                writer.close();
            }
        }
    }

}
