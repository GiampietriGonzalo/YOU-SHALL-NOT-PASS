package Logica;

public abstract class gameObject {
	protected int x;
	protected int y;
	protected String img;
	
	public String getImg(){
		return img;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	//setImg me parecio al pedo, mandalo al constructor ATR
	
	public void setX(int X){
		x=X;
	}
	
	public void setY(int Y){
		y=Y;
	}
}
