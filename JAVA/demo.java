import java.util.Scanner;

 public class demo {
     public static void main(String[] args) {
         int a[],size;
         Scanner in = new Scanner(System.in);
         System.out.println("how many number");
         size=in.nextInt();
         a=new int[size];
         System.out.println("enter"+ size+"element");
         for(i=0;i<size;i++)
         {
             a[size]=in.nextInt();
         }
         System.out.println("enterd"+size+"element");
         for(i=0;i<size;i++)
         {
            System.out.println(a[size]);
         }
        
    }
 }