public class Sword implements Weapon{
    // public String attackType = "Melee";
    private int attack;
    private int durability;
    private String specials;
    private String name;
    private int attacksMade = 0;
    private double accuracy;
    public Sword(){
        name = "Stupid Sword";
        attack = 10;
        durability = 100;
        specials = "null";
    }
    public Sword(String name, int attack,String specials,double accuracy){
        this.name  = name;
        this.attack = attack;
        this.durability = 100;
        this.specials = specials;
        this.accuracy = accuracy;
    }
    public void use(){
        System.out.println("You can't use a weapon!!!");
    }
    public String getName(){
        return name;
    }
    
    public int getAttack(){
        return attack;
    }
   
    public int getDurability(){
        return durability;
    }
    // public String getSlot(){
    //     return slot;
    // }
    public void decreaseDurability(){
        this.durability = this.durability - (this.attacksMade*5);
        //Call once at the end
    }

    public String getSpecials() {
        if(this.specials == ""){
            return ("None");
        }
        return specials;
    }
    
    public void setSpecials(String specials) {
        this.specials = specials;
    }
   

    public void increaseAttack(Player player){
        player.attack += this.attack;

    }
    public void decreaseAttack(Player player){
        player.attack -= this.attack;
    }
    public int getAttacksMade(){
        return attacksMade;
    }
    public void incrementNumberOfUses(){
        attacksMade += 1;
    }
    public double getAccuracy(){
        return this.accuracy;
    }



    public String toString() {
        
        return this.name + "\n" + "ATT: " + this.attack + "\n" + "Specials: " + this.getSpecials() + "\nDurability: " + this.durability +"%\nSlot: "+this.slot + "\n";
    }
}