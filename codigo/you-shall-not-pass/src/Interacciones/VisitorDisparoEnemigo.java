package Interacciones;

import Entidad.Premio;
import Logica.GameObject;
import Personajes.Aliado;
import Personajes.Enemigo;

public class VisitorDisparoEnemigo extends Visitor {

	@Override
	public void visit(Aliado a) {
		a.recibirDamage(150);
	}

	@Override
	public void visit(Enemigo e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Premio q) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DisparoAliado da) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DisparoEnemigo de) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(GameObject gameObject) {
		// TODO Auto-generated method stub
		
	}
	
}
