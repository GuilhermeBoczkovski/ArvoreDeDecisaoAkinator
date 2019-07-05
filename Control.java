package akinator;

public class Control {
    
    private final Screen screen;
    private NodeControl nControl;
    private String aux;
    private Node actualNode;
    private static Control instance;
    private Mapper map;
    
    public static Control getInstance(){
        if(instance == null){
            instance = new Control();
        }
        return instance;
    }
    
    
    private Control() {
        this.screen = new Screen(this);
        this.nControl = new NodeControl(this);
        this.aux = null;
        this.actualNode = null;
        this.map = new Mapper();
        this.screen.showMainMenu();
    }
    
    public void start(){
        actualNode = this.nControl.getRoot();
        this.screen.showQuestion(actualNode.getData());
    }
    
    public void startSavedGame(int i) {
        this.map.load();
        this.nControl = this.map.get(i);
        this.start();
    }
    
    public void answerMainMenu(int scan){
        if(scan==1){
            this.start();
        }else if(scan==2){
            this.screen.showSavedGames(this.map.getList());
        }else{
            System.err.print("Valor inválido"); //corrigir - lançar exceção
        }
    }

    public void answerQuestion(String scan) {
        if(scan.equalsIgnoreCase("S")){
            this.actualNode = this.actualNode.getrSon();
        }else if(scan.equalsIgnoreCase("N")){
            this.actualNode = this.actualNode.getlSon();
        }else{
            System.err.print("Valor inválido"); //corrigir - lançar exceção
        }
        if(this.actualNode.getType().equals(NodeType.QUESTION)){
            this.screen.showQuestion(this.actualNode.getData());
        }else if(this.actualNode.getType().equals(NodeType.CHARACTER)){
            this.screen.showCharacter(this.actualNode.getData());
        }
    }

    public void answerCharacter(String scan) {
        if(scan.equalsIgnoreCase("S")){
            this.screen.showCorrectAnswer();
        }else if(scan.equalsIgnoreCase("N")){
                this.screen.showIncorrectAnswer();
        }else{
            System.err.print("Valor inválido"); //corrigir - lançar exceção
        }
    }

    public void addNewCharacter(String newCharacter) {
        this.aux = newCharacter;
        screen.showAddNewQuestion(actualNode.getData());
    }

    public void addNewQuestion(String scan) {        
        this.nControl.add(actualNode, aux, scan);
        this.start();
    }

    public void answerContinue(String scan) {
        if(scan.equalsIgnoreCase("S")){
            this.start();
        }else if(scan.equalsIgnoreCase("N")){
            screen.showSaveGameQuestion();
        }else{
            System.err.print("Valor inválido"); //corrigir - lançar exceção
        }
    }

    public void answerSaveGameQuestion(String scan) {
        if(scan.equalsIgnoreCase("S")){
            this.screen.showSaveGame();
        }else if(scan.equalsIgnoreCase("N")){
            screen.showEnd();
        }else{
            System.err.print("Valor inválido"); //corrigir - lançar exceção
        }
    }

    public void answerSaveGame(String scan) {
        this.map.load();
        this.nControl.setId(scan);
        this.map.put(this.nControl);
        this.map.persist();
        this.screen.showMainMenu();
    }
    
}
