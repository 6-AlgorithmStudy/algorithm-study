package 그래프;
import java.util.*;

class Solution {
    
    static int max; // 지금까지 나온 최대값(1에서부터 제일 많은 노드를 거친 노드) 저장 
    static int result; // 결과 
    static int[] count; // 방문처리(방문 안했으면 0) 겸 1에서부터 몇 개의 노드를 거쳤는지 저장
    static boolean[][] graph; // 그래프
    static Queue<Node> queue; // 노드 방문할 때 쓸 큐
    
    public int solution(int n, int[][] edge) {
        
        max=0;
        result=0;
        queue=new LinkedList<Node>();
        count=new int[n+1];
        graph=new boolean[n+1][n+1];
        
        for(int i=0; i<edge.length; i++){
            graph[edge[i][0]][edge[i][1]]=true;
            graph[edge[i][1]][edge[i][0]]=true;
        }
        
        queue.offer(new Node(1,1)); // 1번 노드 큐에 넣음
        count[1]=1; // 1번 노드가 첫번째로 방문했다고 방문처리 해주기
        
        while(!queue.isEmpty()){
            Node now=queue.poll(); // 큐에서 빼주기 
            
            for(int i=1; i<n+1; i++){
                if(graph[now.num][i] && count[i]==0){
                    // now.num번과 연결되었으며, 아직 방문되지 않은 노드가 있다면
                    queue.offer(new Node(now.step+1, i)); // 큐에 넣어준다
                    count[i]=now.step+1; // now 다음에 들어갔으므로 now.step에 1 더해주기
                }
            }
            
            if(max<now.step) {
                max=now.step; // 지금까지 중 제일 큰 step 수 저장
            }
        }
        
        for(int i=1; i<n+1; i++){
            if(count[i]==max) result++;
        }
        
        return result;
    }
    
    static class Node {
        int step;
        int num;
        
        public Node(int step, int num){
            this.step=step;
            this.num=num;
        }
    }
}