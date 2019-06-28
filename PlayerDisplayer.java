import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerDisplayer extends JFrame {
    private static final long serialVersionUID = 1L;
    private static JTextArea playerDescription;
    private static JPanel infoPane;
    private static JFrame playerInfoWindow;
    private static JPanel outputPanel;

    public PlayerDisplayer(Player player) {
        //infoPane.add(Box.createRigidArea(new Dimension(20,0)));
        //infoPane.add(Box.createHorizontalGlue());  
        setSize(350, 300);
        //add(infoPane);
        //add(playerDescription);
        setTitle("Player description");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        playerInfoWindow = new JFrame("Player Description");
        playerInfoWindow.setSize(350, 300);
        playerInfoWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        outputPanel = new JPanel();
        outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.PAGE_AXIS));
        Container contentPane = getContentPane();
        this.pack();
        contentPane.add(outputPanel, BorderLayout.SOUTH);
        this.pack();
    }
    public void showPlayerInfo(Player player){
        infoPane = new JPanel();
        infoPane.setLayout(new BoxLayout(infoPane, BoxLayout.PAGE_AXIS));
        infoPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        playerDescription = new JTextArea();
        playerDescription.append(player.toString());
        playerDescription.setEditable(false);
        
        infoPane.add(playerDescription);
        Container contentPane = playerInfoWindow.getContentPane();
        this.pack();
        contentPane.add(infoPane, BorderLayout.NORTH);
        this.pack();
        playerInfoWindow.setVisible(true);
        playerInfoWindow.revalidate();
        playerInfoWindow.repaint();
    }
    public void reEvaluateBox(Player player) {
        playerDescription.setText("Display is being updated, \n please wait\n");
        //playerDescription.setText("");
        System.out.println("Updating display, please wait.");
        playerDescription.setText(player.toString());
        System.out.println("Your display should now be updated.");
        
    }
    public void showInventory(Player player){
        //this.remove(infoPane);
        this.setTitle("Inventory");
        JPanel inventoryPane = new JPanel();
        inventoryPane.setLayout(new BoxLayout(inventoryPane, BoxLayout.PAGE_AXIS));
        JPanel[] item = new JPanel[player.bagSize];
        for(int i = 0; i < player.getNonNullInventoryLength(); i++){
            item[i] = new JPanel();
            item[i].setLayout(new BoxLayout(item[i],BoxLayout.LINE_AXIS));

            JLabel name = new JLabel(player.inventory.get(i).getName());
            Item thisItem = player.inventory.get(i);
            item[i].add(name);
            item[i].add(Box.createHorizontalGlue());
            int no = i;

            JButton equip = new JButton("Equip");
            equip.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Execute when button is pressed
                    player.equip(thisItem);
                    inventoryPane.remove(item[no]);
                    revalidate();
                    repaint();
                }
            });
            item[i].add(equip);
            item[i].add(Box.createRigidArea(new Dimension(2,0)));

            JButton useButton = new JButton("Use");
            useButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Execute when button is pressed
                    player.use(thisItem);
                    if(thisItem instanceof Potion){
                        inventoryPane.remove(item[no]);
                        revalidate();
                        repaint();
                    }
                }
            });
            item[i].add(useButton);
            item[i].add(Box.createRigidArea(new Dimension(2, 0)));

            JButton disposeButton = new JButton("Throw Away");
            disposeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Execute when button is pressed
                    player.remove(thisItem);
                    inventoryPane.remove(item[no]);
                    revalidate();
                    repaint();
                }
            });
            item[i].add(disposeButton);
            inventoryPane.add(item[i]);
        }
        Container contentPane = getContentPane();
        this.pack();
        contentPane.add(inventoryPane,BorderLayout.CENTER);
        this.pack();
        revalidate();
        repaint();
        
    }
    public void printOut(String prtstr){
        
        JTextArea gameLog = new JTextArea();
        gameLog.setEditable(false);
        gameLog.setText("\n"+prtstr+"\n");
        outputPanel.add(gameLog);
        System.out.println("Printing to screen");
        revalidate();
        repaint();
    }
}