package Interacciones;

import Entidad.Premio;
import Logica.GameObject;
import ObjetosMapa.ObjetoConVida;
import Personajes.Aliado;
import Personajes.Enemigo;

public class VisitorEnemigo extends Visitor{
	
	private Enemigo miEnemigo;
	
	public VisitorEnemigo(Enemigo e) {
		miEnemigo=e;
	}

	public void visit(Aliado a) {
		miEnemigo.setSprite("/Imagenes/pelea.gif");
		a.recibirDamage(miEnemigo.getDamage(), miEnemigo);
		
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

	@Override
	public void visit(ObjetoConVida o) {
		miEnemigo.setSprite("/Imagenes/pelea.gif");
		o.recibirDamage(miEnemigo.getDamage(), miEnemigo);
	}

}
