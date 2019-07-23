class Rover {
    private Position p=null;

    public Rover(int x, int y, String dir)
    {
        p=new Position();
        p.direction=dir;
        p.finalX=x;
        p.finalY=y;
    }

    public String getPosition()
    {
        return p.finalX + " " + p.finalY + " " + p.direction;
    }

    private void turnLeft()
    {
        if(p.direction.equalsIgnoreCase("N"))
            p.direction="W";
        else if(p.direction.equalsIgnoreCase("S"))
            p.direction="E";
        else if(p.direction.equalsIgnoreCase("E"))
            p.direction="N";
        else if(p.direction.equalsIgnoreCase("W"))
            p.direction="S";
    }

    private void turnRight()
    {
        if(p.direction.equalsIgnoreCase("N"))
            p.direction="E";
        else if(p.direction.equalsIgnoreCase("S"))
            p.direction="W";
        else if(p.direction.equalsIgnoreCase("E"))
            p.direction="S";
        else if(p.direction.equalsIgnoreCase("W"))
            p.direction="N";
    }

    private void move(String dir)
    {
        switch (dir) {
            case "N":
                p.finalY++;
                break;
            case "S":
                p.finalY--;
                break;
            case "E":
                p.finalX++;
                break;
            case "W":
                p.finalX--;
                break;
        }
    }
    public void rove(char command)
    {
        switch (command)
        {
            case 'M': this.move(p.direction);
                break;
            case 'L': this.turnLeft();
                break;
            case 'R': this.turnRight();
                break;
        }
    }
}