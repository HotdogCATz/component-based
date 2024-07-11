/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author sarun
 */
public class FootShape {

    /**
     * @param args the command line arguments
     */
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
