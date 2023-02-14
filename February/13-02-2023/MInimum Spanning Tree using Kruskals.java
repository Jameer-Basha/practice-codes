import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class DisjointSet {
    int[] rank;
    int[] parent;
    public DisjointSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            rank[i]=0;
            parent[i]=i;
        }
    }
    public int find(int node){
        if(node==parent[node])
            return node;
        return parent[node]= find(parent[node]);
    }
    public void union(int u, int v){
        int x =find(u);
        int y = find(v);
        if(x==y)
            return;
        int xRank = rank[x];
        int yRank = rank[y];
        if(xRank>yRank){
            parent[y]=x;
        }
        else if(yRank>xRank)
            parent[x]=y;
        else{
            parent[x]=y;
            yRank++;
        }
    }
}

class Edge implements Comparable<Edge>{
    int src, des,weight;
    public Edge(int _src,int _des, int _wt){
        this.src= _src;
        this.des =_des;
        this.weight =_wt ;
       
    }
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Result {
    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        List<Edge> edges = new ArrayList<Edge>();
    for (int i = 0; i < gFrom.size(); i++) {
                int adjNode = gTo.get(i);
                int wt = gWeight.get(i);
                int node = gFrom.get(i);
                Edge temp = new Edge(node, adjNode, wt);
                //System.out.println(temp);
                edges.add(temp);
            }
        Collections.sort(edges);
       /* for(int i=0;i<gNodes;i++){
           
              System.out.println(edges.get(i).weight+" "+edges.get(i).src+" "+edges.get(i).des);
               
            }
        */
        DisjointSet ds  = new DisjointSet(gNodes);
        int mstWt =0;
        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).des;
            if (ds.find(u) != ds.find(v)) {
                mstWt += wt;
                ds.union(u, v);
            }
            //System.out.println(mstWt);
        }
        return mstWt;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here.
        bufferedWriter.write(String.valueOf(res));
bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
