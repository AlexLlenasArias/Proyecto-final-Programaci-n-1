package Juego;

import java.util.Random;

public class Spawn {
	
	private Controlador controlador;
	private HUD hud;
	private int guardarPuntos=0;
	private Random r=new Random();
	
	public Spawn(Controlador controlador, HUD hud) {
		this.controlador=controlador;
		this.hud=hud;
	}
	
	public void tick() {
		
		guardarPuntos++;
		
		
		
		if (guardarPuntos>=250) {
			guardarPuntos =0;
			hud.setNivel(hud.getNivel() +1);
			
			if (hud.getNivel()==2) {
				 controlador.addObject(new BasicEnemy(r.nextInt(Juego.ANCHO-50),r.nextInt(Juego.ALTO-50),ID.basicenemy, controlador));
			}
			if (hud.getNivel()==3) {
				controlador.addObject(new FastEnemy2(r.nextInt(Juego.ANCHO-50),r.nextInt(Juego.ALTO-50),ID.basicenemy, controlador));	 
			}
			if (hud.getNivel()==4) {
				 controlador.addObject(new FastEnemy(r.nextInt(Juego.ANCHO-50),r.nextInt(Juego.ALTO-50),ID.fastenemy, controlador));
			}
			if (hud.getNivel()==5) {
				 //controlador.addObject(new SmartEnemy(r.nextInt(Juego.ANCHO-50),r.nextInt(Juego.ALTO-50),ID.smart, controlador));
				controlador.addObject(new BasicEnemy(r.nextInt(Juego.ANCHO-50),r.nextInt(Juego.ALTO-50),ID.basicenemy, controlador));
			}
			if (hud.getNivel()==6) {
				 controlador.addObject(new FastEnemy(r.nextInt(Juego.ANCHO-50),r.nextInt(Juego.ALTO-50),ID.fastenemy, controlador));	 
			}
			if (hud.getNivel()==7) {
				 controlador.addObject(new FastEnemy2(r.nextInt(Juego.ANCHO-50),r.nextInt(Juego.ALTO-50),ID.basicenemy, controlador));	 
			}
			if (hud.getNivel()==8) {
				 controlador.addObject(new FastEnemy(r.nextInt(Juego.ANCHO-50),r.nextInt(Juego.ALTO-50),ID.fastenemy, controlador));	 
			}
			if (hud.getNivel()==10) {
				controlador.clear();
				controlador.addObject(new EnemyBoss((Juego.ANCHO/2)-52,-120,ID.boss, controlador));
			}
			
		}
		
		
	}
}
