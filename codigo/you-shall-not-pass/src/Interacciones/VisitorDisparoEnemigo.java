package Interacciones;

import Entidad.Premio;
import Logica.GameObject;
import Personajes.*;
public class VisitorDisparoEnemigo extends Visitor {
	
	private Enemigo miEnemigo;
	
	public VisitorDisparoEnemigo(Enemigo d) {
		miEnemigo=d;
	}


	public void visit(Aliado a) {
		a.recibirDamage(miEnemigo.getDamage());
		if (a.getProteccion()){
			miEnemigo.morir();
			a.setProteccion(false);
		}
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
