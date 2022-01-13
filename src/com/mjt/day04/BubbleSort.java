package com.mjt.day04;

import java.util.Arrays;

/**
 * @Description
 * @Author mjt
 * @Time 2021/8/9
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = arr.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //一个容易实现，并且百分之百是正确的排序操作，用来验证我们实现的算法是否正确
    public void comparator(int[] arr){
        Arrays.sort(arr);
    }

    /**
     * 自动生成一个随机数组，通过传入参数来确定数组最大值和数组长度
     * @param maxSize：随机数组最大长度
     * @param maxValue：随机数组元素最大值
     * @return 返回随机生成的数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int) ((maxSize + 1)*Math.random())];//随机数组长度为[0~maxSize]
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (maxValue*Math.random() - maxValue*Math.random());//随机数组内元素的取值范围是(-maxValue, maxValue)
        }
        return arr;
    }

    /**
     * 将随机生成的数组拷贝一份，一份数组测试想要测试的算法，一份数组测试百分百正确的算法
     * 通过对比两个算法结果是否一致，来判断所实现算法是否正确
     * @param arr 随机生成的数组
     * @return 拷贝的同样的数组
     */
    public static int[] copyArray(int[] arr){
        if (arr == null){
            return null;
        }
        int[] res = new int[arr.length];//赋值出来的数组
        for (int i = 0; i < arr.length; i++){
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 判断两个不同的排序之后的数组是否完全相同
     * @param arr1 一个排序之后的数组
     * @param arr2 另一个排序之后的数组
     * @return 是否为true
     */
    public static boolean isEqual(int[] arr1, int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        if (arr1 == null && arr2 == null){//同为null，则相同
            return true;
        }
        if (arr1.length != arr2.length){//长度不同，数组必不相同
            return false;
        }
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i]){//有一个元素不同，则不同
                return false;
            }
        }
        return true;
    }

    //打印数组
    public static void printArray(int[] arr){
        if(arr == null){
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int testTime = 50000;//测试次数
        int maxSize = 10;
        int maxValue = 100;
        boolean success = true;
        for (int i = 0; i < testTime; i++){
            int[] arr1 = generateRandomArray(maxSize,maxValue);//随机生成一个数组
            int[] arr2 = copyArray(arr1);//拷贝出另一个元素相同数组
            bubbleSort(arr1);//自己实现的算法进行排序
            Arrays.sort(arr2);//jdk提供的排序方法或者自己实现的百分百正确的排序

            //判断排序后两数组是否相同
            if (!isEqual(arr1,arr2)){
                success = false;
                printArray(arr1);
                System.out.println();
                printArray(arr2);
                System.out.println();
                break;
            }
        }
        System.out.println(success ? "nice" : "fucking fucked");
    }
}
