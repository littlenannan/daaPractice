class BinarySearch2
{
	public static void main(String[] args) 
	{
		int a[]={1,3,4,5,6,8,8,8,11,18};
		int n=1;
		//查找第一个值等于给定值的元素
		int mid=BSearch1(a,10,8);		
		System.out.println("第一个值等于给定值的元素位于下标为："+mid);
		//查找最后一个值等于给定值的元素
		mid=BSearch2(a,10,8);		
		System.out.println("最后一个值等于给定值的元素位于下标为："+mid);
		//查找第一个大于等于给定值的元素
		mid=BSearch3(a,10,7);		
		System.out.println("第一个值大于等于给定值的元素位于下标为："+mid);
		//查找最后一个小于等于给定值的元素
		mid=BSearch4(a,10,9);		
		System.out.println("最后一个值小于等于给定值的元素位于下标为："+mid);
	}

	//查找第一个值等于给定值的元素
	public static int BSearch1(int[] a,int n,int c)
	{
		int low=0,high=n-1;
		int mid;
		while(low<=high)
		{
			mid=low+((high-low)>>1);
			if(a[mid]>c)
			{
				high=mid-1;
			}
			else if(a[mid]<c)
			{
				low=mid+1;
			}
			else
			{
				if(mid==0||a[mid-1]!=c)
					return mid;
				else
					high=mid-1;
			}
		}
		return -1;
	}

	//查找最后一个值等于给定值的元素
	public static int BSearch2(int[] a,int n,int c)
	{
		int low=0,high=n-1;
		int mid;
		while(low<=high)
		{
			mid=low+((high-low)>>1);
			if(a[mid]>c)
			{
				high=mid-1;
			}
			else if(a[mid]<c)
			{
				low=mid+1;
			}
			else
			{
				if(mid==n-1||a[mid+1]!=c)
					return mid;
				else
					low=mid+1;
			}
		}
		return -1;
	}

	//查找第一个大于等于给定值的元素
	public static int BSearch3(int[] a,int n,int c)
	{
		int low=0,high=n-1;
		int mid;
		while(low<=high)
		{
			mid=low+((high-low)>>1);
			if(a[mid]>=c)
			{
				if(mid==0||a[mid-1]<c)
					return mid;
				else
					high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		return -1;
	}

	//查找最后一个小于等于给定值的元素
	public static int BSearch4(int[] a,int n,int c)
	{
		int low=0,high=n-1;
		int mid;
		while(low<=high)
		{
			mid=low+((high-low)>>1);
			if(a[mid]<=c)
			{
				if(mid==n-1||a[mid+1]>c)
					return mid;
				else
					low=mid+1;
			}
			else
			{
				high=mid-1;
			}
		}
		return -1;
	}
}
