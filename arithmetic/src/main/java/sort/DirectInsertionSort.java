package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hechao on 2017/6/12.
 */
public class DirectInsertionSort {
    public static void main(String[] args) {
//        simpleSelectionSort();
//        new HeapSort();
//        bubbleSort();
//        new QuickSort();
//        new MergingSort();
        new RadixSort();
        return;
    }

    public static void directInsertionSort() {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            int j = i - 1;
            temp = a[i];
            for (; j >= 0 && temp < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
            System.out.println(Arrays.toString(a));
        }
    }

    public static void shellSort() {
        int a[] = {1, 54, 6, 3, 78, 34, 12, 45, 56, 100};
        double d1 = a.length;
        int temp = 0;

        while (true) {
            d1 = Math.ceil(d1 / 2);
            int d = (int) d1;
            for (int x = 0; x < d; x++) {

                for (int i = x + d; i < a.length; i += d) {
                    int j = i - d;
                    temp = a[i];
                    for (; j >= 0 && temp < a[j]; j -= d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }

            if (d == 1) {
                break;
            }
            System.out.println(Arrays.toString(a));
        }

    }


    public static void simpleSelectionSort() {
        int a[] = {1, 54, 6, 3, 78, 34, 12, 45};
        int position = 0;
        for (int i = 0; i < a.length; i++) {
            int j = i + 1;
            position = i;
            int temp = a[i];
            for (; j < a.length; j++) {
                if (a[j] < temp) {
                    temp = a[j];
                    position = j;
                }
            }
            a[position] = a[i];
            a[i] = temp;
            System.out.println(Arrays.toString(a));
        }
    }

    public static class HeapSort {

        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

        public HeapSort() {
            heapSort(a);
        }

        public void heapSort(int[] a) {
            System.out.println("开始排序");
            int arrayLength = a.length;
            //循环建堆
            for (int i = 0; i < arrayLength - 1; i++) {
                //建堆
                buildMaxHeap(a, arrayLength - 1 - i);
                //交换堆顶和最后一个元素
                swap(a, 0, arrayLength - 1 - i);
                System.out.println(Arrays.toString(a));
            }
        }


        private void swap(int[] data, int i, int j) {
            // TODO Auto-generated method stub
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }

        //对data数组从0到lastIndex建大顶堆
        private void buildMaxHeap(int[] data, int lastIndex) {
            // TODO Auto-generated method stub
            //从lastIndex处节点（最后一个节点）的父节点开始

            for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
                //k保存正在判断的节点
                int k = i;
                //如果当前k节点的子节点存在
                while (k * 2 + 1 <= lastIndex) {
                        //k节点的左子节点的索引
                        int biggerIndex = 2 * k + 1;
                        //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                        if (biggerIndex < lastIndex) {
                                //若果右子节点的值较大
                                if (data[biggerIndex] < data[biggerIndex + 1]) {
                                    //biggerIndex总是记录较大子节点的索引
                                biggerIndex++;
                            }
                        }

                    //如果k节点的值小于其较大的子节点的值
                    if (data[k] < data[biggerIndex]) {
                        //交换他们
                        swap(data, k, biggerIndex);
                        //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                        k = biggerIndex;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void bubbleSort() {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(a));
        }
    }

    public static class QuickSort {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

        public QuickSort() {
            quick(a);
            System.out.println(Arrays.toString(a));

        }

        public int getMiddle(int[] list, int low, int high) {
            int tmp = list[low];    //数组的第一个作为中轴
            while (low < high) {
                while (low < high && list[high] >= tmp) {
                    high--;
                }

                list[low] = list[high];   //比中轴小的记录移到低端
                while (low < high && list[low] <= tmp) {
                    low++;
                }

                list[high] = list[low];   //比中轴大的记录移到高端
            }
            list[low] = tmp;              //中轴记录到尾
            return low;                   //返回中轴的位置
        }

        public void _quickSort(int[] list, int low, int high) {
            if (low < high) {
                int middle = getMiddle(list, low, high);  //将list数组进行一分为二
                _quickSort(list, low, middle - 1);       //对低字表进行递归排序
                _quickSort(list, middle + 1, high);       //对高字表进行递归排序
            }
        }

        public void quick(int[] a2) {
            if (a2.length > 0) {    //查看数组是否为空
                _quickSort(a2, 0, a2.length - 1);
            }
        }
    }

    public static class MergingSort {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

        public MergingSort() {
            sort(a, 0, a.length - 1);
        }

        public void sort(int[] data, int left, int right) {
            // TODO Auto-generatedmethod stub
            if (left < right) {
                //找出中间索引
                int center = (left + right) / 2;
                //对左边数组进行递归
                sort(data, left, center);
                //对右边数组进行递归
                sort(data, center + 1, right);
                //合并
                merge(data, left, center, right);
            }

        }

        public void merge(int[] data, int left, int center, int right) {
            // TODO Auto-generatedmethod stub
            int[] tmpArr = new int[data.length];
            int mid = center + 1;
            //third记录中间数组的索引
            int third = left;
            int tmp = left;
            while (left <= center && mid <= right) {
                //从两个数组中取出最小的放入中间数组
                if (data[left] <= data[mid]) {
                    tmpArr[third++] = data[left++];
                } else {
                    tmpArr[third++] = data[mid++];
                }

            }

            //剩余部分依次放入中间数组
            while (mid <= right) {
                tmpArr[third++] = data[mid++];
            }

            while (left <= center) {
                tmpArr[third++] = data[left++];
            }

            //将中间数组中的内容复制回原数组
            while (tmp <= right) {
                data[tmp] = tmpArr[tmp++];
            }
            System.out.println(Arrays.toString(data));
        }
    }

    public static class RadixSort {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 101, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

        public RadixSort() {
            sort(a);

            System.out.println(Arrays.toString(a));

        }

        public void sort(int[] array) {
            //首先确定排序的趟数;
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            int time = 0;
            //判断位数;
            while (max > 0) {
                max /= 10;
                time++;
            }

            //建立10个队列;
            List<ArrayList> queue = new ArrayList<ArrayList>();
            for (int i = 0; i < 10; i++) {
                ArrayList<Integer> queue1 = new ArrayList<Integer>();
                queue.add(queue1);
            }

            //进行time次分配和收集;
            for (int i = 0; i < time; i++) {
                //分配数组元素;
                for (int j = 0; j < array.length; j++) {
                    //得到数字的第time+1位数;
                    int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                    ArrayList<Integer> queue2 = queue.get(x);
                    queue2.add(array[j]);
                    queue.set(x, queue2);
                }
                int count = 0;//元素计数器;
                //收集队列元素;
                for (int k = 0; k < 10; k++) {
                    while (queue.get(k).size() > 0) {
                        ArrayList<Integer> queue3 = queue.get(k);
                        array[count] = queue3.get(0);
                        queue3.remove(0);
                        count++;
                    }
                }
            }
        }
    }

}
