/**
 * Klasse mit main-Methode zum Zeichnen von Szenen und als Grundlage
 * fuer die Einfuehrung von Interfaces.
 */
public class Scenery {

    public static void main(String[] args) throws Exception {
        Ogre shrek = new Ogre(100, 500, "green");
        Ogre fiona = new Ogre(850, 500, "red");
        Sun sun = new Sun(540, 80);
        Caterpillar nimmersatt = new Caterpillar(200, 700, "blue");
        Caterpillar immersatt = new Caterpillar(220, 720, "blue");
        Caterpillar immersattBruder = new Caterpillar(230, 700, "blue");
        Hut shreksHut = new Hut(98, 500, 100);
        Hut fionasHut = new Hut(950, 500, 100);

        for (int time = 0; time < 100; time++) {
for (Drawable drawable: drawables){
    drawable.draw();
}

            shrek.draw();
            fiona.draw();
            sun.draw();
            nimmersatt.draw();
            immersatt.draw();
            immersattBruder.draw();
            shreksHut.draw();
            fionasHut.draw();


            Animation.waitAndErase(100);
            shrek.advanceTime();
            fiona.advanceTime();
            sun.advanceTime();
            nimmersatt.advanceTime();
            immersatt.advanceTime();
            immersattBruder.advanceTime();
        }
    }
}
