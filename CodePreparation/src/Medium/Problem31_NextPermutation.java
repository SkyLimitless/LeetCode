package Medium;

/**
 * Created by Aakash on 1/10/2017.
 */
public class Problem31_NextPermutation {
    public static void main(String[] args) {
        Problem31_NextPermutation permutation = new Problem31_NextPermutation();
        int a[] = {1,3,2};
        permutation.nextPermutation(a);
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.println("i1 = " + i1);
        }
    }

    public void nextPermutation(int[] nums) {
        int pivot = nums.length - 2;
        while (pivot > -1 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }
        if(pivot == -1) {
            for (int i = 0; i < nums.length/2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
            return;
        }
        int pivotValue = nums[pivot];
        int swap = nums.length - 1;
        while(swap > pivot && pivotValue >= nums[swap])
        {
            swap--;
        }

        nums[pivot] = nums[swap];
        nums[swap] = pivotValue;

        for (int i = 0; i < (nums.length - pivot - 1)/2; i++) {
            int temp = nums[pivot + i + 1];
            nums[pivot + i + 1] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }
}
