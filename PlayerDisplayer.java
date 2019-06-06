import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerDisplayer extends JFrame {
    private static final long serialVersionUID = 1L;
    private static JTextArea playerDescription;

    public PlayerDisplayer(Player player) {
        playerDescription = new JTextArea();
        playerDescription.append(player.toString());

        playerDescription.setEditable(false);
        JPanel infoPane = new JPanel();
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
        JPanel inventory = new JPanel();
        inventory.setLayout(new BoxLayout(inventory, BoxLayout.PAGE_AXIS));
        for(int i = 0; i < player.inventory.size(); i++){
            JPanel item = new JPanel();
            item.setLayout(new BoxLayout(item,BoxLayout.LINE_AXIS));
            JLabel name = new JLabel(player.inventory.get(i).getName());
            item.add(name);
            item.add(Box.createHorizontalGlue());

            JButton Equip = new JButton("Equip");
            item.add(Equip);
            item.add(Box.createRigidArea(new Dimension(2,0)));

            JButton useButton = new JButton("Use");
            item.add(useButton);
            item.add(Box.createRigidArea(new Dimension(2, 0)));

            JButton disposeButton = new JButton("Throw Away");
            item.add(disposeButton);
            inventory.add(item);
        }
        Container contentPane = getContentPane();
        contentPane.add(inventory,BorderLayout.NORTH);
        revalidate();
        repaint();
        
    }

}