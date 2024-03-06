package strategy;

public class SaveMenager implements Save{
	
	private Save s;


	public SaveMenager (Save s) {
		this.s = s;
	}
	@Override
	public void save(String path) {

		s.save(path);
	}


}
