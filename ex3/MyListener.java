package myevent;
import java.util.*;
public interface MyListener extends EventListener {
	public void changeMyValue(MyEvent e);
}