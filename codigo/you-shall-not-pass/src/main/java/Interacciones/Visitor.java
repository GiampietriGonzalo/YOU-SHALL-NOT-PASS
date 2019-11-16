package Interacciones;

import Entidad.Premio;
import Logica.GameObject;
import ObjetosMapa.ObjetoConVida;
import Personajes.*;

public abstract class Visitor {
	abstract public void visit(Aliado a);
	abstract public void visit(Enemigo e);
	abstract public void visit(Premio q);
	abstract public void visit(DisparoAliado da);
	abstract public void visit(DisparoEnemigo de);
	abstract public void visit(ObjetoConVida o);
	abstract public void visit(GameObject gameObject);
	
}
