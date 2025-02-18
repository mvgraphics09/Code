import java.util.Scanner;
public class BinaryCheck {
        
    public static void main(String[] args) {
    	Scanner cin=new Scanner(System.in);
    	int n,temp,flag=0,sum=0,mul=1;
    	n=cin.nextInt();
    	temp=n;
    	while(n>0)
    	{
    		sum=(n%10);
    		if(sum==1 && sum==0)
    			flag=1;
    			n/=10;
    	}
    	if(flag==0)
    	{
    		System.out.println("binary number");
    	}
    	else
    	{
    		System.out.println("the number is not a binary");
    	}
    }
}