package com.algorithm.sort.basesort;

/**
 * 堆排序
 * 1.大顶堆：
 * 当前节点大于孩子节点
 * 用于升序排序
 * 2.小顶堆
 * 当前节点小于孩子节点
 * 用于降序排序
 *
 * 排序的基本思想：
 * 1.将待排序序列构造成一个大顶堆
 * 2.此时，整个序列的最大值就是堆顶的根节点
 * 3.将其与末尾元素进行交换，此时末尾就是最大值
 * 4.然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素
 * 的次小值，如此反复，直到序列有序
 */
public class DumpSort {
}
