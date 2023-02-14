

class Solution {
    // Function to return Breadth First Traversal of given graph.
    ArrayList<Integer> res = new ArrayList<>();
    boolean [] vis;
    
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        vis =new boolean[V];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        vis[0]=true;
      
        
        while(!que.isEmpty()){
                int curr=que.poll();
                res.add(curr);
                for(int v:adj.get(curr)){
                    if(!vis[v]){
                        vis[v]=true;
                        que.add(v);
                        
                    }
                }
            
        }
        return res;
    }
}
