public class Hut implements Drawable {
	private int xPos;
	private int yPos;
	private int dimension;
	private String roofColor = "camouflageGreen";
	private String corpusColor = "brown";

	/**
	 * Creates a new oger-hut. Initial position may be specified by caller. Size
	 * is fixed.
	 * 
	 * @param x X-Coordinate of top left corner
	 * @param y Y-Coordinate of top left corner
	 */
	public Hut(int x, int y, int dimension) {
		xPos = x;
		yPos = y;
		this.dimension = dimension;
	}

	public void draw() {
		Square b = new Square(xPos, yPos, dimension, corpusColor);
		b.draw();

		Triangle roof = new Triangle(xPos, yPos - dimension, dimension, dimension, roofColor);
		roof.draw();
	}

	@Override
	public void advanceTime() {
	}

}
