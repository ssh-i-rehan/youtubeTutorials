package com.tutorials;

class CountingInversion 
{ 

    public static void main(String args[]) 
    { 

    	int arr[]= {3,6,1,2,4,5};
    	
    	System.out.println("Original Array");
    	printArray(arr);
    	
    	int inversionCount= countInversionAndSort(arr,0,arr.length-1);
    	 
    	System.out.println("Inversion Count : "+ inversionCount);
        
    }

	private static int countInversionAndSort(int[] arr, int l, int r) {
		if(l<r)
		{
			int mid = l+r;
			mid/=2;
			
			int x=countInversionAndSort(arr,l,mid);
			
			int y=countInversionAndSort(arr,mid+1,r);
			
			int z=countSplitInversion(arr,l,mid,r);
			
			return x+y+z;
		}
		return 0;
	}

	private static int countSplitInversion(int[] arr, int l, int mid, int r) {

		int tmpArr[] = new int[r-l+1];
		int i=l,j=mid+1,k=0;
		
		int splitInversion=0; //
		
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
				
				splitInversion+= (mid+1-i); //
				
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
		
		return splitInversion;
		
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	} 

} 