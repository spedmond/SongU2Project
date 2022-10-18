import java.util.Scanner;

public class LinearEquation {
    Scanner input = new Scanner(System.in);
    private String p1;
    private String p2;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private String slope;

    public void getPoints() {
        System.out.println("Please enter your first point: ");
        p1 = input.nextLine();
        System.out.println("Please enter your second point: ");
        p2 = input.nextLine();
    }
    public String getSlope() {
        x1 = Integer.parseInt(p1.substring(1,2));
        x2 = Integer.parseInt(p2.substring(1,2));
        y1 = Integer.parseInt(p1.substring(4,5));
        y2 = Integer.parseInt(p2.substring(4,5));
        int changeInX = x2-x1;
        int changeInY = y2-y1;
        slope = changeInY + "/" + changeInX;

        if (changeInX==0) {
            return "Undefined";
        }
        else if (changeInX==1) {
            return "" + changeInY;
        }
        else if (changeInX==-1) {
            return "-" + changeInY;
        }
        else if ((changeInX < 0 && changeInY > 0) || (changeInX > 0 && changeInY < 0)) {
            return "-" + changeInY + "/" + changeInX;
        }
        else {
            return changeInY + "/" + changeInX;
        }

    }
}
