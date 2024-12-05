public class InsertionBubbleSort {
    public static int[] bubbleSort(int[] sam){
        //you want to start at i = 0 aka beginning of array every time. you use the outloop to track how many items have been sorted alread AND to make sure the comparison/swapping iteration through the entire array happens ENOUGH times. 
        //if you used just a count variable to track how many sorted elements are at the end isntead of the outer loop, it wi ll only run once (aka largest element ends upa t the end but rest of the array isnt sorted)
        for(int i = 0; i < sam.length; i++){
            for(int j = 0; j < sam.length - i - 1 ; j++){ //-1 cause u are checking the next value so you have to so no index out of bounds
                if(sam[j] > sam[j+1]){
                    int temp = sam[j+1];
                    sam[j+1] = sam[j];
                    sam[j] = temp;
                }
            }
        }
        return sam;
    }
    public static int[] insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int val = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > val){ //cehck if arr[j] > val to make sure that we only insert arr[i] where it  is bigger than everything on the left and smaller than everything on the right
                arr[j+1] = arr[j]; //shifts everything to the right, had to store arr[i] in val to not lose it since the first shift would get rid of it since j is i-1 and i - 1 + 1 = i
                j--;
            }
            arr[j + 1] = val; //the while loops ends WHEN arr[j] < val, so this means it ends where the left subarray that is supposed to come before where you are supposed to insert the val is. 
            //therefore, you need to do j+1 to insert it in the right place
        }
        return arr;
    }
    public static void main(String[] args){
        int[] x = {5,4,3,2,1,3,5,1,9,11,3,44};
        int[] y = insertionSort(x);
        for(int meow: y){
            System.out.print(meow + " ");
        }
    }
}