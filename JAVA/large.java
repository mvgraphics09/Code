import java.util.Scanner;
public class large {
        
    
    public static void main(String[] args) {
        Scanner cin= new Scanner(System.in);
        int n,max=0;
        System.out.println("Enter number:");
        n=cin.nextInt();
        max=n%10;
        while(n>0)
        {
        	if(max<(n%10))
        		max=(n%10);
        	
        	n/=10;
        }
        System.out.println("max="+max);
    }
}