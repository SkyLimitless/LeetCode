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
}
