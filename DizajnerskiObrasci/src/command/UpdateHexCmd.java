package command;

import adapter.HexAdapter;

public class UpdateHexCmd implements Cmd {

	private HexAdapter oldState;
	private HexAdapter newState;
	private HexAdapter original = new HexAdapter();;

	public UpdateHexCmd(HexAdapter oldState, HexAdapter newState) {

		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {

		original = (HexAdapter) oldState.clone();

		oldState.getHexagon().setX(newState.getHexagon().getX());
		oldState.getHexagon().setY(newState.getHexagon().getY());

		try {
			oldState.getHexagon().setR(newState.getHexagon().getR());
		} catch (Exception e) {
			throw new NumberFormatException("Radius must be greater then 0.");
		}

		oldState.getHexagon().setSelected(newState.getHexagon().isSelected());
		oldState.getHexagon().setBorderColor(newState.getHexagon().getBorderColor());
		oldState.getHexagon().setAreaColor(newState.getHexagon().getAreaColor());

	}

	@Override
	public void unexecute() {

		oldState.getHexagon().setX(original.getHexagon().getX());
		oldState.getHexagon().setY(original.getHexagon().getY());

		try {
			oldState.getHexagon().setR(original.getHexagon().getR());
		} catch (Exception e) {
			throw new NumberFormatException("Radius must be greater then 0.");
		}

		oldState.getHexagon().setSelected(original.getHexagon().isSelected());
		oldState.getHexagon().setBorderColor(original.getHexagon().getBorderColor());
		oldState.getHexagon().setAreaColor(original.getHexagon().getAreaColor());

	}

}
