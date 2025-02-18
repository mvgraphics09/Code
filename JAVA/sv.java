public class sv {
    public static void main(String[] args) {
        sv.calculate();
        sv ob = new sv();
        ob.calculate();
        ob.calculate1();
    }
    public static void calculate(){
        int x=7;
        float y=2.0f;
        int z=(int)(x/y);
        System.out.println(z);
    }
    public static void calculate1(){
        System.out.println("hello");
    }

}