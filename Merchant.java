import java.util.*;
public class Merchant{
    private ArrayList<Item> catalog;
    private String merchantName;

    public Merchant(){
        this.merchantName = "Merchant";
        catalog = new ArrayList<Item>();
    }
    public Merchant(String name){
        this.merchantName = name;
        catalog = new ArrayList<Item>();
    }
    public void add(Item i){
        catalog.add(i);
    }
    public void remove(Item i){
        catalog.remove(i);
    }
    public void printCatalog(){
        for(int i = 0; i < catalog.size(); i++){
            System.out.println(catalog.get(i));
        }
    }
    public void sellsToPlayer(Item i, Player player){
        if(player.money >= i.getPrice()){
            catalog.remove(i);
            player.inventory.add(i);
            player.money -= i.getPrice();
            System.out.println("You bought " + i.getName() +" from " + this.merchantName + " for $" + i.getPrice() +".");
        }else{
            System.out.println("Either you do not have enough money, or the merchant no longer has that item!!");
        }
    }
    public void buysFromPlayer(Item i, Player player){
        player.inventory.remove(i);
        catalog.add(i);

        player.money += i.getPrice() /2;
    }

}