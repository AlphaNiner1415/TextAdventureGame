public class Clothes implements Wearable{
    private int durability;
    private int defense;
    private int attack;
    private String specials;
    private String name;
    private int battlesSurvived;
    private String slot;
    public Clothes(String name, int attack, int defense, int battlesSurvived,String specials){
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.battlesSurvived = battlesSurvived;
        durability = 100;
        slot = "Body";
        this.specials = specials;
    }
    @Override
    public void use(Player player) {
        System.out.println("Can't use a piece of Clothing!!!");
    }
    
    public String getSpecials() {
        if (this.specials == "") {
            return "None";
        } else {
            return specials;
        }

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void decreaseDurability() {
        this.durability = this.durability - (battlesSurvived*5);

    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public void wear(Player player,int slot) {
        player.equippedStuff[slot] = this;
        player.inventory.remove(this);
        this.increaseStats(player);
    }
    public void takeOff(Player player, int slot){
        player.equippedStuff[slot] = null;
        player.inventory.add(this);
        this.decreaseStats(player);
    }

    @Override
    public void increaseStats(Player player) {
        player.defense += this.defense;
        player.attack += this.attack;
    }
    public void decreaseStats(Player player){
        player.defense -= this.defense;
        player.attack -= this.attack;
    }
    public void incrementNumberOfUses(){
        battlesSurvived += 1;
    }
    public int getSlot(){
        return 1; // 1 for body slot.
    }
    public String toString(){
        return this.name + "\nATT: " +this.attack + "\nSpecials: " + this.getSpecials() + "\nDurability: " + this.durability + "%\nSlot: " + this.slot + "\n";
    }

    @Override
    public void setNumberOfUses(int i) {
        battlesSurvived = i;
    }
    
}