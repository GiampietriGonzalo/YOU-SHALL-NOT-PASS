package Interacciones;

import Logica.Juego;

public class DisparoEnemigo extends Disparo {

	protected VisitorDisparoEnemigo miVisitor;
	
	public DisparoEnemigo(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	} 
}
