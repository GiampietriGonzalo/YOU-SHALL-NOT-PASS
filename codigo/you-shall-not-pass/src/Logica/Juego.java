package Logica;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.*;
import javax.swing.*;
import Niveles.*;
import ObjetosComprables.ComprableTemporal;
import Personajes.*;
import Entidad.*;

/* AUTORES
 * Giampietri, Gonzalo
 * Gonzalo, Facundo
 * Zarate, Tomas/*
 */


/**
 * Clase Responsable actualizar los eventos del juego, y el estado del mismo(ganar/perder).
 * */
public class Juego {
	
	private int oleada;
	protected boolean perdio;
	protected boolean gano;
	private LinkedList<Enemigo> enemigos;
	private LinkedList<Aliado> aliados;
	private LinkedList<GameObject> todos;
	private LinkedList<Premio> premios;
	private LinkedList<ComprableTemporal> CTemporales;
	protected Mapa mapa;
	private JPanel panelMapa;
	private int sumador=0;
	private Nivel nivel;
	private Stack <Enemigo> s;
	protected Aritmetica ari;
	protected Manipulador mani;
	protected AudioClip clip = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/Anillo.WAV"));
	
	
	public Juego(JPanel panelMapa,Manipulador mani,Aritmetica ari) {
		this.panelMapa=panelMapa;
		mapa=new Mapa(10,6);
		aliados=new LinkedList<Aliado>();
		enemigos=new LinkedList<Enemigo>();
		todos=new LinkedList<GameObject>();
		premios=new LinkedList<Premio>();
		this.mani=mani;
		this.ari= ari;
		
		perdio=false;
		gano=false;
		nivel1();
		s = nivel.crearHorda();
		oleada = 1;
	    clip.loop();
	}
	
	/**
	 * Incia el nivel 1
	 * */
	private void nivel1(){
		nivel = new Nivel1(this);
	}
	
	/**
	 * Incia el nivel 2
	 * */
	private void nivel2(){	
		nivel = new Nivel2(this);
	}

	public Mapa getMapa(){
		return mapa;
	}
	
	
	public void venderPersonaje(GameObject j){
		if(j!=null && j.getX()!=9){
			int mon=j.vender();
			ari.sumarMonedas(mon);
		}
	}
	
	/**
	 * Actualiza el estado del juego y los movimientos de los objetos del mapa.
	 * */
	public void actualizar(){
		
		if(sumador++%3==0) 
			ari.sumarMonedas(1);
		
		if(s.isEmpty() && enemigos.isEmpty()){
			s = nivel.crearHorda();
			nuevaOleada();	
		}
		else{ 
			if(!s.isEmpty()) 
				mani.colocarEnemigoMapa(s);
		}
		
		LinkedList<GameObject> toDelete = new LinkedList<GameObject>();
		
		for(GameObject e:todos){
			e.actualizar();
			if(!e.estaVivo()){
				toDelete.add(e);
			}
			
		}
		
		for(GameObject e:toDelete){
			todos.remove(e);	
			mapa.eliminarObjeto(e,e.x,e.y);
			panelMapa.remove(e.getGrafico());
		}
		
		mani.eliminarPremios();
		mani.moverEnemigos();
		mani.actualizarAliados();
		
		Random i;
		i=new Random(System.currentTimeMillis());
		int prob=i.nextInt(50);

		if(prob==20)
			mani.colocarObjetoMapa();

		panelMapa.repaint();
		
		if (oleada == 3)
			nivel2();
		
		if(s.isEmpty() && enemigos.isEmpty() && oleada==6) 
			gano = true;
	}
	
	/**
	 * Envia una nueva oleada de enemigos.
	 * */
	private void nuevaOleada(){
		if (oleada==3) JOptionPane.showMessageDialog(null, "NIVEL 2 ALCANZADO!", "NIVEL 2", JOptionPane.INFORMATION_MESSAGE);
		oleada++;
	}
	
	public boolean ganar(){
		return (gano);
	}
	
	
	public boolean perder(){
		return perdio;
	}

	public JPanel getPanel() {
		return panelMapa;
	}

	/**
	 * Reestablece el juego a su estado inicial, tras perder o ganar. Lo decide el jugador.
	 * */
	public void reiniciar() {
		panelMapa.removeAll();
		aliados.clear();
		aliados=new LinkedList<Aliado>();
		enemigos.clear();
		enemigos=new LinkedList<Enemigo>();
		todos.clear();
		todos = new LinkedList<GameObject>();
		ari.sumarPuntos(-ari.getPuntos());
		ari.sumarMonedas(-ari.getMonedas());
		ari.sumarMonedas(100);
		mapa=new Mapa(10,6);
		perdio=false;
		gano = false;
		mani.colocarTorres();
		oleada = 1;
		nivel1();
		s = nivel.crearHorda();
		panelMapa.repaint();
	}


	public LinkedList<Aliado> getAliados() {
		return aliados;
	}

	public LinkedList<Enemigo> getEnemigos() {
		return enemigos;
	}
	
	public LinkedList<GameObject> getTodos() {
		return todos;
	}
	
	public LinkedList<Premio> getPremios() {
		return premios;
	}
	
	public LinkedList<ComprableTemporal> getTemporales() {
		return CTemporales;
	}
	
	public Aritmetica getAritmetica() {
		return ari;
	}

	public Manipulador getManipulador(){
		return mani;
	}	
	public void setGano(boolean gano) {
		this.gano=gano;
	}
	public void setPerdio(boolean perdio) {
		this.perdio=perdio;
	}
	
}