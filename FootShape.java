
import java.util.Scanner;

public class FootShape {

    private Foot pencil;

    public void getDrawTypeFromUser(String drawType) {
        switch (drawType) {
            case "Ellipse" ->
                pencil = new Ellipse();
            case "Rectangle" ->
                pencil = new Rectangle();
        }
    }

    public String draw() {
        return pencil.draw();
    }

    public static void main(String[] args) {
        FootShape app = new FootShape();
        Scanner inp = new Scanner(System.in);
        System.out.print("What to draw? 1. Ellipse, 2. Rectangle ");
        int type = inp.nextInt();
        switch (type) {
            case 1 ->
                app.getDrawTypeFromUser("Ellipse");
            case 2 ->
                app.getDrawTypeFromUser("Rectangle");

        }
        System.out.println(app.draw());
    }
}
