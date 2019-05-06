class QuickSorts 
{
	public static void main(String[] args) 
	{
		int a[]={2,5,4,3,1};//错误写法：int a[5]={2,5,4,3,1};
		System.out.print("排序前：");
		for(int i=0;i<5;i++)
			System.out.print(a[i]+" ");
		QuickSort(a,0,4);
		System.out.print("排序后：");
		for(int i=0;i<5;i++)
			System.out.print(a[i]+" ");
	}

	//快速排序
	public static void QuickSort(int[] a,int p,int r)
	{
		if(p>=r)
			return;		
		int pivot=Partition(a,p,r);
		QuickSort(a,p,pivot-1);
		QuickSort(a,pivot+1,r);
	}

	//获得分区
	public static int Partition(int[] a,int p,int r)
	{
		int pivot=a[r];
		int i=p;
		for(int j=p;j<r;j++)
		{
			if(a[j]<pivot)
			{
				if(i==j)
				{
					i++;
				}
				else
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
					i++;
				}
			}
		}
		int temp=a[i];
		a[i]=a[r];
		a[r]=temp;
		return i;
	}
}
