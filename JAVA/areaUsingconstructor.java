public class areaUsingconstructor
{
    private double area;
    areaUsingconstructor(int r){
        this.area=3.14*r*r;
        System.out.println("area of circle is "+area);
    }
    areaUsingconstructor(int l, int b){
        this.area=l*b;
        System.out.println("area of rectangle is "+area);
    }

    public static void main(String[] args){
        areaUsingconstructor obj=new areaUsingconstructor(10);
        areaUsingconstructor obj1=new areaUsingconstructor(10,20);
    }
}