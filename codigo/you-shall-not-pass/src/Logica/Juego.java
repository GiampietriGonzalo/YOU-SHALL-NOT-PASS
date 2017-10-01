package Logica;

import java.util.LinkedList;

import javax.swing.JPanel;

import Mapa.Mapa;
import Personajes.Aliado;
import Personajes.Enemigo;

public class Juego {
	
	private int vidaJugador;
	private int puntosJuego;
	private int monedasJuego;
	private LinkedList<Enemigo> enemigos;
	private LinkedList<Aliado> aliados;
	private LinkedList<GameObject> todos;
	private Mapa mapa;
	private int nivel;
	private JPanel panelMapa;
	
	public Juego(JPanel panel_Mapa) {
		this.panelMapa=panel_Mapa;
		mapa=new Mapa(10,6);
		aliados=new LinkedList<Aliado>();
		enemigos=new LinkedList<Enemigo>();
		todos=new LinkedList<GameObject>();
		nivel=1;
		puntosJuego=0;
		monedasJuego=0;
	}
	
	public int getVida(){
		return vidaJugador;
	}
	public int getPuntos(){
		return puntosJuego;
	}
	public int getMonedas(){
		return monedasJuego;
	}
	
	public void sumarPuntos(int p){
		puntosJuego+=p;
	}
	
	public void sumarMonedas(int m){
		monedasJuego+=m;
	}
	
	public void restarMonedas(int m){
		monedasJuego-=m;
	}
	
	public void restarVida(int v){
		vidaJugador-=v;
	}
	
	public Mapa getMapa(){
		return mapa;
	}
	
	public void colocarAliado(Aliado j,int x, int y){
		if(mapa.getObject(x, y)==null){
			mapa.agregarPersonaje(j,x,y);
			monedasJuego-=j.getPrecioAliado();
			todos.add(j);
			aliados.add(j);
			panelMapa.add(j.getGrafico());
			restarMonedas(j.getPrecioAliado());
			j.getGrafico().setOpaque(true);
			panelMapa.repaint();
		}
	}
	public void colocarEnemigo(Enemigo j,int x, int y){
		if(mapa.getObject(x, y)==null){	
			mapa.agregarPersonaje(j,x,y);
			j.setX(x);
			j.setY(y);
			todos.add(j);
			enemigos.add(j);
			panelMapa.add(j.getGrafico());
			j.getGrafico().setOpaque(true);
		}
	}
	public void venderPersonaje(Aliado j,int x, int y){
		j.morir();
		aliados.remove(j);
		monedasJuego+=j.getPrecioAliado()/2;
	}
	
	public void actualizar(){
		LinkedList<Enemigo> toDelete=new LinkedList<Enemigo>();
		for(Enemigo e:enemigos){
			if(e.estaVivo())
				e.mover();
			else
				toDelete.add(e);
		}
		for(Enemigo e:toDelete){
			enemigos.remove(e);
			mapa.eliminarPersonaje(e,e.getX(),e.getY());
			panelMapa.remove(e.getGrafico());
			monedasJuego+=e.getMonedas();
			puntosJuego+=e.getPuntos();
		}
		panelMapa.repaint();
	}
}