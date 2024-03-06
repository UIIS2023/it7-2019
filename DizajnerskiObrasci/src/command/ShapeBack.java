package command;

import geometry.Shape;
import mvc.DrawingModel;

public class ShapeBack implements Cmd{
	
	//najniza pozicija
	
	private Shape shape; 
	private DrawingModel model; 
	private int index;

	public ShapeBack(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model; 
		this.index = model.getShapes().indexOf(shape);
	}

	@Override
	public void execute() {
		model.getShapes().remove(index);
		model.addOnIndex(0, shape);

	}

	@Override
	public void unexecute() {
		model.getShapes().remove(0);
		model.addOnIndex(index, shape);

	}

}
