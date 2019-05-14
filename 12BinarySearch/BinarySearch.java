class BinarySearch
{
	public static void main(String[] args) 
	{
		int a[]={3,7,9,12,17,21};
		int n=6;
		//循环法二分查找
		int mid=BSearch2(a,6,21);		
		System.out.println("所找元素位于下标为"+mid+"的位置");
		
	}

	//循环法
	public static int BSearch1(int[] a,int n,int c)
	{
		int low=0,high=n-1,mid;
		while(low<=high)
		{
			mid=low+((high-low)>>1);
			if(c==a[mid])
				return mid;
			else if(c<a[mid])
			{
				high=mid-1;				
			}
			else
			{
				low=mid+1;
			}
		}
		return -1;//注意：因为返回值为int，所以不能返回null值哦			
	}

	//递归法
	public static int BSearch2(int[] a,int n,int c)
	{
		return BSearchInternally(a,0,n-1,c);
	}

	public static int BSearchInternally(int[] a,int low,int high,int c)
	{
		if(low>high)
			return -1;
		int mid=low+((high-low)>>1);
		if(a[mid]==c)
			return mid;
		else if(a[mid]>c)
			return BSearchInternally(a,low,mid-1,c);
		else
			return BSearchInternally(a,mid+1,high,c);		
	}

}
