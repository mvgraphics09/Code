class a{
    private int x;
    public int y;
    protected int z;
    public a(){x=0;y=0;z=0;}
    public a(int x,int y,int z){
        this.x=x;
        this.y=y;
        this.z=z;
        System.out.println("class a");
    }
   // public int getx(){return x;}
   public void show(){
    System.out.println("x:="+x+"y:="+y+"z:="+z);
   }    
}
class b extends a{
    private int a;
    public b(){a=0;}
    public b(int x,int y,int z,int a){
        super(x, y, z);//super keyword call the constrictor of parent class
        this.a=a;
        System.out.println("class b");
    }
    public void show(){
        super.show();
        System.out.println("a:="+a);
    }
}
public class singlelevel{
    public static void main(String[] args) {
        b ob=new b(10,20,30,40);
        ob.show();
    }   
}
