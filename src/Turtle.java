import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Turtle {
    private Random random = new Random();
    public int posX;
    public int posY;
    private String direction = "east";
    private int distance;
    private String previousDirection = " ";


    public Turtle (int width, int height) {
        this.posX = (width / 2);
        this.posY = (height / 2);
    }

    public void centerTurtle (int width, int height) {
        this.posX = (width / 2);
        this.posY = (height / 2);
    }

    public void direction(String direction) {
        boolean invalidValue = true;
        switch (direction){
            case "forward":
            case "backward":
                System.out.println("How many cells would you like to move?");
                while (invalidValue) {
                    try {
                        this.distance = Integer.parseInt(readLine());
                        invalidValue = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid value! Please try again...");
                    }
                }
                move(direction, distance);
                previousDirection = direction;
                break;
            case "to right":
                rotate("clockwise");
                break;
            case "to left":
                rotate("counterClockwise");
                break;
            default:
                System.out.println("\n\n\nINVALID COMMAND!");
                break;
        }
    }


    public void move(String direction, int distance) {
            if ((direction.equals("forward")) & (this.direction.equals("east"))) {
                posX += distance;
            } else if ((direction.equals("backward")) & (this.direction.equals("east"))) {
                posX -= distance;
            }
            if ((direction.equals("forward")) & (this.direction.equals("south"))) {
                posY += distance;
            } else if ((direction.equals("backward")) & (this.direction.equals("south"))) {
                posY -= distance;
            }
            if ((direction.equals("forward")) & (this.direction.equals("west"))) {
                posX -= distance;
            } else if ((direction.equals("backward")) & (this.direction.equals("west"))) {
                posX += distance;
            }
            if ((direction.equals("forward")) & (this.direction.equals("north"))) {
                posY -= distance;
            } else if ((direction.equals("backward")) & (this.direction.equals("north"))) {
                posY += distance;
            }
    }

    private void rotate(String rotate) {
        if (direction.equals("east") & (rotate.equals("clockwise"))){
            this.direction = "south";
        } else if((direction.equals("south")) & (rotate.equals("clockwise"))) {
            this.direction = "west";
        } else if((direction.equals("west")) & (rotate.equals("clockwise"))) {
            this.direction = "north";
        } else if ((direction.equals("north")) & (rotate.equals("clockwise"))){
            this.direction = "east";
        }
        if (direction.equals("east") & (rotate.equals("counterClockwise"))) {
            this.direction = "north";
        } else if((direction.equals("north")) & (rotate.equals("counterClockwise"))) {
            this.direction = "west";
        } else if((direction.equals("west")) & (rotate.equals("counterClockwise"))) {
            this.direction = "south";
        } else if((direction.equals("south")) & (rotate.equals("counterClockwise"))) {
            this.direction = "east";
        }
    }

    public String getDirection() {
        return direction;
    }

    public String getPreviousDirection() {
        return previousDirection;
    }

    private static InputStreamReader in = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(in);
    private static String readLine() {


        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
