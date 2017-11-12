
package Logica;

import java.util.Stack;
import java.util.Random;

import Personajes.*;

public class Nivel2 extends Nivel{
	
	
	public Nivel2(Juego j) {
		super(j);
	}

	Stack<Enemigo> crearHorda() {
		Stack<Enemigo> horda = new Stack<Enemigo>();
		Random rnd = new Random(System.currentTimeMillis());
		int a;
		
		for(int i=0;i<10;i++){
			a = rnd.nextInt(10);
			int p = rnd.nextInt(15);
			if(a<5){
				horda.push(new OrcoUrukHai(juego.getMapa()));
			}else if (a<8){
				horda.push(new MagoOscuro(juego.getMapa()));
			}
			else {
				Enemigo e = new Troll(juego.getMapa());
				if (p == 9) e.proteccion();
				System.out.println("Soy un Troll con vida "+e.getVida());
				horda.push(e);
			}
		}
		
		return horda;
	}

	Enemigo crearBoss() {
		return null;
	}
	
}