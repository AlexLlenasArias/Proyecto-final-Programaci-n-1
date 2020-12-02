package Juego;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter {
	
	private Controlador controlador;
	private boolean [] usandoTecla = new boolean [4];
	
	public Input(Controlador controlador) {
		this.controlador=controlador;
		
		usandoTecla [0]=false;
		usandoTecla [1]=false;
		usandoTecla [2]=false;
		usandoTecla [3]=false;
	}
	
	public void keyPressed(KeyEvent e) {
		int tecla = e.getKeyCode();
		
		for (int i = 0; i < controlador.Object.size(); i++) {
			GameObject tempObject = controlador.Object.get(i);
			
			if (tempObject.getID()==ID.player) {
				//eventos para player 1
				
				if(tecla == KeyEvent.VK_W) { tempObject.setvelY(-5); usandoTecla[0]=true;}
				if(tecla == KeyEvent.VK_S) { tempObject.setvelY(5); usandoTecla[1]=true;}
				if(tecla == KeyEvent.VK_A) { tempObject.setvelX(-5); usandoTecla[2]=true;}
				if(tecla == KeyEvent.VK_D) { tempObject.setvelX(5); usandoTecla[3]=true;}
			}
			
			
		}
		if (tecla == KeyEvent.VK_ESCAPE) System.exit(1);
		//System.out.println(tecla);
	}
	
	public void keyReleased(KeyEvent e) {
		int tecla = e.getKeyCode();
		
		for (int i = 0; i < controlador.Object.size(); i++) {
			GameObject tempObject = controlador.Object.get(i);
			
			if (tempObject.getID()==ID.player) {
				//eventos para player 1
				
				if(tecla == KeyEvent.VK_W) usandoTecla[0] =false;//tempObject.setvelY(0);
				if(tecla == KeyEvent.VK_S) usandoTecla[1] =false;//tempObject.setvelY(0);
				if(tecla == KeyEvent.VK_A) usandoTecla[2] =false;//tempObject.setvelX(0);
				if(tecla == KeyEvent.VK_D) usandoTecla[3] =false;//tempObject.setvelX(0);
				
				if(!usandoTecla[0] && !usandoTecla[1]) tempObject.setvelY(0);
				
				if(!usandoTecla[2] && !usandoTecla[3]) tempObject.setvelX(0);
			}
			

		}
	}

}
