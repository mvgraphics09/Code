public class methodover{
    public void display(int x){
        System.out.println("value of in integer is "+x);
    }
    public void display(char x){
        System.out.println("value of in character is "+x);
    }
    public void display(double x){
        System.out.println("value of in double is "+x);
    }
    public void display(String x){
        System.out.println("value of in string is "+x);
    }
      public static void main(String[] args){
        methodover obj=new methodover();
        obj.display(10);
        obj.display('a');
        obj.display(10.5);
        obj.display("hello");

        
    
        
    }

}

