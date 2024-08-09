import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int idx = 0;
        List<String> boardList = new ArrayList<>();

        // 행 처리
        if (h > 0) { // 위쪽 검사
            boardList.add(board[h-1][w]);
        }
        if (h < board.length - 1) { // 아래쪽 검사
            boardList.add(board[h+1][w]);
        }

        // 열 처리
        if (w > 0) { // 왼쪽 검사
            boardList.add(board[h][w-1]);
        }
        if (w < board[0].length - 1) { // 오른쪽 검사
            boardList.add(board[h][w+1]);
        }

        for (String value : boardList) {
            if (value.equals(board[h][w])) {
                idx++;
            }
        }

        return idx;
    }
}