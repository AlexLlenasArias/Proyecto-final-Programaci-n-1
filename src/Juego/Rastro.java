package Juego;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Rastro  extends GameObject{
	
	private float alpha=1;
	private float duracion;
	private Controlador controlador;
	private Color color;
	
	private int alto,ancho;
	

	public Rastro(int x, int y, ID id,Color color,int ancho,int alto,float duracion,Controlador controlador) {
		super(x, y, id);
		this.controlador = controlador;
		this.color = color;
		this.ancho = ancho;
		this.alto = alto;
		this.duracion = duracion;
	}

	@Override
	public void tick() {
		
		if (alpha > duracion) {
			alpha -= (duracion - 0.0001f);
		}
		else controlador.removeObject(this);
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.setColor(color);
		g.fillRect(x, y, ancho, alto);
		
		g2d.setComposite(makeTransparent(1));
	}
	
	private AlphaComposite makeTransparent (float alpha) {
		int tipo = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(tipo, alpha));
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

}
