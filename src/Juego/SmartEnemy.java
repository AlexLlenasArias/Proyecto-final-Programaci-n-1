package Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{
	private Controlador controlador;
	private int ancho=16,alto=16;
	private GameObject jugador;
	

	public SmartEnemy(int x, int y, ID id, Controlador controlador) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.controlador = controlador;
		
		for (int i = 0; i < controlador.Object.size(); i++) {
			if (controlador.Object.get(i).getID() == ID.player) {
				jugador = controlador.Object.get(i);
			}
		}
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
//		float difx= x - jugador.getX();
//		float dify= y - jugador.getY();
//		
//		float distancia = (float) Math.sqrt((x-jugador.getX())*(x-jugador.getX()) + (y-jugador.getY())*(y-jugador.getY()));
//		//float diffX = x - jugador.getX()-8;
//		//float diffY = y - jugador.getY()-8;
//		
//		velX= (int) ((-1/distancia)*difx);
//		velY= (int) ((-1/distancia)*dify);
		
		if(y <= 0 || y >= Juego.ALTO - 48) velY *= -1;
		if(x <= 0 || x >= Juego.ANCHO -32) velX *= -1;
		
		controlador.addObject(new Rastro(x, y, ID.rastro, Color.green, ancho, alto, 0.07f, controlador));
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		
		g.fillRect(x, y, ancho, alto);
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, ancho, alto);
	}

}
