public class FighterTest{
    public static void main(String[] args) {
        Player myPlayer = new Player("Anon", 100, 10, 20, 50);
        Sword rapier = new Sword("Rapier",20, "", 60.0);
        for(int i = 0; i < myPlayer.equippedStuff.length;i++){
            System.out.println(myPlayer.equippedStuff[i]);
        }
        Clothes comfyClothes = new Clothes("Comfortable Clothes", 0, 0, 0,"");
        System.out.println(myPlayer);
        System.out.println(comfyClothes);
        myPlayer.add(rapier);
        myPlayer.equip(rapier);
        System.out.println(rapier);
        //System.out.println(myPlayer);
        myPlayer.unequip(rapier);
       //System.out.println(myPlayer);
    }
}