public class MainDisplayerTest{
    public static void main(String[] args) {
        Player player1 = new Player("Anon", 200, 10, 20, 50);
        MainDisplayer displayer1 = new MainDisplayer(player1);
        displayer1.setVisible(true);
    }
}