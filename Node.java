package akinator;

import java.io.Serializable;

public class Node implements Serializable{
    
    private Node lSon;
    private Node rSon;
    private Node father;
    private String data;
    private final NodeType type;

    public Node(NodeType type) {
        lSon = null;
        rSon = null;
        father = null;
        data = null;
        this.type = type;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public Node getlSon() {
        return lSon;
    }

    public void setlSon(Node lSon) {
        this.lSon = lSon;
    }

    public Node getrSon() {
        return rSon;
    }

    public void setrSon(Node rSon) {
        this.rSon = rSon;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public NodeType getType() {
        return type;
    }
    
}
