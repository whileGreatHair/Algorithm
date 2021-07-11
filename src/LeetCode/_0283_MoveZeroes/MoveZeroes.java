package LeetCode._0283_MoveZeroes;

/**
 * @author yiqru
 * @date 2021/7/11 10:16 上午
 */
public class MoveZeroes {
    /**
     * 283.给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * </p>
     */
    public void moveZeroes(int[] nums) {
        int old = 0, now = 0;
        int[] a = new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        Integer[] a = new Integer[5];
        System.out.println(a[0]);
    }
}
