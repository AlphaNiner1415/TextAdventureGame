public class FighterTest{
    public static void main(String[] args) {
        Player myPlayer = new Player("Anon", 100, 10, 20, 50);
        Player player2 = new Player("Test",10,10,20,50);
        Sword rapier = new Sword("Rapier",20, "", 60.0,10);
        Sword dagger = new Sword("Dagger", 10, "", 70.0, 10);
        Merchant merchant1 = new Merchant("Merchant 1");
        merchant1.add(dagger);
        merchant1.sellsToPlayer(dagger, myPlayer);
        
        System.out.println(rapier.getAccuracy());
        for(int i = 0; i < myPlayer.equippedStuff.length;i++){
            System.out.println(myPlayer.equippedStuff[i]);
        }
        Clothes comfyClothes = new Clothes("Comfortable Clothes", 0, 0, 0,"");
        Potion healthPotion = new Potion("HP Potion", "hitpoints", 30, 3);
        //System.out.println(myPlayer);
        //System.out.println(comfyClothes);
        myPlayer.add(rapier);
        myPlayer.equip(rapier);
        //System.out.println(rapier);
        myPlayer.add(healthPotion);
        healthPotion.use(myPlayer);
        myPlayer.attack(player2);
        myPlayer.attack(player2);
        myPlayer.attack(player2);
        System.out.println(myPlayer);
    }
}