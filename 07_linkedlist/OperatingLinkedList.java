class OperatingLinkedList
{
	public static void main(String[] args)
	{
		//Node node3=new Node(4,null);
		Node node2=new Node(3,null);
		Node node1=new Node(2,node2);
		Node node=new Node(1,node1);
		//node2.next=node;
		
		//寻找中间结点
		System.out.println("寻找中间结点");
		System.out.print("链表：");
		PrintLinkedList(node);
		Node n=FindeMiddleNode(node);
		System.out.print("中间结点为：");
		System.out.println(n.data);


		/*System.out.println("链表反转：");
		PrintLinkedList(node);
		//链表反转
		Node revList=ReverseLinkedList(node);		
		PrintLinkedList(revList);
		System.out.println();*/

		/*//检测环
		boolean b=CheckCircle(node);
		System.out.println("检测环：");
		//PrintLinkedList(node);
		System.out.println("是否为环："+b);
		/*node2.next=node;
		b=CheckCircle(node);
		System.out.println("检测环：");
		System.out.println(b);*/

		/*//合并有序链表
		Node no2=new Node(5,null);
		Node no1=new Node(3,no2);
		Node no=new Node(1,no1);
		//打印
		System.out.println("合并前：");
		System.out.print("n1:");
		PrintLinkedList(node);
		System.out.print("n2:");
		PrintLinkedList(no);
		System.out.print("合并后：");
		Node newNode=MergeSortedLists(node,no);
		PrintLinkedList(newNode);*/

		/*//删除倒数第n个结点
		System.out.println("删除倒数第2个结点");
		System.out.println("删除前：");
		PrintLinkedList(node);
		DeleteLastNth(node,2);
		System.out.println("删除后：");
		PrintLinkedList(node);*/



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

	//有序链表合并
	public static Node MergeSortedLists(Node n1,Node n2)
	{
		if(n1==null)
			return n2;
		if(n2==null)
			return n1;
		Node m1=n1,m2=n2;
		Node newNode=null;
		if(m1.data<=m2.data)
		{
			newNode=m1;
			m1=m1.next;
		}
		else
		{
			newNode=m2;
			m2=m2.next;
		}
		//PrintLinkedList(newNode);
		/*记录下新合并链表头结点的位置
		不记录的话newNode会一直后移就找不到头结点啦
		*/
		Node newHead=newNode;
		while(m1!=null&&m2!=null)
		{
			if(m1.data<=m2.data)
			{
				newNode.next=m1;
				m1=m1.next;
			}
			else
			{
				newNode.next=m2;
				m2=m2.next;
			}
			newNode=newNode.next;//忘写这句啦！
			//PrintLinkedList(newNode);
		}
		if(m1==null)
		{
			newNode.next=m2;
		}
		else
		{
			newNode.next=m1;
		}
		//PrintLinkedList(newHead);
		return newHead;
	}

	//删除倒数第n个结点
	public static Node DeleteLastNth(Node node,int n)
	{
		if(node==null)
			return null;
		Node n1=node,n2=node,prev=null;
		int m=n;
		while(m!=0)
		{
			n1=n1.next;
			m--;
		}
		while(n1!=null)
		{
			n1=n1.next;
			prev=n2;
			n2=n2.next;
		}
		prev.next=n2.next;
		return node;
	}

	//寻找中间结点
	public static Node FindeMiddleNode(Node node)
	{
		if(node==null)
			return null;
		Node fast=node,slow=node;
		while(fast.next!=null&&fast.next!=null)//这两个条件缺一不可
		{
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}

	public static void PrintLinkedList(Node node)
	{
		while(node!=null)
		{
			System.out.print(node.data+"\t");
			node=node.next;
		}
		System.out.println();
	}

}

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
