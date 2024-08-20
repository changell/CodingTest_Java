import java.util.*;
class Solution {
    //방향 배열
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};
    
    // 시작 위치, 종료 위치 저장 배열
    int[] start, end;
    
    public int solution(String[] board) {
        int rLng = board.length;        //행 길이
        int cLng = board[0].length();   //열 길이
        
        for(int i = 0; i < rLng; i++){
            for(int j = 0; j < cLng; j++){
                char c = board[i].charAt(j);
                switch (c) {
                    case 'R':
                        start = new int[]{i, j, 0}; //시작 위치 설정
                        
                        break;
                    case 'G' :
                        end = new int[]{i, j, 0};   //종료 위치 설정
                        
                        break;
                }  
            }
        }
        
        // bfs 사용 - 최소 이동 거리 계산
        int answer = bfs(board, start[0], start[1], rLng, cLng);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    private int bfs(String[] board, int startX, int startY, int rLng, int cLng){
        Queue<int[]> que = new LinkedList<>();  //큐 생성
        que.add(new int[]{startX, startY, 0});  //시작 위치 추가
        
        //시작 위치는 방문했다고 표시
        boolean[][] visited = new boolean[rLng][cLng];
        visited[startX][startY] = true;
        
        //while 큐가 비기까지 탐색
        while(!que.isEmpty()){
            int[] len = que.poll(); // 현재 위치 겟
            
            //if 종료 위치에 도달 했는지 여부
            if(len[0] == end[0] && len[1] == end[1]){
                return len[2];  //이동 거리 반환
            }
            
            //상하좌우 이동
            for(int i = 0; i < 4; i++){
                int nx = len[0];
                int ny = len[1];
            
                // 맵안에 있고 장애물이 없는 곳으로 이동
                while (isMap(nx + dx[i], ny + dy[i], rLng, cLng) && board[nx + dx[i]].charAt(ny + dy[i]) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                
                // if 이미 방문 했는지 || 이동이 없는 경우 
                if (visited[nx][ny] || (len[0] == nx && len[1] == ny)) continue;

                visited[nx][ny] = true;     //방문 표시
                que.add(new int[]{nx, ny, len[2] + 1});     //큐에 추가
            }
            
        }
        
        return -1;
    
    }
    
    //현재 위치가 보드 내에 존재 하는지 여부 확인
    private boolean isMap(int x, int y, int rLng, int cLng){
        return x >= 0 && y >= 0 && x < rLng && y < cLng;
    }
    
}