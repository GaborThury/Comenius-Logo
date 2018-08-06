import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Map {
    private int width;
    private int height;
    public static char[][] map;
    public int previousY;
    public int previousX;
    private int placeTurtleCounter = 0;
    public boolean penDown = false;


    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        map = new char[height][width];
    }
    public void mapGenerate () {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = '◇';
            }
        }
    }

    public void placeTurtle (int posX, int posY, String direction) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if ((map[i][j] == '▶') ||
                        (map[i][j] == '▼') ||
                        (map[i][j] == '◀') ||
                        (map[i][j] == '▲')) {
                    map[i][j] = '◇';
                }
            }
        }
        if (direction.equals("east")) {
            try {
                map[posY][posX] = '▶';
                placeTurtleCounter++;
            } catch (Exception e) {
                System.out.println("\n*****\nThe number you have entered is too big, your Turtle left the map! Please try again...\n*****\n");
            }
        }
        if (direction.equals("south")) {
            try {
                map[posY][posX] = '▼';
                placeTurtleCounter++;
            } catch (Exception e) {
                System.out.println("\n*****\nThe number you have entered is too big, your Turtle left the map! Please try again...\n*****\n");
            }
        }
        if (direction.equals("west")) {
            try {
                map[posY][posX] = '◀';
                placeTurtleCounter++;
            } catch (Exception e) {
                System.out.println("\n*****\nThe number you have entered is too big, your Turtle left the map! Please try again...\n*****\n");
            }
        }
        if (direction.equals("north")) {
            try {
                map[posY][posX] = '▲';
                placeTurtleCounter++;
            } catch (Exception e) {
                System.out.println("\n*****\nThe number you have entered is too big, your Turtle left the map! Please try again...\n*****\n");
            }
        }
    }

    public void draw (int posX, int posY, String direction, String previousDirection) {
        if (penDown && placeTurtleCounter > 1) {
            if ((direction.equals("east")) && previousDirection.equals("forward") ||
                    direction.equals("west") && previousDirection.equals("backward")) {
                for (int i = previousX; i <= posX; i++) {
                    try {
                        map[posY][i] = '■';
                    } catch (Exception ignored) {
                    }
                }
            }
            if ((direction.equals("west")) && previousDirection.equals("forward") ||
                    direction.equals("east") && previousDirection.equals("backward")) {
                for (int i = previousX; i >= posX; i--) {
                    try {
                        map[posY][i] = '■';
                    } catch (Exception ignored) {
                    }
                }
            }
            if ((direction.equals("south")) && previousDirection.equals("forward") ||
                    direction.equals("north") && previousDirection.equals("backward")) {
                for (int i = previousY; i <= posY; i++) {
                    try {
                        map[i][posX] = '■';
                    } catch (Exception ignored) {
                    }
                }
            }
            if ((direction.equals("north")) && previousDirection.equals("forward") ||
                    direction.equals("south") && previousDirection.equals("backward")) {
                for (int i = previousY; i >= posY; i--) {
                    try {
                        map[i][posX] = '■';
                    } catch (Exception ignored) {
                    }
                }
            }
        }
    }

    public void clearMap () {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '■') {
                    map[i][j] = '◇';
                }
            }
        }
    }

    public void print () {
        for (char[] aMap : map) {
            for (char anAMap : aMap) {
                System.out.print(anAMap + " ");
            }
            System.out.println();
        }
    }

    public void commandList() {
        System.out.println("The commands are: forward, backward, to right, to left, pen up, pen down, center, clear, exit.");
    }

    public String penExamine(){
        if (penDown){
            return "down";
        } else{
            return "up";
        }
    }
}

