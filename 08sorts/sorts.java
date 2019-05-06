class Sorts 
{
	public static void main(String[] args) 
	{
		int a[]={2,5,4,3,1};//错误写法：int a[5]={2,5,4,3,1};
		System.out.print("排序前：");
		for(int i=0;i<5;i++)
			System.out.print(a[i]+" ");
		//BubbleSort(a,5);
		InsertSort(a,5);
		System.out.print("排序后：");
		for(int i=0;i<5;i++)
			System.out.print(a[i]+" ");
	}

	//插入排序
	public static void InsertSort(int[] a,int n)
	{
		if(n<=1)
			return;
		for(int i=1;i<n;i++)
		{
			int temp=a[i];
			int j=i-1;
			for(;j>=0;j--)
			{
				if(temp<a[j])
				{
					a[j+1]=a[j];
				}
				else
				{
					break;
				}
			}
			a[j+1]=temp;
		}
	}

	//冒泡排序
	public static void BubbleSort(int[] a,int n)
	{
		if(n<=1)
			return;
		int flag;
		for(int i=0;i<n;i++)
		{
			flag=0;//没有发生交换标志为0
			//之前这样写：for(int j=i;j<n-1;j++)，是错的。这样每次i之前的数字就不会再比较了。
			for(int j=0;j<n-i-1;j++)
			{
				if(a[j]>a[j+1])
				{
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					flag=1;//发生交换标志为1
				}
			}
			if(flag==0)//若上个循环没有发生交换，则排序完成，结束循环
				break;
		}
	}
}
