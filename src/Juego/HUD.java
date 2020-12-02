package Juego;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int VIDA = 100;
	private int valorColor = 255;
	
	private int puntaje=0;
	private int nivel=1;
	
	public void tick() {
		
		//HEALTH++;
		
		VIDA = Juego.limites(VIDA, 0, 100);
		valorColor = Juego.limites(valorColor, 0, 255);
		
		valorColor = VIDA*2;
		
		
		
		if (!(VIDA<=0)) {
			puntaje ++;
		}
		
	}
	
	public void render (Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75,valorColor,0));
		g.fillRect(15, 15, VIDA * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		
		
		g.drawString("Score: "+ puntaje, 15, 64);
		g.drawString("Nivel: "+ nivel, 15, 80);
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
}
