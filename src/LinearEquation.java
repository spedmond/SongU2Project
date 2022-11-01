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

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void getPoints() {
        System.out.println("Please enter your first point: ");
        p1 = input.nextLine();
        System.out.println("Please enter your second point: ");
        p2 = input.nextLine();
        x1 = Integer.parseInt(p1.substring(1,2));
        x2 = Integer.parseInt(p2.substring(1,2));
        y1 = Integer.parseInt(p1.substring(4,5));
        y2 = Integer.parseInt(p2.substring(4,5));
    }
    public String getSlope() {
        int changeInX = x2-x1;
        int changeInY = y2-y1;
        slope = changeInY + "/" + changeInX;

        if (changeInX==0) { //undefined
            return "Undefined";
        }
        else if (changeInY == 0) { //0 slope
            return "0";
        }
        /*else if (changeInX == 1) { //pos whole #
            return "" + changeInY;
        } else if (changeInX == -1) { //neg whole #
            return "-" + changeInY;
        } */
        else if (changeInX == changeInY) { //slope of one
            return "1";
        }
        else if (changeInX == changeInY * -1) { //slope of -1
            return "-1";
        }
        else if (changeInX % 1.0==0.0 && changeInY % 1.0==0.0) {
            return changeInY/changeInX + "";
        }
        else if ((changeInX < 0 && changeInY > 0) || (changeInX > 0 && changeInY < 0)) { //neg fraction slope
            return "-" + changeInY + "/" + changeInX;
        }
        else { //positive fraction slope
            return changeInY + "/" + changeInX;
        }
    }

    public
}
