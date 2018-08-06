import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        boolean invalidWidth = true;
        boolean invalidHeight = true;
        int width = 0;
        int height = 0;
        String key = "";

        // Giving map's width
        while (invalidWidth) {
            try {
                System.out.println("Please, give the map's width: ");
                width = Integer.parseInt(readLine());
                if (width < 1) {
                    System.out.println("You have entered an invalid value! Please try again...");
                } else {
                    invalidWidth = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an invalid value! Please try again...");
            }
        }
        // Giving map's height
        while(invalidHeight) {
            try {
                System.out.println("Please, give the map's height: ");
                height = Integer.parseInt(readLine());
                if (height < 1) {
                    System.out.println("You have entered an invalid value! Please try again...");
                } else {
                    invalidHeight = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an invalid value! Please try again...");
            }
        }

        // Creating turtle and map
        Turtle turtle = new Turtle(width, height);
        Map map = new Map(width, height);

        // Generating map
        map.mapGenerate();

        while (true) {
            // Placing the turtle on the map
            map.placeTurtle(turtle.posX, turtle.posY, turtle.getDirection());
            // Printing command list and pen state
            map.commandList();
            System.out.println("The pen is: " + map.penExamine() + "\n");
            // Printing the map
            map.print();
            key = readLine();
            switch (key) {
                case "exit":
                    System.out.println("Bye!\nExiting...");
                    System.exit(0);
                case "pen down":
                    map.penDown = true;
                    break;
                case "pen up":
                    map.penDown = false;
                    break;
                case "center":
                    map.penDown = false;
                    turtle.centerTurtle(width, height);
                    break;
                case "clear":
                    map.clearMap();
                    break;
                default:
                    turtle.direction(key);
                    break;
            }
            // If the pen is down and there was movement, this method makes the drawing on the map
            map.draw(turtle.posX, turtle.posY, turtle.getDirection(), turtle.getPreviousDirection());
            System.out.println();
            map.previousX = turtle.posX;
            map.previousY = turtle.posY;
        }
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