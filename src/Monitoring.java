import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Monitoring {
    // This class for read other txt and super class for Write class

    private String ID; // Employee's ID
    private Integer week1; // Work hour for week1
    private Integer week2; // Work hour for week2
    private Integer week3; // Work hour for week3
    private Integer week4; // Work hour for week4
    public static List<String[]> data_monitoring; // List for hold data in the txt file

    public Monitoring(String ID, Integer week1, Integer week2, Integer week3, Integer week4) {
        // Constructor method
        this.ID = ID;
        this.week1 = week1;
        this.week2 = week2;
        this.week3 = week3;
        this.week4 = week4;
    }

    public Monitoring() {
        // Other constructor
    }

    // Getters and Setters
    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }
    public Integer getWeek1() { return week1; }
    public void setWeek1(Integer week1) { this.week1 = week1; }
    public Integer getWeek2() { return week2; }
    public void setWeek2(Integer week2) { this.week2 = week2; }
    public Integer getWeek3() { return week3; }
    public void setWeek3(Integer week3) { this.week3 = week3; }
    public Integer getWeek4() { return week4; }
    public void setWeek4(Integer week4) { this.week4 = week4; }

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

    public List<String> main(String[] args) throws IOException {
        // This method for keep data in the list
        String[] lines = readfile(args[1]);
        List<String[]> newlist = new ArrayList<>();
        for (String line : lines) {
            List<String[]> newlist2 = new ArrayList<>();
            newlist2.add(line.split("\t"));
            newlist.addAll(newlist2);
        }
        data_monitoring =  newlist;
        return null;
    }
}
