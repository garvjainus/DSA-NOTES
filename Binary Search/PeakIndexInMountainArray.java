

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] < arr[mid+1]){// this is so you keep moving TOWARDS the peak and can return it at the end, since the peak is from left to right
                left = mid + 1;
            } else {
                right = mid - 1; //this is the descending side of the mountain, so you can eliminate the right half
            }
        }
        return left; //you can return left because you are MOVING towards the peak value with your left iterations on gangnem
    }
}

/*
3 5 3 2 0


if the value to the right is > than the at middle, keep searching
if its not return
 this solution works but retarded
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if((mid-1 >= 0 && mid + 1 < arr.length) && (arr[mid] > arr [mid - 1] && arr[mid] > arr[mid + 1])){
                return mid;
            } else if ((mid-1 >= 0 && mid + 1 < arr.length) && (arr[mid] > arr [mid - 1] && arr[mid] < arr[mid + 1])){
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return 1;
    }
}
*/