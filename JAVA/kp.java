import java.util.Scanner;
public class kp {
        
    public static void main(String[] args) {
    	Scanner cin=new Scanner(System.in);
    	int n,sum=0;
    	n=cin.nextInt();
    	while(n>0)
    	{
    		sum+=n%10;
    		n/=10;
    	}
    	System.out.println("the sum of the given number is"+sum);
            }
}