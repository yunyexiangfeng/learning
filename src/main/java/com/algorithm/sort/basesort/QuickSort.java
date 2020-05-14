package com.algorithm.sort.basesort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 快排，对冒泡排序算法的优化
 * Created by OY on 2020/4/19.
 */
public class QuickSort {

    @Test
    public void test() {
        //构建数组
        int[] array = {3, 3, 1, 2, 9, 8};
//        int[] array = {1,2,3,4,5,6};
//        int[] array = {1, 2, 3, 5, 9, 8};
        int left = 0;
        int right = array.length - 1;

//        quickSort(array, left, right);
//        System.out.println("排序后：" + Arrays.toString(array));

        qSort(array, left, right);
        System.out.println("排序后：" + Arrays.toString(array));
    }

    public void qSort(int[] array, int low, int high){
        if (low < high){
//            int pivotLocation = partitionLow(array, low, high);
//            int pivotLocation = partitionHigh(array, low, high);
//            int pivotLocation = partitionMid(array, low, high);
            int pivotLocation = partition(array, low, high);
            System.out.println("pivot location : " + pivotLocation);
            System.out.println("-------------------------");
//            qSort(array, low, pivotLocation -1);
//            qSort(array, pivotLocation + 1, high);
        }
    }

    /**
     * 按照从小到大排序
     * 将数组第一个值设置为锚点
     *  *锚点位置影响遍历顺序
     *      1.如果锚点设置在数组第一个位置，得先从high->low遍历，保证在进行锚点交换后，
     *      锚点右边的值一定比锚点值大
     *      2.如果锚点设置在数组最后个位置，得先从low->high遍历，保证在进行锚点交换后，
     *      锚点左边的值一定比锚点值小
     *      3.如果锚点放在中间，low<->high同时遍历，之后进行交换
     * @param array
     * @param low
     * @param high
     * @return
     */
    public int partitionLow(int[] array, int low, int high){
        int pivot = array[low];
        while (low < high){
            //从数组两端交替向中间扫描

            //从右往左
            while (low < high && array[high] >= pivot)
                -- high;
            //交换
            swap(array, low, high);
            //从左往右
            while (low < high && array[low] <= pivot)
                ++ low;
            //交换
            swap(array, low, high);
        }
        System.out.println("每趟排序结果：" + Arrays.toString(array));
        return low;
    }

    public int partitionHigh(int[] array, int low, int high){
        int pivot = array[high];
        while (low < high){
            while (low < high && array[low] <= pivot)
                ++ low;
            swap(array, low, high);

            while (low < high && array[high] >= pivot)
                -- high;
            swap(array, low, high);
        }
        System.out.println("每趟排序结果：" + Arrays.toString(array));
        return low;
    }

    public int partitionMid(int[] array, int low, int high){
        int pivot = array[(low + high)/2];
        System.out.println(high);
        while (low < high){
            while (high > low && array[low] <= pivot)
                low ++;
            while (high > low && array[high] >= pivot)
                high --;

            System.out.println("low = " + low + "; high = " + high);
            swap(array, low, high);
        }
        System.out.println("每趟排序结果：" + Arrays.toString(array));
        return low;
    }

    /**
     * 对交换的方式进行改进：减少交换次数
     * @param array 待排序数组
     * @param low 低位
     * @param high 高位
     * @return
     */
    public int partition(int[] array, int low, int high){
        //pivot为枢纽值
        int pivot = array[low];
        while (low < high){
            //从数组两端交替向中间扫描

            //从右往左
            while (low < high && array[high] >= pivot)
                -- high;
            //将 <low 的高位前移，减少swap移动次数
            array[low] = array[high];
            //从左往右
            while (low < high && array[low] <= pivot)
                ++ low;
            //将 >low 的低位后移，减少swap移动次数
            array[high] = array[low];
        }
        //经过一轮移动之后，array[low]的位置为下一轮数组分割位
        //且为枢纽位，才能保证array[low]之前的值都小，之后值都大
        //无论是array[low]往高位移动，还是array[high]往低位移动
        //覆盖的值都是pivot记录的枢纽值
        //才能保证array[low] = pivot时数据不丢失
        array[low] = pivot;
        System.out.println("每趟排序结果：" + Arrays.toString(array));
        return low;
    }
    public void swap(int[] array, int low, int high){
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }
}
