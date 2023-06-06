package Programa;
import ArvoreAVL.Tree;
import java.io.*;
import java.util.Scanner;
import java.util.Timer;

public class Main {

    public static void delay(long milliSecs){
        Timer timer = new Timer();
        try {
            timer.wait(milliSecs);
        }
        catch (InterruptedException e){
            return;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int controle = 1;
        while(controle == 1) {
            System.out.println("Qual arquivo deseja abrir?");
            String nomeArquivo = sc.next();
            File file = new File(System.getProperty("user.dir") + "\\Arquivo\\" + nomeArquivo + ".txt");
            Tree tree = new Tree();
            try {
                if (!file.createNewFile()) {
                    Scanner reader = new Scanner(file);
                    while (reader.hasNextLine()){
                        tree.add(reader.nextLine());
                    }
                    System.out.println(tree.getHashCode());
                    System.out.println("Deseja abrir outro arquivo? 1-Sim 2-Não");
                    controle = Integer.parseInt(sc.next());
                } else {
                    System.out.println("Arquivo não existe");
                    System.out.println("Criando arquivo...");
                }
            } catch (IOException e) {
                System.out.println("deu ruim");
                break;
            }
        }
    }
}
