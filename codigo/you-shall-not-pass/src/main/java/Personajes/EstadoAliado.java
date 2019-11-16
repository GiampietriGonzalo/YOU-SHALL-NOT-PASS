package Personajes;


/**
 * Representaci�n de los posible estados de un aliado.
 * */
public abstract class EstadoAliado {
	
	protected Aliado miAliado;
	
	public EstadoAliado(Aliado a) {
		miAliado=a;
	}
}