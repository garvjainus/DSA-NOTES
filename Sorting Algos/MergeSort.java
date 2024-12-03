public class MergeSort {
    public static void mergeSort(int[] arr){
        if(arr.length == 1){
            return;
        }

        int mid = arr.length/2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[arr.length-mid];

        for(int i = 0; i < mid; i++){
            leftHalf[i] = arr[i];
        }

        for(int i = mid; i < arr.length; i++){
            rightHalf[i-mid] = arr[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        mergeArrays(arr, leftHalf, rightHalf);
    }

    //assuming left half and right half are sorted since we bring it down to one element which is automatically considered sorted
    private static void mergeArrays(int[] arr, int[] leftHalf, int[] rightHalf){
        int leftTrack = 0;
        int rightTrack = 0;
        int mergeTrack = 0;
        while(leftTrack < leftHalf.length && rightTrack < rightHalf.length){
            int rElement = rightHalf[rightTrack];
            int lElement = leftHalf[leftTrack];
            if(lElement > rElement){
                arr[mergeTrack] = rElement;
                rightTrack++;
            } else {
                arr[mergeTrack] = lElement;
                leftTrack++;
            }
            mergeTrack++;
        }

        while(leftTrack < leftHalf.length){
            arr[mergeTrack] = leftHalf[leftTrack];
            mergeTrack++;
            leftTrack++;
        }

        while(rightTrack < rightHalf.length){
            arr[mergeTrack] = rightHalf[rightTrack];
            mergeTrack++;
            rightTrack++;
        }
    }
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
        System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args){
        int arr[] = { 6, 5, 12, 10, 9, 1 };
        mergeSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }
}
