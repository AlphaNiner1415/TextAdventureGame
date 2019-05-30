public class Potion implements Item{
    private String name;
    private String category;
    private int amount;
    private int effectsDuration;

    public Potion(String name, String category, int amount, int effectsDuration){
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.effectsDuration = effectsDuration;
    }

    @Override
    public void use(Player player) {
        if (player.inventory.contains(this)){
            player.remove(this);
            switch (category) {
                case "hitpoints":
                    System.out.println("Your hitpoints have increased by " + this.amount+", you feel rejuvenated.");
                    player.hp += amount;
                    break;
                case "accuracy":
                    System.out.println("The potion has increased your accuracy by "+ this.amount + "%.");
                    player.accuracy += this.amount;
                    break;
            
                default:
                    System.out.println("The potion gives a refreshing effect, but other than that nothing has happened.");
                    break;
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void decreaseDurability() {
        return;
    }

    @Override
    public int getDurability() {
        return 0;
    }

    @Override
    public void incrementNumberOfUses() {
        effectsDuration -= 1;
    }

    @Override
    public String getSpecials() {
        return "None";
    }
    public int getEffectsDuration(){
        return effectsDuration;
    }
    public void decreaseStats(Player player){
        
        switch (category) {
            case "hitpoints":

                player.hp -= amount;
                break;
            case "accuracy":

                player.accuracy -= this.amount;
                break;
        }
        
        
    }
    public String toString(){
        return this.name + "\nThis potion increases the user's " + this.category + " by " + this.amount +"\n It still has " + effectsDuration +" battles' worth of effect left.";
    }
}