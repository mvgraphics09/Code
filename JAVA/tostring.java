public class tostring {
  int x,y;      
    /**
     * Creates a new instance of <code>tostring</code>.
     */
    public tostring(int x,int y) {
    	this.x=x;
    	this.y=y;
    }
    public void show()
    {
    	System.out.println("x="+x+"y="+y);
    }
    public String tostring()
    {
    	return "x="+x+"y="+y;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        tostring ob=new tostring(10,20);
        System.out.println("value of:"+ob);
        ob.show();
    }
}