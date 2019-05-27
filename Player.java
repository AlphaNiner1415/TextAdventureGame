import java.util.Random;
import java.util.ArrayList;
public class Player {
    public String name;
    public int hp;
    public int attack;
    public int defense;
    public double accuracy;
    public int xp;
    public int maxXp;
    public int level;
    public ArrayList<Item> inventory;
    public Item[] equippedStuff;
    private double tempAccuracy;
    int[][] levelRef = {{1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10},{50,100,150,200,250,300,350,400,450,500}};
    
    Random rand = new Random();
    public Player(){
        name = "John";
        hp = 100;
        attack =10;
        defense =10;
        accuracy = 0.5;
        xp = 0;
        level = 1;
        inventory = new ArrayList<Item>();
        equippedStuff = new Item[5]; //Head, Body, Hand, Feet, Secondary
    }
    public Player(String name,int hp, int attack, int defense, int accuracy){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.accuracy = (double) accuracy;
        this.xp = 0;
        level = 1;
        inventory = new ArrayList<Item>();
        equippedStuff = new Item[5];
  
    }
    public void attack(Player F2){

        if (this.accuracy <= rand.nextDouble()){
           
            String AttackPower = attack-F2.defense + "";
            System.out.println(this.name + " attacks, dealing " + AttackPower + " to "+ F2.name+ ".");
            equippedStuff[2].incrementNumberOfUses();
            F2.hp = this.attack - F2.defense;
            if (equippedStuff[2] != null) {
                equippedStuff[2].decreaseDurability();
                if (equippedStuff[2].getDurability() == 0) {
                    System.out.println("Your " + equippedStuff[2].getName() + " breaks!!!");
                }
                
            }
            
            if (F2.hp ==0){
                System.out.println(F2.name + " has died.");
            }
        } else{
            System.out.println(this.name + " missed!");
        }
        
    }
    public void equip(Item i){
        if(i instanceof Weapon){
            Weapon w;
            w = (Weapon) i;
            if (w.slot == "primaryHand") {
                if (this.inventory.contains(w)) {
                    this.equippedStuff[2] = w;
                    w.increaseAttack(this);
                    tempAccuracy = this.accuracy;
                    this.accuracy = w.getAccuracy();
                    remove(w);
                } else {
                    System.out.println("There's no such thing in your inventory!!!!");
                }
        }else if(i instanceof Wearable){
            Wearable q = (Wearable) i;
            q.wear(this, q.getSlot());
        }
        
        }else{
            System.out.println("That item cannot be worn or held!!!!");
        }
    }
    public void unequip(Item i){
        if(i instanceof Weapon){
            Weapon w = (Weapon) i;
            w.decreaseAttack(this);
            this.equippedStuff[2] = null;
            this.accuracy = tempAccuracy;
            add(w);
        } else if(i instanceof Wearable){
            Wearable q = (Wearable) i;
            q.takeOff(this, q.getSlot());
        }
        
    }
    public void add(Item i){
        this.inventory.add(i);
    }
    public void remove(Item i){
        this.inventory.remove(i);
    }
    public String getXP(){
        for(int i = 0; i < levelRef[0].length; i++){
            if(level == levelRef[0][i]){
                maxXp = levelRef[1][i];
            }
        }
        return xp+"/"+maxXp;
    }
    public String toString(){
        return this.name + "\n------------\nHP: " + this.hp + "\nATT: " + this.attack +"\nDEF: " +this.defense + "\nAccuracy: " + this.accuracy + "\nLevel: " + level + "\n XP: " + getXP() +"\n"; 
    }
    public void getInventory(){
        if(inventory.size() == 0){
            System.out.println("Your inventory is empty!");
        }else {
            System.out.print("Your inventory contains: ");
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println(inventory.get(i).getName());
            }
        }
        
    }
    public void getEquipment(){
        for(int i = 0; i < equippedStuff.length;i++){
            System.out.println(equippedStuff[i]);
        }
    }


}