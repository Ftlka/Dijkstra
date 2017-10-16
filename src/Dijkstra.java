//import java.util.*;
//
//public class Dijkstra
//{
//    private Graph graph;
//    private String initialNodeLabel;
//    private HashMap<String, String> predecessors;
//    private HashMap<String, Integer> distances;
//    private PriorityQueue<Node> availableNodes;
//    private HashSet<Node> visitedNodes;
//
//    public Dijkstra(Graph graph, String initialNodeLabel){
//        this.graph = graph;
//        Set<String> nodeKeys = this.graph.nodeKeys();
//
//        if(!nodeKeys.contains(initialNodeLabel)){
//            throw new IllegalArgumentException("The graph must contain the initial vertex.");
//        }
//
//        this.initialNodeLabel = initialNodeLabel;
//        this.predecessors = new HashMap<String, String>();
//        this.distances = new HashMap<String, Integer>();
//        this.availableNodes = new PriorityQueue<Node>(nodeKeys.size(), new Comparator<Node>(){
//
//            public int compare(Node one, Node two){
//
//                int weightOne = Dijkstra.this.distances.get(one.getLabel());
//
//                int weightTwo = Dijkstra.this.distances.get(two.getLabel());
//
//                return weightOne - weightTwo;
//            }
//        });
//
//        this.visitedNodes = new HashSet<Node>();
//        //for each Vertex in the graph
//        //assume it has distance infinity denoted by Integer.MAX_VALUE
//        for(String key: nodeKeys){
//            this.predecessors.put(key, null);
//            this.distances.put(key, Integer.MAX_VALUE);
//        }
//
//        //the distance from the initial vertex to itself is 0
//        this.distances.put(initialNodeLabel, 0);
//        //and seed initialVertex's neighbors
//        Node initialVertex = this.graph.getNode(initialNodeLabel);
//        ArrayList<Edge> initialNodeNeighbors = initialNode.getNeighbors();
//        for(Edge e : initialNodeNeighbors){
//            Node other = e.getNeighbor(initialVertex);
//            this.predecessors.put(other.getLabel(), initialNodeLabel);
//            this.distances.put(other.getLabel(), e.getWeight());
//            this.availableNodes.add(other);
//        }
//        this..visitedNodes.add(initialNode);
//        //now apply Dijkstra's algorithm to the Graph
//        processGraph();
//    }
//
//
//}