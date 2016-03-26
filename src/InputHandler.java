import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{
	
	public InputHandler(First game){
		game.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_W){
			//First.player.goingdown=false;
			First.player.goingup=true;
		}
		if(keycode == KeyEvent.VK_S){
			First.player.goingdown=true;;
			//First.player.goingup=false;
		}
                 //player 2 controls
                                if(keycode == KeyEvent.VK_UP){
                                    First.ai.goingup = true;
                                }
		if(keycode == KeyEvent.VK_DOWN){
                                    First.ai.goingdown = true;
                                }
                
                                if(keycode == KeyEvent.VK_ESCAPE){
                                    System.exit(0);
                                }
	}

	
	public void keyReleased(KeyEvent e) {
         int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_W){
			//First.player.goingdown=false;
			First.player.goingup=false;
		}
		if(keycode == KeyEvent.VK_S){
			First.player.goingdown=false;
			//First.player.goingup=false;
		}
                                //player 2 controls
                                if(keycode == KeyEvent.VK_UP){
                                    First.ai.goingup = false;
                                }
		if(keycode == KeyEvent.VK_DOWN){
                                    First.ai.goingdown = false;
                                }
                                
                
	}

	
	public void keyTyped(KeyEvent e) {
		
	}

	

}