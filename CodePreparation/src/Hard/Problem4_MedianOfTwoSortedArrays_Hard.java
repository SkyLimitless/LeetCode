package Hard;

/**
 * Created by achaurasia on 8/31/16.
 */
public class Problem4_MedianOfTwoSortedArrays_Hard {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int nums3[] = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }
        if(i < n1) {
            while(i < n1) {
                nums3[k++] = nums1[i++];
            }
        }

        if(j < n2) {
            while(j < n2) {
                nums3[k++] = nums2[j++];
            }
        }

        if((n1 + n2)%2 == 0) {
            return (nums3[(n1 + n2)/2] + (double)nums3[(n1 + n2)/2 - 1])/2;
        } else {
            return (double) nums3[(n1 + n2)/2];
        }
    }

    public double findMedianSortedArraysOptimzed(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int mid1;
        int mid2;
        double total;
        if ((n1 + n2)%2 == 0) {
            mid1 = (n1 + n2)/2 - 1;
            mid2 = (n1 + n2)/2;
            total = 2.0;
        } else {
            mid1 = (n1 + n2)/2;
            mid2 = -1;
            total = 1.0;
        }
        int i = 0, j = 0, k = -1;
        while(k < (n1 + n2)/2) {
            k++;
            if(i < n1 && j < n2 && nums1[i] < nums2[j]) {
                int temp = nums1[i++];
                if (k == mid1)
                    mid1 = temp;
                if (k == mid2)
                    mid2 = temp;
            } else {
                int temp = nums2[j++];
                if (k == mid1)
                    mid1 = temp;
                if (k == mid2)
                    mid2 = temp;
            }
        }
        
        if(total == 2) {
            return (mid1 + mid2)/2.0;
        } else {
            return mid1;
        }
    }

    public static void main(String[] args) {
        Problem4_MedianOfTwoSortedArrays_Hard problem4_medianOfTwoSortedArrays_hard = new Problem4_MedianOfTwoSortedArrays_Hard();
        int a[] = {1, 3, 7, 11, 12};
        int b[] = {4, 6, 9, 13};
        double res = problem4_medianOfTwoSortedArrays_hard.findMedianSortedArraysOptimzed(a, b);
        System.out.println("res = " + res);
        double res1 = problem4_medianOfTwoSortedArrays_hard.findMedianSortedArrays(a, b);
        System.out.println("res1 = " + res1);
    }
}
