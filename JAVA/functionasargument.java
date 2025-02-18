//passing object as an argument
public class functionasargument {
    private String sname;
    private int marks;
    public functionasargument(String sname, int marks){
        this.sname=sname;
        this.marks=marks;
    }
    public void display()
    {
        System.out.println("student name is "+sname);
        System.out.println("student marks is "+marks);
    }
    public functionasargument getmarks(functionasargument obj){
        if(marks>obj.marks){
            return this;
        }
        else{
            return obj;
        }
    }
    public static void main(String[] args){
        functionasargument obj1=new functionasargument("manthan",95);
        functionasargument obj2=new functionasargument("neev",90);
        functionasargument obj3=obj1.getmarks(obj2);
        obj3.display();
        
    }
}
