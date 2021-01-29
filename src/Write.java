import java.io.IOException;
import java.util.List;

public class Write extends Monitoring {

    public static Integer extrasalary = 0; // This is the overwork salary to reach other classes
    public static String currentID = ""; // Current ID for reach other classes and match the ID's

    public Write(String ID, Integer week1, Integer week2, Integer week3, Integer week4) {
        // Constructor
        super(ID, week1, week2, week3, week4);
    }

    public Write() {
        // Other Constructor
    }

    public List<String> main(String[] args) throws IOException {
        // Main method for compile and read txt's
        Personnel personnel = new Personnel();
        Monitoring monitoring = new Monitoring();
        personnel.main(args);
        monitoring.main(args);
        read();
        return null;
    }

    public void read() throws IOException {
        // This method for read the data lists
        for (String[] strings : Monitoring.data_monitoring) {
            Write write = new Write(strings[0], Integer.valueOf(strings[1]), Integer.valueOf(strings[2]),
                    Integer.valueOf(strings[3]), Integer.valueOf(strings[4]));
            if (write.getID().substring(0, 1).equals("R")) {
                currentID = strings[0];
                Academician academician = new Academician();
                academician.writeassistant();
            }

            if (write.getID().substring(0, 1).equals("F")) {
                currentID = strings[0];
                extrasalary = 0;
                Academician facultymember = new Academician();
                int addCourse = 0;
                Integer[] liste = {Integer.valueOf(strings[1]), Integer.valueOf(strings[2]), Integer.valueOf(strings[3]),
                        Integer.valueOf(strings[4])};

                for (Integer integer : liste) {
                    if (integer - 40 >= 8) {
                        addCourse = addCourse + 8;
                    } else {
                        addCourse = addCourse + (integer - 40);
                    }
                }
                extrasalary = 20 * addCourse;
                facultymember.writefacultymember();
            }

            if (write.getID().substring(0, 1).equals("W")){
                currentID = strings[0];
                extrasalary = 0;
                Employee worker = new Employee();
                int overwork = 0;
                Integer[] liste = {Integer.valueOf(strings[1]), Integer.valueOf(strings[2]), Integer.valueOf(strings[3]),
                        Integer.valueOf(strings[4])};
                for (Integer integer : liste) {
                    if (integer - 40 >= 10) {
                        overwork = overwork + 10;
                    } else {
                        overwork = overwork + (integer - 40);
                    }
                }
                extrasalary = 11 * overwork;
                worker.writeworker();
            }

            if (write.getID().substring(0, 1).equals("S")){
                currentID = strings[0];
                extrasalary = 0;
                Security security = new Security();
                int foodtransmoney = 90;
                Integer[] liste = {Integer.valueOf(strings[1]), Integer.valueOf(strings[2]), Integer.valueOf(strings[3]),
                        Integer.valueOf(strings[4])};
                for (Integer integer : liste){
                    if (integer >= 30 && integer <= 54){
                        extrasalary = extrasalary + (integer * 10) + foodtransmoney;
                    }
                    else if (integer > 54){
                        extrasalary = extrasalary + (54 * 10) + foodtransmoney;
                    }
                }
                security.writesecurity();
            }

            if (write.getID().substring(0, 1).equals("O")){
                currentID = strings[0];
                extrasalary = 0;
                Officer officer = new Officer();
                int overwork = 0;
                Integer[] liste = {Integer.valueOf(strings[1]), Integer.valueOf(strings[2]), Integer.valueOf(strings[3]),
                        Integer.valueOf(strings[4])};
                for (Integer integer : liste) {
                    if (integer - 40 >= 10) {
                        overwork = overwork + 10;
                    } else {
                        overwork = overwork + (integer - 40);
                    }
                }
                extrasalary = 20 * overwork;
                officer.writeofficer();

            }

            if (write.getID().substring(0, 1).equals("C")){
                currentID = strings[0];
                extrasalary = 0;
                Employee chief = new Employee();
                int overwork = 0;
                Integer[] liste = {Integer.valueOf(strings[1]), Integer.valueOf(strings[2]), Integer.valueOf(strings[3]),
                        Integer.valueOf(strings[4])};
                for (Integer integer : liste) {
                    if (integer - 40 >= 8) {
                        overwork = overwork + 8;
                    } else {
                        overwork = overwork + (integer - 40);
                    }
                }
                extrasalary = 15 * overwork;
                chief.writechief();
            }

            if (write.getID().substring(0, 1).equals("P")){
                currentID = strings[0];
                extrasalary = 0;
                Employee parttime = new Employee();
                Integer[] liste = {Integer.valueOf(strings[1]), Integer.valueOf(strings[2]), Integer.valueOf(strings[3]),
                        Integer.valueOf(strings[4])};
                for (Integer integer : liste){
                    if (integer >= 10 && integer <= 20){
                        extrasalary = extrasalary + (integer * 18);
                    }
                    else if (integer > 20){
                        extrasalary = extrasalary + (20 * 18);
                    }
                }
                parttime.writeparttime();

            }
        }

    }
}

