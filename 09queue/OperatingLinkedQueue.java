class OperatingLinkedQueue 
{
	public static void main(String[] args) 
	{
		LinkedQueue lq=new LinkedQueue();
		lq.PrintLinkedQueue();
		System.out.println(lq.DeQueue());
		lq.EnQueue("1");
		lq.EnQueue("2");
		lq.EnQueue("3");
		lq.EnQueue("4");
		lq.EnQueue("5");
		lq.PrintLinkedQueue();
		System.out.println(lq.DeQueue());
		System.out.println(lq.DeQueue());
		System.out.println(lq.DeQueue());
		System.out.println(lq.DeQueue());
		System.out.println(lq.DeQueue());
		System.out.println(lq.DeQueue());
	}

}

class LinkedQueue
{
	Node head=null;
	Node tail=null;

	//入队
	public void EnQueue(String item)
	{
		Node node=new Node(item,null);
		if(tail==null)
		{			
			head=node;
			tail=node;
		}
		else
		{
			tail.next=node;
			tail=tail.next;
		}		
				
	}

	//出队
	public String DeQueue()
	{
		if(head==null)
			return null;
		String item=head.data;
		head=head.next;
		if(head==null)
			tail=null;
		return item;
	}

	public void PrintLinkedQueue()
	{
		Node p=head;
		while(p!=null)
		{
			System.out.print(p.data+"\t");
			p=p.next;
		}
		System.out.println();
	}


}

class Node
{
	String data;
	Node next;
	public Node(String data,Node next)
	{
		this.data=data;
		this.next=next;
	}
}
