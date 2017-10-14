package Interacciones;

import Entidad.Premio;
import Logica.GameObject;
import Personajes.Aliado;
import Personajes.Enemigo;

public class VisitorAliado extends Visitor {
	protected Aliado miPersonaje;
	
	public VisitorAliado(Aliado l){
		miPersonaje=l;
	}
	
	
	@Override
	public void visit(Aliado a) {
		//No pasa nada
	}

	@Override
	public void visit(Enemigo e) {
		e.recibirDamage(10);
	}

	@Override
	public void visit(Premio q) {
		// TODO Auto-generated method stub
		//Rellenar mas tarde
	}

	@Override
	public void visit(DisparoAliado da) {
		//No pasa nada		
	}

	@Override
	public void visit(DisparoEnemigo de) {
		//miPersonaje.recibirDamage(10);
	}


	@Override
	public void visit(GameObject gameObject) {
		// TODO Auto-generated method stub
		
	}
	
	
}
