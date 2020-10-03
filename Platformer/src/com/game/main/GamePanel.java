package com.game.main;

import com.game.gamestate.GameStateManager;
import com.game.resources.Images;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable, KeyListener{
    private  static  final  long serialVersionUID = 1L;

    public static final  int WIDTH = 800;
    public static  final  int HEIGHT = 600;

    private Thread thread;
    private boolean isRunning = false;
    
    private int FPS =60;
    private long targetTime = 1000/FPS;
    
    private GameStateManager gsm;
    
    public GamePanel(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        addKeyListener(this);
        setFocusable(true);
        
        new Images();
        
        start();
    }
    
    private void start() {
    	isRunning = true;
    	thread = new Thread(this);
    	thread.start();
    	
    }
    public void run() {
    	long start, elapsed, wait;
    	
    	gsm = new GameStateManager();
    	 while(isRunning) {
    		 start= System.nanoTime();
    		 
    		 tick();
    		 repaint();
    		 
    		 elapsed = System.nanoTime() - start;
    		 wait = targetTime - elapsed / 100000000;
    		 
    		 if(wait <0) {
    			 wait=5;
    		 }
    		 try {
    			 Thread.sleep(wait);
    		 } catch(Exception e) {
    			 e.printStackTrace();
    		 }
    	 }
    }
    public void tick() {
    	gsm.tick();
    	
    }
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	g.clearRect(0, 0, WIDTH, HEIGHT);
    	gsm.draw(g);
    }
    
    public void keyPressed(KeyEvent e) {
    	gsm.keyPressed(e.getKeyCode());
    }
    
    public void keyReleased(KeyEvent e) {
    	gsm.keyReleased(e.getKeyCode());
    }
 
    public void keyTyped(KeyEvent e) {
 	
 }
}
