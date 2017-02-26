package hackerrank.graphtheory;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class BreathFirstSearchShortest {

    public static void main(String[] args) throws IOException {
        int weight = 6;
        //Scanner s = new Scanner(new FileReader("src/input.txt"));
        Scanner s = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int queries = s.nextInt();
        while (queries != 0) {
            int qtNodes = s.nextInt();
            Graph g = new Graph();
            int count = 0;
            while (count  != qtNodes) {
                Node newOne = new Node(count+1);
                g.nodes.add(newOne);
                count++;
            }
            int qtEdges = s.nextInt();
            while (qtEdges != 0) {
                int from = s.nextInt();
                int to = s.nextInt();
                Node fromNode = g.getByIndex(from-1);
                Node toNode = g.getByIndex(to-1);
                fromNode.adjacents.add(toNode);
                toNode.adjacents.add(fromNode);
                qtEdges--;
            }
            int start = s.nextInt();
            String distances = executeQuery(start, g, weight);
            bw.write(distances);
            queries--;
        }
        bw.flush();
    }

    private static String executeQuery(int start, Graph g, int weight) {
        int[] aux = new int[g.nodes.size()];
        Queue<Node> q = new LinkedList();
        q.add(g.getANode(start));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int depth = aux[cur.value - 1];
            for (Node adj : cur.adjacents) {
                if (!adj.visited) {
                    q.add(adj);
                    aux[adj.value - 1] = depth + 1;
                    adj.visited = true;
                }
            }
        }
        return printDistances(aux, start, weight);
    }

    private static String printDistances(int[] aux, int start, int weight) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aux.length; i++) {
            if (i + 1 != start && aux[i] == 0) {
                sb.append("-1");
                if (i == aux.length - 1) {
                    sb.append("\n");
                } else {
                    sb.append(" ");
                }
            } else if (i + 1 != start) {
                sb.append(aux[i] * weight);
                if (i == aux.length - 1) {
                    sb.append("\n");
                } else {
                    sb.append(" ");
                }
            }

        }
        return sb.toString();

    }

    private static class Node {

        private int value;
        List<Node> adjacents;
        private boolean visited;

        public Node(int qtNodes) {
            this.value = qtNodes;
            this.adjacents = new ArrayList<>();
            this.visited = false;
        }
    }

    private static class Graph {

        List<Node> nodes;

        private Graph() {
            nodes = new ArrayList<>();
        }

        public Node getANode(int value) {
            for (Node n : nodes) {
                if(n.value == value){
                    return n;
                }
            }
            return null;
        }
        
        public Node getByIndex(int index){
            return nodes.get(index);
        }
    }
}
