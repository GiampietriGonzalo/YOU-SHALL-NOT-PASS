package ObjetosComprables;

import Logica.Juego;

public abstract class ObjetoComprable{
	
	protected int precio;
	protected int tiempo;
	protected Juego juego;
	
	public int getPrecio(){return precio;}
	
	public int getTiempo(){return tiempo;}
	
	public void actualizar(){}
	
}