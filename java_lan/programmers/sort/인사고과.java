import java.util.*;

class Employee implements Comparable<Employee> {
    int index;
    int s1, s2, sum;
    
    public Employee(int index, int s1, int s2) {
        this.index = index;
        this.s1 = s1;
        this.s2 = s2;
        this.sum = s1 + s2;
    }
    
    @Override
    public int compareTo(Employee o) {
        int osum = o.s1 + o.s2;
        int tsum = this.s1 + this.s2;
        return (osum == tsum) ? (this.index - o.index) : (osum - tsum);
    }
}

class Solution {
    public int solution(int[][] scores) {
        int answer = -1;
        List<Employee> list = new ArrayList<>();
        int[][] arr = new int[scores.length][3];
        
        for(int i = 0; i < scores.length; i++) {
            arr[i][0] = scores[i][0];
            arr[i][1] = scores[i][1];
            arr[i][2] = i;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
            }
        });
        int max = -1;
        for(int i = 0; i < arr.length; i++) {
            if(max <= arr[i][1]) {
                max = arr[i][1];
                list.add(new Employee(arr[i][2], arr[i][0], arr[i][1]));
            }
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).index == 0) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
}