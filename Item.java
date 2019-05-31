public interface Item{
    
    public void use(Player player);
    //public void remove(Player player);
    //public String getDescription();
    public String toString();
    public String getName();
    public void decreaseDurability();
    public int getDurability();
    //public String getSlot();
    public void incrementNumberOfUses();
    public String getSpecials();
	public void setNumberOfUses(int i);
    

    //public void add(Player player);
}