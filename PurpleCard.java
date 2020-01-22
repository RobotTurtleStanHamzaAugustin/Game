class PurpleCard extends Card {
    PurpleCard() {
        this.description = "Tourner la tortue de 90° à droite";
        this.name = "Purple Card";
    }

    void executerCard(Player player) {
        int direction = (player.getDirection() + 1) % 4;
        int angle = (player.getAngle() + 90) % 360;
        player.setDirection(direction);
        player.setAngle(angle);
    }
}
