import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node
{
    private int name;
    private List<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;//+inf
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination, int distance)
    {
        adjacentNodes.put(destination,distance);
    }

    public Node(int name)
    {
        this.name=name;
    }

    public void setDistance(int dist)
    {
        distance=dist;
    }

    public void setShortestPath(List<Node> list)
    {
        shortestPath=list;
    }

    public Map<Node, Integer> getAdjacentNodes()
    {
        return adjacentNodes;
    }

    public Integer getDistance()
    {
        return distance;
    }

    public List<Node> getShortestPath()
    {
        return shortestPath;
    }

}


