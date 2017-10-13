package Interacciones;

import Logica.Juego;

public class DisparoAliado extends Disparo {

	protected VisitorDisparoAliado miVisitor;
	
	public DisparoAliado(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
