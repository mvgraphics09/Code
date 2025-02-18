class a
{
    int a = 10, b = 20;
    void add()
    {
        System.out.println(a + b);
    }
}
class pr14 extends a 
{
        void mul()
        {
            System.out.println(a * b);
        }
    public static void main(String args[])
    {
        pr14 objb = new pr14();
        System.out.println("Add of two number :");
        objb.add();
        System.out.println("mul of two number :");
        objb.mul();
    }
}