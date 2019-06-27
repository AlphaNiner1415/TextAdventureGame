import java.util.Scanner;
public class FighterTest{
    public static void main(String[] args) {
        Player myPlayer = new Player("Anon", 100, 10, 20, 50);
        Player player2 = new Player("Player2",10,10,20,50);
        Sword rapier = new Sword("Rapier",20, "", 60.0,10);
        Sword dagger = new Sword("Dagger", 10, "", 70.0, 10);
        Clothes comfyClothes = new Clothes("Comfortable Clothes", 0, 0, 0, "");
        Potion healthPotion = new Potion("HP Potion", "hitpoints", 30, 3);
        Merchant merchant1 = new Merchant("Merchant 1");
        merchant1.add(dagger);
        

        myPlayer.add(comfyClothes);
        myPlayer.add(rapier);
        myPlayer.equip(rapier);
        myPlayer.equip(comfyClothes);
        myPlayer.add(healthPotion);
   
    }
    public static void menu(Player player, Merchant merchant){
        Scanner sc = new Scanner(System.in);
        System.out.print("Welcome to the Text Adventure Game v2.0!!! This is the Prelude stage of the game, where you'll have time to look at your character sheet or buy stuff from the merchant, once you're ready choose \"Advance to the Next Screen\".\n Now please choose what to do: \n1) Open Character Menu\n2) Buy Stuff from the merchant\n3) Advance to the Next Screen\nPlease type a number choosing what to do: ");
        int userInput1 = Integer.parseInt(sc.nextLine());
        
        if (userInput1 != 3){
            while(userInput1 != 3){
                if(userInput1 == 2){
                    buys(player, merchant);
                } else if (userInput1 == 1) {
                    System.out.println(player);
                }
                System.out.print("What do you want to do? \n1) Open Character Menu\n2) Buy Stuff from the merchant\n 3) Advance to the Next Screen\n> ");
                int userInput2 = Integer.parseInt(sc.nextLine());
                userInput1 = userInput2;
            }
        }
    }
    public static void buys(Player player, Merchant merchant){
        Scanner sc = new Scanner(System.in);
        merchant.printCatalog();
        System.out.print("What do you want to buy?\n> ");
        String userBuy = sc.nextLine();

        for (int i = 0; i < merchant.catalog.size(); i++) {
            if (merchant.catalog.get(i).getName() == userBuy) {
                merchant.sellsToPlayer(merchant.catalog.get(i), player);
                break;
            }
        }
    }
}