public interface Wearable extends Item{
    public void wear(Player player,int slot);
    public void increaseStats(Player player);
    public void decreaseStats(Player player);
    public int getSlot();
    public void takeOff(Player player, int slot);
}