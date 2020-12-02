package Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Jugador extends GameObject{

	Random r= new Random();
	Controlador controlador;
	
	public Jugador(int x, int y, ID id, Controlador controlador) {
		super(x, y, id);
		this.controlador = controlador;
//		velX = r.nextInt(5)+1;
//		velY = r.nextInt(5);
	}

	public void tick() {
		
		x += velX;
		y += velY;
		
		x = Juego.limites(x, 0, Juego.ANCHO-48);
		y = Juego.limites(y, 0, Juego.ALTO-70);
		
		colision();
	}
	
	public void colision() {
		for (int i = 0; i < controlador.Object.size(); i++) {
			
			GameObject tempObject = controlador.Object.get(i);
			
			if (tempObject.getID()==ID.basicenemy || tempObject.getID()==ID.fastenemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.VIDA -= 2;
				}
			}
		}
	}


	public void render(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}




	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 32, 32);
	}
	
	

}
