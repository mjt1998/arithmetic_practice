package com.mjt.day02;

/**
 * @Description
 * @Author mjt
 * @Time 2021/8/7
 */
public class QuickSort {

    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
