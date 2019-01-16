package main;

import javax.swing.JFrame;

public class Window extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	private Thread renderingThread;
	
	private Panel renderingPanel;
	
	public Window() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
        this.setTitle("Generador de Particulas");

        renderingPanel = new Panel();
        this.getContentPane().add(renderingPanel);
        
        renderingThread = new Thread(this);
        renderingThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			renderingPanel.render();
			try {
				Thread.sleep(12);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
