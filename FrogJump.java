class FrogJump {
    //there are two possible ways to reach the third stone from so make the long possible case to find the length.
    public int maxJump(int[] stones) {
        if(stones.length==2)
            return stones[1];
        int length=0,maxOfJump;

        //loop till the last stone to find all the max passibles.
        for(int i=2;i<stones.length;i++){

            //max of the two jumps
            maxOfJump=Math.max(stones[i]-stones[i-2],stones[i]-stones[i-1]);

            //assign the max to the length 
            if(length<maxOfJump){
                length=maxOfJump;
            }
        }

        //return length.
        return length;
    }
}
