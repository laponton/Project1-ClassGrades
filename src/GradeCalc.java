import java.util.*;
import java.io.*;
import java.text.*;
public class GradeCalc {
    public static void main(String[]args) throws IOException {


        File inputFile = new File("ClassGrades.txt");
        Scanner data = new Scanner(inputFile);
        DecimalFormat averages = new DecimalFormat("#.#");
        int students = data.nextInt();
        int assignments = data.nextInt();
        double gradebook[][] = new double [students + 1][assignments + 1];

        //putting the scores into the array
        for (int i=0; i<students; i++) { //rows
            for (int j=0; j<assignments; j++) { //coloums
                gradebook[i][j] = data.nextDouble();
            }
        }

        //calculating the average assignment score for each student (coloums)
        for (int i=0; i<students; i++) {
            double studentTotal = 0;
            for (int j=0; j<assignments; j++) {
                studentTotal = studentTotal + gradebook[i][j];
            }
            gradebook[i][assignments] = studentTotal/assignments;
        }

        //calculating the homework average
        for (int i=0; i<students; i++) {
            double studentTotal = 0;
            for (int j=0; j<10; j++) {
                studentTotal = studentTotal + gradebook[i][j];
            }
            gradebook[i][10] = studentTotal/10;
        }

        //printing the grades
        System.out.print("\t\t\t\tAssignment #:\n\t\t");
        for (int j=0; j<assignments; j++) {
            System.out.print((j+1) + "\t");
        }

        System.out.println("Avg");
        for (int i=0; i<students; i++) {
            System.out.print("Student #" + (i+1) + ":\t");
            for (int j=0; j<10; j++) {
                System.out.print(gradebook[i][j] + "\t");
            }
            System.out.println(averages.format(gradebook[i][assignments]));
        }

        System.out.println();

        double overallAvg = 0;
        for (int i=0; i<students; i++) {
            overallAvg = overallAvg + gradebook[i][assignments];
        }

    }
}