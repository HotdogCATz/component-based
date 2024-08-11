package myevent;
import java.awt.event.*;
import java.beans.*;
import java.util.*;

public class MySource {
	private int source;
	private Vector<MyListener> listeners;
	public MySource() {
		listeners = new Vector<MyListener>();
	}
	public void setSource(int val) {
		source = val;
		fireMyEvent(new MyEvent(this, source));
	}
	public int getSource() {
		return source;
	}
	public void addMyListener(MyListener l) {
		listeners.addElement(l);
	}
	public void removeMyListener(MyListener l) {
		listeners.removeElement(l);
	}
	public void fireMyEvent(MyEvent e) {
      for(int i = 0; i < listeners.size(); i++) {
			MyListener l = listeners.elementAt(i);
			l.changeMyValue(e);
		}
	}
}
