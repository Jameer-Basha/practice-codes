/*

There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.


*/

class Solution {
    int timer =0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> AdjList = new ArrayList<>();
        for (int i=0;i<n;i++){
            AdjList.add(new ArrayList<>());
        }
        for(List<Integer> pair: connections){
            int a=pair.get(0);
            int b=pair.get(1);
            AdjList.get(a).add(b);
            AdjList.get(b).add(a);
        }
        boolean[] visited =new boolean[n];
        int[] discover =new int[n];
        int[] low =new int[n];
        dfs(0,-1,visited,discover,low,AdjList,result);
        return result;
    }
    public void dfs(int u, int parent ,boolean[] visited, int[] discover , int[] low,List<List<Integer>> AdjList, List<List<Integer>> result ){
        discover[u]= low[u]=timer;
        timer++;
        visited[u] = true;
        for(int v : AdjList.get(u)){
            if(v== parent)
                continue;
            if(!visited[v]){
                dfs(v,u, visited, discover,low,AdjList,result);
                low[u]= Math.min(low[u],low[v]);
                if(low[v]>discover[u]){
                    List<Integer> res = new ArrayList<Integer>();
                    res.add(u);
                    res.add(v);
                    result.add(res);
                }
            }
            else{
            low[u]=Math.min(low[u] , low[v]);
            }
        }
    }
}
