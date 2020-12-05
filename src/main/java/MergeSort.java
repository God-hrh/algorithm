package sort;

import java.util.Arrays;

/**
 * @author Heerh
 * @version 1.0
 * @date 2020/11/24 22:17
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] param = {9,2,4,7,5,3,9};
        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.MergeSort(param)));
    }
    public int[] MergeSort(int[] param){
        if (param.length==1) {
            return param;
        }
        int mid = param.length/2;
        //分
        int[] left = MergeSort(subArray(param,0,mid));
        int[] right = MergeSort(subArray(param,mid,param.length));
        //合
        int[] res = new int[left.length+right.length];
        //左右两个指针
        int l = 0,r=0,index=0;
        while (l<left.length&&r<right.length){
            if (left[l]<=right[r]){
                res[index] = left[l];
                l++;
            }else {
                res[index] = right[r];
                r++;
            }
            index++;
        }
        if (l<left.length){
            for (int i = l; i < left.length; i++) {
                res[index] = left[i];
                index++;
            }
        }
        if (r<right.length){
            for (int i = r; i < right.length; i++) {
                res[index] = right[i];
                index++;
            }
        }
        return res;
    }
    public int[] subArray(int[] source,int left,int right){
        int[] res = new int[right-left];
        for (int i = left; i < right; i++) {
            res[i-left] = source[i];
        }
        return res;
    }
}
