class LongestSubstringWithoutRepeatation {
    public int lengthOfLongestSubstring(String s) 
    {
        //when a string is empty return 0.
        if(s.length()==0)
        {
            return 0;
        }
        //create a linkedlist to add each character to the linked list.
       LinkedList <Character> bucket= new LinkedList<>();
       int sizeOfSubstring=1;  //Initialize the integer to 1 and the size of the sub string.

       //loop until the end char of the string.
       int pos=0;
       while(pos<s.length())
       {
           //add the unique characters to the list & increment the position.
           if(!bucket.contains(s.charAt(pos)))
           {
               bucket.add(s.charAt(pos++));
           }

           else 
           {
               //when size of the list is larger than the substring reasign the size of the substring with list size.
               if(sizeOfSubstring<bucket.size())
               {
                   sizeOfSubstring=bucket.size();
               }
                //when there is  a character that is already present  in the list remove the first element from the list.
               bucket.removeFirst();
           }
       }
       //when size of the list is larger than the substring reasign the size of the substring with list size.
               if(sizeOfSubstring<bucket.size())
               {
                   sizeOfSubstring=bucket.size();
               }
       //return the size of the substring.
        return sizeOfSubstring;
    }
}
