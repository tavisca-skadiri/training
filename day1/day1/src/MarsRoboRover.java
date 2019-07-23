public class MarsRoboRover {
    public static void main(String[] args) {
        String currentPosition = "3 3 E";
        String commands = "MMRMMRMRRM";
        String[] positions = currentPosition.split(" ");
        int x = Integer.valueOf(positions[0]);
        int y = Integer.valueOf(positions[1]);
        String dir = positions[2];

        //First Rover
        RoboMovement roboMovement = new RoboMovement(x,y,dir);
        for (char newMovement : commands.toCharArray()) {
            changeMovement(newMovement,roboMovement);
        }
        displayOutput(currentPosition, commands, roboMovement);

        //Second rover
        RoboMovement roboMovement2 = new RoboMovement(x,y,dir);
        for (char newMovement : commands.toCharArray()) {
            changeMovement(newMovement,roboMovement2);
        }
        displayOutput(currentPosition, commands, roboMovement);
    }
    private static void changeMovement(char newMovement, RoboMovement roboMovement) {
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
    private static void displayOutput(String currentPosition,String commands, RoboMovement roboMovement){
        System.out.println("currentPosition..." + currentPosition);
        System.out.println("commands..." + commands);
        System.out.println("newPosition..." + roboMovement.getX() + " " + roboMovement.getY() + " " + roboMovement.getCurrentDirection());
    }
}