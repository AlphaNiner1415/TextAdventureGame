import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PlayerDisplayer extends JFrame{
    private static final long serialVersionUID = 1L;
    private static JTextArea playerDescription;
    public PlayerDisplayer(Player player){
        playerDescription = new JTextArea();
        playerDescription.append(player.toString());
       
        playerDescription.setEditable(false);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setSize(350,300);
        add(playerDescription);
        setTitle("Player description");
        
    }

}