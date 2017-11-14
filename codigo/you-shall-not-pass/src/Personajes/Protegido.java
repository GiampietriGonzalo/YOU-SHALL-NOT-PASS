package Personajes;

public class Protegido extends EstadoEnemigo{
	
	public Protegido(Enemigo e) {
		super(e);
		miEnemigo.setVida(500000);
		miEnemigo.setSprite("/Imagenes/"+e.getClass().getSimpleName()+"Protegido.gif");
	}


	public void proteccion() {
		
	}

	public void relentizar() {
		
	}
	
	public void recibirDamage(int d, Personaje p){
			System.out.println("Perdi proteccion");
			if (p!=null){ //Si no es una bomba
				p.morir();
				p.eliminar();
				miEnemigo.setEstado(new Normal(miEnemigo));
		}
	}
	}
