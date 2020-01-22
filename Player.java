

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Player {
    private String color;
    private int direction;
    private int angle;
    private int[] position;
    private int[] positionFrame;
    private List<Card> program;
    private List<Card> deck;
    private List<Card> hand;
    private List<Blocks> blocksInHand;
    private int passageOrder;

    Player(String color, int[] position, int[] positionFrame, int passageOrder) {
        this.color = color;
        this.direction = 2;
        this.angle = 270;
        this.position = position;
        this.positionFrame = positionFrame;

        this.passageOrder = passageOrder;
        this.setDeck();
        this.setBlocksInHand();
    }

    String getColor() {
        return color;
    }

    void setDirection(int direction) {
        this.direction = direction;
    }


    void setPosition(boolean up, boolean right, boolean down, boolean left) {
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

    void retourDepart(Graphique graphique) {
        this.direction = 2;
        switch (graphique.getMenu()) {
            case 2:
                if (this.passageOrder == 1) {
                    this.position = new int[]{0, 1};
                    this.positionFrame = new int[]{107, 24};
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
                    this.positionFrame = new int[]{26, 24};
                    this.angle = 270;
                } else if (this.passageOrder == 2) {
                    this.position = new int[]{0, 3};
                    this.positionFrame = new int[]{269, 24};
                    this.angle = 270;
                } else if (this.passageOrder == 3) {
                    this.position = new int[]{0, 6};
                    this.positionFrame = new int[]{512, 24};
                    this.angle = 270;
                }
                break;
            case 4:
                if (this.passageOrder == 1) {
                    this.position = new int[]{0, 0};
                    this.positionFrame = new int[]{26, 24};
                    this.angle = 270;
                } else if (this.passageOrder == 2) {
                    this.position = new int[]{0, 2};
                    this.positionFrame = new int[]{188, 24};
                    this.angle = 270;
                } else if (this.passageOrder == 3) {
                    this.position = new int[]{0, 5};
                    this.positionFrame = new int[]{431, 24};
                    this.angle = 270;
                } else if (this.passageOrder == 4) {
                    this.position = new int[]{0, 7};
                    this.positionFrame = new int[]{593, 24};
                    this.angle = 270;
                }
                break;
            default:
                break;
        }
    }

    private void setDeck() {
        this.deck = new ArrayList<>();
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

    private void setBlocksInHand() {
        this.blocksInHand = new ArrayList<>();
        StoneBlock stoneBlock = new StoneBlock();
        IceBlock iceBlock = new IceBlock();
        for (int i = 0; i < 3; i++) {
            this.blocksInHand.add(stoneBlock);
        }
        for (int i = 0; i < 2; i++) {
            this.blocksInHand.add(iceBlock);
        }

    }

    void initialiserHand() {
        this.hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            this.hand.add(this.deck.get(0));
            this.deck.remove(0);
        }
    }


    void initialiserProgram() {
        this.program = new ArrayList<>();

    }

    void completerProgram(int ind) {
        this.program.add(this.hand.get(ind));
        this.hand.remove(ind);


    }

    List<Card> getProgram() {
        return program;
    }

    void defausserHand(int i) {
        this.hand.remove(i);
    }

    void defausserBlock(int i) {
        this.blocksInHand.remove(i);
    }


    void piocherHand() {
        while (this.hand.size() < 5) {
            if (this.deck.size() > 0) {
                this.hand.add(this.deck.get(0));
                this.deck.remove(0);
            } else {
                this.setDeck();
            }

        }
    }

    List<Card> getHand() {
        return hand;
    }

    List<Blocks> getBlocksInHand() {
        return blocksInHand;
    }

    int getDirection() {
        return direction;
    }

    int getAngle() {
        return angle;
    }

    void setAngle(int angle) {
        this.angle = angle;
    }

    int[] getPosition() {
        return position;
    }

    int getPassageOrder() {
        return passageOrder;
    }

    int[] getPositionFrame() {
        return positionFrame;
    }


    void inverserPosition() {
        if (this.direction == 0) {
            this.direction = 2;
            this.angle = 270;
        } else if (this.direction == 1) {
            this.direction = 3;
            this.angle = 0;
        } else if (this.direction == 2) {
            this.direction = 0;
            this.angle = 90;
        } else if (this.direction == 3) {
            this.direction = 1;
            this.angle = 180;
        }

    }

    List<Card> getDeck() {
        return deck;
    }
}
