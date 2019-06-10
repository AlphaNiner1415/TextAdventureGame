import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PlayerDisplayer extends JFrame {
    private static final long serialVersionUID = 1L;
    private static JTextArea playerDescription;
    private static JPanel infoPane;

    public PlayerDisplayer(Player player) {
        playerDescription = new JTextArea();
        playerDescription.append(player.toString());

        playerDescription.setEditable(false);
        infoPane = new JPanel();
        infoPane.setLayout(new BoxLayout(infoPane, BoxLayout.PAGE_AXIS));
        infoPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //infoPane.add(Box.createRigidArea(new Dimension(20,0)));
        //infoPane.add(Box.createHorizontalGlue());
        infoPane.add(playerDescription);
        setSize(350, 300);
        Container contentPane = getContentPane();
        contentPane.add(infoPane, BorderLayout.CENTER);
        //add(infoPane);
        //add(playerDescription);
        setTitle("Player description");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void reEvaluateBox(Player player) {
        playerDescription.setText("Display is being updated, \n please wait");
        try {
            Thread.sleep(2500);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        playerDescription.setText("");
        System.out.println("Updating display, please wait.");
        playerDescription.append(player.toString());
        System.out.println("Your display should now be updated.");
        
    }
    public void showInventory(Player player){
        this.remove(infoPane);
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
        
        contentPane.add(inventoryPane,BorderLayout.NORTH);
        revalidate();
        repaint();
        
    }



}