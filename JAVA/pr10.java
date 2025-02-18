final class text
 {
     final int a =20;
     final void display()
    {
        a++;
        System.out.println(a);
    }
}
class pr10 extends text
{
        void display()
        {
            System.out.println("hello world");
        }
    public static void main(String args[]) {
        text t = new text();
        t.display();
    }
} 

