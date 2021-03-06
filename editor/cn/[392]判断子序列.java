//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"ae
//c"不是）。 
//
// 示例 1: 
//s = "abc", t = "ahbgdc" 
//
// 返回 true. 
//
// 示例 2: 
//s = "axc", t = "ahbgdc" 
//
// 返回 false. 
//
// 后续挑战 : 
//
// 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码
//？ 
//
// 致谢: 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
// Related Topics 贪心算法 二分查找 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 - xx 第一遍；7.27 第二遍
 - 思路：双指针。
 1. 两个指针分别指向string的首位，若相等，则分别将 i，j 指针往后移动一位
 2. 如果不相等，则保持i不动，将j往后移动。最后如果 i 走到了str s 的最后一位，说明 s 中的每一个字符都能在 t 中找到对应。即 s 为 t 的子串。
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int i= 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i += 1;
                j += 1;
            } else {
                j += 1;
            }
        }
        return i == m;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
