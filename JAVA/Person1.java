public class Person1
{
    private String pname;
    private int age;
    private String address;
    public Person1(String n,int a,String ad)
    {
        pname=n;
        age=a;
        address=ad;
    }
    public String get_pname(){
        return pname;
    }
    public int get_age(){
        return age;
    }
    public String get_address(){
        return address;
    }
    public void set_pname(String n){
        pname=n;
    }
    public void set_age(int a){
        age=a;
    }
    public void set_address(String ad){
        address=ad;
    }
    public void introduce(){
        System.out.println("name is "+pname);
        System.out.println("age is "+age);
        System.out.println("address is "+address);
    }
    public static void main(String[] args){
        Person1 p1=new Person1("manthan",20,"adipur");
        System.out.println("name is "+p1.get_pname());
        p1.set_pname("manthan");
        p1.introduce();
        

    }
}
