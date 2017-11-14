
package Logica;

import java.util.Stack;
import java.util.Random;
import Personajes.Enemigo;
import Personajes.*;

public class Nivel1 extends Nivel{
	
	
	public Nivel1(Juego j) {
		super(j);
	}

	Stack<Enemigo> crearHorda() {
		Stack<Enemigo> horda = new Stack<Enemigo>();
		Random rnd = new Random(System.currentTimeMillis());
		int a;
		
		for(int i=0;i<10;i++){
			a = rnd.nextInt(10);
			int p = rnd.nextInt(2);
			if(a<5){
				Enemigo e = new Orco(juego.getMapa());
				if (p == 1) e.proteccion();
				horda.push(e);
			}else if (a<8){
				horda.push(new Huargo(juego.getMapa()));
			}
			else {
				horda.push(new Nazgul(juego.getMapa()));
				
			}
			
		}
		
		return horda;
	}

	Enemigo crearBoss() {
		return null;
	}
	
}
