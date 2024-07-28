package com.best.utils;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author cctv14
 * @data 2023/10/2 16:26
 * @description 排序算法
 */
public class SortUtils {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(heapSort(new int[]{7, 10, 13, 15, 4, 20, 19, 8})));
        System.out.println(Arrays.toString(bubbleSort(new int[]{7, 10, 13, 15, 4, 20, 19, 8})));
        System.out.println(Arrays.toString(selectionSort(new int[]{7, 10, 13, 15, 4, 20, 19, 8})));
        System.out.println(Arrays.toString(insertSort(new int[]{7, 10, 13, 15, 4, 20, 19, 8})));
        System.out.println(Arrays.toString(shellSort(new int[]{7, 10, 13, 15, 4, 20, 19, 8})));
        System.out.println(Arrays.toString(mergeSort(new int[]{7, 10, 13, 15, 4, 20, 19, 8})));
        System.out.println(Arrays.toString(quickSort(new int[]{7, 10, 13, 15, 4, 20, 19, 8}, 0, 7)));
        System.out.println(Arrays.toString(countingSort(new int[]{7, 10, 13, 15, 4, 20, 19, 8})));
        System.out.println(Arrays.toString(bucketSort(new int[]{7, 10, 13, 15, 4, 20, 19, 8})));
        System.out.println(Arrays.toString(radixSort(new int[]{7, 10, 13, 15, 4, 20, 19, 8})));
    }

    /**
     * 基数排序: 将整数按位数切割成不同的数字，然后按每个位数分别比较，桶排序 + 计数排序
     */
    public static int[] radixSort(int[] arr) {
        OptionalInt maxOption = Arrays.stream(arr).max();
        int maxValue = Integer.MIN_VALUE;
        if (maxOption.isPresent()) {
            maxValue = maxOption.getAsInt();
        }
        int length = (maxValue + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        for (int i = 0, n = 1; i < length; i++, n *= 10) {
            for (int value : arr) {
                int digitOfElement = value / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = value;
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] > 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                    bucketElementCounts[k] = 0;
                }
            }
        }
        return arr;
    }

    /**
     * 桶排序: 桶排序就是根据桶划分区间元素，对于每一个桶的元素进行排序
     */
    public static int[] bucketSort(int[] arr) {
        int bucketSize = 5;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        OptionalInt maxOptional = Arrays.stream(arr).max();
        OptionalInt minOptional = Arrays.stream(arr).min();
        if (maxOptional.isPresent()) {
            maxValue = maxOptional.getAsInt();
        }
        if (minOptional.isPresent()) {
            minValue = minOptional.getAsInt();
        }
        int bucketCount = (maxValue + minValue) / 2;
        int[][] buckets = new int[bucketCount][0];
        for (int el : arr) {
            int index = (el - minValue) / bucketSize;
            int[] bucketArr = Arrays.copyOf(buckets[index], buckets[index].length + 1);
            bucketArr[bucketArr.length - 1] = el;
            buckets[index] = bucketArr;
        }

        int i = 0;
        for (int[] bucket : buckets) {
            if (bucket.length < 1) {
                continue;
            }
            Arrays.sort(bucket);
            for (int el : bucket) {
                arr[i++] = el;
            }
        }
        return arr;
    }

    /**
     * 计数排序: 对每个元素进行计数，数组更新
     */
    public static int[] countingSort(int[] arr) {
        int maxValue = Integer.MIN_VALUE;
        OptionalInt maxOptional = Arrays.stream(arr).max();
        if (maxOptional.isPresent()) {
            maxValue = maxOptional.getAsInt();
        }
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];
        for (int item : arr) {
            bucket[item]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j] > 0) {
                arr[i++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    /**
     * 快速排序: 每次确定基准的位置，从右往左找小于基准的交换，在从左往右找比基准大的交换直到位置重叠
     */
    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
        return arr;
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    /**
     * 归并排序: 分治每一段都是有序的，比较首元素存储新空间
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] < right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

    /**
     * 希尔排序: 递减增量式交换值排序，关注的是增量位置的元素，不需要每次的遍历
     */
    public static int[] shellSort(int[] arr) {
        int length = arr.length;
        int temp = 0;
        for (int step = length / 2; step > 0; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
        return arr;
    }

    /**
     * 插入排序: j 遍历未排序的数据，往已排序的数据中右到左遍历，元素后移，j 位置插入元素
     */
    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
        }
        return arr;
    }

    /**
     * 选择排序: 每次找到未排序的最小元素的下标，最小元素与未排序的第一个元素交换
     */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    /**
     * 冒泡排序: 相邻比较，每次冒泡都会找到未排序的最大元素
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

    /**
     * 堆排序: 从左到右构建堆，从最后树枝比较，大顶堆保证根节点存放较大值，结果升序排列
     */
    public static int[] heapSort(int[] arr) {
        int len = arr.length;

        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }

        for (int i = len - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, len);
        }
    }
}
