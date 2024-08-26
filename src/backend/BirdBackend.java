package backend;

public class BirdBackend {
	private int Y;
	static private final int X=200;
	private int radius;
	
	public BirdBackend(int Y, int radius)
	{
		this.Y=Y;
		this.radius=radius;
	}
	public int GetX()
	{
		return X;
	}
	public int GetY()
	{
		return Y;
	}
	public int GetRadius()
	{
		return radius;
	}
	
	

}
