class CountingSorts 
{
	public static void main(String[] args) 
	{
		int A[]={2,5,3,0,2,3,0,3};
		System.out.print("排序前：");
		for(int i=0;i<8;i++)
			System.out.print(A[i]+"\t");
		CountingSort(A,8);
		System.out.println();
		System.out.print("排序后：");
		for(int i=0;i<8;i++)
			System.out.print(A[i]+"\t");
	}

	public static void CountingSort(int[] A,int n)
	{
		if(n<=1)
			return;
		//查找数组中最大数
		int max=A[0];
		for(int i=1;i<n;i++)
		{
			if(A[i]>max)
				max=A[i];
		}

		//存储每个数据个数的数组C
		int[] C=new int[max+1];

		for(int i=0;i<max+1;i++)
		{
			C[i]=0;
		}

		for(int i=0;i<n;i++)
		{
			C[A[i]]++;
		}

		//依次累加
		for(int i=1;i<max+1;i++)
		{
			C[i]+=C[i-1];
		}

		//遍历A并将A中数据存入R中相应位置
		int[] R=new int[n];

		for(int i=0;i<n;i++)
		{
			R[C[A[i]]-1]=A[i];
			C[A[i]]--;
		}

		//将结果拷贝给A数组
		for(int i=0;i<n;i++)
		{
			A[i]=R[i];
		}
	}
}
