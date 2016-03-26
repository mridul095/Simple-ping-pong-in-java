import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class First extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	public static PlayerPaddle player;
	public static AIPaddle ai;
        public static Ball ball;
	InputHandler IH;

	JFrame frame;
	public final int width=500;
	public final int height=300;
	public final Dimension gamesize= new Dimension(width,height);
	public final String Title="Ping Pong";
	
	//public int ScreenWidth; // gives width and height of canvas
	//public int ScreenHeight;
	
	
	BufferedImage image = new BufferedImage(width , height, BufferedImage.TYPE_INT_RGB);

	static boolean gamerunning = false;
        
        int p1Score, p2Score;
	
	Thread thread;
	
	public void run() {
            while (gamerunning) {
                tick();
                render();

                try{
                    Thread.sleep(10);

                }catch(Exception ex){
                    ex.printStackTrace();	
                }
            }
	}
	
	public synchronized void start(){
            gamerunning=true;
            new Thread(this).start();
	}
	
	public static synchronized void stop(){
            gamerunning=false;
            System.exit(0);
	}

	public First() {
            frame = new JFrame();
            setMinimumSize(gamesize);
            setPreferredSize(gamesize);
            setMaximumSize(gamesize);
            frame.add(this,BorderLayout.CENTER);
            frame.pack();

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setTitle(Title);
            frame.setLocationRelativeTo(null);

            //ScreenWidth= getWidth();
            //ScreenHeight= getHeight();

            IH = new InputHandler(this);
            frame.addKeyListener(IH); //not working without this line

            player = new PlayerPaddle(0, 60);
            ai = new AIPaddle(getWidth() - 5, 60);
            ball = new Ball(getWidth() / 2, getHeight() / 2);
	}
	
	public void tick(){
		player.tick(this);
		ai.tick(this);
                ball.tick(this);
	}
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs==null){
			createBufferStrategy(3);
			return;
		}
		Graphics g=bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                
		g.setColor(Color.BLACK);
		g.fillRect(0,0, getWidth(), getHeight());
                
                g.setColor(Color.WHITE);
                
                g.drawString("Player 1 : " + p1Score, 5, 10);
                g.drawString("Player 2 : " + p2Score, getWidth() - 65, 10);
		
		player.render(g);
		ai.render(g);
                ball.render(g);
		
		g.dispose();
		bs.show();
		
	}

	
}
