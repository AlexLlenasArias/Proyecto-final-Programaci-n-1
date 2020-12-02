package Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy2 extends GameObject{
	private Controlador controlador;
	private int ancho=16,alto=16;
	

	public FastEnemy2(int x, int y, ID id, Controlador controlador) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.controlador = controlador;
		
		velX = 9;
		velY=2;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Juego.ALTO - 48) velY *= -1;
		if(x <= 0 || x >= Juego.ANCHO -32) velX *= -1;
		
		controlador.addObject(new Rastro(x, y, ID.rastro, Color.lightGray, ancho, alto, 0.07f, controlador));
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.lightGray);
		
		g.fillRect(x, y, ancho, alto);
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, ancho, alto);
	}

}
