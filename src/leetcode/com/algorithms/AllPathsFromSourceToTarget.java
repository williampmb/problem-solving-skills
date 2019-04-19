package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args){
        int[][] graph = {{1,2},{3},{3},{}};
        List<List<Integer>> allPathsSourceTarget = allPathsSourceTarget(graph);

        for(List<Integer> l : allPathsSourceTarget){
            for(Integer i : l){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer,List<List<Integer>>> memo = new HashMap<>();
        allPaths(graph,memo,0);
        List<List<Integer>> list = memo.get(0);
        for(int i = list.size()-1 ; i >= 0; i--){
            if(list.get(i).get(list.get(i).size()-1)!=graph.length-1){
                list.remove(i);
            }
        }
        return list;
    }

    private static void allPaths(int[][] graph, Map<Integer, List<List<Integer>>> memo, int node) {
        
        List<List<Integer>> curPaths = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
        if(graph[node].length ==0 || graph.length-1 == node) {
            cur.add(node);
            curPaths.add(cur);
            memo.put(node,curPaths);
        }else{
            for(int col = 0; col < graph[node].length; col++){
                if(!memo.containsKey(graph[node][col])){ //memoization
                    allPaths(graph,memo,graph[node][col]); //since it is not cyclic, it won't have stack overflow.
                }
                List<List<Integer>> paths = memo.get(graph[node][col]);
                curPaths = memo.getOrDefault(node, new ArrayList<>());
                for(List<Integer> p : paths){
                    List<Integer> path = new ArrayList<>();
                    path.add(node);
                    path.addAll(p);
                    curPaths.add(path);
                }
                memo.put(node,curPaths);
            }
        }
    }

    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, 0, graph.length - 1, new ArrayList<Integer>(), graph);
        return res;
    }
    public void backTracking(List<List<Integer>> res, int curPos, int endPos, List<Integer> curList, int[][] graph) {
        curList.add(curPos);
        if (curPos == endPos) {
            res.add(new ArrayList<Integer>(curList));
            return;
        }
        for (int n : graph[curPos]) {
            backTracking(res, n, endPos, curList, graph);
            curList.remove(curList.size() - 1);
        }
        
    }
}