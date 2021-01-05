package sort;

import java.util.Arrays;

/**
 * @author Heerh
 * @version 1.0
 * @date 2020/11/24 23:13
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] param = {1,6,4,2,5,3};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort1(param,0,param.length-1);
        System.out.println(Arrays.toString(param));
    }
    public void quickSort(int[] param){
        int axis = param.length-1;
        int left = 0,right = param.length-2;
        while (true){
                while (param[left]<param[axis]&&left<right){
                    left++;
                }
                while (param[right]>param[axis]&&right>0){
                    right--;
                }
                if (left>=right)break;
                else {
                    int tmp = param[left];
                    param[left] = param[right];
                    param[right] = tmp;
                }
            }
    }
    //快排递归实现
    public void quickSort1(int[] param , int left,int right){
        if (left>right) return;
        int p = partition(param,left,right);
        quickSort1(param,left,p-1);
        quickSort1(param,p+1,right);
    }
    int partition(int[] param , int left,int right){
        if (left == right) return left;
        int pivot = param[left];
        int i = left,j = right+1;
        while (true){
            while (param[++i]<pivot){
                if (i==right)break;
            }
            while (param[--j]>pivot){
                if (j==left)break;
            }
            if (i>=j)break;
            swap(param,i,j);
        }
        swap(param,left,j);
        return j;
    }
    void swap(int[] param , int left,int right){
        int tmp = param[left];
        param[left] = param[right];
        param[right] = tmp;
    }
}
