class OperatingArrayQueue 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		ArrayQueue aq=new ArrayQueue(5);
		System.out.println(EnQueue(aq,"1"));
		PrintArrayQueue(aq);
		System.out.println(EnQueue(aq,"2"));
		System.out.println(EnQueue(aq,"3"));
		System.out.println(EnQueue(aq,"4"));
		System.out.println(EnQueue(aq,"5"));
		PrintArrayQueue(aq);
		System.out.println(EnQueue(aq,"6"));
		System.out.println(DeQueue(aq));
		System.out.println(DeQueue(aq));
		System.out.println(DeQueue(aq));
		System.out.println(DeQueue(aq));
		System.out.println(DeQueue(aq));
		System.out.println(DeQueue(aq));

	}

	//入队
	public static boolean EnQueue(ArrayQueue aq,String item)
	{
		if(aq.tail==aq.count)
		{
			if(aq.head==0)
				return false;//所有位置都占满了
			for(int i=aq.head;i<=aq.tail;i++)
			{
				aq.items[i-aq.head]=aq.items[aq.head];
			}
			//搬移完成后更新head和tail
			aq.head=0;
			aq.tail-=aq.head;
		}
		aq.items[aq.tail]=item;
		aq.tail++;
		return true;			
	}

	//出队
	public static String DeQueue(ArrayQueue aq)
	{
		if(aq.head==aq.tail)
			return null;
		String temp=aq.items[aq.head];
		aq.head++;
		return temp;
	}

	public static void PrintArrayQueue(ArrayQueue aq)
	{
		for(int i=aq.head;i<aq.tail;i++)//i<aq.tail而不是<=
		{
			System.out.print(aq.items[i]+"\t");			
		}
		System.out.println();
	}

}

class ArrayQueue
{
	String[] items;
	int count;
	int head;
	int tail;

	//初始化队列
	public ArrayQueue(int count)
	{
		this.count=count;
		this.items=new String[count];
		this.head=0;
		this.tail=0;
	}
}
