class MergeSorts 
{
	public static void main(String[] args) 
	{
		int a[]={2,5,4,3,1};//错误写法：int a[5]={2,5,4,3,1};
		System.out.print("排序前：");
		for(int i=0;i<5;i++)
			System.out.print(a[i]+" ");
		//BubbleSort(a,5);
		//InsertSort(a,5);
		MergeSort(a,0,4);
		System.out.print("排序后：");
		for(int i=0;i<5;i++)
			System.out.print(a[i]+" ");
	}

	//归并排序
	public static void MergeSort(int[] a,int p,int r)
	{
		if(p>=r)
			return;
		//取p到r的中间位置，不这样写：int q=(p+r)/2;的原因是怕p+r的值超过int类型最大值
		int q = p + (r - p)/2;
		MergeSort(a,p,q);
		MergeSort(a,q+1,r);
		Merge(a,p,q,r);
	}

	//归并
	public static void Merge(int[] a,int p,int q,int r)
	{
		int[] temp=new int[r-p+1];
		int i=p,j=q+1,k=0;
		while(i<=q&&j<=r)
		{
			if(a[i]<=a[j])
			{
				temp[k]=a[i];
				i++;
			}
			else
			{
				temp[k]=a[j];
				j++;
			}
			k++;
		}
		//前半个数组有剩余
		if(i<=q)
		{
			for(;i<=q;i++)
			{
				temp[k]=a[i];
				k++;
			}
		}
		//后半个数组有剩余
		else if(j<=r)
		{
			for(;j<=r;j++)
			{
				temp[k]=a[j];
				k++;
			}
		}
		//将temp数组中的数据放回原数组a
		for(i=0;i<=r-p;i++)
		{
			a[p+i]=temp[i];
		}
	}
}
