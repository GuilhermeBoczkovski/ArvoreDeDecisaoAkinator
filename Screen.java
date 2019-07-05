package akinator;
import java.util.ArrayList;
import java.util.Scanner;

public class Screen {
    
    private Scanner scan;
    private Control control;

    public Screen(Control control) {
        this.control = control;
        this.scan = new Scanner(System.in);
    }
    
    public void showSavedGames(ArrayList<NodeControl> trees){
        System.out.println("Escolha o jogo que deseja carregar: ");
        int i = 0;
        for(NodeControl tree : trees){
            System.out.println("Jogo [" + i + "]: " + tree.getId());
            i++;
        }
        int s = scan.nextInt();
        scan.nextLine();
        control.startSavedGame(s);
    }
    
    public void showQuestion(String data){
        System.out.println("O seu personagem " + data + "? [S/N]");
        String s = scan.next();
        scan.nextLine();
        control.answerQuestion(s);
    }
    
    public void showCharacter(String data){
        System.out.println("Seu personagem é o(a) " + data + "? [S/N]");
        String s = scan.next();
        scan.nextLine();
        control.answerCharacter(s);
    }
    
    public void showIncorrectAnswer(){
        System.out.println("Que pena. Parece que não tenho este personagem em meu banco de dados.");
        this.showAddNewCharacter();
    }
    
    public void showAddNewCharacter(){
        System.out.println("Qual o seu personagem?");
        control.addNewCharacter(scan.nextLine());
    }
    
    public void showAddNewQuestion(String data){
        System.out.println("Adicione uma caracterisca que diferencie seu personagem do " + data + " (ex: é superforte, é rico...)");
        control.addNewQuestion(scan.nextLine());
    }
    
    public void showCorrectAnswer(){
        System.out.println("UHUUUUULLL!!! ACERTEEEEIIII!!!");
        this.showContinue();
    }
    
    public void showContinue(){
        System.out.println("Deseja continuar? [S/N]");
        control.answerContinue(scan.next());
    }
    
    public void showEnd(){
        System.out.println("Espero que tenha gostado do jogo!");
    }

    public void showSaveGameQuestion(){
        System.out.println("Deseja salvar o seu preogresso? [S/N]");
        String s = scan.next();
        scan.nextLine();
        control.answerSaveGameQuestion(s);
    }
    
    public void showSaveGame() {
        System.out.println("Dê um nome à sua criação:");
        String s = scan.next();
        scan.nextLine();
        control.answerSaveGame(s);
    }

    void showMainMenu() {
        System.out.println("Bem vindo ao Programa de Seleção de SuperHumanos");
        System.out.println("Deseja iciciar um novo programa ou carregar um existente?");
        System.out.println("[1] Iniciar novo programa");
        System.out.println("[2] Carregar programa existente");
        int s = scan.nextInt();
        scan.nextLine();
        control.answerMainMenu(s);
    }

}