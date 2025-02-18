class  A
{
	int A=30;
	public void display()
	{
		System.out.println(A);
	}
}
	
class D extends A
{
	int D=20;
	public void display()
	{
		System.out.println(D);
	}
	public static void main(String[] args)
	{
		A objA=new A();
		D objD=new D();
		objD.display();
		objA.display();	
	}
	
}