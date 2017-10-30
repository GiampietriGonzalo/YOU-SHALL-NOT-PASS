package Interacciones;

import Logica.Juego;

public class DisparoAliado extends Disparo {

	protected VisitorDisparoAliado miVisitor;
	
	public DisparoAliado(Juego j,int x, int y) {
		super(j,x, y);
		miVisitor= new VisitorDisparoAliado();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
