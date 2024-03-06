package observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SelectedShapes {
	
	private int s;
	private PropertyChangeSupport pcs; 


	public SelectedShapes() {
		//kad kreiramo objekat, kreiramo i instancu pcs i prihvata klasu na koju se odnosi
		
		pcs = new PropertyChangeSupport(this);
	}

	//mora observer da se prijavi na nase pracenje
	//koristi se osluskivac 
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {

		pcs.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {

		pcs.removePropertyChangeListener(pcl);
	}

	
	public int getSize() {
		return s;
	}

	public void setSize(int s) {
		pcs.firePropertyChange("Size", this.s, s);
		this.s = s;
	}

	public PropertyChangeSupport getPcs() {
		return pcs;
	}

	public void setPcs(PropertyChangeSupport pcs) {
		this.pcs = pcs;
	}

}
