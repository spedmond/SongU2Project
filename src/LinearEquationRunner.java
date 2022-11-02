import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your first coordinate: ");
        String p1 = input.nextLine();

        System.out.println("Please enter your second coordinate: ");
        String p2 = input.nextLine();

        int x1 = Integer.parseInt(p1.substring(1,p1.indexOf(",")));
        int x2 = Integer.parseInt(p2.substring(1,p2.indexOf(",")));
        int y1 = Integer.parseInt(p1.substring((p1.indexOf(" ")+1),p1.indexOf(")")));
        int y2 = Integer.parseInt(p2.substring((p2.indexOf(" ")+1),p2.indexOf(")")));

        if (x1==x2) {
            System.out.println("The line is vertical.");
            System.out.println("Equation: x = " + x1);
            return;
        }

        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);

        equation.start();
        System.out.println("Equation: " + equation.equation());
        System.out.println("Slope: " + equation.slope());
        System.out.println("y-intercept: " + equation.yIntercept());
        System.out.println("Distance: " + equation.distance());
        System.out.println();
        System.out.println("----- Line info -----");
        System.out.println(equation.lineInfo());
        System.out.println();
        double testX = 4;
        System.out.println("Coordinate for x: " + equation.coordinateForX(testX));

    }
}
