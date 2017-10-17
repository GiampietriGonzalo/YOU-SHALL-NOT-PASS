package Logica;

import java.applet.*;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
	private JPanel panelMapa;
	AudioClip clip = Applet.newAudioClip(this.getClass().getResource("/Musica/Anillo_NO_8.WAV"));
	
	
	public Juego(JPanel panel_Mapa) {
		this.panelMapa=panel_Mapa;
		mapa=new Mapa(10,6);
		aliados=new LinkedList<Aliado>();
		enemigos=new LinkedList<Enemigo>();
		todos=new LinkedList<GameObject>();
		puntosJuego=0;
		monedasJuego=0;
		colocarTorres();
	    clip.loop();
	}
	
	private void colocarTorres(){
		for(int i=0;i<6;i++){
			Torre t=new Torre(this,new ImageIcon(this.getClass().getResource("/Imagenes/Torre"+i+".png")));
			mapa.agregarObjeto(t, 9, i);
			todos.add(t);
			t.setPosGrafic(9*64, i*64);
			t.grafico.setBackground(null);
			panelMapa.add(t.getGrafico());
			t.getGrafico().setOpaque(true);
		}
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
			mapa.agregarObjeto(j,x,y);
			monedasJuego-=j.getPrecioAliado();
			todos.add(j);
			aliados.add(j);
			panelMapa.add(j.getGrafico());
			restarMonedas(j.getPrecioAliado());
			j.grafico.setBackground(null);
			j.getGrafico().setOpaque(true);
			panelMapa.repaint();
		}
	}
	public void colocarEnemigo(Enemigo j,int x, int y){
		if(mapa.getObject(x, y)==null){	
			mapa.agregarObjeto(j,x,y);
			j.setX(x);
			j.setY(y);
			todos.add(j);
			enemigos.add(j);
			panelMapa.add(j.getGrafico());
			j.grafico.setBackground(null);
			j.getGrafico().setOpaque(true);
		}
	}
	public void agregarObjeto(GameObject j,int x, int y){
		if(mapa.getObject(x, y)==null){	
			mapa.agregarObjeto(j,x,y);
			j.setX(x);
			j.setY(y);
			panelMapa.add(j.getGrafico());
			j.grafico.setBackground(null);
			j.getGrafico().setOpaque(true);
		}
	}
	public void venderPersonaje(Aliado j,int x, int y){
		j.morir();
		aliados.remove(j);
		monedasJuego+=j.getPrecioAliado()/2;
	}
	
	public void eliminarObjeto(GameObject j,int x,int y){
		todos.remove(j);
		mapa.eliminarObjeto(j, x, y);
		j.getGrafico().setVisible(false);
	}
	
	public void actualizar(){
		LinkedList<GameObject> toDelete=new LinkedList<GameObject>();
		for(GameObject e:todos){
			if(e.estaVivo()){
				e.mover();
			}
			else
				toDelete.add(e);
		}
		for(GameObject e:toDelete){
			//enemigos.remove(e);
			todos.remove(e);
			mapa.eliminarObjeto(e,e.getX(),e.getY());
			panelMapa.remove(e.getGrafico());
			monedasJuego+=e.getMonedas();
			puntosJuego+=e.getPuntos();
		}
		panelMapa.repaint();
	}
}