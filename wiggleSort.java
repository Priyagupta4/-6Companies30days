import java.util.*;
class wiggleSort {
    public void wiggleSort(int[] nums) {
  
    //step 1 sort the array 
    Arrays.sort(nums);
    //step 2 make an extra array and manage equility in it    
    int n = nums.length;
    int [] res = new int[n];
    int i=1; //starts from intial postion
    int j=n-1;   //starts from last backword 
    while(i < n){
        res[i] = nums[j]; 
        i += 2; //check index by jum
        j--;
    }
    //after going out of length intailze it i with 0 once again
    i=0;
    while(i<n ){
        res[i] = nums[j];
        i += 2;
        j--;
    }
    //step 3. fill input array from res
    for(i =0; i<n; i++){
        nums[i] =res[i];
    }

   
    }
    public static void main(String arg[]){
       wiggleSort obj = new wiggleSort();
        int [] nums={1,5,1,1,6,4};
        obj.wiggleSort(nums);
        // wiggleSortfun(System.out.println(nums));
        System.out.println("Wiggle sorted array:" +Arrays.toString(nums));

    }
}

    
//tc =o(nlogn) & sc = o(n)
//output- Wiggle sorted array:[1, 6, 1, 5, 1, 4]