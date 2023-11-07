package now.in.jvm;

import java.util.Arrays;

public class Solution {
    /**
     * 入口函数（递归方法），算法的调用从这里开始。
     */
    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        // 核心算法部分：分别介绍 双边指针（交换法），双边指针（挖坑法），单边指针
        int pivot = partition(arr, start, end);
        // int pivot = doublePointerHole(arr, start, end);
        // int pivot = singlePointer(arr, start, end);

        // 用分界值下标区分出左右区间，进行递归调用
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    /**
     * 双边指针（交换法）
     * 思路：
     * 记录分界值 pivot，创建左右指针（记录下标）。
     * （分界值选择方式有：首元素，随机选取，三数取中法）
     *
     * 首先从右向左找出比pivot小的数据，
     * 然后从左向右找出比pivot大的数据，
     * 左右指针数据交换，进入下次循环。
     *
     * 结束循环后将当前指针数据与分界值互换，
     * 返回当前指针下标（即分界值下标）
     */
    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start;
        int j = end;

        while (i < j) {
            // 从右向左找出比pivot小的数据
            while (i < j && nums[j] > pivot) {
                j--;
            }
            // 从左向右找出比pivot大的数据
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            // 没有过界则交换
            if (i < j) {
                swap(nums, i, j);
            }
        }
        // 最终将分界值与当前指针数据交换
        nums[start] = nums[j];
        nums[j] = pivot;
        // 返回分界值所在下标
        return j;
    }

    private int select(int[] nums, int start, int end, int k) {
        if (start == end) return nums[k];

        int pivot = nums[start];
        int i = start;
        int j = end;

        while (i < j) {
            // 从右向左找出比pivot小的数据
            while (i < j && nums[j] > pivot) {
                j--;
            }
            // 从左向右找出比pivot大的数据
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            // 没有过界则交换
            if (i < j) {
                swap(nums, i, j);
            }
        }
        if (k == j) {
            return pivot;
        }
        nums[start] = nums[j];
        nums[j] = pivot;
        return k < j ? select(nums, start, j - 1, k) : select(nums, j + 1, end, k);
    }

    int quickselect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j) return quickselect(nums, l, j, k);
        else return quickselect(nums, j + 1, r, k);
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return select(nums, 0, n - 1, n - k);
    }

    private void swap(int[] a, int i, int j) {
        int n = a[i];
        a[i] = a[j];
        a[j] = n;
    }

    /**
     * 单边指针
     * 思路：
     * 记录首元素为分界值 pivot, 创建标记 mark 指针。
     * 循环遍历与分界值对比。
     * 比分界值小，则 mark++ 后与之互换。
     * 结束循环后，将首元素分界值与当前mark互换。
     * 返回 mark 下标为分界值下标。
     */
    private int singlePointer(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start;

        for (int j = start + 1; j <= end; j++) {
            // 如果比分界值小，则 mark++ 后互换。
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
            System.out.println(Arrays.toString(nums));
        }
        // 将首元素分界值与当前mark互换
        nums[start] = nums[i];
        nums[i] = pivot;
        return i;
    }
}
