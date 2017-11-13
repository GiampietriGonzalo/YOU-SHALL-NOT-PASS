package Logica;

import java.applet.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Interacciones.*;
import ObjetosMapa.*;
import Personajes.*;
import Entidad.*;


public class Juego {
	
	private int oleada;
	private boolean perdio;
	private boolean gano;
	private int puntosJuego;
	private int monedasJuego;
	private LinkedList<Enemigo> enemigos;
	private LinkedList<Aliado> aliados;
	private LinkedList<GameObject> todos;
	private LinkedList<Premio> premios;
	private Mapa mapa;
	private JPanel panelMapa;
	private int sumador=0;
	private Nivel nivel;
	private Stack <Enemigo> s;
	private int disparador;
	private int contador;
	private int cont;
	//AudioClip clip = Applet.newAudioClip(this.getClass().getResource("/Musica/Anillo.WAV"));
	
	
	public Juego(JPanel panel_Mapa) {
		this.panelMapa=panel_Mapa;
		mapa=new Mapa(10,6);
		aliados=new LinkedList<Aliado>();
		enemigos=new LinkedList<Enemigo>();
		todos=new LinkedList<GameObject>();
		premios=new LinkedList<Premio>();
		puntosJuego=0;
		monedasJuego=100;
		perdio=false;
		gano=false;
		colocarTorres();
		nivel1();
		s = nivel.crearHorda();
		oleada = 1;
		contador=0;
		disparador=0;
		cont=0;
	    //clip.loop();
	}
	
	private void nivel1(){
		
		nivel = new Nivel1(this);
		
	}
	
	private void nivel2(){
		
		nivel = new Nivel2(this);
		
	}
	
	private void colocarTorres(){
		
		for(int i=0;i<6;i++){
			Torre t=new Torre(mapa,new ImageIcon(this.getClass().getResource("/Imagenes/Torre"+i+".png")),9,i);
			mapa.agregarObjeto(t, 9, i);
			todos.add(t);
			aliados.add(t);
			t.setPosGrafic(9*64, i*64);
			t.grafico.setBackground(null);
			panelMapa.add(t.getGrafico());
			t.getGrafico().setOpaque(true);
		}
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
	
	public Mapa getMapa(){
		return mapa;
	}
	
	public void colocarAliado(Aliado j,int x, int y){

		if(j.getPrecioAliado()<=monedasJuego && mapa.getObject(x, y)==null){
			j.setX(x);
			j.setY(y);
			j.setPosGrafic(x*64, y*64);
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
	public void colocarAliado(Ent j,int x,int y){

		if(j.getPrecioAliado()<=monedasJuego && mapa.getObject(x, y)==null && mapa.getObject(x, y+1)==null){
			j.setX(x);
			j.setY(y);
			j.setPosGrafic(x*64, y*64);

			mapa.agregarObjeto(j,x,y);
			mapa.agregarObjeto(j,x,y+1);
			todos.add(j);
			aliados.add(j);
			
			monedasJuego-=j.getPrecioAliado();

			panelMapa.add(j.getGrafico());
			j.grafico.setBackground(null);
			j.getGrafico().setOpaque(true);
			panelMapa.repaint();
		}
	}
	public boolean colocarEnemigo(Enemigo j,int x, int y){
		if(mapa.getObject(x, y)==null){	
			mapa.agregarObjeto(j,x,y);
			j.setX(x);
			j.setY(y);
			todos.add(j);
			enemigos.add(j);
			panelMapa.add(j.getGrafico());
			j.grafico.setBackground(null);
			j.getGrafico().setOpaque(true);
			return true;
		}
		else return false;
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
	
	public void venderPersonaje(Aliado j){
		if(j!=null){
			if (j.getVida() <= j.getVida()/2){
		j.morir();
		monedasJuego+=j.getPrecioAliado()/2;
		}
		else{
			j.morir();
			monedasJuego+=j.getPrecioAliado();
			}
		}
	}
	
	public void eliminarObjeto(GameObject j,int x,int y){
		todos.remove(j);
		mapa.eliminarObjeto(j, x, y);
		j.getGrafico().setVisible(false);
	}
	
	public void actualizar(){
		if(sumador++%3==0) 
			monedasJuego++;
		if(s.isEmpty() && enemigos.isEmpty()){
			
			s = nivel.crearHorda();
			nuevaOleada();
			
		}
		else{ 
			if(!s.isEmpty()) 
				colocarEnemigoMapa(s);
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
		eliminarPremios();
		moverEnemigos();
		actualizarAliados();
		
		Random i;
		i=new Random(System.currentTimeMillis());
		int prob=i.nextInt(25);
		if(prob==13)
			colocarObjetoMapa();
		panelMapa.repaint();
		
		if (oleada == 3)
			nivel2();
		
		if(s.isEmpty() && enemigos.isEmpty() && oleada==6) gano = true;
	}
	
	
	private void colocarObjetoMapa() {
		Random i;
		cont++;
		i=new Random(System.currentTimeMillis()+cont);
		int tipo=i.nextInt(4);
		int x=i.nextInt(10);
		int y=i.nextInt(6);
		ObjetoMapa objeto;
		switch(tipo){
			case 0:
				objeto=new Piedra();
				objeto.setPosGrafic(x*64, y*64);
				agregarObjeto(objeto,x,y);
				todos.add(objeto);
			case 1:
				objeto=new Agua();
				objeto.setPosGrafic(x*64, y*64);
				agregarObjeto(objeto,x,y);
				todos.add(objeto);
			case 2:
				objeto=new Gandalf();
				objeto.setPosGrafic(x*64, y*64);
				agregarObjeto(objeto,x,y);
				todos.add(objeto);
			case 3:
				objeto=new Gollum();
				objeto.setPosGrafic(x*64, y*64);
				agregarObjeto(objeto,x,y);
				todos.add(objeto);
		}
		
	}

	private void eliminarPremios() {
		LinkedList<GameObject> toDelete = new LinkedList<GameObject>();
		for(Premio e:premios){
			if(!e.estaVivo()){
				toDelete.add(e);
			}
		}
		for(GameObject e:toDelete){
			premios.remove(e);
			mapa.eliminarObjeto(e,e.x,e.y);
			panelMapa.remove(e.getGrafico());
		}
	}

	private void nuevaOleada(){
		if (oleada==3) JOptionPane.showMessageDialog(null, "NIVEL 2 ALCANZADO!", "NIVEL 2", JOptionPane.INFORMATION_MESSAGE);
		oleada++;
	}
	
	public boolean ganar(){
		return (gano);
	}
	
	//Enemigos
	private void moverEnemigos(){
		LinkedList<Enemigo> toDelete=new LinkedList<Enemigo>();
		for(Enemigo e:enemigos){
			if(!e.estaVivo()){
				toDelete.add(e);
			}
			else {
			if(!hayObjetoEnRango(e)) {
				//Avanzo
				if(mapa.getObject(e.getX()+1,e.getY())==null) {
					mapa.eliminarObjeto(e,e.getX(), e.getY());
					e.posX+=e.getVelocidad();
					e.setX(e.posX/64);
					mapa.agregarObjeto(e, e.getX(), e.getY());
					e.grafico.setBounds(e.posX,e.posY, 64, 64);
					if(e.x==9) perdio=true; //perder
				}
			}
			else {
				if(e.getRango()>0){
					if(disparador%10==0) {
						//Disparo
						Disparo d=new DisparoEnemigo(this,e,e.getX(),e.getY());
						d.setPosGrafic((e.getX()+1)*64,e.getY()*64);
						agregarObjeto(d, e.getX()+1, e.getY());
						d.start();
					}
					disparador++;
				}
				else{
					//Ataque cuerpo a cuerpo
					e.colisionar(mapa.getObject(e.getX()+1,e.getY()));
				}
			}
			}
		}
		for(Enemigo e:toDelete){
			
			Random rnd = new Random(System.currentTimeMillis());
			todos.remove(e);
			enemigos.remove(e);
			e.eliminar();
			panelMapa.remove(e.getGrafico());
			monedasJuego+=e.getMonedas();
			puntosJuego+=e.getPuntos();
			int i = rnd.nextInt(10);
			if (i==1){
				Bomba b = new Bomba(this);
				b.setPosGrafic(e.getX()*64, e.getY()*64);
				this.agregarPower(b,e.getX(), e.getY());
			}
			if (i==2){
				RelojArena r = new RelojArena(this);
				r.setPosGrafic(e.getX()*64, e.getY()*64);
				this.agregarPower(r,e.getX(), e.getY());
			}
			if (i==3){
				Curacion c = new Curacion(this);
				c.setPosGrafic(e.getX()*64, e.getY()*64);
				this.agregarPower(c,e.getX(), e.getY());
			}
			
		}
	}
	
	private void agregarPower(Premio j,int x, int y){
		
		mapa.agregarObjeto(j,x,y);
		premios.add(j);
		todos.add(j);
		j.setX(x);
		j.setY(y);
		panelMapa.add(j.getGrafico());
		j.grafico.setBackground(null);
		j.getGrafico().setOpaque(true);
		
	}
	
	private boolean hayObjetoEnRango(Enemigo e){
		boolean hay=false;
		int x=e.getX();
		while(!hay && x!=9 && x<e.getX()+e.getRango()+1){
			hay=mapa.getObject(x+1,e.getY())!=null;
			x++;
		}
		return hay;
	}
	
	//Aliados
	private void actualizarAliados(){
		LinkedList<Aliado> toDelete=new LinkedList<Aliado>();
		for(Aliado e:aliados){
			
			if(!e.estaVivo()) {
				toDelete.add(e);
			}
			else{
				
			if(hayObjetoEnRango(e)) {
				if(e.getRango()>0){
					if(disparador%6==0) {
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
					e.colisionar(mapa.getObject(e.getX()-1,e.getY()));
				}
			}
			}	
		}
		for(Aliado e:toDelete){
			todos.remove(e);
			aliados.remove(e);
			e.eliminar();
			panelMapa.remove(e.getGrafico());
		}
	}
	
	private boolean hayObjetoEnRango(Aliado e){
		boolean hay=false;
		int x=e.getX();
		while(!hay && x>0 && x>(e.getX()-e.getRango())-1){
			hay=mapa.getObject(x-1,e.getY())!=null;
			x--;
		}
		return hay;
	}
	
	
	public boolean perder(){
		return perdio;
	}

	public JPanel getPanel() {
		return panelMapa;
	}
	
	public void colocarEnemigoMapa(Stack<Enemigo> s){
		if(contador%6==0){
			Enemigo e = s.peek();
			Random rnd = new Random(System.currentTimeMillis());
			int i = rnd.nextInt(6);
			e.setPosGrafic(0, i*64);
			if(this.colocarEnemigo(e, 0, i)) s.pop();
			//Si la posicion esta ocupada por alguien, no inserto el enemigo
		}
		contador++;
	}

	public void reiniciar() {
		//Preg por clear
		panelMapa.removeAll();
		aliados.clear();
		aliados=new LinkedList<Aliado>();
		enemigos.clear();
		enemigos=new LinkedList<Enemigo>();
		todos.clear();
		todos = new LinkedList<GameObject>();
		puntosJuego=0;
		monedasJuego=100;
		mapa=new Mapa(10,6);
		perdio=false;
		gano = false;
		colocarTorres();
		oleada = 1;
		nivel1();
		s = nivel.crearHorda();
		panelMapa.repaint();
	}

	public void reaccionar(int i, int j) {
		
		mapa.getObject(i, j).efecto();
		
	}

	public LinkedList<Aliado> getAliados() {
		return aliados;
	}

	public LinkedList<Enemigo> getEnemigos() {
		return enemigos;
	}

	
	
	

	
}