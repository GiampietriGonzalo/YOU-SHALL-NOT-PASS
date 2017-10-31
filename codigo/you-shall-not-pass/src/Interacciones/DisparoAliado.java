package Interacciones;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;
import Personajes.Aliado;

public class DisparoAliado extends Disparo {

	protected VisitorDisparoAliado miVisitor;
	protected volatile boolean execute=true;
	protected Aliado miAliado;
	
	public DisparoAliado(Juego j,Aliado a,int x, int y) {
		super(j,x, y);
		miAliado=a;
		miVisitor=new VisitorDisparoAliado(a);
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/disparo2.png"));
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
		if(x==9) {
			this.morir();
			juego.eliminarObjeto(this, x,y);
			
			this.terminate();
		} else {
			if(juego.getMapa().getObject(x-1, y)==null){
				
				juego.getMapa().eliminarObjeto(this,x, y);
				posX-=velocidad;
				x=posX/64;
				juego.getMapa().agregarObjeto(this, x, y);
				this.grafico.setBounds(posX,posY, 64, 64);	
			}
			else {
				juego.getMapa().getObject(x-1,y).accept(miVisitor);
				this.morir();
				juego.eliminarObjeto(this, x,y);
				
				this.terminate();
			}
		}
	}
	public void terminate(){
		execute=false;
	}
	
	public Aliado getAliado(){
		return miAliado;
	}
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
