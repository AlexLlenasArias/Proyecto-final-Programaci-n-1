package Juego;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Juego extends Canvas implements Runnable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2935247470375332996L;

	public static final int ANCHO= 640, ALTO = (ANCHO /12) *9;
	
	private Thread hilo;
	
	private boolean corriendo = false;
	
	private Controlador controlador;
	
	private Random r;
	
	private HUD hud;
	
	private Spawn spawner;
	
	
	public Juego() {
		
		controlador = new Controlador();
		this.addKeyListener(new Input(controlador));
		
		new Ventana(ANCHO,ALTO,"TÍTULO",this); 
		
		hud = new HUD();
		spawner = new Spawn(controlador, hud);
		r = new Random();
		
		//controlador.addObject(new EnemyBoss((Juego.ANCHO/2)-52,-120,ID.boss, controlador));
		
		 for (int i = 0; i < 1; i++) { controlador.addObject(new
		 BasicEnemy(r.nextInt(ANCHO-50),r.nextInt(ALTO-50),ID.basicenemy, controlador)); }
		 
		controlador.addObject(new Jugador((ANCHO/2-32),(ALTO/2-32),ID.player,controlador));
		
	}
	
	public synchronized void start() {
		hilo= new Thread(this);
		hilo.start();
		corriendo = true;
	}
	
	public synchronized void fin() {
		try {
			hilo.join();
			corriendo=false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static int limites(int var, int min, int max) {
		if (var>= max) {
			return var=max;
		}
		else if  (var<=min) {
			return var=min;
		}
		else 
			return var;
	}
	
	public static void main(String args[]) {
		
		new Juego();
		
	}

	@Override
	public void run() {
		this.requestFocus();
		// TODO Auto-generated method stub
		long lastTime = System.nanoTime(); // Obtener tiempo actual en nanosegundos
		  double amountOfTicks = 60.0; // fijar número de ticks
		  double ns = 1000000000 / amountOfTicks; // Esto determina cuantas veces se puede dividir 60 en 1e9 nanosegundos o 1 segundo
		  double delta = 0; // change in time (delta always means a change like delta v is change in velocity)
		  long timer = System.currentTimeMillis(); // conseguir tiempo actual
		  int frames = 0; // declarar los frames
		  while(corriendo){ 
		   long now = System.nanoTime(); // get current time in nonoseconds durring current loop
		   delta += (now - lastTime) / ns; // add the amount of change since the last loop
		   lastTime = now;  // set lastTime to now to prepare for next loop
		   while(delta >= 1){
		    // one tick of time has passed in the game this 
		    //ensures that we have a steady pause in our game loop 
		    //so we don't have a game that runs way too fast 
		    //basically we are waiting for  enough time to pass so we 
		    // have about 60 frames per one second interval determined to the nanosecond (accuracy)
		    // once this pause is done we render the next frame
		    tick();  
		    delta--;  // lower our delta back to 0 to start our next frame wait
		   }
		   if(corriendo){
		    render(); // render the visuals of the game
		   }
		   frames++; // note that a frame has passed
		   if(System.currentTimeMillis() - timer > 1000 ){ // if one second has passed
		    timer+= 1000; // add a thousand to our timer for next time
		    //System.out.println("FPS: " + frames); // print out how many frames have happend in the last second
		    frames = 0; // reset the frame count for the next second
		   }
		  }
		  fin();
		  
	}
	
	private void tick() {
		
		controlador.tick();
		hud.tick();
		spawner.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs==null) {
			this.createBufferStrategy(3);//no poner en 1
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, ANCHO, ALTO);
		
		controlador.render(g);
		
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
}
