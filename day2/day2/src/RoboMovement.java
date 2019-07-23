import java.util.ArrayList;
import java.util.Arrays;
class RoboMovement {
    private final static ArrayList<String> directions=new ArrayList<>(Arrays.asList("N","E","S","W"));;
    private int currentDirectionIndex;
    private int x;
    private int y;
    RoboMovement(int x, int y, String dir){
        currentDirectionIndex = directions.indexOf(dir);
        this.x=x;
        this.y=y;
    }
    void changeMovement(char newMovement, RoboMovement roboMovement) {
        switch (newMovement) {
            case 'M':
                roboMovement.move();
                break;
            case 'L':
                roboMovement.goLeft();
                break;
            case 'R':
                roboMovement.goRight();
                break;
        }
    }
    private void goLeft() {
        if(currentDirectionIndex==0)
            currentDirectionIndex=3;
        else
            currentDirectionIndex--;
    }
    private void goRight() {
        if(currentDirectionIndex==3)
            currentDirectionIndex=0;
        else
            currentDirectionIndex++;
    }
    private void move() {
        String currentDirection = getCurrentDirection();
        switch (currentDirection) {
            case "N": y++;
                break;
            case "E": x++;
                break;
            case "S": y--;
                break;
            case "W": x--;
                break;
        }
    }
    int getX() {
        return x;
    }
    int getY() {
        return y;
    }
    String getCurrentDirection(){
        return directions.get(currentDirectionIndex);
    }
}