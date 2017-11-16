package Interacciones;

import Entidad.Premio;
import Logica.GameObject;
import ObjetosMapa.ObjetoConVida;
import Personajes.*;


public class VisitorDisparoAliado extends Visitor {
	
	private Aliado miAliado;
	
	public VisitorDisparoAliado(Aliado a) {
		miAliado=a;
	}

	
	public void visit(Aliado a) {
		
	}

	
	public void visit(Enemigo e) {
		e.recibirDamage(miAliado.getDamage(), miAliado);
		miAliado.setSprite("/Imagenes/"+miAliado.getClass().getSimpleName()+".gif");
	}

	
	public void visit(Premio q) {
	
		
	}


	public void visit(DisparoAliado da) {
		
		
	}


	public void visit(DisparoEnemigo de) {
		
	}
	
	public void visit(GameObject gameObject) {
		
	}


	public void visit(ObjetoConVida o) {
		
	}

}
