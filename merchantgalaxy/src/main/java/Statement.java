class Statement {
    private String romanNumber;
    private int credits;
    private String unknownMetal;
    Statement(String romanNumber, int credits, String unknownMetal) {
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
    String getRomanNumber() {
        return romanNumber;
    }
    int getCredits() {
        return credits;
    }
    String getUnknownMetal() {
        return unknownMetal;
    }
}