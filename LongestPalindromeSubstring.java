// class Solution {
//     public String longestPalindrome(String s) {
//         return palindrome(s,"");
//     }
//     //check two strings are palindrome or not.
//     public String palindrome(String s,String max){
//         if(s.length()<=max.length()){
//             return max;
//         }
//         String rev="";
//         for(int i=0;i<s.length();i++){
//             rev=s.charAt(i)+rev;
//         }
//         if(s.compareTo(rev)==0&&s.length()>max.length()){
//                 return max=s;
//         }
//         String max1=palindrome(s.substring(0,s.length()-1),max);
//         String max2=palindrome(s.substring(1,s.length()),max);
//         if(max1.length()>max2.length())
//             return max1;
//         return max2;

//     }
// }
class Solution {
    public String longestPalindrome(String s) {
        int[][] dp=new int [s.length()][s.length()];
        String maxStr=""+s.charAt(0);
        maxStr=palindrome(s,maxStr,dp);
        return maxStr;
    }
    public String palindrome(String s,String maxStr,int[][]dp)
    {
        int count=0,i=0,j=0;
       while(i!=0||j<s.length())
       {
          
            if(i==j)dp[i][j]=1;
            else if(j==i+1)
            {
                if(s.charAt(i)==s.charAt(j))
                {
                    dp[i][j]=1;
                    if(maxStr.length()<2)
                            maxStr=s.substring(i,j+1);
                }
            }
            else
            {
                if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]==1)
                    {
                        if(maxStr.length()<s.substring(i,j+1).length())
                            maxStr=s.substring(i,j+1);
                        dp[i][j]=1;
                    }
            }
           
            i++;j++;
            if(j==s.length())
            {
                count++;
                j=count;
                i=0;
            }
       } 
    return maxStr;   
    }
}
