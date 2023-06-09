package Programa;
import ArvoreAVL.Tree;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int controle = 1;
        while(controle == 1) {
            Tree tree = new Tree();
            System.out.println("Qual o primeiro arquivo que deseja abrir?");
            String nomeArquivo = sc.next();
            File original = new File(System.getProperty("user.dir") + "/Arquivo/" + nomeArquivo + ".txt");
            System.out.println("Qual o segundo arquivo que deseja abrir?");
            nomeArquivo = sc.next();
            File testCase = new File(System.getProperty("user.dir") + "/Arquivo/" + nomeArquivo + ".txt");
            try {
                if (!(original.createNewFile() || testCase.createNewFile())) {
                    Scanner reader = new Scanner(original);
                    while (reader.hasNextLine()){
                        tree.add(reader.nextLine());
                    }
                    tree.add(Long.toString(original.lastModified()));
                    String originalHash = tree.getHashCode();
                    reader = new Scanner(testCase);
                    tree.clear();
                    while (reader.hasNextLine()){
                        tree.add(reader.nextLine());
                    }
                    tree.add(Long.toString(testCase.lastModified()));
                    String testCaseHash = tree.getHashCode();
                    if(originalHash.equals(testCaseHash)){
                        System.out.println("O arquivo é original");
                    }
                    else {
                        System.out.println("O arquivo é editado");
                    }
                    System.out.println("Deseja fazer outro caso de teste? 1-Sim 2-Não");
                    controle = Integer.parseInt(sc.next());
                } else {
                    System.out.println(original.getName() + " não existe");
                    System.out.println("Criando arquivo...");
                    if(testCase.createNewFile()){
                        System.out.println(testCase.getName() + " não existe");
                        System.out.println("Criando arquivo...");
                    }
                }
            } catch (IOException e) {
                System.out.println("deu ruim");
                break;
            }
        }
    }
}
