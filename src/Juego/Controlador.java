package Juego;

import java.awt.Graphics;
import java.util.LinkedList;

public class Controlador {
	
	LinkedList<GameObject> Object = new LinkedList<GameObject>();
	
	public void tick() {
		
		for (int i = 0; i < Object.size(); i++) {
			GameObject tempObject = Object.get(i);
			
			tempObject.tick();
		}
		
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < Object.size(); i++) {
			GameObject tempObject = Object.get(i);
			
			tempObject.render(g);
		}
	}
	

	
	public void addObject(GameObject object) {
		this.Object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.Object.remove(object);
	}
	
	public void clear() {
		
		for (int i = 0; i < Object.size(); i++) {
			GameObject tempObject = Object.get(i);
			
			Object.clear();
			addObject(new Jugador((Juego.ANCHO/2-32),(Juego.ALTO-100), ID.player, this));
		}
		
	}

}


