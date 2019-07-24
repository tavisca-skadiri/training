package main;

import java.util.HashMap;

class RoverVector {
    private int x;
    private int y;
    private final String direction;
    private final HashMap<String,String> leftMap = new HashMap<>(){{
        put("N","W");
        put("W","S");
        put("S","E");
        put("E","N");
    }};
    private final HashMap<String,String> rightMap = new HashMap<>(){{
        put("N","E");
        put("W","N");
        put("S","W");
        put("E","S");
    }};
    RoverVector(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    RoverVector turnLeft() {
        String newDirection = leftMap.get(direction);
        return new RoverVector(this.x,this.y,newDirection);
    }
    RoverVector turnRight() {
        String newDirection = rightMap.get(direction);
        return new RoverVector(this.x,this.y,newDirection);
    }
    void move() {
        switch (direction) {
            case "N": y++; break;
            case "S": y--; break;
            case "E": x++; break;
            case "W": x--; break;
        }
    }
    void rove(char newCommand) {
        switch (newCommand) {
            case 'M': move();
                break;
            case 'L': turnLeft();
                break;
            case 'R': turnRight();
                break;
        }
    }
    String getVectorDetails(){
        return x + " " + y + " " + direction;
    }
}