package Interacciones;

import Entidad.Premio;
import Logica.GameObject;
import Personajes.Aliado;
import Personajes.Enemigo;

public class VisitorDisparoAliado extends Visitor {

	public VisitorDisparoAliado(int d) {
		super(d);
	}

	
	public void visit(Aliado a) {
		
	}

	
	public void visit(Enemigo e) {
		e.recibirDamage(150);
	}

	
	public void visit(Premio q) {
	
		
	}


	public void visit(DisparoAliado da) {
		
		
	}


	public void visit(DisparoEnemigo de) {
		
	}

	@Override
	public void visit(GameObject gameObject) {
		
	}

}
