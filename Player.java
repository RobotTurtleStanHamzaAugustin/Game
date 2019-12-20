import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private String color;
    private int direction;
    private int[] position;
    private String name;
    private List<Card> program;
    private List<Card> deck;
    private List<Card> hand;
    private List<Blocks> iceBlocks;
    private List<Blocks> stoneBlocks;
    private List<Blocks> blocksInHand;
    //    private List<Block> blocks;
    private int passageOrder;

    public Player(String color, int[] position, String name, int passageOrder) {
        this.color = color;
        this.direction = 2;
        this.position = position;
        this.name = name;
        this.passageOrder = passageOrder;
        this.setDeck();
        this.setIceBlocks();//a deplacer je ne sais où
        this.setStoneBlocks();//same
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }


    public void setProgram(List<Card> program) {

        this.program = program;
    }

    public void setPosition(boolean up, boolean right, boolean down, boolean left) {
        if (up){
            this.position[0] -= 1;
        } else if (down){
            this.position[0] += 1;
        } else if (right){
            this.position[1] += 1;
        } else if (left) {
            this.position[1] -= 1;
        }

    }

    public void setDeck() {
        this.deck = new ArrayList<Card>();
        BlueCard bluecard = new BlueCard();
        YellowCard yellowcard = new YellowCard();
        PurpleCard purplecard = new PurpleCard();
        LaserCard lasercard = new LaserCard();
        for (int i = 0; i < 18; i++) {
            this.deck.add(bluecard);
        }
        for (int i = 0; i < 8; i++) {
            this.deck.add(yellowcard);
            this.deck.add(purplecard);
        }
        for (int i = 0; i < 3; i++) {
            this.deck.add(lasercard);
        }
        Collections.shuffle(this.deck);
    }
    
     public void setIceBlocks() {
        this.iceBlocks = new ArrayList<Blocks>();
        IceBlock iceBlock = new IceBlock();
        for (int i = 0; i < 12; i++) { 
            this.iceBlocks.add(iceBlock);
        }
    }
    
    public void setStoneBlocks() {
        this.stoneBlocks = new ArrayList<Blocks>();
        StoneBlock stoneBlock = new StoneBlock();
        for (int i = 0; i < 20; i++) {
            this.stoneBlocks.add(stoneBlock);
            }
    }

    public void initialiserHand() {
        this.hand = new ArrayList<Card>();
        for (int i = 0; i < 5; i++) {
            this.hand.add(this.deck.get(0));
            this.deck.remove(0);
        }
    }

     public void initilaiserBlocksInHand() { //initialise la liste des  blocks que possedent chaque joueur
   	 this.blocksInHand = new ArrayList<Blocks>();
        for (int i = 0; i < 3; i++) {
            this.blocksInHand.add(this.iceBlocks.get(0));
            this.iceBlocks.remove(0);
        }
        for (int i = 0; i < 4; i++) {
            this.blocksInHand.add(this.stoneBlocks.get(0));
            this.stoneBlocks.remove(0);
        }
   }
    
    public void initialiserProgram() {
        this.program = new ArrayList<Card>();

    }

    public void completerProgram(int indice) {
        this.program.add(this.hand.get(indice));
        this.hand.remove(indice);
    }

    public List<Card> getProgram() {
        return program;
    }

    public void defausserHand(int i) {
        this.hand.remove(i);
    }

    public void piocherHand() {
        while (this.hand.size() < 5) {
            this.hand.add(this.deck.get(0));
            this.deck.remove(0);

        }
    }

    public List<Card> getDeck() {
        return deck;
    }

    public List<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public int getDirection() {
        return direction;
    }

    public int[] getPosition() {
        System.out.println(position[0] + " ; " + position[1]);
        return position;
    }
}
