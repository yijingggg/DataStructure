import java.util.ArrayList;

class TestGraph {
    public static void main(String[] args) {
        Graph<String> graph1 = new Graph<String>();
        String[] cities = {"Alor Setar", "Kuching", "Langkawi", "Melaka", "Penang", "Tawau"};
        for (String i : cities)
            graph1.addVertex(i);

        System.out.println("The number of vertices in graph1: " + graph1.getSize());

        System.out.println("Cities and their vertices ");
        for (int i = 0; i<=graph1.getSize()-1; i++)
            System.out.print( i + ": " + graph1.getVertex(i) + "\t");
        System.out.println();

        System.out.println("Is Melaka in the Graph? " + graph1.hasVertex("Melaka"));
        System.out.println("Is Ipoh in the Graph? " + graph1.hasVertex("Ipoh"));
        System.out.println();

        System.out.println("Kuching at index:  " + graph1.getIndex("Kuching"));
        System.out.println("Ipoh at index:  " + graph1.getIndex("Ipoh"));
        System.out.println();

        System.out.println("add edge Kuching - Melaka: " + graph1.addEdge("Kuching", "Melaka") );
        System.out.println("add edge Langkawi - Penang : " + graph1.addEdge("Langkawi", "Penang") );
        System.out.println("add edge Melaka - Penang : " + graph1.addEdge("Melaka", "Penang") );
        System.out.println("add edge Alor Setar - Kuching : " + graph1.addEdge("Alor Setar", "Kuching") );
        System.out.println("add edge Tawau - Alor Setar : " + graph1.addEdge("Tawau", "Alor Setar") );
        System.out.println("add edge Kuching - Tawau : " + graph1.addEdge("Kuching", "Tawau") );
        System.out.println("add edge Langkawi - Ipoh : " + graph1.addEdge("Langkawi", "Ipoh") );
        System.out.println();

        System.out.println("has edge from Kuching to Melaka?  " + graph1.hasEdge("Kuching", "Melaka") );
        System.out.println("has edge from Melaka to Langkawi?  " + graph1.hasEdge("Melaka", "Kuching") );
        System.out.println("has edge from Ipoh to Langkawi?  " + graph1.hasEdge("Ipoh", "Langkawi") );
        System.out.println();

        System.out.println("In and out degree for Kuching is " + graph1.getIndeg("Kuching") + " and " + graph1.getOutdeg("Kuching") );
        System.out.println("In and out degree for Penang is " + graph1.getIndeg("Penang") + " and " + graph1.getOutdeg("Penang") );
        System.out.println("In and out degree for Ipoh is " + graph1.getIndeg("Ipoh") + " and " + graph1.getOutdeg("Ipoh") );
        System.out.println();

        System.out.println("Neighbours of Kuching : " + graph1.getNeighbours("Kuching"));
        System.out.println("remove edge: " + graph1.removeEdge("Kuching", "Melaka"));
        System.out.println("\nPrint Edges : " );
        graph1.printEdges();

    }
}

public class Graph<T extends Comparable<T>> {
    Vertex<T, Integer> head;
    int size;

    public Graph()	{
        head=null;
        size=0;
    }

    public void clear() {
        head=null;
    }

    public int getSize()   {
        return this.size;
    }

    public int getIndeg(T v)  {
        if (hasVertex(v)==true)	{
            Vertex<T,Integer> temp = head;
            while (temp!=null) {
                if ( temp.vertexInfo.compareTo( v ) == 0 )
                    return temp.indeg;
                temp=temp.nextVertex;
            }
        }
        return -1;
    }

    public int getOutdeg(T v)  {
        if (hasVertex(v)==true)	{
            Vertex<T,Integer> temp = head;
            while (temp!=null) {
                if ( temp.vertexInfo.compareTo( v ) == 0 )
                    return temp.outdeg;
                temp=temp.nextVertex;
            }
        }
        return -1;
    }

    public boolean hasVertex(T v)	{
        if (head==null)
            return false;
        Vertex<T,Integer> temp = head;
        while (temp!=null)	{
            if ( temp.vertexInfo.compareTo( v ) == 0 )
                return true;
            temp=temp.nextVertex;
        }
        return false;
    }

    public boolean addVertex(T v)	{
        if (hasVertex(v)==false)	{
            Vertex<T,Integer> temp=head;
            Vertex<T,Integer> newVertex = new Vertex<>(v, null);
            if (head==null)
                head=newVertex;
            else {
                Vertex<T,Integer> previous=head;;
                while (temp!=null)  {
                    previous=temp;
                    temp=temp.nextVertex;
                }
                previous.nextVertex=newVertex;
            }
            size++;
            return true;
        }
        else
            return false;
    }

    public int getIndex(T v) {
        Vertex<T,Integer> temp = head;
        int pos=0;
        while (temp!=null)	{
            if ( temp.vertexInfo.compareTo( v ) == 0 )
                return pos;
            temp=temp.nextVertex;
            pos+=1;
        }
        return -1;
    }

    public ArrayList<T> getAllVertexObjects() {
        ArrayList<T> list = new ArrayList<>();
        Vertex<T,Integer> temp = head;
        while (temp!=null)	{
            list.add(temp.vertexInfo);
            temp=temp.nextVertex;
        }
        return list;
    }

    public ArrayList<Vertex<T,Integer>> getAllVertices() {
        ArrayList<Vertex<T,Integer>> list = new ArrayList<>();
        Vertex<T,Integer> temp = head;
        while (temp!=null)	{
            list.add(temp);
            temp=temp.nextVertex;
        }
        return list;
    }

    public T getVertex(int pos) {
        if (pos>size-1 || pos<0)
            return null;
        Vertex<T,Integer> temp = head;
        for (int i=0; i<pos; i++)
            temp=temp.nextVertex;
        return temp.vertexInfo;
    }

    public boolean addEdge(T source, T destination)   {
        if (head==null)
            return false;
        if (!hasVertex(source) || !hasVertex(destination))
            return false;
        Vertex<T,Integer> sourceVertex = head;
        while (sourceVertex!=null)	{
            if ( sourceVertex.vertexInfo.compareTo( source ) == 0 )   {
                // Reached source vertex, look for destination now
                Vertex<T,Integer> destinationVertex = head;
                while (destinationVertex!=null)	{
                    if ( destinationVertex.vertexInfo.compareTo( destination ) == 0 )   {
                        // Reached destination vertex, add edge here
                        Edge<T,Integer> currentEdge = sourceVertex.firstEdge;
                        Edge<T,Integer> newEdge = new Edge<>(destinationVertex, currentEdge);
                        sourceVertex.firstEdge=newEdge;
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;
                        return true;
                    }
                    destinationVertex=destinationVertex.nextVertex;
                }
            }
            sourceVertex=sourceVertex.nextVertex;
        }
        return false;
    }

    public boolean hasEdge(T source, T destination) {
        if (head==null)
            return false;
        if (!hasVertex(source) || !hasVertex(destination))
            return false;
        Vertex<T,Integer> sourceVertex = head;
        while (sourceVertex!=null)	{
            if ( sourceVertex.vertexInfo.compareTo( source ) == 0 )   {
                // Reached source vertex, look for destination now
                Edge<T,Integer> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination)==0)
                        // destination vertex found
                        return true;
                    currentEdge=currentEdge.nextEdge;
                }
            }
            sourceVertex=sourceVertex.nextVertex;
        }
        return false;
    }

    public ArrayList<T> getNeighbours (T v)  {
        if (!hasVertex(v))
            return null;
        ArrayList<T> list = new ArrayList<T>();
        Vertex<T,Integer> temp = head;
        while (temp!=null)	{
            if ( temp.vertexInfo.compareTo( v ) == 0 )   {
                // Reached vertex, look for destination now
                Edge<T,Integer> currentEdge = temp.firstEdge;
                while (currentEdge != null) {
                    list.add(currentEdge.toVertex.vertexInfo);
                    currentEdge=currentEdge.nextEdge;
                }
            }
            temp=temp.nextVertex;
        }
        return list;
    }

    public void printEdges()   {
        Vertex<T,Integer> temp=head;
        while (temp!=null) {
            System.out.print("# " + temp.vertexInfo + " : " );
            Edge<T,Integer> currentEdge = temp.firstEdge;
            while (currentEdge != null) {
                System.out.print("[" + temp.vertexInfo + "," + currentEdge.toVertex.vertexInfo +"] " );
                currentEdge=currentEdge.nextEdge;
            }
            System.out.println();
            temp=temp.nextVertex;
        }
    }

    // LAB SESSION ANS

    public boolean addUndirectedEdge (T source, T destination)   {
        if (head==null)
            return false;
        if (!hasVertex(source) || !hasVertex(destination))
            return false;
        Vertex<T,Integer> sourceVertex = head;
        while (sourceVertex!=null)	{
            if ( sourceVertex.vertexInfo.compareTo( source ) == 0 )   {
                // Reached source vertex, look for destination now
                Vertex<T,Integer> destinationVertex = head;
                while (destinationVertex!=null)	{
                    if ( destinationVertex.vertexInfo.compareTo( destination ) == 0 )   {
                        // Reached destination vertex, add edge here
                        Edge<T,Integer> currentEdge = sourceVertex.firstEdge;
                        Edge<T,Integer> newEdge = new Edge<>(destinationVertex, currentEdge);
                        sourceVertex.firstEdge=newEdge;
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;

                        // Add reverse edge
                        Edge<T,Integer> currentEdge2 = destinationVertex.firstEdge;
                        Edge<T,Integer> newEdge2 = new Edge<>(sourceVertex, currentEdge2);
                        destinationVertex.firstEdge=newEdge2;
                        destinationVertex.outdeg++;
                        sourceVertex.indeg++;

                        return true;
                    }
                    destinationVertex=destinationVertex.nextVertex;
                }
            }
            sourceVertex=sourceVertex.nextVertex;
        }
        return false;
    }

    public boolean removeEdge(T source, T destination) {
        if (head==null)
            return false;
        if (!hasVertex(source) || !hasVertex(destination))
            return false;
        Vertex<T,Integer> sourceVertex = head;
        while (sourceVertex!=null)	{
            if ( sourceVertex.vertexInfo.compareTo( source ) == 0 )   {
                // Reached source vertex, look for destination now
                Edge<T,Integer> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null) {
                    // if next edge is null, not found
                    if(currentEdge.nextEdge == null)
                        return false;
                    // if next edge vertex info is destination
                    if(currentEdge.nextEdge.toVertex.vertexInfo.compareTo(destination)==0){
                        // remove the edge using next next edge
                        currentEdge.nextEdge = currentEdge.nextEdge.nextEdge;
                        return true;
                    }
                    currentEdge=currentEdge.nextEdge;
                }
            }
            sourceVertex=sourceVertex.nextVertex;
        }
        return false;
    }
}

