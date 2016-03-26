import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MainMenu extends JFrame {
        private static final long serialVersionUID = 1L;
        
        int screenWidth = 275;
        int screenHeight = 200;
        
        int buttonWidth = 100;
        int buttonHeight = 40;
        
        JButton Play, Quit;
        JCheckBox twoPlayer;
    
       public MainMenu(){
                
                addButtons();
                addActions();
                
                getContentPane().setLayout(null);
                
                Play.setBounds((screenWidth - buttonWidth) / 2, 5, buttonWidth, buttonHeight);
                Quit.setBounds((screenWidth - buttonWidth) / 2, 50, buttonWidth, buttonHeight);
                twoPlayer.setBounds((screenWidth - buttonWidth) /2, 95, buttonWidth, buttonHeight);
                
                //Placing buttons
                getContentPane().add(Play);
                getContentPane().add(Quit);
                getContentPane().add(twoPlayer); //add checkbox to JFrame
                
                
                //JFrame stuff
                pack();
                setVisible(true);
                setLocationRelativeTo(null);
                setSize(screenWidth, screenHeight);
                setTitle("Pong");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setResizable(false);
                
     }
        
       
       private void addButtons(){
                Play = new JButton("Play", new ImageIcon("images/start.png"));
                Play.setContentAreaFilled(false);
                Quit = new JButton("Quit", new ImageIcon("images/exit.gif"));
                Quit.setContentAreaFilled(false);
                twoPlayer = new JCheckBox("2 PLAYERS");
           
       }
       
       private void addActions(){
                
                Play.addActionListener(new ActionListener()  {  //Takes play button, add new actionlistener
                    //@Override
                    public void actionPerformed(ActionEvent e) { //turn the action into a variable
                        dispose();
                        First game = new First();
                        
                        if(twoPlayer.isSelected()){
                            game.ai.isTwoPlayer = true;
                        } else {
                            game.ai.isTwoPlayer = false;
                        }
                        
                        game.start();
                    }
                });//Play button
                
                Quit.addActionListener(new ActionListener()  {
                    //@Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
           
       }
    
}
