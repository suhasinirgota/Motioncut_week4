import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class TextAdventureGameGUI extends JFrame {
    private JButton button1;
    private JButton button2;
    private JLabel label;
    private int currentStep = 0;
    public TextAdventureGameGUI() {
        super("Text Adventure Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 400));
        label = new JLabel("Welcome to the Text Adventure Game!");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBorder(new EmptyBorder(20, 20, 20, 20));
        label.setForeground(new Color(51, 153, 255)); // Set custom text color
        add(label, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        button1 = createStyledButton("Explore the enchanted forest");
        button2 = createStyledButton("Set up camp and rest");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        add(buttonPanel, BorderLayout.CENTER);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButton1Click();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButton2Click();
            }
        });
        pack();
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextAdventureGameGUI().setVisible(true);
            }
        });
    }
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(51, 153, 255)); // Set custom button background color
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand
        return button;
    }
    private void handleButton1Click() {
        if (currentStep == 0) {
            label.setText("<html>You step into the enchanted forest, surrounded by ancient trees<br> covered in glowing moss.</html>");
            label.setToolTipText("Choose 1 to follow the lights, or 2 to listen to the forest's whispers.");
            button1.setText("Follow the mysterious lights");
            button2.setText("Listen to the forest's whispers");
            currentStep = 1;
        } else if (currentStep == 1) {
            int choice = getUserChoice("1 or 2");
            if (choice == 1) {
                label.setText("<html>As you follow the lights, you discover a hidden glen where <br>fairies dance under the moonlight.</html>");
                label.setToolTipText("Choose 1 to join the fairies in their dance, or 2 to observe quietly from a distance.");
                button1.setText("Join the fairies in their dance");
                button2.setText("Observe quietly from a distance");
                currentStep = 2;
            } else if (choice == 2) {
                 label.setText("Invalid game state. Please restart the game.");
                button1.setVisible(false);
                button2.setVisible(false);
                currentStep = 99; // End of the story
            }
            else{
                label.setText("Invalid choice. Please select 1 or 2.");
                button1.setVisible(false);
                button2.setVisible(false);
            }
        }
        else{
            int choice1 = getUserChoice("1 or 2");
            if (choice1 == 1) {
                label.setText("<html>Enchanted by the music, you  couldn't resist joining the fairies in their dance and enjoyed the night.<br><br><hr><br><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*END OF STORY*</p></html>");
                button1.setVisible(false);
                button2.setVisible(false);
                currentStep = 99; // End of the story
            }
            else if(choice1 == 2) {
                label.setText("Invalid game state. Please restart the game.");
                button1.setVisible(false);
                button2.setVisible(false);   
                currentStep = 99; // End of the story
         
            }
            else{
                label.setText("Invalid choice. Please select 1 or 2.");
                button1.setVisible(false);
                button2.setVisible(false);

            }
        }
    }
    private void handleButton2Click() {
        if (currentStep == 0) {
            label.setText("<html>You decide to set up camp in a peaceful clearing and rest under the starry sky.<br><br><hr><br><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*END OF STORY*</p></html>");
            button1.setVisible(false);
            button2.setVisible(false);
            currentStep = 99; // End of the story
        }
        else if (currentStep == 1) {
            int choice = getUserChoice("1 or 2");
            if (choice == 2) {
                label.setText("<html>You listen to the forest's whispers and feel a deep connection <br>with the ancient trees.<br><br><hr><br><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*END OF STORY*</p></html>");
                button1.setVisible(false);
                button2.setVisible(false);
                currentStep = 99; // End of the story
             } 
             else if(choice==1){
                label.setText("Invalid game state. Please restart the game.");
                button1.setVisible(false);
                button2.setVisible(false);
             }
             else{
                label.setText("Invalid choice. Please select 1 or 2.");
                button1.setVisible(false);
                button2.setVisible(false);
                }  
        }
        else{
            int choice1 = getUserChoice("1 or 2");
            if (choice1 == 1) {
                label.setText("Invalid game state. Please restart the game.");
                button1.setVisible(false);
                button2.setVisible(false);            }
            else if(choice1 == 2) {
                label.setText("<html>You were captivated by the fairies dance and chose to let them be, savoring the enchanting spectacle from a distance.<br><br><hr><br><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*END OF STORY*</p></html>");
                button1.setVisible(false);
                button2.setVisible(false);
                currentStep = 99; // End of the story
            }
            else{
                label.setText("Invalid choice. Please select 1 or 2.");
                button1.setVisible(false);
                button2.setVisible(false);

            }
        }
        
    }
    private int getUserChoice(String validOptions) {
        while (true) {
            String input = JOptionPane.showInputDialog("Confirm your choice:");
            if (input == null) {
                // User closed the dialog, treat it as cancel
                return -1;
            }
            try {
                int choice = Integer.parseInt(input);
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    JOptionPane.showMessageDialog(null, 
                    "Invalid input. Please enter a valid choice (1 or 2).", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, 
                "Invalid input. Please enter a valid choice (1 or 2).", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}








