import java.io.*;
import java.util.*;

class demo {
    public int classTimes = -1;
    public int rooms = -1;
    public int classes = -1;
    public int teachers = -1;
    public int students = -1;
    public int[] classTeach = new int[20000];
    public int[] roomSize = new int[10000];

    public static void main(String[] args) {
        System.out.println("Welcome to the scheduling tool.");
        demo dem = new demo();
        String[][] constraints = dem.ReadConstraints("demo_constraints.txt");
        int[][] studentPrefs = dem.ReadStudents("demo_studentprefs.txt");
        for (int i = 0; i < studentPrefs.length; i++) {
            for (int j = 0; j < studentPrefs[i].length; j++) {
                if (studentPrefs[i][j] != 0)
                    System.out.print(studentPrefs[i][j] + " ");
            }
            System.out.println();
        }
        // for (int i = 0; i < dem.classTeach.length; i++) {
        // if (dem.classTeach[i] == 0)
        // break;
        // System.out.println(dem.classTeach[i]);
        // }
        // System.out.println();
        // for (int i = 0; i < dem.roomSize.length; i++) {
        // if (dem.roomSize[i] == 0)
        // break;
        // System.out.println(dem.roomSize[i]);
        // }
    }

    public demo() {
    }

    public int[][] ReadStudents(String a) {
        int[][] studentPrefs = new int[100][4];
        try {
            File myObj = new File(a);
            Scanner myReader = new Scanner(myObj);
            boolean boo = false;
            int j = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] temp = data.split("\\s+", 5);
                if (boo == true) {
                    int[] arr = new int[temp.length];
                    for (int i = 0; i < temp.length; i++) {
                        arr[i] = Integer.parseInt(temp[i]);
                        studentPrefs[j] = Arrays.copyOfRange(arr, 1, arr.length);
                    }
                }
                boo = true;
                j++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return studentPrefs;
    }

    public String[][] ReadConstraints(String a) {
        String[][] constraints = new String[100][2];
        try {
            File myObj = new File(a);
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (i == 0) {
                    String[] temp = data.split("\\s+", 3);
                    constraints[0][0] = (temp[0] + temp[1]);
                    constraints[0][1] = temp[2];
                } else
                    constraints[i] = data.split("\\s+", 2);
                // System.out.println(constraints[i][0] + " " + constraints[i][1]);
                i++;
            }
            myReader.close();
            int check = 0;
            classTimes = Integer.parseInt(constraints[0][1]);
            int j = 0;
            boolean swap = true;
            for (i = 0; i < constraints.length; i++) {
                if (check >= 3)
                    swap = false;
                try {
                    int next = Integer.parseInt(constraints[i][0]);
                    if (swap) {
                        roomSize[j] = Integer.parseInt(constraints[i][1]);
                    } else {
                        classTeach[j] = Integer.parseInt(constraints[i][1]);
                    }

                    j++;
                } catch (NumberFormatException e) {
                    j = 0;
                    // System.out.println(i + " " + check);
                    try {
                        if (check == 1) {
                            rooms = Integer.parseInt(constraints[i][1]);
                        } else if (check == 2) {
                            classes = Integer.parseInt(constraints[i][1]);
                        } else if (check == 3) {
                            teachers = Integer.parseInt(constraints[i][1]);
                        }
                    } catch (NumberFormatException f) {
                    }
                    check++;
                }
                if (check > 5)
                    break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // System.out.println(classTimes + " " + rooms + " " + classes + " " +
        // teachers);
        roomSize = MergeSort.main(roomSize);
        return constraints;
    }
}