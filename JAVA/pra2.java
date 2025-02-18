import java.util.Scanner;
public class pra2 
{
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b,c;
            b = sc.nextInt();
            c = sc.nextInt();
            System.out.println((a>b)?(a>c)?a:c : (b>c)?b:c);
		}
}       