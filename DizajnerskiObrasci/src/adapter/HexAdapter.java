package adapter;

import java.awt.Color;
import java.awt.Graphics;

import geometry.Point;
import geometry.Shape;
import hexagon.Hexagon;

public class HexAdapter extends Shape {
	
	// Kompozicija (referenca i konstruktori)
	// 2. nacin je Nasledjivanje

	private Hexagon hexagon = new Hexagon(0,0,0);

	public HexAdapter() {

	}

	public HexAdapter(Point p) {
		hexagon.setX(p.getX());
		hexagon.setY(p.getY());
	}

	public HexAdapter(Point p, int r) {
		hexagon.setX(p.getX());
		hexagon.setY(p.getY());
		hexagon.setR(r);

	}

	public HexAdapter(Point p, int r, boolean sel, Color borderC, Color innerC) {
		this.hexagon = new Hexagon(p.getX(), p.getY(), r);
		this.hexagon.setBorderColor(borderC);
		this.hexagon.setAreaColor(innerC);
		this.hexagon.setSelected(sel);
	}

	public HexAdapter(Point p, int r, Color borderC, Color innerC) {

		this.hexagon = new Hexagon(p.getX(), p.getY(), r);
		this.hexagon.setBorderColor(borderC);
		this.hexagon.setAreaColor(innerC);

	}

	@Override
	public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Hexagon) {
			return (this.hexagon.getR() - ((Hexagon) o).getR());
		}
		return 0;
	}

	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.hexagon.getX() - 3, this.hexagon.getY() - 3, 6, 6);
			g.drawRect(this.hexagon.getX() - this.hexagon.getR() - 3, this.hexagon.getY() - 3, 6, 6);
			g.drawRect(this.hexagon.getX() + this.hexagon.getR() - 3, this.hexagon.getY() - 3, 6, 6);
			g.drawRect(this.hexagon.getX() - 3, this.hexagon.getY() - this.hexagon.getR() - 3, 6, 6);
			g.drawRect(this.hexagon.getX() - 3, this.hexagon.getY() + this.hexagon.getR() - 3, 6, 6);
		}
	}
	
	public HexAdapter clone () {
		HexAdapter hexAdapt = new HexAdapter(); 

		hexAdapt.hexagon.setX(this.hexagon.getX());
		hexAdapt.hexagon.setY(this.hexagon.getY());

				try {
					hexAdapt.hexagon.setR(this.hexagon.getR());
				} catch (Exception e) {
					throw new NumberFormatException("Radius must be greater then 0.");
				}

				hexAdapt.hexagon.setSelected(this.hexagon.isSelected());
				hexAdapt.hexagon.setBorderColor(this.hexagon.getBorderColor());
				hexAdapt.hexagon.setAreaColor(this.hexagon.getAreaColor());

		return hexAdapt;
	}

	
	public Hexagon getHexagon() {
		return hexagon;
	}

	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
	public String toString() {
		return "Hexagon: center: " + getHexagon().getX() + " " + getHexagon().getY() + " radius: " + getHexagon().getR()
				+ " area_color: " + getHexagon().getAreaColor().getRGB() + " line_color: "
				+ getHexagon().getBorderColor().getRGB();
	}

	
}
