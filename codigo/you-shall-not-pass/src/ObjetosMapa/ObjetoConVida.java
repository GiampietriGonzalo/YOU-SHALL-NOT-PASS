package ObjetosMapa;

import Interacciones.Visitor;
import Personajes.Enemigo;

public abstract class ObjetoConVida extends ObjetoMapa{

	protected int vida;
	
	public void recibirDamage(int d, Enemigo e){
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
	
}
