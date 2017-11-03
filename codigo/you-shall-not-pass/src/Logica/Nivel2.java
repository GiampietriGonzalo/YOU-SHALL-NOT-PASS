
package Logica;

import java.util.Stack;
import java.util.Random;
import Personajes.Enemigo;
import Personajes.*;

public class Nivel2 extends Nivel{
	
	
	public Nivel2(Juego j) {
		super(j);
	}

	@Override
	Stack<Enemigo> crearHorda() {
		Stack<Enemigo> horda = new Stack<Enemigo>();
		Random rnd = new Random(System.currentTimeMillis());
		int a;
		
		for(int i=0;i<10;i++){
			a=rnd.nextInt(10);
			if(a<5){
				horda.push(new OrcoUrukHai());
			}else if (a<8)
				horda.push(new MagoOscuro());
			else horda.push(new Troll());
		}
		
		return horda;
	}

	@Override
	Enemigo crearBoss() {
		// TODO Auto-generated method stub
		return null;
	}
	
}