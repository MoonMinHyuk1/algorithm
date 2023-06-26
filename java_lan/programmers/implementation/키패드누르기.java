class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        //left = 1: 1, 2: 4, 3: 7, 4: *
        //center = 1: 2, 2: 5, 3: 8, 4: 0
        //right = 1: 3, 2: 6, 3: 9, 4: #
        int[] arr = {4, 1, 1, 1, 2, 2, 2, 3, 3, 3};
        
        int left = 4, right = 4;
        boolean leftHand = true, rightHand = true;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 1 ||numbers[i] == 4 ||numbers[i] == 7) {
                answer += 'L';
                left = arr[numbers[i]];
                leftHand = true;
            } else if(numbers[i] == 3 ||numbers[i] == 6 ||numbers[i] == 9) {
                answer += 'R';
                right = arr[numbers[i]];
                rightHand = true;
            } else {
                int nl = Math.abs(arr[numbers[i]] - left);
                int nr = Math.abs(arr[numbers[i]] - right);
                if(leftHand) nl++;
                if(rightHand) nr++;
                if((nl < nr) || (nl == nr && hand.equals("left"))) {
                    answer += 'L';
                    left = arr[numbers[i]];
                    leftHand = false;
                } else if((nl > nr) || (nl == nr && hand.equals("right"))) {
                    answer += 'R';
                    right = arr[numbers[i]];
                    rightHand = false;
                }
            }
        }
        
        return answer;
    }
}