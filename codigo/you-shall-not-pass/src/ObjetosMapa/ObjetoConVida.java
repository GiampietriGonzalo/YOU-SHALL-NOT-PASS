package ObjetosMapa;

import Interacciones.Visitor;

public abstract class ObjetoConVida extends ObjetoMapa{

	protected int vida;
	
	public void recibirDamage(int d){}
	
	public void accept(Visitor v){
		v.visit(this);
	}
	
}
