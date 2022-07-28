package com.howtodoinjava.algo.sort;

/**
 * @Author : mayurdeolasee
 */
public class CountingSort {
    /**
     *
     * @param inputArray - This is integer input array
     * @param maxInArray - this is maximum element permissible in array. Algo is efficient only when maxInArray = O(n)
     * @return
     */
    private int[] sortIntegerByCountingSort(int[] inputArray, int maxInArray) {
        int n = inputArray.length;
        int[] sortedArray = new int[n]; //This array will be returned
        int[] temp = new int[maxInArray+1]; //+1 considering 0 . Temp storage

        //Temp array now contains elements equal to i
        for(int i=0;i<inputArray.length; i++){
               ++temp[inputArray[i]];
        }

        //Temp now contains elements less than or equal to  k
        for(int k=1; k<maxInArray+1; k++){
           temp[k] = temp[k]+temp[k-1];
        }


        //Now elements are put in position where they should belong in sorted array
        for (int i = n-1; i >= 0; i--) {
            --temp[inputArray[i]];
            sortedArray[temp[inputArray[i]]]  = inputArray[i];

        }

        return sortedArray;
    }

    public static void main(String args[]){
        CountingSort myCountingSort = new CountingSort();
        int[] marksOutOfTen = new int[]{6, 2, 5, 1, 2, 6, 8, 9, 10, 0, 1, 8, 7, 6, 6, 3, 6, 6, 0};
        int[] sortedMarks = myCountingSort.sortIntegerByCountingSort(marksOutOfTen, 10);
        System.out.println("Array in sorted order : ");
        for(int i=0; i<sortedMarks.length; i++){
            System.out.print(sortedMarks[i]+" ");
        }

    }

}