package Personajes;

public class AliadoNormal extends EstadoAliado{
	
	public AliadoNormal(Aliado a) {
		super(a);
		miAliado.setVida(a.getVidaOriginal());
		miAliado.setDamage(a.getDamageOriginal());
		miAliado.setRango(a.getRangoOriginal());
		miAliado.setSprite("/Imagenes/"+a.getClass().getSimpleName()+".gif");

	}
	
	public void potenciar(Humano h) {}
	public void potenciar(Enano n) {}
	public void potenciar(Elfo f) {}
	public void potenciar(Mago m ) {}

}
