class PurpleCard extends Card {
    public PurpleCard() {
        this.description = "Tourner la tortue de 90° à droite";
        this.name =  "Purple Card";
    }

    public void executerCard(Player player){
        int direction = (player.getDirection() + 1) % 4;
        player.setDirection(direction);
    }
}
