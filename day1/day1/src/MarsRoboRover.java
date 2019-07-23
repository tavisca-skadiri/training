public class MarsRoboRover {
    public static void main(String[] args) {
        String currentPosition = "3 3 E";
        String commands = "MMRMMRMRRM";
        String[] positions = currentPosition.split(" ");
        int x = Integer.valueOf(positions[0]);
        int y = Integer.valueOf(positions[1]);
        String dir = positions[2];
        RoboMovement roboMovement = new RoboMovement(x,y,dir);
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'M': roboMovement.move();
                    break;
                case 'L': roboMovement.goLeft();
                    break;
                case 'R': roboMovement.goRight();
                    break;
            }
        }
        System.out.println("currentPosition..." + currentPosition);
        System.out.println("commands..." + commands);
        System.out.println("newPosition..." + roboMovement.getX() + " " + roboMovement.getY() + " " + roboMovement.getCurrentDirection());
    }
}