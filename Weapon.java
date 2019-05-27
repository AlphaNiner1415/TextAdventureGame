interface Weapon extends Item{
    public String slot = "primaryHand";
    public void increaseAttack(Player player);
    public void decreaseAttack(Player player);
    public double getAccuracy();
}
