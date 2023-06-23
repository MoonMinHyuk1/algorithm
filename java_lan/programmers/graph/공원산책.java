class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] graph = new int[park.length][park[0].length()];
        int[] now = new int[2];
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    graph[i][j] = 0;
                    now[0] = i;
                    now[1] = j;
                } else if(park[i].charAt(j) == 'O') {
                    graph[i][j] = 0;
                } else { //X
                    graph[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            int index = 0;
            int step = Integer.parseInt(route[1]);
            if(route[0].equals("N")) index = 0;
            if(route[0].equals("S")) index = 1;
            if(route[0].equals("W")) index = 2;
            if(route[0].equals("E")) index = 3;
            
            int nx = now[0];
            int ny = now[1];
            boolean flag = false;
            for(int j = 0; j < step; j++) {
                nx += dx[index];
                ny += dy[index];
                if(0 <= nx && nx < park.length && 0 <= ny && ny < park[0].length() && graph[nx][ny] == 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                now[0] = nx;
                now[1] = ny;
            }
        }
        answer[0] = now[0];
        answer[1] = now[1];
        
        return answer;
    }
}