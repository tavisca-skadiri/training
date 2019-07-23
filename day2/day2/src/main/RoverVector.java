package main;
class RoverVector {
    int x;
    int y;
    String direction;
    RoverVector(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    void turnLeft() {
        if(direction.equalsIgnoreCase("N"))
            direction="W";
        else if(direction.equalsIgnoreCase("S"))
            direction="E";
        else if(direction.equalsIgnoreCase("E"))
            direction="N";
        else if(direction.equalsIgnoreCase("W"))
            direction="S";
    }
    void turnRight() {
        if(direction.equalsIgnoreCase("N"))
            direction="E";
        else if(direction.equalsIgnoreCase("S"))
            direction="W";
        else if(direction.equalsIgnoreCase("E"))
            direction="S";
        else if(direction.equalsIgnoreCase("W"))
            direction="N";
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