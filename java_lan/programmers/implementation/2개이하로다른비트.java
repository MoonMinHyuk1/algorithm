class Solution {
    
    public long bit(long n) {
        if(n % 2 == 0) return n + 1;
        
        long num = n;
        String binary = Long.toBinaryString(n);
        char[] arr = binary.toCharArray();
        boolean flag = true;
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == '0') {
                flag = false;
                break;
            }
        }
        if(flag) {
            StringBuilder sb = new StringBuilder();
            sb.append("10");
            for(int i = 1; i < arr.length; i++) {
                sb.append("1");
            }
            num = Long.parseLong(sb.toString(), 2);
        } else {
            int index = 0;
            for(int i = arr.length - 1; i >= 0; i--) {
                if(arr[i] == '0') {
                    arr[i] = '1';
                    index = i;
                    break;
                }
            }
            for(int i = index + 1; i < arr.length; i++) {
                if(arr[i] == '1') {
                    arr[i] = '0';
                    break;
                }
            }
            num = Long.parseLong(String.valueOf(arr), 2);
        }
        
        return num;
    }
    
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            answer[i] = bit(numbers[i]);
        }
        
        return answer;
    }
}