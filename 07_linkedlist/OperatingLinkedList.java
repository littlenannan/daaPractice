class OperatingLinkedList
{
	public static void main(String[] args)
	{
		/*����д����
		Node node,node1,node2;
		node.data=1;
		node.next=node1;
		node1.data=2;
		node1.next=node2;
		node2.data=3;
		node2.next=null;
		*/
		//��ȷд����
		Node node2=new Node(3,null);
		Node node1=new Node(2,node2);
		Node node=new Node(1,node1);
		

		System.out.println("����ת��");
		PrintLinkedList(node);
		//����ת
		Node revList=ReverseLinkedList(node);		
		PrintLinkedList(revList);
		System.out.println();

		//��⻷
		boolean b=CheckCircle(node);
		System.out.println("��⻷��");
		System.out.println(b);
		node2.next=node;
		b=CheckCircle(node);
		System.out.println("��⻷��");
		System.out.println(b);


	}



	//����ת
	public static Node ReverseLinkedList(Node node)
	{
		Node pre=null,now=node,next=node;
		while(next!=null)//��ʼ��д��node!=null ��������ѭ��
		{
			next=next.next;//next=node.next������now.next
			now.next=pre;
			pre=now;
			now=next;
		}
		return pre;
	}
	
	//��⻷
	public static boolean CheckCircle(Node node)
	{
		if(node==null)
			return false;
		Node slow=node,fast=node.next; //ԭ������д�ģ�fast=node,slow=node;Ϊʲô�������������أ�
		while(slow!=null&&fast!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(fast==null)//��������β���������޻�
			{
				return false;
			}
			else if(slow==fast)//�����л�
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