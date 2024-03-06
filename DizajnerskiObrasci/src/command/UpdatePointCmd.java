package command;

import geometry.Point;

public class UpdatePointCmd implements Cmd{
	
	private Point oldState;
	private Point newState; 
	private Point original;

	public UpdatePointCmd(Point oldState, Point newState) {
		this.oldState = oldState;
		this.newState = newState;

	}

	@Override
	public void execute() {
		// ovako smo radili na vezbama ali smo sada ubacili u geometry klase
//		original.setX(oldState.getX());
//		original.setY(oldState.getY());
//		original.setColor(oldState.getColor());
		
		original = oldState.clone();

		oldState.setX(newState.getX());
		oldState.setY(newState.getY());
		oldState.setColor(newState.getColor());
	}

	@Override
	public void unexecute() {
		oldState.setX(original.getX());
		oldState.setY(original.getY());
		oldState.setColor(original.getColor());

	}

}
