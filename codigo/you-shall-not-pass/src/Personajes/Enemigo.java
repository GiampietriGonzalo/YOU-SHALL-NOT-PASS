package Personajes;


import Interacciones.*;
import Logica.Mapa;

public abstract class Enemigo extends Personaje {
	
	protected int velocidad;
	protected int monedas;
	protected int puntos;
	protected EstadoEnemigo estado;
	
	public Enemigo(Mapa m,int damage,int vida){
		super(m,damage,vida);
		miVisitor=new VisitorEnemigo(this);
	}
	
	
	public void setSprite(String s){
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	
	
	public void recibirDamage(int d){
		vida-=d;
		if(vida<=0){ 
			morir();
		}
	}
	
	public EstadoEnemigo getEstado() {return estado;}

	public void setVelocidad(int i) {
		velocidad=i;
	}
	
	public void relentizar(){
		if(estado==null)
			estado= new Relentizado(this);	
	}
	
	public void proteccion(){
		if(estado==null)
			estado= new Protegido(this);
	}
	
	public void normal(){
			estado= new Normal(this);
	}
	
	public void setEstado(EstadoEnemigo e) {
		estado=e;
	}
	
	public void eliminar(){
		mapa.eliminarObjeto(this, x, y);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public int getPuntos(){
		return puntos;
	}
	
	public int getMonedas(){
		return monedas;
	}
}
