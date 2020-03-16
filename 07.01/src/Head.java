public class Head {

    private int xPos;
    private int yPos;
    private String colour;

    public Head(int xPos, int yPos, String colour) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.colour = colour;
    }

    public void draw() {
        Ellipse head = new Ellipse(xPos, yPos, 100, 120, this.colour);

        Ellipse leftIris = new Ellipse(xPos + 20, yPos + 30, 20, 20, "black");
        Ellipse leftPupil = new Ellipse(xPos + 25, yPos + 35, 8, 8, "white");

        Ellipse rightIris = new Ellipse(xPos + 60, yPos + 30, 20, 20, "black");
        Ellipse rightPupil = new Ellipse(xPos + 65, yPos + 35, 8, 8, "white");

        Ellipse leftEar = new Ellipse(xPos - 15, yPos + 30, 25, 25, this.colour);
        Ellipse rightEar = new Ellipse(xPos + 90, yPos + 30, 25, 25, this.colour);

        Ellipse leftNostril = new Ellipse(xPos + 35, yPos + 60, 10, 10, "black");
        Ellipse rightNostril = new Ellipse(xPos + 55, yPos + 60, 10, 10, "black");

        head.draw();
        leftIris.draw();
        leftPupil.draw();
        leftEar.draw();
        leftNostril.draw();

        rightIris.draw();
        rightPupil.draw();
        rightEar.draw();
        rightNostril.draw();

    }
    
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public void move(int deltaX, int deltaY) {
        this.xPos += deltaX;
        this.yPos += deltaY;
    }
}
