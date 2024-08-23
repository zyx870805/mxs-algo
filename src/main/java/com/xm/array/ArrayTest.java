package com.xm.array;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayTest {
    /**
     * 旋转数组-临时数组法
     *
     * @param arr
     * @param k
     */
    public void rotationArray(int[] arr, int k) {
        k = k % arr.length;
        int[] tempArr = new int[k];
        int i, j;
        for (i = 0; i < k; i++) {
            tempArr[i] = arr[i];
        }

        for (i = 0; i < arr.length - k; i++) {
            arr[i] = arr[i + k];
        }

        for (j = 0; j < k; j++) {
            arr[i++] = tempArr[j];
        }
    }

    /**
     * 旋转数组-按部就班移动法
     *
     * @param arr
     * @param k
     */
    public void leftRotate(int[] arr, int k) {
        k = k % arr.length;
        for (int i = 0; i < k; i++) {
            leftRotateOne(arr);
        }

    }

    public void leftRotateOne(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }

    /**
     * 计算公约数
     *
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    /**
     * 旋转数组-最大公约数法
     *
     * @param arr
     * @param k
     */
    public void rotateArrWithGcd(int[] arr, int k) {
        k = k % arr.length;
        int gcd = gcd(arr.length, k);

        int i, j, s, temp;
        for (i = 0; i < gcd; i++) {
            temp = arr[i];
            j = i;
            while (true) {
                s = j + k;
                if (s >= arr.length) {
                    s = s - arr.length;
                }
                if (s == i) {
                    break;
                }
                arr[j] = arr[s];
                j = s;
            }
            arr[j] = temp;
        }
    }

    public void rotateArrWithReverse(int[] arr, int k) {
        if (k == 0 || k == arr.length) {
            return;
        }
        k = k % arr.length;

        reverseArr(arr, 0, k - 1);
        reverseArr(arr, k, arr.length - 1);
        reverseArr(arr, 0, arr.length - 1);
    }

    public void reverseArr(int[] arr, int start, int end) {
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayTest arrayTest = new ArrayTest();
//        arrayTest.rotationArray(arr, 2);
//        arrayTest.leftRotate(arr, 2);
//        arrayTest.rotateArrWithGcd(arr, 2);
        arrayTest.rotateArrWithReverse(arr, 2);
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(",")));

    }
}
