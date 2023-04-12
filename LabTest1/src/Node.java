public class Node<E> {

    private E value;
    private String edgeName1;
    private String edgeName2;
    private Node<E> edgeNode1;
    private Node<E> edgeNode2;


    public Node(E value) {
        this.value = value;
    }

    public void setEdge1(String edgeName, Node<E> node) {
        this.edgeName1 = edgeName;
        this.edgeNode1 = node;
    }

    public void setEdge2(String edgeName, Node<E> node) {
        this.edgeName2 = edgeName;
        this.edgeNode2 = node;
    }

    public E getValue() {
        return this.value;
    }

    public void printEdgesAndNodes() {
        System.out.println("-------------------------------------");
        System.out.println(this.value.toString());
        if (!this.edgeName1.isEmpty()) {
            System.out.println(" :" + this.edgeName1 + "->");
            System.out.println("   " + this.edgeNode1.getValue().toString());
        }
        if (!this.edgeName2.isEmpty()) {
            System.out.println(" :" + this.edgeName2 + "->");
            System.out.println("   " + this.edgeNode2.getValue().toString());
        }
        System.out.println("-------------------------------------");
    }

    public Node<E> traverse(String edgeName) {
        if (edgeName.equals(this.edgeName1)) {
            return this.edgeNode1;
        } else if (edgeName.equals(this.edgeName2)) {
            return this.edgeNode2;
        } else {
            return null;
        }
    }
}
