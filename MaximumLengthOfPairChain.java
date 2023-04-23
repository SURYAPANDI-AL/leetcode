class Solution {
    public int findLongestChain(int[][] pairs) {
        //sort the pairs:
        Arrays.sort(pairs,new Comparator<int[]>(){
            public int compare( int [] row1, int [] row2 ){
                return Integer.compare(row1[1],row2[1]);
            }});
        return helper(pairs);
    }

    int helper(int [][] arr ){
            int dp[] = new int[arr.length];
            Arrays.fill(dp,1);
            for(int i=1;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    if( arr[i][0]>arr[j][1] && dp[i]<=dp[j] ){
                        dp[i]=1+dp[j];
                    }
                }
            }
            int count = 1;
            for(int i=1;i<arr.length;i++){
                count = Math.max(count,dp[i]);
            }
            return count;
    }
}
