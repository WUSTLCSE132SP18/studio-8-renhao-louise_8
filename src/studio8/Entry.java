package studio8;

public class Entry {
	public double x,y,z;
	public Entry(double x, double y,double z) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public double scale(Entry e) {
		return x/e.x+y/e.y+z/e.z;
	}
}
