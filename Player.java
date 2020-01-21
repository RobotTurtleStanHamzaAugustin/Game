import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private String color;
    private int direction;
    private int angle;
    private int[] position;
    private int[] positionFrame;
    private String name;
    private List<Card> program;
    private List<Card> deck;
    private List<Card> hand;
    private List<Blocks> blocksInHand;
    private int passageOrder;

    public Player(String color, int[] position,int[] positionFrame, String name, int passageOrder) {
        this.color = color;
        this.direction = 2;
        this.angle = 270;
        this.position = position;
        this.positionFrame = positionFrame;
        this.name = name;
        this.passageOrder = passageOrder;
        this.setDeck();
        this.setBlocksInHand();
    }

    public String getColor() {
        return color;
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
            this.positionFrame[1] -= 79;
        } else if (down) {
            this.position[0] += 1;
            this.positionFrame[1] += 79;
        } else if (right) {
            this.position[1] += 1;
            this.positionFrame[0] += 81;
        } else if (left) {
            this.position[1] -= 1;
            this.positionFrame[0] -= 81;
        }

    }

    public void retourDepart(Graphique graphique) {
        this.direction = 2;
        switch (graphique.getMenu()){
            case 2:
                if (this.passageOrder == 1) {
                    this.position = new int[]{0, 1};
                    this.positionFrame = new int[]{107,24};
                    this.angle = 270;
                } else if (this.passageOrder == 2) {
                    this.position = new int[]{0, 5};
                    this.positionFrame = new int[]{431, 24};
                    this.angle = 270;
                }
                break;
            case 3:
                if (this.passageOrder == 1) {
                    this.position = new int[]{0, 0};
                    this.positionFrame = new int[]{26,24};
                    this.angle = 270;
                } else if (this.passageOrder == 2) {
                    this.position = new int[]{0, 3};
                    this.positionFrame = new int[]{269,24};
                    this.angle = 270;
                } else if (this.passageOrder == 3) {
                    this.position = new int[]{0, 6};
                    this.positionFrame = new int[]{512,24};
                    this.angle = 270;
                }
                break;
            case 4:
                if (this.passageOrder == 1) {
                    this.position = new int[]{0, 0};
                    this.positionFrame = new int[]{26,24};
                    this.angle = 270;
                } else if (this.passageOrder == 2) {
                    this.position = new int[]{0, 2};
                    this.positionFrame = new int[]{188,24};
                    this.angle = 270;
                } else if (this.passageOrder == 3) {
                    this.position = new int[]{0, 5};
                    this.positionFrame = new int[]{431,24};
                    this.angle = 270;
                } else if (this.passageOrder == 4) {
                    this.position = new int[]{0, 7};
                    this.positionFrame = new int[]{593,24};
                    this.angle = 270;
                }
                break;
            default:
                break;
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

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int[] getPosition() {
        return position;
    }

    public int getPassageOrder() {
        return passageOrder;
    }

    public int[] getPositionFrame() {
        return positionFrame;
    }


    public void setPositionFrame(int[] positionFrame) {
        this.positionFrame = positionFrame;
    }

    public  void inverserPosition(){
        if (this.direction == 0){
            this.direction = 2;
            this.angle = 270;
        } else if (this.direction == 1){
            this.direction = 3;
            this.angle =0;
        } else if (this.direction == 2){
            this.direction = 0;
            this.angle = 90;
        } else if (this.direction == 3){
            this.direction = 1;
            this.angle = 180;
        }

    }
}
