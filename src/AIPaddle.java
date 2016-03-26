import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AIPaddle {
	int x;
	int y;
	int width = 15;
	int height = 40;
                int speed = 1;
                
                boolean isTwoPlayer = false;
	
        Rectangle boundingBox;
        
	boolean goingup = false;
	boolean goingdown = false;
	
	public AIPaddle(int x, int y){
            
            this.x=x;
            this.y=y;
            boundingBox = new Rectangle(x, y, width, height);
            boundingBox.setBounds(x, y, width, height);
	}
	
	public void tick(First game){
            
            boundingBox.setBounds(x, y, width, height);
            
            if(!isTwoPlayer){
            if(First.ball.y < y && y >= 0){
                    y -= speed;
            }else if(First.ball.y > y && y + height <= game.getHeight()){
                    y += speed;
            }
            } else {
                if(goingup && y>0){
                    y -= speed;
                } else if(goingdown && y+height <game.getHeight()){
                    y += speed;
                }
            }
        }
        
	
	public void render(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

}
}