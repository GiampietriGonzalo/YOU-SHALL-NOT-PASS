package Interacciones;

import javax.swing.JLabel;
import Logica.Juego;
import Personajes.Aliado;

public class DisparoAliado extends Disparo {

	
	protected Aliado miAliado;
	
	public DisparoAliado(Juego j,Aliado a,int x, int y) {
		super(j,x, y);
		miAliado=a;
		miVisitor=new VisitorDisparoAliado(a);
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}
	
	public void run(){
		while(execute){
			this.avanzar();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
	
	public void avanzar(){
		if(x==0) {
			this.morir();
			j.getManipulador().eliminarObjeto(this, x,y);
			
			this.terminate();
		} else {
			if(j.getMapa().getObject(x-1, y)==null){
				
				j.getMapa().eliminarObjeto(this,x, y);
				posX-=velocidad;
				x=posX/64;
				j.getMapa().agregarObjeto(this, x, y);
				this.grafico.setBounds(posX,posY, 64, 64);	
			}
			else {
				j.getMapa().getObject(x-1,y).accept(miVisitor);
				this.morir();
				j.getManipulador().eliminarObjeto(this, x,y);
				
				this.terminate();
			}
		}
	}
	
	
	public Aliado getAliado(){
		return miAliado;
	}

}
