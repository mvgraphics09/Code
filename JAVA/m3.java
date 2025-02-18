import java.util.Scanner;

public class m3 {

    public static void main(String[] args) {
        Scanner j = new Scanner(System.in); //scannre Object
        String Na;
        System.out.println("enter your name");
        Na=j.nextLine();//Name in string
        System.out.println("enter your age");
        int x=j.nextInt();//Age in string
        System.out.println("enter your pagar");
        double s=j.nextDouble();
        //int x=Integer.parseInt(a);//Conver from string to integer
        System.out.println("name is"+Na);
        System.out.println("age is"+x);
        System.out.println("Tamaro pagar che"+s);
        if (x>=18) {
            System.out.println("can vote");
        }
        else{
            System.out.println("cant vote|vote");
        }
    }
}