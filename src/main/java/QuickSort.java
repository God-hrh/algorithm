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
        quickSort.quickSort(param);
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
}
