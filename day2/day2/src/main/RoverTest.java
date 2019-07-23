package main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class RoverTest {
    @Test
    void roverInitializesWithGivenDetails() {
        RoverVector roverVector = new RoverVector(0, 0, "N");
        assertEquals("0 0 N", roverVector.getVectorDetails());
    }
    @Test
    void roverCanRotateLeft() {
        RoverVector roverVector = new RoverVector(10, 20, "N");
        roverVector.turnLeft();
        assertEquals("10 20 W", roverVector.getVectorDetails());
    }
    @Test
    void roverCanRotateRight() {
        RoverVector roverVector = new RoverVector(2, 50, "E");
        roverVector.turnRight();
        assertEquals("2 50 S", roverVector.getVectorDetails());
    }
}