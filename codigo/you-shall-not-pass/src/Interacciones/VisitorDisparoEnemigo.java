package Interacciones;

import Entidad.Premio;
import Logica.GameObject;
import ObjetosMapa.ObjetoConVida;
import Personajes.*;
public class VisitorDisparoEnemigo extends Visitor {
	
	private Enemigo miEnemigo;
	
	public VisitorDisparoEnemigo(Enemigo d) {
		miEnemigo=d;
	}


	public void visit(Aliado a) {
		a.recibirDamage(miEnemigo.getDamage(), miEnemigo);
		miEnemigo.setSprite("/Imagenes/"+miEnemigo.getClass().getSimpleName()+".gif");
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

	public void visit(ObjetoConVida o) {
		o.recibirDamage(miEnemigo.getDamage(), miEnemigo);

	}
	
}
