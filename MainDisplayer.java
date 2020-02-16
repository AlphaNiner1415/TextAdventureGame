import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
public class MainDisplayer extends JFrame{
    private static JScrollPane mainScrollingWindow;
    private static JTextArea mainTextPane;
    private static JButton buttonNoOne;
    private static JPanel mainPanel;
    private static JPanel buttonsPanel;
    public MainDisplayer(Player player){
        mainTextPane = new JTextArea("kfjkfjfkfj");
        mainScrollingWindow = new JScrollPane(mainTextPane);
        buttonNoOne = new JButton();
        buttonNoOne.setText("This Is a Button");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(200,200));
        buttonsPanel = new JPanel();

        this.setSize(new Dimension(350,500));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Text Adventure Game");
        mainPanel.add(mainScrollingWindow); 

        buttonsPanel.add(buttonNoOne);
        Container contentPane = getContentPane();
        contentPane.add(mainPanel);
        contentPane.add(buttonsPanel);
    }
    public void printToScreen(String printStr){
        mainTextPane.append("\n" + printStr);
        this.revalidate();
        this.repaint();
    }
}