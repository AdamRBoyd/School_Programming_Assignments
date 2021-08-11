package asModel;

import java.util.Vector;

public class Model {
	
	private int recLength;
	private int recWidth;
	private Vector<MyPropertyChangeListener> myPropertyChangeListeners = new Vector<MyPropertyChangeListener>();

	public Model(int l, int w) {
		recLength = l;
		recWidth = w;
	}

	public void setRecLength(int l) {
		MyPropertyChangeEvent me = new MyPropertyChangeEvent("length", recLength, l);
		recLength = l;
		fireMyPropertyChanged(me);
	}

	public void setRecWidth(int w) {
		MyPropertyChangeEvent me = new MyPropertyChangeEvent("width", recWidth, w);
		recWidth = w;
		fireMyPropertyChanged(me);
	}

	public int getRecLength() {
		return recLength;
	}

	public int getRecWidth() {
		return recWidth;
	}

	public synchronized void fireMyPropertyChanged(MyPropertyChangeEvent ev) {
		for (int i = 0; i < myPropertyChangeListeners.size(); i++) {
			myPropertyChangeListeners.elementAt(i).myPropertyChange(ev);
		}
	}

	public synchronized void addMyPropertyChangeListener(MyPropertyChangeListener ml) {
		if (!myPropertyChangeListeners.contains(ml)) {
			myPropertyChangeListeners.addElement(ml);
		}
	}

	public synchronized void removeMyPropertyChangeListener(MyPropertyChangeListener ml) {
		if (myPropertyChangeListeners.contains(ml)) {
			myPropertyChangeListeners.removeElement(ml);
		}
	}
}
