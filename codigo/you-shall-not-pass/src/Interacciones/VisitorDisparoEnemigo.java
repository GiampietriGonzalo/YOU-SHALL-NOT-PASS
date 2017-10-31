package Interacciones;

import Entidad.Premio;
import Logica.GameObject;
import Personajes.Aliado;
import Personajes.Enemigo;

public class VisitorDisparoEnemigo extends Visitor {

	public VisitorDisparoEnemigo(int d) {
		super(d);
	}


	public void visit(Aliado a) {
		a.recibirDamage(damage);
	}

	
	public void visit(Enemigo e) {
		
	}


	public void visit(Premio q) {
		
		
	}


	public void visit(DisparoAliado da) {
		
	}

	public void visit(DisparoEnemigo de) {
		
	}

	public void visit(GameObject gameObject) {
		
	}
	
}
