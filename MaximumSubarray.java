//Find the maximum continuous sum obtain by the Array.
class MaximumSubarray {
    public int maxSubArray(int[] nums) {
    	
        int maxValue=Integer.MIN_VALUE; //initialize the maxValue to the minimum value of the integer.
        int maxAdd=0; //initialize the maxAdd to zero.
        
        //linearly traverse through the array to find the maximum sum .
        for(int element=0;element<nums.length;element++)
        {
        	//add the element&maxAdd then assign it to maxAdd on each loop.
            maxAdd+=nums[element];
            
            //to find max sum update the maxValue each time by comparing it with maxAdd.
            if(maxValue<maxAdd){
                maxValue=maxAdd;
            }
          //Avoid adding elements to the negative element by replacing the negative value with zero.
            if(maxAdd<0){
                maxAdd=0;
            }
        }
        
        //return the last updated maxValue.
        return maxValue;
    }
}


//53.
