class OperatingStack 
{
	public static void main(String[] args) 
	{
		ArrayStack a=new ArrayStack(10);
		//for(int i=0;i<10;i++)
			//push(a,"1");
		//System.out.println(push(a,"2"));
		String s=pop(a);
		System.out.println("栈顶元素为："+s);
	}


	//入栈
	public static boolean push(ArrayStack as,String s)
	{
		if(as.n==as.count)
			return false;
		else
		{
			as.items[as.n]=s;
			as.n++;
			return true;
		}
	}

	//出栈
	public static String pop(ArrayStack as)
	{
		if(as.n==0)
			return null;
		else
		{
			String temp=as.items[as.n-1];//注意栈顶元素是as.n-1这个位置而非as.n
			as.n--;
			return temp;
		}
	}
}

class ArrayStack
{
	String[] items;
	int count;//栈的大小
	int n;//栈中的元素个数
	//初始化一个大小为count的栈
	public ArrayStack(int count)
	{
		this.count=count;
		this.n=0;
		this.items=new String[count];
	}
}
