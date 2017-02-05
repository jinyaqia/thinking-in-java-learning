# coding:utf-8


class Solution(object):
    def solveSudoku(self, board):

        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        self.board = board
        self.val = self.PossibleVals()
        self.Solver()
        return self.board

    def PossibleVals(self):
        a = "123456789"
        d, val = {}, {}
        for i in range(9):
            for j in range(9):
                ele = self.board[i][j]
                if ele != ".":
                    d[("r", i)] = d.get(('r', i), []) + [ele]  # 存储行
                    d[("c", j)] = d.get(('c', j), []) + [ele]  # 存储列
                    d[(i // 3, j // 3)] = d.get((i // 3, j // 3), []) + [ele]  # 存储3*3方格

                else:
                    val[(i, j)] = []

        for (i, j) in val.keys():
            inval = d.get(('r', i), []) + d.get(('c', j), []) + d.get((i / 3, j / 3), [])
            val[(i, j)] = [n for n in a if n not in inval]
        return val

    def Solver(self):
        if len(self.val) == 0:
            return True
        # 选择最少种可能的空先填
        kee = min(self.val.keys(), key=lambda x: len(self.val[x]))
        nums = self.val[kee]

        for n in nums:
            update = {kee: self.val[kee]}
            if self.ValidOne(n, kee, update):
                if self.Solver():

                    return True
            self.undo(kee, update)

        return False

    def ValidOne(self, n, kee, update):
        self.board[kee[0]][kee[1]] = n
        del self.val[kee]
        i, j = kee
        for ind in self.val.keys():
            if n in self.val[ind]:
                if ind[0] == i or ind[1] == j or (ind[0] / 3, ind[1] / 3) == (i / 3, j / 3):
                    update[ind] = n
                    self.val[ind].remove(n)
                    if len(self.val[ind]) == 0:
                        return False
        return True

    def undo(self, kee, update):
        self.board[kee[0]][kee[1]] = "."
        for k in update:
            if k not in self.val:
                self.val[k] = update[k]
            else:
                self.val[k].append(update[k])
        return None


if __name__ == '__main__':
    board1 = [['5', '3', '.', '.', '7', '.', '.', '.', '.'],
              ['6', '.', '.', '1', '9', '5', '.', '.', '.'],
              ['.', '9', '8', '.', '.', '.', '.', '6', '.'],
              ['8', '.', '.', '.', '6', '.', '.', '.', '3'],
              ['4', '.', '.', '8', '.', '3', '.', '.', '1'],
              ['7', '.', '.', '.', '2', '.', '.', '.', '6'],
              ['.', '6', '.', '.', '.', '.', '2', '8', '.'],
              ['8', '.', '.', '4', '1', '9', '.', '.', '5'],
              ['8', '.', '.', '.', '8', '.', '.', '7', '9']]
    # board1 = ["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
    board2 = Solution().solveSudoku(board1)
    for k, v in enumerate(board2):
        print(v)
