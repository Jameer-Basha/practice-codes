

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    ArrayList<Integer> res = new ArrayList<>();
    boolean[] visited;
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        visited = new boolean[V];
        dfs(0,adj);
        return res;
    }
    public void dfs(int source, ArrayList<ArrayList<Integer>> adj ){
        visited[source]=true;
        res.add(source);
        for(int v: adj.get(source)){
            if(!visited[v]){
                dfs(v,adj);
            }
        }
    }
}
