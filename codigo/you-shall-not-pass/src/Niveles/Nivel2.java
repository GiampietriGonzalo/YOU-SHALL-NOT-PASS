
package Niveles;

import java.util.Stack;

import Logica.Juego;

import java.util.Random;

import Personajes.*;

public class Nivel2 extends Nivel{
	
	
	public Nivel2(Juego j) {
		super(j);
	}

	public Stack<Enemigo> crearHorda() {
		Stack<Enemigo> horda = new Stack<Enemigo>();
		Random rnd = new Random(System.currentTimeMillis());
		int a;
		
		for(int i=0;i<10;i++){
			a = rnd.nextInt(10);
			int p = rnd.nextInt(15);
			Enemigo e;
			if(a<5){
				e = new MagoOscuro(juego.getMapa());
				e.normal();
				horda.push(e);
			}else if (a<8){
				e = new Nazgul(juego.getMapa());
				e.normal();
				horda.push(e);
			}
			else {
				e = new Troll(juego.getMapa());
				e.normal();
				if (p == 9) e.proteccion();
				horda.push(e);
			}
		}
		
		return horda;
	}

	Enemigo crearBoss() {
		return null;
	}
	
}