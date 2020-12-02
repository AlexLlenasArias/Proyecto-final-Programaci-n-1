package Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{
	private Controlador controlador;
	private int ancho=96,alto=96;
	int timer = 80;
	int timer2 = 50;
	private Random r=new Random();
	

	public EnemyBoss(int x, int y, ID id, Controlador controlador) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.controlador = controlador;
		
		velX = 0;
		velY=2;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		if (timer <= 0) velY = 0;
		else timer--;
		
		if (timer <= 0) timer2--;
		if (timer2 <= 0) {
			if (velX==0) velX=3;
			int spawn = r.nextInt(10);
			if (spawn == 1) {
				//controlador.addObject(new BalaJefe(x, y, ID.basicenemy, controlador));
				controlador.addObject(new BalaJefe(x+48, y+48, ID.basicenemy, controlador));
			}
		}
		
//		if(y <= 0 || y >= Juego.ALTO - 135) velY *= -1;
		if(x <= 0 || x >= Juego.ANCHO -110) velX *= -1;
		
		controlador.addObject(new Rastro(x, y, ID.rastro, Color.red, ancho, alto, 0.1f, controlador));
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		
		g.fillRect(x, y, ancho, alto);
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, ancho, alto);
	}

}
