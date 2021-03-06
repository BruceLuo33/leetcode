//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.4 第一遍，6.5 第二遍
 - 思路：三次判定：
 1. 首先，设置 boolean 矩阵，第一个对应的是对于每一行中是否出现重复元素的判定，row 代表的是 board 的 0 - 8 行，col 中的 0 - 8 代表的是九个数字是否曾经出现；
 2. 同理，第二个矩阵是对于每一列中是否有重复元素的判定，row 代表的是每一行；第三个矩阵是对于每一个小 block 中是否有重复元素的判定；
 3. 将 `board[i][j]` 对应到第一、二个矩阵很简单，但是对应到每一个 block 需要一番心思，具体而言能找到如下规律：
 - 从左到右、从上到下依次给 block 编号为 0 - 8，每一层有三个 block，所以第 0 层序号为：0-2，第 1 层为 3-5，第 2 层为 6-8；
 - 如果 `0 <= i <= 2`，说明 `board[i][j]`在第一层的三个 block 之中，因为 9 个 block 实际上的排列为 3x3，所以其对应的 block 的层级为 `i / 3 * 3`（`*3`是因为每一层有三个 block）
 - 在这一层中，block 又位于第几个呢？这就需要 j 来判定，即 `j/3`
 - 所以，最终的 block 的序号，即为`blockIndex = i / 3 * 3 + j / 3`
 - 复杂度分析：O(N^2)
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int value = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (row[i][value] || col[j][value] || block[blockIndex][value]) {
                        return false;
                    } else {
                        row[i][value] = true;
                        col[j][value]= true;
                        block[blockIndex][value] = true;
                    }
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
