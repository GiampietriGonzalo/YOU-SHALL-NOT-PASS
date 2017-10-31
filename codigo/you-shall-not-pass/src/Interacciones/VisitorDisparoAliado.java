package Interacciones;

import Entidad.Premio;
import Logica.GameObject;
import Personajes.Aliado;
import Personajes.Enemigo;


public class VisitorDisparoAliado extends Visitor {
	private Aliado miAliado;
	public VisitorDisparoAliado(Aliado a) {
		miAliado=a;
	}

	
	public void visit(Aliado a) {
		
	}

	
	public void visit(Enemigo e) {
		
		e.recibirDamage(miAliado.getDamage());
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
