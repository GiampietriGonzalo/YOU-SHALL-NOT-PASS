package ObjetosComprables;

import Personajes.*;

public class HachaGimli extends ObjetoComprable{
	
	public HachaGimli(){
		tiempo = 8;
	}
	
	public void actualizar(){
		tiempo--;
	}
	
	public void efecto(Aliado a){
		a.setEstado(new Potenciado(a));
		a.getEstado().potenciar((Enano) a);
	}
<<<<<<< HEAD


	public void efecto() {}
}
=======
}
>>>>>>> 0a004dc6c76ee56c5de4e89a5bb2c801a862cf59
