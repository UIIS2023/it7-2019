package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Donut extends Circle implements Cloneable {

	private int innerRadius;

	public Donut() {

	}

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		this.setSelected(selected);
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color) {
		this(center, radius, innerRadius, selected);
		this.setColor(color);
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color, Color innerColor) {
		this(center, radius, innerRadius, selected, color);
		this.setInnerColor(innerColor);
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Donut) {
			return (int) (this.area() - ((Donut) o).area());
		}
		return 0;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		super.fill(g);
		g.setColor(Color.WHITE);
		g.fillOval(this.getCenter().getX() - this.innerRadius, this.getCenter().getY() - this.innerRadius,
				this.innerRadius * 2, this.innerRadius * 2);
	}

	@Override
	public void draw(Graphics g) {
		Shape donut = transparentDonut();
		g.setColor(getInnerColor());
		((Graphics2D) g).fill(donut);
		g.setColor(getColor());
		((Graphics2D) g).draw(donut);

		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - super.getRadius() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + super.getRadius() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - super.getRadius() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + super.getRadius() - 3, 6, 6);
		}

	}

	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}

	public boolean contains(int x, int y) {
		double dFromCenter = this.getCenter().distance(x, y);
		return super.contains(x, y) && dFromCenter > innerRadius;
	}

	public boolean contains(Point p) {
		double dFromCenter = this.getCenter().distance(p.getX(), p.getY());
		return super.contains(p.getX(), p.getY()) && dFromCenter > innerRadius;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut d1 = (Donut) obj;
			if (this.getCenter().equals(d1.getCenter()) && this.getRadius() == d1.getRadius()
					&& this.innerRadius == d1.innerRadius) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public Donut clone() {

		Donut donut = new Donut();

		donut.setCenter(this.getCenter().clone());

		try {
			donut.setRadius(this.getRadius());
		} catch (Exception e) {

			throw new NumberFormatException("Radius must be greater then 0.");
		}

		donut.setInnerRadius(this.getInnerRadius());
		donut.setSelected(this.isSelected());
		donut.setColor(this.getColor());
		donut.setInnerColor(this.getInnerColor());

		return donut;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	private Shape transparentDonut() {
		Ellipse2D inner = new Ellipse2D.Double(this.getCenter().getX() - this.innerRadius,
				this.getCenter().getY() - this.innerRadius, this.innerRadius * 2, this.innerRadius * 2);
		Ellipse2D outter = new Ellipse2D.Double(super.getCenter().getX() - super.getRadius(),
				super.getCenter().getY() - super.getRadius(), super.getRadius() * 2, super.getRadius() * 2);

		Area area = new Area(outter);
		area.subtract(new Area(inner));

		return area;
	}

	public String toString() {
		return "Donut: " + super.toString() + " inner_radius: " + getInnerRadius();
	}
}
