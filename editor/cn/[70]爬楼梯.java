//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        // 4.10 第一遍，4.22 第二遍
        // 思路：动态规划。将到达第 n 级台阶拆解为到达第 n-1 和 n-2，
        // 然后再往前走 1/2 步。就能完成任务。
        // 步骤：先写停止递归条件（数学归纳法里面的首步条件，然后写递归公式
        // 注意如果用斐波那契数列的写法，会造成时间过长，在这里我们要保存每一步的内容，
        // 需要用的动态规划

        // 4.22 codes
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int first = 1, second = 2, third = 0;
        for (int i = 0; i < n - 2; i++){
            third = first + second;
            first = second;
            second = third;
        }
        return second;

        // 4.10 codes
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int first = 1;
        int second = 2;
        for (int i = 3; i < n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
