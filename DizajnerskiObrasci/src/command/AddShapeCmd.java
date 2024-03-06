package command;

import geometry.Shape;
import mvc.DrawingModel;

public class AddShapeCmd implements Cmd {
	
	private DrawingModel model;
	private Shape shape;
	
	public AddShapeCmd (Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;

	}
	@Override
	public void execute() {
		
		model.getShapes().add(shape);

	}

	@Override
	public void unexecute() {
		
		model.remove(shape);

	}

}
