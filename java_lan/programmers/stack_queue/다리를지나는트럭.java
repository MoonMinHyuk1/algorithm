import java.util.*;

class Solution {
    static class Car {
        int weight;
        int distance;
        
        public Car(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Car> queue = new LinkedList<>();
        
        for(int i = 0; i < truck_weights.length; i++) {
            int total = 0;
            for(Car car : queue) {
                total += car.weight;
            }
            while(!queue.isEmpty() && (total + truck_weights[i] > weight || queue.peek().distance >= bridge_length)) {
                total = 0;
                Car now = queue.poll();
                int plusDis = bridge_length - now.distance;
                for(Car car : queue) {
                    car.distance += plusDis;
                    total += car.weight;
                }
                answer += plusDis;
            }
            queue.offer(new Car(truck_weights[i], 0));
            for(Car car : queue) {
                car.distance++;
            }
            answer++;
        }
        while(!queue.isEmpty()) {
            Car now = queue.poll();
            int plusDis = bridge_length - now.distance;
            for(Car car : queue) {
                car.distance += plusDis;
            }
            answer += plusDis;
        }
        
        return answer;
    }
}