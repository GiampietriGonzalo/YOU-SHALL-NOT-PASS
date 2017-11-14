package Personajes;

import Interacciones.*;
import Logica.Mapa;

public abstract class Aliado extends Personaje {
	
	protected int precioAliado;
	protected EstadoAliado estado;
	
	public Aliado(Mapa m,int damage,int vida){
		super(m,damage,vida);
		miVisitor=new VisitorAliado(this);
	}
	
	public int getPrecioAliado(){
		return precioAliado;
	}
	
	public void recibirDamage(int d, Personaje p){
		vida-=d;
		if(vida<=0) morir();
	}
	
	public EstadoAliado getEstado() {return estado;}
	
	public void accept(Visitor v) {
		v.visit(this);
	}

}
