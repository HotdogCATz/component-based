package myevent;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class MyEvent extends EventObject {
	private int myValue;
	public MyEvent() {
        super(new Object());  // Default source
        this.myValue = 0;     // Default value
    }
	public MyEvent(Object source, int val) {
		super(source);
		myValue = val;
	}
	public int getMyValue() {
		return myValue;
	}
}