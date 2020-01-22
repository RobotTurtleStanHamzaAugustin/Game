

class YellowCard extends Card {
    YellowCard() {
        this.description = "Tourner la tortue de 90° à gauche";
        this.name = "Yellow Card";
    }

    void executerCard(Player player) {
        int direction = (player.getDirection() + 4 - 1) % 4;
        int angle = (player.getAngle() + 360 - 90) % 360;
        player.setDirection(direction);
        player.setAngle(angle);
    }
}
