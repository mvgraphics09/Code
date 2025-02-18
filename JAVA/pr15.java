class a
{
    int a = 10, b = 20;
    void add()
    {
        System.out.println(a + b);
    }
}
class c extends a{
    void sub()
    {
        System.out.println(b - a);
    }
} 
class pr15 extends c
{
        void mul()
        {
            System.out.println(a * b);
        }
    public static void main(String args[])
    {
        pr15 objb = new pr15();
        System.out.println("Add of two number :");
        objb.add();
        System.out.println("mul of two number :");
        objb.mul();
        System.out.println("sub of two number :");
        objb.sub();
    }
}