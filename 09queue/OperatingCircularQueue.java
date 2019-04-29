class OperatingCircularQueue 
{
	public static void main(String[] args) 
	{
		CircularQueue cq=new CircularQueue(5);
		System.out.println(cq.DeQueue());
		cq.PrintCircularQueue();
		System.out.println(cq.EnQueue("1"));
		cq.PrintCircularQueue();
		System.out.println(cq.EnQueue("2"));
		cq.PrintCircularQueue();
		System.out.println(cq.EnQueue("3"));
		cq.PrintCircularQueue();
		System.out.println(cq.EnQueue("4"));
		cq.PrintCircularQueue();
		System.out.println(cq.EnQueue("5"));
		cq.PrintCircularQueue();
		System.out.println(cq.EnQueue("6"));
		cq.PrintCircularQueue();
		System.out.println(cq.DeQueue());
	}
}

class CircularQueue
{
	String[] items;
	int count;
	int head;
	int tail;

	//初始化队列
	public CircularQueue(int count)
	{
		this.count=count;
		this.items=new String[count];
		this.head=0;
		this.tail=0;
	}

	//入队
	public boolean EnQueue(String item)
	{
		if((tail+1)%count==head)
			return false;
		if(tail==head)
			items[head]=item;
		else
			items[tail]=item;
		tail=(tail+1)%count;
		return true;			
	}

	//出队
	public String DeQueue()
	{
		if(head==tail)
			return null;
		String temp=items[head];
		head=(head+1)%count;
		return temp;
	}

	public void PrintCircularQueue()
	{
		for(int i=head;i!=tail;i=(i+1)%count)//i<aq.tail而不是<=
		{
			System.out.print(items[i]+"\t");			
		}
		System.out.println();
	}
}
