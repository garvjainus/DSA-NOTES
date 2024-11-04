/* 
have left pointer (starts at first element)
mid pointer (starts at right+left/2)
and right pointer (starts at last element))
if the mid pointer is not bad,
make the left pointer the mid pointer + 1
and then reset the mid pointer to right+left/2
if the mid pointer is bad, check if mid pointer - 1 is bad. 
    if it is, change right pointer to mid pointer -1
    if its not, return mid pointer
g b
*/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        if(n == 1){
            return n;
        }
        while(left<=right){
            int mid = left + (right - left) / 2; //prevents overflow error, if you add 1.3 mill and 1.7 mill and max in java is 2 mil, this is overflow. you want to make sure u arent directly adding these because you want the mid point not the sum
            if(isBadVersion(mid)){
                if(isBadVersion(mid-1)){
                    right = mid -1; 
                } else {
                    return mid; 
                }
            } else {
                left = mid +1; 
            }
        }
        return -1;
    }
}