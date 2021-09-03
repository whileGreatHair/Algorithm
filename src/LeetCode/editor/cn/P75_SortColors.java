package LeetCode.editor.cn;

import java.util.Arrays;

//75.颜色分类
public class P75_SortColors {
    //leetcode submit region begin(Prohibit modification and deletion)
    //单指针
    class Solution {
        public void sortColors(int[] nums) {
            int n = nums.length;
            int p = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[p];
                    nums[p] = temp;
                    ++p;
                }
            }
            for (int i = p; i < n; ++i) {
                if (nums[i] == 1) {
                    int temp = nums[i];
                    nums[i] = nums[p];
                    nums[p] = temp;
                    ++p;
                }
            }

        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    //双指针
    class Solution2 {
        public void sortColors(int[] nums) {
            int n = nums.length;
            int p0 = 0, p1 = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[p0];
                    nums[p0] = temp;
                    if (p0 < p1) {
                        temp = nums[i];
                        nums[i] = nums[p1];
                        nums[p1] = temp;
                    }
                    ++p0;
                    ++p1;

                } else if (nums[i] == 1) {
                    int temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                    ++p1;
                }
            }


        }
    }

    //双指针
    class Solution3 {
        public void sortColors(int[] nums) {
            int n = nums.length;
            int p0 = 0, p2 = n - 1;
            for (int i = 0; i <= p2; ++i) {
                while (i <= p2 && nums[i] == 2) {
                    int temp = nums[i];
                    nums[i] = nums[p2];
                    nums[p2] = temp;
                    --p2;
                }
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[p0];
                    nums[p0] = temp;
                    ++p0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new P75_SortColors().new Solution();
        Solution2 solution2 = new P75_SortColors().new Solution2();
        int nums[] = {2, 0, 2, 1, 1, 0};
        solution2.sortColors(nums);
    }
}
