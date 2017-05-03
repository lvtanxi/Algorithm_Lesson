package com.lv.lesson18;

/**
 * Date: 2017-05-03
 * Time: 14:57
 * Description:  归并排序
 */
public class MergeSort {
    private int[] theArray;
    private int nItem;

    private MergeSort(int max) {
        theArray = new int[max];
        nItem = 0;
    }

    private void insert(int value) {
        theArray[nItem++] = value;
    }

    private void displayList() {
        for (int i = 0; i < nItem; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println("");
    }

    private void mergeSort() {
        int[] workspace = new int[nItem];
        recMergeSort(workspace, 0, nItem - 1);
    }

    /**
     * 对半拆分数组
     *
     * @param workspace 零时数组
     * @param lower     起始位置
     * @param upper     结束位置
     */
    private void recMergeSort(int[] workspace, int lower, int upper) {
        if (lower == upper)
            return;
        int mid = (lower + upper) / 2; // 获取中间位置
        recMergeSort(workspace, lower, mid);//拆分0到中间的(递归前半部分排序处理)
        recMergeSort(workspace, mid + 1, upper);//拆分中间到末尾(递归后半部分排序处理)
        merge(workspace, lower, mid + 1, upper); //合并数据
    }

    /**
     * 合并数据
     *
     * @param workspace 零时数组
     * @param lowPtr    起始位置
     * @param midPtr    中间位置
     * @param upper     结束位置
     */
    private void merge(int[] workspace, int lowPtr, int midPtr, int upper) {
        int lower = lowPtr; //开始位置
        int mid = midPtr - 1;//前半部分的中间位置
        int n = upper - lowPtr + 1; //进行排序的数据项个数
        int j = 0;
        while (lowPtr <= mid && midPtr <= upper)
            // 左半部分的数据小于右半部分的数据，就放左边的数据，否则则相反
            if (theArray[lowPtr] < theArray[midPtr])
                workspace[j++] = theArray[lowPtr++];//++表示移动数据下标
            else
                workspace[j++] = theArray[midPtr++];
        //如果左边的数组还有数据没有排完(大数据)
        while (lowPtr <= mid)
            workspace[j++] = theArray[lowPtr++];
        //如果右边的数组还有数据没有排完(大数据)
        while (midPtr <= upper)
            workspace[j++] = theArray[midPtr++];
        //结果还原
        for (j = 0; j < n; j++)
            theArray[lower + j] = workspace[j];
    }

    public static void main(String[] args) {
        MergeSort myArray = new MergeSort(10);

        myArray.insert(80);
        myArray.insert(38);
        myArray.insert(49);
        myArray.insert(25);
        myArray.insert(3);
        myArray.insert(75);

        myArray.displayList();
        myArray.mergeSort();
        myArray.displayList();
    }
}
