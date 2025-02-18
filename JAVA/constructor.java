public class constructor    
{
    private String s_name;
    private int age;
    public constructor(){
        s_name =" ";
        age =0;
    }
    public constructor(String s_name,int age)
    {
        this.s_name = s_name;
        this.age=age;
    }
    public constructor(constructor obj1)
    {
        this.s_name=obj1.s_name;
        this.age=obj1.age;
    }
    public void showname()
    {
        System.out.println("Name :"+s_name+"age"+age);

    }
    public void addage(constructor obj1)
    {
        obj1.age+=10;
    
    }
    public static void main(String[] args) {
        constructor obj=new constructor();
        constructor obj1=new constructor("manthan",36);
        constructor obj2=new constructor(obj1);
        obj.showname();
        obj1.showname();
        obj2.showname();
        obj2.addage(obj2);
        obj2.showname();

        
    }
}