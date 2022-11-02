public class LinearEquation {
    //Instance Variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    //Constructor
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void start() {
        System.out.println("Welcome!");
    }

    /* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
    the nearest hundredth */
    public double distance() {
        return roundedToHundredth(Math.sqrt((Math.pow((x2-x1),2) + Math.pow((y2-y1),2))));
    }


    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double yIntercept() {
        return roundedToHundredth(y1 - (slope() * x1));
    }


    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double slope() {
        return roundedToHundredth((double)(y2 - y1) / (x2 - x1));
    }


    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".
       First finds the slope, then finds the y-int and adds them together.*/
    public String equation() {
        int rise = y2-y1;
        int run = x2-x1;
        boolean isWhole = (double)rise%run==0.0;
        boolean risePos = rise>0;
        boolean runPos = run>0;
        boolean riseNeg = rise<0;
        boolean runNeg = run<0;

        String slope;
        String b;
        //SLOPE
        if (isWhole && risePos && runPos) { //two pos #s, simplified
            slope = rise/run + "x";
        }
        else if (risePos && runPos) { //two pos #s, can't simplify
            slope = rise + "/" + run + "x";
        }
        //-------------------------------
        else if (((risePos && runNeg)||(riseNeg && runPos)) && isWhole) { //one neg #, simplified
            slope = "-" + (rise/run) + "x";
        }
        else if ((risePos && runNeg)||(riseNeg && runPos)) { //one neg #, can't simplify
            slope = "-" + rise + "/" + run + "x";
        }
        //-------------------------------
        else if (isWhole && riseNeg && runNeg) { //two negative #s, simplified to whole #
            slope = Math.abs(rise)/Math.abs(run) + "x";
        }
        else if (riseNeg && runNeg) { //two neg #s, can't simplify
            slope = Math.abs(rise) + "/" + Math.abs(run) + "x"; //two negative #s, can't simplify
        }
        //-------------------------------
        else { //zero
            slope = "";
        }

        //B
        if (yIntercept()==0) { //Prints nothing if y-int is zero
            b = "";
        }
        else if (yIntercept()<0) { //Prints "-" instead of "+" if negative
            b = " - " + yIntercept();
        }
        else {
            b = " + " + yIntercept();
        }
        return "y = " + slope + b;
    }


    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue) {
        return "(" + xValue + ", " + roundedToHundredth(slope()*xValue+yIntercept()) + ")";
    }

    //Used in other methods, multiplies by 100 to get hundredths place as the ones digit, rounds, then sends it back to the hundredths place by dividing by 100 again
    public double roundedToHundredth(double toRound) {
        return Math.round(toRound*100)/100.0;
    }


    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method)

      This method should call all other appropriate methods to get the info it needs:
      equation(), slope(), yIntercept(), distance().
      */
    public String lineInfo() {
        return "Original points: " + "(" + x1 + ", " + y1 + ") " + "and" + " (" + x2 + ", " + y2 + ")" + "\n" +
                "Equation of the line: " + equation() + "\n" +
                "Slope: " + slope() + "\n" +
                "Y-intercept: " + yIntercept() + "\n" +
                "Distance between the points: " + distance();
    }
}
