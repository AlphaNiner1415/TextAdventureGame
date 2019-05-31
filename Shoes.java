public class Shoes implements Wearable{
    private int durability;
    private int attack;
    private int defense;
    private String name;
    private int battlesSurvived;
    private String specials;
    
    public Shoes(String name, int attack, int defense, String specials){
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.specials = specials;
        this.battlesSurvived = 0;
        this.durability = 100;
    }
    @Override
    public void use(Player player) {
        System.out.println("You can't use a shoe!!");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void decreaseDurability() {
        this.durability = this.durability - battlesSurvived*5;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public void incrementNumberOfUses() {
        battlesSurvived += 1;
    }

    @Override
    public void wear(Player player,int slot) {
        player.equippedStuff[slot] = this;
        player.inventory.remove(this);
        this.increaseStats(player);
    }
    
    public void takeOff(Player player, int slot) {
        player.equippedStuff[slot] = null;
        player.inventory.add(this);
        this.decreaseStats(player);
    }

    @Override
    public void increaseStats(Player player) {
        player.attack += this.attack;
        player.defense += this.defense;
    }

    @Override
    public void decreaseStats(Player player) {
        player.attack -= this.attack;
        player.defense -= this.defense;
    }

    @Override
    public int getSlot() {
        return 3;
    }

    @Override
    public String getSpecials() {
        if (this.specials == "") {
            return ("None");
        }
        return specials;
    }

    @Override
    public void setNumberOfUses(int i) {
        battlesSurvived = i;
    }
   
    
}