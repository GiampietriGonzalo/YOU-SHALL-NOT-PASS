package Personajes;

public class Potenciado extends EstadoAliado{
	
	public Potenciado(Aliado a) {
		super(a);
		a.setSprite("/Imagenes/"+a.getClass().getSimpleName()+"Potenciado.gif");
	}
	
	public void potenciar(Humano h) {
		h.setDamage(50);
	}
	public void potenciar(Enano n) {
		n.setDamage(50);
		n.setVida(100);
	}
	public void potenciar(Elfo f) {
		f.setDamage(50);
		f.setRango(4);
	}
	public void potenciar(Mago m ) {
		m.setRango(4);
		m.setVida(100);
	}
	
}
