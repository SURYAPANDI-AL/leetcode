

class Solution {
    //memoization:
    Map<String,Boolean> map = new HashMap();

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if( len1+len2 != len3 )return false;

        return helper( s1,s2,s3,len1,len2,len3,0,0,0);
    }

    boolean helper( String s1,String s2, String s3, int len1, int len2, int len3 , int p1, int p2, int p3){
        //base condition:
        if(len3 == p3) return len1 == p1 && len2 == p2 ? true : false;

        String key = p1+"*"+p2+"*"+p3;
        if(map.containsKey(key))
            return map.get(key);

        if(p1==len1) {
            map.put(key,s2.substring(p2,s2.length()).equals(s3.substring(p3,s3.length())));
            return map.get(key);
        }
        if(p2==len2){
            map.put(key,s1.substring(p1,s1.length()).equals(s3.substring(p3,s3.length())));
            return map.get(key);
        }
        boolean one = false, two = false;
        if(s1.charAt(p1)==s3.charAt(p3))
            one = helper(s1,s2,s3,len1,len2,len3,p1+1,p2,p3+1);
        if(s2.charAt(p2)==s3.charAt(p3))
            two = helper(s1,s2,s3,len1,len2,len3,p1,p2+1,p3+1);
        map.put(key,(one || two ));
        return map.get(key);
    }
}
