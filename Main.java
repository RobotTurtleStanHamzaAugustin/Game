import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*int positionBlue[] = {0, 0};
        Player bluePlayer = new Player("blue", positionBlue, "Augustin", 1);
        List<Card> liste = bluePlayer.getDeck();
        for (int i=0; i<5;i++){
            System.out.println(liste.get(i).getDescription());
        }
        System.out.println(bluePlayer.getDeck());
        bluePlayer.initialiserHand();
        System.out.println(bluePlayer.getDeck());
        List<Card> hand = bluePlayer.getHand();
        System.out.println(hand);
        bluePlayer.defausserHand(2);
        bluePlayer.defausserHand(2);
        System.out.println(hand);
        bluePlayer.piocherHand();
        System.out.println(hand);
        System.out.println(bluePlayer.getDeck())*/;
        int positionBlue[] = {0, 0};
        Player bluePlayer = new Player("blue", positionBlue, "Augustin", 1);
        bluePlayer.initialiserHand();
        bluePlayer.initialiserProgram();
        List<Card> hand = bluePlayer.getHand();
        System.out.println(hand);
        Game.getPlayerChoice(1,bluePlayer);
        System.out.println(hand);
        Game.getPlayerChoice(1,bluePlayer);
        System.out.println(hand);
        Game.getPlayerChoice(1,bluePlayer);
        System.out.println(hand);
        Game.getPlayerChoice(1,bluePlayer);
        System.out.println(hand);
        Game.getPlayerChoice(2,bluePlayer);
        System.out.println(bluePlayer.getPosition());
        System.out.println(bluePlayer.getDirection());












    }
}
