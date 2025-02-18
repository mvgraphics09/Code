public class ToStringDemo {

	int x,y;
	public ToStringDemo(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public void show()
	{
		System.out.println("X=" + x + " y=" + y);
	}
	public void callByValue(int x,int y)
	{
		x++;
		y++;
		System.out.println("Value of x=" + x + " y=" + y + " In Method");
	}

	public void callByReferance(Integer x,Integer y) // call by value
	{
		x++;
		y++;
		System.out.println("Value of x1=" + x + " y1=" + y + " In Method");
	}
	
	public String toString()
	{
		return "X=" + x + " y=" + y;
	}
    public static void main(String[] args) {
        // TODO code application logic here
        ToStringDemo ob = new ToStringDemo(10,20);
      //  System.out.println("Value of " + ob);
        int x=10,y=20;
        //call by value
        System.out.println("Value of x=" + x + " y=" + y);
        ob.callByValue(x,y);
        System.out.println("Value of x=" + x + " y=" + y);
        //ob.show();
        // call by Referance
        Integer x1 = new Integer(10);
        Integer y1 = new Integer(10);
        System.out.println("Value of x1=" + x1 + " y1=" + y1);
        ob.callByReferance(x1,y1);
        System.out.println("Value of x1=" + x1 + " y1=" + y1);
        
        Double dd = new Double(30);
        double dx = x1.doubleValue();
        dx=x1;
        System.out.println("Double Value of Integer is  " + dx);
        long lx = x1.longValue();
        System.out.println("Long Value of Integer is  " + lx);
        y1=22;
        if (x1.compareTo(y1) == 0)  // compares the Value
        {
        	System.out.println("Same " + x1.compareTo(y1));
        }
        else
        {
        	System.out.println("Same " + x1.compareTo(y1));
        }
        
        if (x1 == y1)  // compares the address(Referance) 
        {
        	System.out.println("Same ");
        }else
        {
        	System.out.println("Not Same Referance or Address");
        }
        
        y1=x1;   // both are pointing to same memory location
        if (x1 == y1)  // compares the address 
        {
        	System.out.println("Same  Referance or Address");
        }
        
        if(x1.equals(y1))
        {
        	System.out.println("Same " + x1.equals(y1));
        }
        
        
        String xx="10";
        Integer yy = Integer.parseInt(xx);
        System.out.println("yy=" + yy + " xx=" + xx);
        double yy1 = Integer.parseInt(xx);
        System.out.println("yy=" + yy1 + " xx=" + xx);
        
    }
}