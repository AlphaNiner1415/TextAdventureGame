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
    public int bagSize;
    public Item[] equippedStuff;
    private final double defaultAccuracy;
    public ArrayList<Potion> potionsInEffect;
    public int money;
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
        money = 1000;
        inventory = new ArrayList<Item>();
        equippedStuff = new Item[5]; //Head, Body, Hand, Feet, Secondary
        bagSize = 20;
        defaultAccuracy = 0.5;
    }
    public Player(String name,int hp, int attack, int defense, int accuracy){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.accuracy = ((double) accuracy)/100;
        this.xp = 0;
        level = 1;
        inventory = new ArrayList<Item>();
        equippedStuff = new Item[5];
        potionsInEffect = new ArrayList<Potion>();
        money = 1000;
        bagSize = 20;
        defaultAccuracy = accuracy;
        
  
    }
    public void attack(Player F2){
        if(F2.hp <= 0){
            System.out.println("The player is already dead, why would you beat up a corpse?");
            return;
        }

        if (this.accuracy <= rand.nextDouble()){
            String AttackPower = attack-F2.defense + "";
            System.out.println(this.name + " attacks, dealing " + AttackPower + " damage to "+ F2.name+ ".");
            F2.hp -= this.attack -F2.defense;
            System.out.println(F2.name + " now has " + F2.hp + " hitpoints left.");
            equippedStuff[2].incrementNumberOfUses();
            Weapon w;
            w =(Weapon) equippedStuff[2];
            if(w.getAttacksMade() >= w.getDurability()/5){
                w.decreaseDurability();
                w.setNumberOfUses(0);
                System.out.println("Your "+ w.getName() + " breaks!");
            }

            if(F2.hp <= 0){
                System.out.println("Player " + F2.name + " has died.");
                for(Potion p : potionsInEffect){
                    p.incrementNumberOfUses();
                    if(p.getEffectsDuration()<= 0){
                        p.decreaseStats(this);
                    }
                }
                for(int i = 0; i < equippedStuff.length; i++){
                    if(i != 2 && equippedStuff[i] != null){
                        equippedStuff[i].incrementNumberOfUses();
                        if(checkIfBroken(equippedStuff[i])){
                            System.out.println("Your " + equippedStuff[i].getName() + "breaks!");
                        }
                    }
                }
            }
        } else {
            System.out.println(this.name + " missed!!");
        }
    }
    public String equip(Item i){
        String returnString = "";
        if(inventory.contains(i)){
            if(i instanceof Weapon){
                Weapon w;
                w = (Weapon) i;
                equipWeapon(w);
                returnString = "Equipping " + w.getName();
                System.out.println(returnString);
            }else if(i instanceof Wearable){
                Wearable q = (Wearable) i;
                equipWearable(q);
                
                returnString = "Equipping " + q.getName();
            } else {
                returnString = "That item cannot be worn or held. Why don't you try using it instead?";
            }
        }else{
            returnString = "There is no such thing in your inventory!!!!";
        }
        return returnString;
    }
    public void equipWearable(Wearable q){
        if(this.equippedStuff[q.getSlot()] != null){
            Wearable alreadyWorn = (Wearable) this.equippedStuff[q.getSlot()];
            alreadyWorn.takeOff(this, alreadyWorn.getSlot());
        }
        q.wear(this, q.getSlot()); //Wear already increase the Stats.
    }
    public void equipWeapon(Weapon w){
        if(this.equippedStuff[2] != null){
            Item alreadyEquipped = this.equippedStuff[2];
            unequip(alreadyEquipped);
        } 
        
        this.equippedStuff[2] = w;
        w.increaseAttack(this);
        this.accuracy = w.getAccuracy();
        remove(w);
        
    }
    public void unequip(Item i){
        if(i instanceof Weapon){
            Weapon w = (Weapon) i;
            w.decreaseAttack(this);
            this.equippedStuff[2] = null;
            this.accuracy = defaultAccuracy;
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
        return this.name + "\n------------\nHP: " + this.hp + "\nATT: " + this.attack +"\nDEF: " +this.defense + "\nAccuracy: " + this.accuracy + "\nLevel: " + level + "\n XP: " + getXP() +"\nCash: " + this.money + "\n"; 
    }
    public void getInventory(){
        if(inventory.size() == 0){
            System.out.println("Your inventory is empty!");
        }else {
            System.out.println("Your inventory contains: ");
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
    public boolean checkIfBroken(Item i){
        i.decreaseDurability();
        i.setNumberOfUses(0);
        if(i.getDurability() <= 0){
            return true;
        }else {
            
            return false;
        }
    }
    public void use(Item i){
        i.use(this);
    }
    public int getNonNullInventoryLength(){
        int count = 0;
        for(int i = 0; i < this.inventory.size();i++){
            if(this.inventory.get(i) != null){
                count++;
            }
        }
        return count;
    }


}