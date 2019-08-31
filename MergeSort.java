package com.tutorials;

class MergeSort 
{ 

    public static void main(String args[]) 
    { 
    	int arr[]= {4,2,6,3,1,8,5,7};
    	
    	System.out.println("Original Array");
    	printArray(arr);
    	
    	mergeSort(arr,0,arr.length-1);
    	
    	System.out.println("Sorted Array");
    	printArray(arr);
    	
        
    }

	private static void mergeSort(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		if(l<r)
		{
			int mid = l+r;
			mid/=2;
			
			mergeSort(arr,l,mid);
			
			mergeSort(arr,mid+1,r);
			
			merge(arr,l,mid,r);
			
			
		}
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		// TODO Auto-generated method stub
		
		
		int tmpArr[] = new int[r-l+1];
		int i=l,j=mid+1,k=0;
		while(i<=mid&&j<=r)
		{
			if(arr[i]<arr[j])
			{
				tmpArr[k]=arr[i];
				i++;
				k++;
			}
			else
			{
				tmpArr[k]=arr[j];
				j++;
				k++;
			}
		}
		
		while(i<=mid)
		{
			tmpArr[k]=arr[i];
			i++;
			k++;
		}
		while(j<=r)
		{
			tmpArr[k]=arr[j];
			j++;
			k++;
		}
		
		
		for(int m=l;m<=r;m++)
		{
			arr[m]=tmpArr[m-l];
		}
		
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	} 

} 