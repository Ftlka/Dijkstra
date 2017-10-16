import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MainApp
{
    //TODO: we have to sets[set is a collection that doesn't allow duplicates]. In the first-unsettled-
    //TODO: are nodes that we need to calculate our paths from. In the second-settled: nodes that we already calculated.
    //TODO: we add our very first node first to unsettled and calculate distances to its adjacent. Then we add
    //TODO: adjacent to unsettled and first node to settled.
    //TODO: first we get nearest node with the minimum distance to it
    //TODO: then we remove our current node[with the min dist] from the list
    //TODO: we get all of the neighbors of this deleted node
    public static void main(String[] args) throws IOException
    {
        getGraphFromfile();
    }

    public static Graph getGraphFromfile() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("/home/ftlka/Documents/Dijkstra/src/in.txt"));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null)
        {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }

        String[] arrayOfLines = sb.toString().split("\\n");
        for (int i=1; i<arrayOfLines.length-2; i++)
        {
            Node node = new Node(i);
        }


        return null;

    }

    public static Graph calculateShortesPath(Graph graph, Node start)
    {
        start.setDistance(0);

        Set<Node> visitedNodes = new HashSet<>();
        Set<Node> unvisitedNodes = new HashSet<>();

        unvisitedNodes.add(start);

        while (unvisitedNodes.size() != 0)
        {
            //TODO: до этого момента всё норм вроде
            Node currentNode = getLowestDistanceNode(unvisitedNodes);//тут типа исходную и получим, ок
            unvisitedNodes.remove(currentNode);//удаляем первую
            //now we get all adjacent of this node and calculate all distances to them
            for (Map.Entry< Node, Integer> adjacencyPair:
                    currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!visitedNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unvisitedNodes.add(adjacentNode);
                }
            }
            visitedNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode,
                                                 Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

}
