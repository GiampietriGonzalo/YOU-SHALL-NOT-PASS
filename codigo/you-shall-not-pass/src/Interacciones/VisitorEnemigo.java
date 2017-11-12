package Interacciones;

import Entidad.Premio;
import Logica.GameObject;
import Personajes.Aliado;
import Personajes.Enemigo;

public class VisitorEnemigo extends Visitor{
	
	private Enemigo miEnemigo;
	
	public VisitorEnemigo(Enemigo e) {
		miEnemigo=e;
	}

	public void visit(Aliado a) {
		System.out.println("Me estoy chocando algo");
		System.out.println("Estoy pegando con daño "+miEnemigo.getDamage());
		a.recibirDamage(miEnemigo.getDamage());
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
