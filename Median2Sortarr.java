import java.util.*;
import java.io.*;

/*  complexity is o(m+n) not o(log (m+n) . 


class Median2Sortarr {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] arr = new int[n1 + n2];
        int i=0, j=0, k=0;

      while( i< n1 && j< n2) {
        //merge array in sorted way
         if(nums1[i]<nums2[j]){
          arr[k++] = nums1[i++];
           } 
        else{
           arr[k++] =nums2[j++]; 
        }
      }
        //for remaining element if nums1 had more lements
        while(i< n1) {
          arr[k++] = nums1[i++];
        }
        while(j< n2){
            arr[k++] = nums2[j++];
        }
    int total = arr.length;
    if(total % 2 == 0){
        return  arr[total/2] ;
    } else{
        return (arr[total/2 -1] + arr[total /2]) /2.0;
    }
       }
    }

*/
// so dont use 3 loops use while loop and try to intiate
class Median2Sortarr {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) merged[k++] = nums1[i++];
        while (j < nums2.length) merged[k++] = nums2[j++];
        
        int len = merged.length;
        if (len % 2 == 0) {
            return (merged[len/2 - 1] + merged[len/2]) / 2.0;
        } else {
            return merged[len/2];
     }
        
    }
}




 
 
 
 
 
