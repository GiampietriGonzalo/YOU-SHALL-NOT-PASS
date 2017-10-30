package Logica;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Interacciones.*;
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
	private int sumador=0;
	//private Nivel nivel;
	int disparador=0;
	//AudioClip clip = Applet.newAudioClip(this.getClass().getResource("/Musica/Anillo.WAV"));
	
	
	public Juego(JPanel panel_Mapa) {
		this.panelMapa=panel_Mapa;
		mapa=new Mapa(10,6);
		aliados=new LinkedList<Aliado>();
		enemigos=new LinkedList<Enemigo>();
		todos=new LinkedList<GameObject>();
		puntosJuego=0;
		monedasJuego=100;
		colocarTorres();
	    //clip.loop();
	}
	
	private void colocarTorres(){
		
		for(int i=0;i<6;i++){
			Torre t=new Torre(new ImageIcon(this.getClass().getResource("/Imagenes/Torre"+i+".png")));
			mapa.agregarObjeto(t, 9, i);
			todos.add(t);
			aliados.add(t);
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
		if(j.getPrecioAliado()<=monedasJuego && mapa.getObject(x, y)==null){
			mapa.agregarObjeto(j,x,y);
			monedasJuego-=j.getPrecioAliado();
			todos.add(j);
			aliados.add(j);
			panelMapa.add(j.getGrafico());
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
		if(sumador++%3==0) monedasJuego++;
		moverEnemigos();
		actualizarAliados();
		panelMapa.repaint();
	}
	
	//Enemigos
	private void moverEnemigos(){
		LinkedList<Enemigo> toDelete=new LinkedList<Enemigo>();
		for(Enemigo e:enemigos){
			if(!e.estaVivo())
				toDelete.add(e);
			else {
			if(!hayObjetoEnRango(e)) {
				//Avanzo
				if(getMapa().getObject(e.getX()+1,e.getY())==null) {
					getMapa().eliminarObjeto(e,e.getX(), e.getY());
					e.posX+=e.getVelocidad();
					e.setX(e.posX/64);
					getMapa().agregarObjeto(e, e.getX(), e.getY());
					e.grafico.setBounds(e.posX,e.posY, 64, 64);
					if(e.x==7) e.morir();
				}
			}
			else {
				if(e.getRango()>0){
					if(disparador%4==0) {
						//Disparo
						Disparo d=new DisparoEnemigo(this,e,e.getX(),e.getY());
						d.setPosGrafic((e.getX()+1)*64,e.getY()*64);
						agregarObjeto(d, e.getX()+1, e.getY());
						d.start();
					}
					disparador++;
				}
				else{
					//Ataque cuerpo a cuerpos
					e.colisionar(getMapa().getObject(e.getX()+1,e.getY()));
				}
			}
			}
		}
		for(Enemigo e:toDelete){
			todos.remove(e);
			enemigos.remove(e);
			mapa.eliminarObjeto(e,e.getX(),e.getY());
			panelMapa.remove(e.getGrafico());
			monedasJuego+=e.getMonedas();
			puntosJuego+=e.getPuntos();
		}
	}
	
	private boolean hayObjetoEnRango(Enemigo e){
		boolean hay=false;
		int x=e.getX();
		while(!hay && x<e.getX()+e.getRango()+1){
			hay=getMapa().getObject(x+1,e.getY())!=null;
			x++;
		}
		return hay;
	}
	
	//Aliados
	private void actualizarAliados(){
		LinkedList<Aliado> toDelete=new LinkedList<Aliado>();
		for(Aliado e:aliados){
			
			if(!e.estaVivo())
				toDelete.add(e);
			else{
				
			if(hayObjetoEnRango(e)) {
				if(e.getRango()>0){
					if(disparador%4==0) {
						//Disparo
						Disparo d=new DisparoAliado(this,e,e.getX(),e.getY());
						d.setPosGrafic((e.getX()-1)*64,e.getY()*64);
						agregarObjeto(d, e.getX()-1, e.getY());
						d.start();
					}
					disparador++;
				}
				else{
					
					//Ataque cuerpo a cuerpos
					e.colisionar(getMapa().getObject(e.getX()-1,e.getY()));
				}
			}
			}	
		}
		for(Aliado e:toDelete){
			todos.remove(e);
			aliados.remove(e);
			mapa.eliminarObjeto(e,e.getX(),e.getY());
			panelMapa.remove(e.getGrafico());
		}
	}
	
	private boolean hayObjetoEnRango(Aliado e){
		boolean hay=false;
		int x=e.getX();
		while(!hay && x>(e.getX()-e.getRango())-1){
			hay=getMapa().getObject(x-1,e.getY())!=null;
			x--;
		}
		return hay;
	}
}