package Logica;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Entidad.*;
import Interacciones.*;
import ObjetosMapa.*;
import Personajes.*;


public class Manipulador {



	private int disparador;
	private int contador;
	private int cont;

	protected Juego juego;
	
	public Manipulador(){
		
		disparador=0;
		cont=0;
		contador=0;
	}	
	
	public void setJuego(Juego juego){this.juego=juego;}

	
	public void colocarTorres(){
		
		for(int i=0;i<6;i++){
			Torre t=new Torre(juego.getMapa(),new ImageIcon(this.getClass().getResource("/Imagenes/Torre"+i+".png")),9,i);
			juego.getMapa().agregarObjeto(t, 9, i);
			juego.getTodos().add(t);
			juego.getAliados().add(t);
			t.setPosGrafic(9*64, i*64);
			t.grafico.setBackground(null);
			juego.getPanel().add(t.getGrafico());
			t.getGrafico().setOpaque(true);
		}
	}


	public void colocarAliado(Aliado j,int x, int y){

		if(j.getPrecioAliado()<=juego.getAritmetica().getMonedas() && juego.getMapa().getObject(x, y)==null && x!=0){ 			j.setX(x);
			j.setY(y);
			j.setPosGrafic(x*64, y*64);
			juego.getMapa().agregarObjeto(j,x,y);
			juego.getAritmetica().restarMonedas(j.getPrecioAliado());
			juego.getTodos().add(j);
			juego.getAliados().add(j);
			juego.getPanel().add(j.getGrafico());
			j.grafico.setBackground(null);
			j.getGrafico().setOpaque(true);
			juego.getPanel().repaint();
		}
	}
		
	public void colocarAliado(Ent j,int x,int y){

		if(j.getPrecioAliado()<=juego.getAritmetica().getMonedas() && juego.getMapa().getObject(x, y)==null && juego.getMapa().getObject(x, y+1)==null){
			j.setX(x);
			j.setY(y);
			j.setPosGrafic(x*64, y*64);

			juego.getMapa().agregarObjeto(j,x,y);
			juego.getMapa().agregarObjeto(j,x,y+1);
			juego.getTodos().add(j);
			juego.getAliados().add(j);
		
			juego.getAritmetica().restarMonedas(j.getPrecioAliado());

			juego.getPanel().add(j.getGrafico());
			j.grafico.setBackground(null);
			j.getGrafico().setOpaque(true);
			juego.getPanel().repaint();
		}
	}
	
	public boolean colocarEnemigo(Enemigo j,int x, int y){
		if(juego.getMapa().getObject(x, y)==null){	
			juego.getMapa().agregarObjeto(j,x,y);
			j.setX(x);
			j.setY(y);
			juego.getTodos().add(j);
			juego.getEnemigos().add(j);
			juego.getPanel().add(j.getGrafico());
			j.grafico.setBackground(null);
			j.getGrafico().setOpaque(true);
			return true;
		}
		else 
			return false;
	}

	public void agregarObjeto(GameObject j,int x, int y){
		if(juego.getMapa().getObject(x, y)==null){	
			juego.getMapa().agregarObjeto(j,x,y);
			j.setX(x);
			j.setY(y);
			juego.getPanel().add(j.getGrafico());
			j.grafico.setBackground(null);
			j.getGrafico().setOpaque(true);
		}
	}

	public void eliminarObjeto(GameObject j,int x,int y){
		juego.getTodos().remove(j);
		juego.getMapa().eliminarObjeto(j, x, y);
		j.getGrafico().setVisible(false);
	}
	
	public void colocarObjetoMapa() {
		Random i;
		cont++;
		i=new Random(System.currentTimeMillis()+cont);
		int tipo=i.nextInt(5);
		int x=i.nextInt(8);
		int y=i.nextInt(5);
		ObjetoMapa objeto;
		if ((juego.getMapa().getObject(x, y) == null)){
		  switch(tipo){
			case 0:{
				objeto=new Piedra();
				objeto.setPosGrafic(x*64, y*64);
				agregarObjeto(objeto,x,y);
				juego.getTodos().add(objeto);
				break;
				}
			case 1:{
				objeto=new Agua();
				objeto.setPosGrafic(x*64, y*64);
				agregarObjeto(objeto,x,y);
				juego.getTodos().add(objeto);
				break;
				}
			case 2:{
				objeto=new Gandalf();
				objeto.setPosGrafic(x*64, y*64);
				agregarObjeto(objeto,x,y);
				juego.getTodos().add(objeto);
				break;
				}
			case 3:{
				objeto=new Gollum();
				objeto.setPosGrafic(x*64, y*64);
				agregarObjeto(objeto,x,y);
				juego.getTodos().add(objeto);
				break;
				}
			case 4:{
				objeto=new Ent2();
				objeto.setPosGrafic(x*64, y*64);
				agregarObjeto(objeto,x,y);
				juego.getTodos().add(objeto);
				break;
			}
		  }
		}
	}
	
	public void eliminarPremios() {
		LinkedList<GameObject> toDelete = new LinkedList<GameObject>();
		for(Premio e:juego.getPremios()){
			if(!e.estaVivo()){
				toDelete.add(e);
			}
		}
		for(GameObject e:toDelete){
			juego.getPremios().remove(e);
			juego.getMapa().eliminarObjeto(e,e.x,e.y);
			juego.getPanel().remove(e.getGrafico());
		}
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

	//Enemigos
		public void moverEnemigos(){
			LinkedList<Enemigo> toDelete=new LinkedList<Enemigo>();
			for(Enemigo e:juego.getEnemigos()){
				if(!e.estaVivo()){
					toDelete.add(e);
				}
				else {
					if(!hayObjetoEnRango(e)) {
						//Avanzo
						if(juego.getMapa().getObject(e.getX()+1,e.getY())==null) {
							juego.getMapa().eliminarObjeto(e,e.getX(), e.getY());
							e.posX+=e.getVelocidad();
							e.setX(e.posX/64);
							juego.getMapa().agregarObjeto(e, e.getX(), e.getY());
							e.setPosGrafic(e.posX, e.posY);
							e.grafico.setBounds(e.posX,e.posY, 64, 64);
							if(e.x==9) juego.setPerdio(true); //perder
						}	
					}
					else {
						if(e.getRango()>0){
							if(disparador%10==0) {
								//Disparo
								Disparo d=new DisparoEnemigo(juego,e,e.getX(),e.getY());
								d.setSprite("/Imagenes/Disparo"+e.getClass().getSimpleName()+".gif");
								d.setPosGrafic((e.getX()+1)*64,e.getY()*64);
								agregarObjeto(d, e.getX()+1, e.getY());
								d.start();
							}
							disparador++;
						}
						else{
							//Ataque cuerpo a cuerpo
							e.colisionar(juego.getMapa().getObject(e.getX()+1,e.getY()));
						}
					}
				}
			}
			
			for(Enemigo e:toDelete){
				
				Random rnd = new Random(System.currentTimeMillis());
				juego.getTodos().remove(e);
				juego.getEnemigos().remove(e);
				e.eliminar();
				juego.getPanel().remove(e.getGrafico());
				juego.getAritmetica().sumarMonedas(e.getMonedas());
				juego.getAritmetica().sumarPuntos(e.getPuntos());
				int i = rnd.nextInt(10);
				if (i==1){
					Bomba b = new Bomba(juego);
					b.setPosGrafic(e.getX()*64, e.getY()*64);
					this.agregarPower(b,e.getX(), e.getY());
				}
				if (i==2){
					RelojArena r = new RelojArena(juego);
					r.setPosGrafic(e.getX()*64, e.getY()*64);
					this.agregarPower(r,e.getX(), e.getY());
				}
				if (i==3){
					Curacion c = new Curacion(juego);
					c.setPosGrafic(e.getX()*64, e.getY()*64);
					this.agregarPower(c,e.getX(), e.getY());
				}
				
			}
		}
		
		public void agregarPower(Premio j,int x, int y){
			
			juego.getMapa().agregarObjeto(j,x,y);
			juego.getPremios().add(j);
			juego.getTodos().add(j);
			j.setX(x);
			j.setY(y);
			juego.getPanel().add(j.getGrafico());
			j.grafico.setBackground(null);
			j.getGrafico().setOpaque(true);
			
		}
		
		private boolean hayObjetoEnRango(Enemigo e){
			boolean hay=false;
			int x=e.getX();
			while(!hay && x!=9 && x<e.getX()+e.getRango()+1){
				hay=juego.getMapa().getObject(x+1,e.getY())!=null;
				x++;
			}
			return hay;
		}
		
		//Aliados
		public void actualizarAliados(){
			LinkedList<Aliado> toDelete=new LinkedList<Aliado>();
			for(Aliado e:juego.getAliados()){
				
				if(!e.estaVivo()) {
					toDelete.add(e);
				}
				else{
					
					if(hayObjetoEnRango(e)) {
						if(e.getRango()>0){
							if(disparador%6==0) {
								//Disparo
								Disparo d=new DisparoAliado(juego,e,e.getX(),e.getY());
								d.setSprite("/Imagenes/Disparo"+e.getClass().getSimpleName()+".gif");
								d.setPosGrafic((e.getX()-1)*64,e.getY()*64);
								agregarObjeto(d, e.getX()-1, e.getY());
								d.start();
							}
							disparador++;
						}
						else{
							//Ataque cuerpo a cuerpos
							e.colisionar(juego.getMapa().getObject(e.getX()-1,e.getY()));
						}
					}
				}	
			}
			
			for(Aliado e:toDelete){
				juego.getTodos().remove(e);
				juego.getAliados().remove(e);
				e.eliminar();
				juego.getPanel().remove(e.getGrafico());
			}
		}
		
		private boolean hayObjetoEnRango(Aliado e){
			boolean hay=false;
			int x=e.getX();
			while(!hay && x>0 && x>(e.getX()-e.getRango())-1){
				hay=juego.getMapa().getObject(x-1,e.getY())!=null;
				x--;
			}
			return hay;
		}
		
		public void reaccionar(int i, int j) {	
			juego.getMapa().getObject(i, j).efecto();
		}
	
		

}
