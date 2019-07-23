public class MarsRoboRover {
    public static void main(String[] args) {
        String currentPosition = "3 3 E";
        String commands = "MMRMMRMRRM";

        String[] positions = currentPosition.split(" ");
        int x = Integer.valueOf(positions[0]);
        int y = Integer.valueOf(positions[1]);
        String dir = positions[2];

        Rover rover = new Rover(x,y,dir);
        for (char command : commands.toCharArray()) {
            rover.rove(command);
        }
        getRoverDetails(currentPosition,commands,rover);
    }
    private static void getRoverDetails(String currentPosition,String commands,Rover rover){
        System.out.println("currentPosition..." + currentPosition);
        System.out.println("commands..." + commands);
        System.out.println("newPosition..." + rover.getPosition() );
    }
}