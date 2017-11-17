package Interacciones;

import Entidad.Premio;
import Logica.GameObject;
import ObjetosMapa.ObjetoConVida;
import Personajes.Aliado;
import Personajes.Enemigo;

public class VisitorAliado extends Visitor {
	
	private Aliado miAliado;
	
	public VisitorAliado(Aliado l){
		miAliado=l;
	}
	
	
	
	public void visit(Aliado a) {
		//No pasa nada
	}

	
	public void visit(Enemigo e) {
		miAliado.setSprite("/Imagenes/pelea.gif");
		e.recibirDamage(miAliado.getDamage(), miAliado);
	}

	
	public void visit(Premio q) {
		
		//Rellenar mas tarde
	}

	
	public void visit(DisparoAliado da) {
		//No pasa nada		
	}

	
	public void visit(DisparoEnemigo de) {
		//miPersonaje.recibirDamage(10);
	}


	
	public void visit(GameObject gameObject) {
		
		
	}



	@Override
	public void visit(ObjetoConVida o) {
		// TODO Auto-generated method stub
		
	}
	
	
}
