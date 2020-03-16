public class Castle {
    int xPos;
    int yPos;
    int width;
    int height;

    public Castle(int xPos, int yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    public boolean isTower(int w) {
        if (width % 2 != 0) {
            return (w % 2 == 0);
        } else {

            if (w < width / 2) {
                return (w % 2 == 0);
            } else {
                return (w % 2 == 1);
                }
            }
        }



        public void draw () {
            for (int w = 0; w < width; w++) {
                for (int h = 0; h < height; h++) {
                    Square boden = new Square(xPos + 25 * w, yPos - 25 * h, 25, "gray");
                    boden.draw();
                }
            }
            for (int w = 0; w < width; w++) {
                if (isTower(w)) {
                    Square towerStown = new Square(xPos + 25 * w, yPos - 25 * height, 25, "gray");
                    towerStown.draw();
                    Triangle tower = new Triangle(xPos + 25 * w, yPos - 25 * (height + 1), 25, 25, "red");
                    tower.draw();
                }
            }
        }
    }
