public class Clothes implements Wearable{
    private int durability;
    private int defense;
    private int attack;
   
    private String name;
    private int battlesSurvived;
    public Clothes(String name, int attack, int defense, int battlesSurvived){
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.battlesSurvived = battlesSurvived;
        durability = 100;

    }
    @Override
    public void use() {
        System.out.println("Can't use a piece of Clothing!!!");
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
    
}