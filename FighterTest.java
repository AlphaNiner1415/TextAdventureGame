public class FighterTest{
    public static void main(String[] args) {
        Player myPlayer = new Player("Anon", 100, 10, 20, 50);
        Sword rapier = new Sword("Rapier",20, "", 60.0);
        Sword emptyItem = new Sword();
        for(int i = 0; i < myPlayer.equippedStuff.length; i++){
            myPlayer.equippedStuff[i] = emptyItem;
        }
        System.out.println(myPlayer);
        myPlayer.add(rapier);
        myPlayer.equip(rapier);
        System.out.println(myPlayer);
        myPlayer.unequip(rapier);
        System.out.println(myPlayer);
    }
}