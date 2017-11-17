package ObjetosComprables;

import Logica.Juego;

public abstract class ComprableTemporal extends ObjetoComprable{
		
		protected Juego juego;
	
		public ComprableTemporal(Juego j){
			juego=j;
		}
		
		public void actualizar(){
			tiempo--;
			if(tiempo==0) 
				morir();
		}
		
		public int getTiempo(){return tiempo;}
}
