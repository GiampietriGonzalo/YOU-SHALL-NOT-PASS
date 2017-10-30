
package Logica;

import java.util.Stack;
import java.util.Random;
import Personajes.Enemigo;
import Personajes.*;

public class Nivel1 extends Nivel{
	
	
	public Nivel1(Juego j) {
		super(j);
	}

	@Override
	Stack<Enemigo> crearPrimeraHorda() {
		Stack<Enemigo> horda=new Stack<Enemigo>();
		Random rnd=new Random(System.currentTimeMillis());
		int a;
		
		for(int i=0;i<15;i++){
			a=rnd.nextInt(10);
			if(a<5){
				horda.push(new Orco());
			}else if (a<8)
				horda.push(new Huargo());
			else horda.push(new Nazgul());
		}
		
		return horda;
	}

	@Override
	Stack<Enemigo> crearSegundaHorda() {
		
		return null;
	}

	@Override
	Stack<Enemigo> crearTerceraHorda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Enemigo crearBoss() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
