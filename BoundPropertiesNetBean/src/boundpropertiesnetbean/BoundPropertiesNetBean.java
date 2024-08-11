/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boundpropertiesnetbean;

import java.util.Scanner;

/**
 *
 * @author wutic
 */
public class BoundPropertiesNetBean {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LiveScoreBean liveScore = new LiveScoreBean();
        Subscriber sub1 = new Subscriber();
        Subscriber sub2 = new Subscriber();
        
        liveScore.addSubscripber(sub1);
        liveScore.addSubscripber(sub2);
        
        Scanner sc = new Scanner(System.in);
        // user input
        while (true) {
            System.out.println("Enter score for Team LIV (or press 'Enter' key to quit): ");
            String livScoreInput = sc.nextLine();
            if (livScoreInput.isEmpty()){
                break;
            }
                
            System.out.println("Enter score for Team SEV (or press 'Enter' key to quit): ");
            String sevScoreInput = sc.nextLine();
            if (sevScoreInput.isEmpty()){
                break;
            }
                
            int livScore = Integer.parseInt(livScoreInput);
            int sevScore = Integer.parseInt(sevScoreInput);
                
            liveScore.setScoreLineProperty(livScore, sevScore);
        }
        sc.close();
    }
    
}
