package com.mjt.day01;

/**
 * @Description
 * @Author mjt
 * @Time 2021/7/30
 */
public class QuickSort {

    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
