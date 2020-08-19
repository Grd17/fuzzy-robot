package main.text01;

public class MergeSort {
    /**
     * 归并排序算法, A是数组，n表示数组大小
     */
    public  void merge_sort(int[] a, int n){
        merge_sort_c(a,0,n-1);
    }

    // 递归调用函数
    public void merge_sort_c(int[] a,int p, int r){
      //递归终止条件
      if (p >= r) return;
      //取p和r中间位置为q
        int q = (p+r)/2;
        //分治递归
        merge_sort_c(a,p,q);
        merge_sort_c(a,q+1,r);
        //将a[] 下标p...q 和下标q+1...r 合并为a[]
        merge(a,p,q,r);
    }

    //合并函数
    public void  merge(int[] a, int p,int q,int r){
        //变量i,j分别指向两个数组的第一个元素
        int i = p;
        int j = q+1;
        int k = 0;
        //申请一个临时数组和原数组大小一样
        int[] tmp = new int[r-p+1];
        while (i<=q && j<=r){
            if(a[i]<= a[j]){
                tmp[k++] = a[i++];
            }else {
                tmp[k++] = a[j++];
            }
        }
        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if(j<=r){
            start = j;
            end = r;
        }
        //将剩下的数据拷贝到临时数组
        while (start<=end){
            tmp[k++] = a[start++];
        }
        //将tmp中的数组拷贝回a[]
        for ( i = 0;i<= r-p;i++){
            a[p+i] = tmp[i];
        }

    }

}
