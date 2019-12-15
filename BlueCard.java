class BlueCard extends Card {
    public BlueCard() {
        this.description = "Avancer la tortue d'une case";
        this.name = "Blue Card";
    }

    public void executerCard(Player player) {
        if (player.getDirection() == 0) {
            player.setPosition(true, false, false, false);
        } else if (player.getDirection() == 1) {
            player.setPosition(false, true, false, false);
        } else if (player.getDirection() == 2) {
            player.setPosition(false, false, true, false);
        } else if (player.getDirection() == 3) {
            player.setPosition(false, false, false, true);
        }

    }

}
