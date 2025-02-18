import java.util.*;
public class pr5 
   {
    public static void main(String args[])
    {
    	
    	Scanner a=new Scanner(System.in);
    	System.out.println("enter number");
    	int n=a.nextInt();
    	int flag=1;
    	System.out.println("prime number is");
    	for(int i=2;i<n;i++)
    	{
    		flag=0;
    		for(int j=2;j<i;j++)
    		{
    			if(i%j==0)
    			{
    				flag=1;
    				break;
    			}
    		
    		}
    
    	if(flag==0)
    	{
    		System.out.println(i+" "+"prime");
    	}
    	}
    }
}