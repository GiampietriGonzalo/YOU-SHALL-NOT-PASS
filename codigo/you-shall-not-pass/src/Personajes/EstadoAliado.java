package Personajes;

public abstract class EstadoAliado {
	
	protected Aliado miAliado;
	
	public EstadoAliado(Aliado a) {
		miAliado=a;
	}
	
	public abstract void potenciar(Humano h);
	public abstract void potenciar(Enano n);
	public abstract void potenciar(Elfo f);
	public abstract void potenciar(Mago m );

	
}
