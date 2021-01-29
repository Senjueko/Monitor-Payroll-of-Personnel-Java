import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Personnel {
// This class for read txt and our super class

    private String name; // Name of the employee
    private String surname; // Surname of the employee
    private String ID; // His or her ID
    private String position; // The position her or his where work
    private Integer year_of_start; // Start year
    public final Double base_salary = 2600.0; // Constant, base salary
    public static List<String[]> data_personnel; // List for hold data in the txt file

    public Personnel(String name, String surname, String ID, String position, Integer year_of_start) {
        // Constructor method
        this.name = name;
        this.surname = surname;
        this.ID = ID;
        this.position = position;
        this.year_of_start = year_of_start;
    }

    public Personnel() {
        // Other constructor method
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public Integer getYear_of_start() { return year_of_start; }
    public void setYear_of_start(Integer year_of_start) { this.year_of_start = year_of_start; }

    public static String[] readfile(String path) {
        // Method for read txt file
        try {
            int i = 0;
            int length = Files.readAllLines(Paths.get(path)).size();
            String[] results = new String[length];
            for (String line : Files.readAllLines(Paths.get(path))) {
                results[i++] = line;
            }
            return results;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public  List<String> main(String[] args) throws IOException {
        // This method for keep data in the list
        String[] lines = readfile(args[0]);
        List<String[]> newlist = new ArrayList<>();
        for (String line : lines) {
            List<String[]> newlist2 = new ArrayList<>();
            newlist2.add(line.split("\t"));
            newlist.addAll(newlist2);
        }
        data_personnel =  newlist;
        return null;
    }
}
