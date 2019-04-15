class OperatingLinkedList
{
	public static void main(String[] args)
	{
		//正确写法：
		Node node2=new Node(3,null);
		Node node1=new Node(2,node2);
		Node node=new Node(1,node1);
		

		System.out.println("链表反转：");
		PrintLinkedList(node);
		//链表反转
		Node revList=ReverseLinkedList(node);		
		PrintLinkedList(revList);
		System.out.println();

		//检测环
		boolean b=CheckCircle(node);
		System.out.println("检测环：");
		System.out.println(b);
		node2.next=node;
		b=CheckCircle(node);
		System.out.println("检测环：");
		System.out.println(b);


	}

	//链表反转
	public static Node ReverseLinkedList(Node node)
	{
		Node pre=null,now=node,next=node;
		while(next!=null)//开始错写成node!=null 陷入了死循环
		{
			next=next.next;//next=node.next而不是now.next
			now.next=pre;
			pre=now;
			now=next;
		}
		return pre;
	}
	
	//检测环
	public static boolean CheckCircle(Node node)
	{
		if(node==null)
			return false;
		Node slow=node,fast=node.next; //原先这样写的：fast=node,slow=node;为什么这样就有问题呢？
		while(slow!=null&&fast!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(fast==null)//到达链表尾部，链表无环
			{
				return false;
			}
			else if(slow==fast)//链表有环
			{
				return true;
			}
		}
		return false;
	}

	public static void PrintLinkedList(Node node)
	{
		while(node!=null)
		{
			System.out.print(node.data+"\t");
			node=node.next;
		}
	}

}

//节点类
class Node
{
	int data;
	Node next;
	public Node(int data,Node next)
	{
		this.data=data;
		this.next=next;
	}
}
