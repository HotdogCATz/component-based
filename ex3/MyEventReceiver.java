package myevent;
import java.awt.*;
import java.awt.event.*;

public class MyEventReceiver extends Panel 
implements MyListener {
  private TextArea ta;

  public MyEventReceiver() {
    setLayout(null);
    ta = new TextArea();
    ta.setBounds(0, 0, 150, 300);
    add(ta);
    setSize(150, 300);
  }

  public void changeMyValue(MyEvent e) {
    ta.append("my value changed to " + e.getMyValue() + "\n");
  }
}