import java.util.Scanner;
public class FighterTest{
    public static void main(String[] args) {
        Player myPlayer = new Player("Anon", 100, 10, 20, 50);
        Player player2 = new Player("Player2",10,10,20,50);
        Sword rapier = new Sword("Rapier",20, "", 60.0,10);
        Sword dagger = new Sword("Dagger", 10, "", 70.0, 10);
        Merchant merchant1 = new Merchant("Merchant 1");
        merchant1.add(dagger);
        merchant1.sellsToPlayer(dagger, myPlayer);
        PlayerDisplayer displayer1 = new PlayerDisplayer(myPlayer);
        Clothes comfyClothes = new Clothes("Comfortable Clothes", 0, 0, 0,"");
        Potion healthPotion = new Potion("HP Potion", "hitpoints", 30, 3);
        myPlayer.add(comfyClothes);
        //System.out.println(myPlayer);
        //System.out.println(comfyClothes);

        Scanner kb = new Scanner(System.in);

        displayer1.setVisible(true);
        System.out.println("Press enter to continue");
        //kb.nextLine();
        myPlayer.add(rapier);
        myPlayer.equip(rapier);
        
        //System.out.println(rapier);
        myPlayer.add(healthPotion);
        
        healthPotion.use(myPlayer);
        myPlayer.attack(player2);
        myPlayer.attack(player2);
        myPlayer.attack(player2);
        
        displayer1.reEvaluateBox(myPlayer);
        displayer1.showInventory(myPlayer);
        System.out.println(player2.hp);
    }
}