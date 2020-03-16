public class Eye {

    private int xPos;
    private int yPos;

    Eye(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    void draw() {
        Ellipse iris = new Ellipse(xPos, yPos, 11, 11, "black");
        Ellipse pupil = new Ellipse(xPos + 3, yPos + 3, 4, 4, "white");

        iris.draw();
        pupil.draw();
    }

}
