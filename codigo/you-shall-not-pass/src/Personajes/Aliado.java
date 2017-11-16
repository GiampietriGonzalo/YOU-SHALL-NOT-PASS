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
	
	public abstract int getRangoOriginal();
	public abstract int getDamageOriginal();
	
	public int getPrecioAliado(){
		return precioAliado;
	}
	
	public void recibirDamage(int d, Personaje p){
		vida-=d;
		if(vida<=0) morir();
	}
	
	public EstadoAliado getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoAliado e) {
		estado=e;
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public int vender(){
		morir();
		eliminar();
		int mon=this.getPrecioAliado();
		if(this.vida<this.getVidaOriginal())
			mon=mon/2;
		return mon;
	}
	
	
}
