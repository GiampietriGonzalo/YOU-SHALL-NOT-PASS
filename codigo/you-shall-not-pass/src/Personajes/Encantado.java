package Personajes;

public class Encantado extends EstadoEnemigo{
	

	public Encantado(Enemigo e) {
		super(e);
	}
	
	public void relentizar(){
		//Cambiar al estado Relentizado, Se conserva el escudo.
		miEnemigo.setEstado(new Relentizado(miEnemigo));
	}
	
	//Un enemigo no encantado inicialmente no se puede encantar.
	//Si un enemigo está encantando y se relentiza, Pasa al estado Relentizado y conserva el escudo.
}
