import java.util.ArrayList;

class Statement {
    String romanNumber;
    int credits;
    String unknownMetal;
    public Statement(String romanNumber, int credits, String unknownMetal) {
        this.romanNumber = romanNumber;
        this.credits = credits;
        this.unknownMetal = unknownMetal;
    }
    @Override
    public String toString() {
        return "Statement{" +
                "romanNumber='" + romanNumber + '\'' +
                ", credits=" + credits +
                ", unknownMetal='" + unknownMetal + '\'' +
                '}';
    }
}