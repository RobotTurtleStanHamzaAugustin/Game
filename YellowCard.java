import sun.security.util.ArrayUtil;

class YellowCard extends Card{
    public YellowCard() {
        this.description = "Tourner la tortue de 90° à gauche";
        this.name =  "Yellow Card";
    }

    public void executerCard(Player player){
        int direction = (player.getDirection() + 4 - 1) % 4;
        player.setDirection(direction);
    }
}
