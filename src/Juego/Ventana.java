package Juego;

import java.awt.Canvas;
import java.awt.*;

import javax.swing.*;

public class Ventana extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1851221602829013291L;
	
	public Ventana(int ancho, int alto, String titulo, Juego juego) {
		JFrame frame=new JFrame(titulo);
		frame.setPreferredSize(new Dimension(ancho,alto));
		frame.setMaximumSize(new Dimension(ancho,alto));
		frame.setMinimumSize(new Dimension(ancho,alto));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(juego);
		frame.setVisible(true);
		juego.start();
	}
	
}
