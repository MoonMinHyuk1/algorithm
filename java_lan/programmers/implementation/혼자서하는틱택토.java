class Solution {
    
    public int sequence(String[] board) {
        int o = 0, x = 0;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                if(board[i].charAt(j) == 'O') o++;
                if(board[i].charAt(j) == 'X') x++;
            }
        }
        
        return (o - x == 0 || o - x == 1) ? 1 : 0;
    }
    
    public int end(String[] board) {
        int o = 0, x = 0;
        int o1 = 0, o2 = 0, o3 = 0, x1 = 0, x2 = 0, x3 = 0;
        int ocnt = 0, xcnt = 0;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                if(board[i].charAt(j) == 'O') ocnt++;
                if(board[i].charAt(j) == 'X') xcnt++;
            }
        }
        //가로
        for(int i = 0; i < board.length; i++) {
            boolean flag = true;
            char c = board[i].charAt(0);
            for(int j = 1; j < board[i].length(); j++) {
                if(c != board[i].charAt(j)) flag = false;
            }
            if(flag && c == 'O') o1++;
            if(flag && c == 'X') x1++;
        }
        o += o1; x += x1;
        if(o1 >= 2 || x1 >= 2 || (o >= 1 && x >= 1)) {
            return 0;
        }
        //세로
        for(int i = 0; i < board[0].length(); i++) {
            boolean flag = true;
            char c = board[0].charAt(i);
            for(int j = 1; j < board.length; j++) {
                if(c != board[j].charAt(i)) flag = false;
            }
            if(flag && c == 'O') o2++;
            if(flag && c == 'X') x2++;
        }
        o += o2; x += x2;
        if((o2 >= 2 || x2 >= 2) || (o >= 1 && x >= 1)) {
            return 0;
        }
        //대각선
        if(board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
            if(board[0].charAt(0) == 'O') o3++;
            if(board[0].charAt(0) == 'X') x3++;
        }
        if(board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)) {
            if(board[0].charAt(2) == 'O') o3++;
            if(board[0].charAt(2) == 'X') x3++;
        }
        o += o3; x += x3;
        if((o >= 3 || x >= 3) && (o >= 1 && x >= 1)) {
            return 0;
        }
        if((o == 1 && x == 0) && (ocnt - 1 != xcnt)) {
            return 0;
        }
        if((o == 0 && x == 1) && (ocnt != xcnt)) {
            return 0;
        }
        
        return 1;
    }
    
    public int solution(String[] board) {
        int answer = -1;
        
        answer = sequence(board);
        if(answer == 1) answer = end(board);
        
        return answer;
    }
}