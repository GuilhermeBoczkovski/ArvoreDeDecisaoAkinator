package akinator;

import java.io.Serializable;

public class NodeControl implements Serializable{
    
    private String id;
    private final Control control;
    private final Node root;

    public NodeControl(Control control) {
        this.control = control;
        this.root = new Node(NodeType.QUESTION);
        this.root.setData("é rico");
        
        Node lSon = new Node(NodeType.CHARACTER);
        lSon.setData("Homem-Aranha");
        lSon.setFather(root);
        this.root.setlSon(lSon);
        
        Node rSon = new Node(NodeType.CHARACTER);
        rSon.setData("Batman");
        rSon.setFather(root);
        this.root.setrSon(rSon);
        
        id = "Standart"; // CORRIGIIIIIIIIIIIIRRRRRRRRRR
    }
    
    public void add(Node nOldCharacter, String newCharacter, String question){
        Node nQuestion = new Node(NodeType.QUESTION);
        nQuestion.setData(question);
        
        Node nNewCharacter = new Node(NodeType.CHARACTER);
        nNewCharacter.setData(newCharacter);
        nNewCharacter.setFather(nQuestion);
        
        if(nOldCharacter.getFather().getlSon().getData().equals(nOldCharacter.getData())){
            nOldCharacter.getFather().setlSon(nQuestion);
        }else if(nOldCharacter.getFather().getrSon().getData().equals(nOldCharacter.getData())){
            nOldCharacter.getFather().setrSon(nQuestion);
        }
        
        nOldCharacter.setFather(nQuestion);
        
        nQuestion.setlSon(nOldCharacter);
        nQuestion.setrSon(nNewCharacter);
        
    }

    public Node getRoot() {
        return root;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
}