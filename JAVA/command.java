/**
 * @(#)command.java
 *
 *
 * @author 
 * @version 1.00 2025/2/1
 */

public class command    {
        
    public static void main(String[] args) {
        // TODO code application logic here
        int sum=0;
        for(int i=0;i<args.length;i++)
        {
        	sum+=Integer.parseInt(args[i]);
        }
        System.out.println("sum="+sum);
    }
}