/**
 * Diese Klasse repraesentiert Oger.
 * Oger trinken Elixire, die gewisse Auswirkungen auf sie haben.
 * Ein Oger kann einen Begleiter haben und (mit diesem) gegen andere
 * Oger kaempfen.
 */
class Ogre {
    private int xPos;
    private int yPos;
    private String color;
    private int lifepoints;
    private int strength;
    private Ogre companion;
    /**
     * Initialisert ein Oger-Objekt mit Werten fuer die Attribute.
     *
     * @param xPos  x-Position des Ogers im canvas-Fenster.
     * @param yPos  y-Position des Ogers im canvas-Fenster.
     * @param color Farbe des Ogers.
     */
    Ogre(int xPos, int yPos, String color, int lifepoints, int strength) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        this.lifepoints = lifepoints;
        this.strength = strength;
    }
    /**
     * Zeichnet dieses Oger-Objekt.
     */
    void draw() {
        Ellipse body = new Ellipse(xPos, yPos, 150, 180, this.color);
        Ellipse head = new Ellipse(xPos + 25, yPos - 90, 100, 120, this.color);
        Ellipse leftEar = new Ellipse(xPos + 10, yPos - 60, 25, 25, this.color);
        Ellipse rightEar = new Ellipse(xPos + 115, yPos - 60, 25, 25, this.color);
        Ellipse leftNostril = new Ellipse(xPos + 60, yPos - 30, 10, 10, "black");
        Ellipse rightNostril = new Ellipse(xPos + 80, yPos - 30, 10, 10, "black");
        Eye leftEye = new Eye(xPos + 45, yPos - 60);
        Eye rightEye = new Eye(xPos + 85, yPos - 60);

        body.draw();
        head.draw();
        leftEar.draw();
        rightEar.draw();
        leftNostril.draw();
        rightNostril.draw();
        leftEye.draw();
        rightEye.draw();
    }

    /**
     * Setter fuer die aktuelle Frabe des Ogers.
     *
     * @param newColour Neu Frabe, die beim naechsten {@code draw}-Aufruf verwendet wird.
     */
    void setColor(String newColour) {
        this.color = newColour;
    }

    Ogre getCompanion() {
        if(companion == null){
            return null;
        }
        return this.companion;
    }

    void move(int deltaX, int deltaY) {
        this.xPos += deltaX;
        this.yPos += deltaY;
    }

    public void meet(Ogre other) {
        int teamStrength;
        int otherTeamStrength;
        int difference;
        if (other == this || other == null) {
            return;
        }
        if (other.lifepoints < 1 || this.lifepoints < 1) {
            return;
        }
        if (this.companion == null && other.companion == null) {
            this.companion = other;
            other.companion = this;
        } else {
            if (this.companion == null) {
                teamStrength = this.getStrength();
            } else {
                teamStrength = this.companion.getStrength() + this.getStrength();
            }
            if (other.companion == null) {
                otherTeamStrength = other.getStrength();
            } else {
                otherTeamStrength = other.companion.getStrength() + other.getStrength();
            }
            if (teamStrength < otherTeamStrength) {
                difference = otherTeamStrength - teamStrength;
                this.setLifePoints(this.getLifePoints() - difference);
            } else {
                difference = teamStrength - otherTeamStrength;
                other.setLifePoints(other.getLifePoints() - difference);
            }
            if (this.getLifePoints() < 1) {
            this.setColor("black");
            if (this.companion != null) {
                this.companion.companion = null;
                this.companion = null;
            }
            }
        }
    }
    public void drinkElixir(Elixir elixir) {
        if (getLifePoints() >= 1) {
            if (elixir.makesInvisible() == true) {

                setColor("white");
            }
            setLifePoints(getLifePoints()+elixir.heal());
        }
    }
    public int getStrength() {
        return strength;
    }
    public int getxPos() {
        return xPos;
    }
    public int getyPos() {
        return yPos;
    }
    public String getColor() {
        return color;
    }
    public int getLifePoints() {
        if (this.lifepoints < 0) {
            return 0;
        } else {
            return lifepoints;
        }
    }
    public void setLifePoints(int lifepoints) {
       this.lifepoints = lifepoints;
        if (lifepoints < 1) {
            setColor("black");
        }
    }

}


