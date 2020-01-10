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
    private List<Blocks> blocksInHand;
    private int passageOrder;

    public Player(String color, int[] position, String name, int passageOrder) {
        this.color = color;
        this.direction = 2;
        this.position = position;
        this.name = name;
        this.passageOrder = passageOrder;
        this.setDeck();
        this.setBlocksInHand();
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }


    public void setProgram(List<Card> program) {

        this.program = program;
    }

    public void setPosition(boolean up, boolean right, boolean down, boolean left) {
        if (up) {
            this.position[0] -= 1;
        } else if (down) {
            this.position[0] += 1;
        } else if (right) {
            this.position[1] += 1;
        } else if (left) {
            this.position[1] -= 1;
        }

    }

    public void retourDepart() {
        this.direction = 2;
        if (this.passageOrder == 1) {
            this.position = new int[]{0, 0};
        } else if (this.passageOrder == 2) {
            this.position = new int[]{0, 2};
        } else if (this.passageOrder == 3) {
            this.position = new int[]{0, 5};
        } else if (this.passageOrder == 4) {
            this.position = new int[]{0, 7};
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

    public void setBlocksInHand() {
        this.blocksInHand = new ArrayList<Blocks>();
        StoneBlock stoneBlock = new StoneBlock();
        IceBlock iceBlock = new IceBlock();
        for (int i = 0; i < 3; i++) {
            this.blocksInHand.add(stoneBlock);
        }
        for (int i = 0; i < 2; i++) {
            this.blocksInHand.add(iceBlock);
        }

    }

    public void initialiserHand() {
        this.hand = new ArrayList<Card>();
        for (int i = 0; i < 5; i++) {
            this.hand.add(this.deck.get(0));
            this.deck.remove(0);
        }
    }


    public void initialiserProgram() {
        this.program = new ArrayList<Card>();

    }

    public void completerProgram(int ind) {
        this.program.add(this.hand.get(ind));
        this.hand.remove(ind);


    }

    public List<Card> getProgram() {
        return program;
    }

    public void defausserHand(int i) {
        this.hand.remove(i);
    }

    public void defausserBlock(int i) {
        this.blocksInHand.remove(i);
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

    public List<Blocks> getBlocksInHand() {
        return blocksInHand;
    }

    public String getName() {
        return name;
    }

    public int getDirection() {
        return direction;
    }

    public int[] getPosition() {
        return position;
    }

    public int getPassageOrder() {
        return passageOrder;
    }
}
