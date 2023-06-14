package Programa;
import ArvoreAVL.Tree;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static String getHash(File file){
        Tree tree = new Tree();
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                tree.add(reader.nextLine());
            }
            return tree.getHashCode();
        }
        catch (FileNotFoundException e){
            return "";
        }
    }

    public static int inputInt(Scanner sc){
        try {
            return Integer.parseInt(sc.next());
        }
        catch (NumberFormatException e){
            System.out.println("Insira apenas números!");
            return inputInt(sc);
        }
    }

    public static void printFileNotExists(String fileName){
        System.out.println(fileName + " não existe");
        System.out.println("Criando arquivo...");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int controle = 1;
        while(controle == 1) {
            try {
                System.out.println("O que deseja fazer?");
                System.out.println("1 - Geração de Código de Autenticação");
                System.out.println("2 - Verificação e Autencidade do Documento");
                System.out.println("0 - Encerrar Programa");
                int comando = inputInt(sc);
                if(comando == 0){
                    break;
                }
                if(comando == 1) {
                    System.out.println("De qual arquivo deseja gerar o código de autenticação?");
                    String nomeArquivo = sc.next();
                    File file = new File(System.getProperty("user.dir") + "/Arquivo/" + nomeArquivo + ".txt");
                    if(!file.createNewFile()) {
                        System.out.println("Código de Autenticação: " + getHash(file));
                    }
                    else {
                        printFileNotExists(nomeArquivo);
                    }
                }
                if(comando == 2){
                    System.out.println("Qual o primeiro arquivo?");
                    String nomeOriginal = sc.next();
                    File original = new File(System.getProperty("user.dir") + "/Arquivo/" + nomeOriginal + ".txt");
                    System.out.println("Qual o segundo arquivo?");
                    String nomeTestCase = sc.next();
                    File testCase = new File(System.getProperty("user.dir") + "/Arquivo/" + nomeTestCase + ".txt");
                    boolean originalAttempt = original.createNewFile();
                    boolean testCaseAttempt = testCase.createNewFile();
                    if (!(originalAttempt || testCaseAttempt)) {
                        String originalHash = getHash(original);
                        String testCaseHash = getHash(testCase);
                        if (originalHash.equals(testCaseHash)) {
                            System.out.println("O arquivo é original");
                        } else {
                            System.out.println("O arquivo é editado");
                        }
                        System.out.println("Códigos Hash:");
                        System.out.println(nomeOriginal + ": " + originalHash);
                        System.out.println(nomeTestCase + ": " + testCaseHash);
                    }
                    else{
                        if(originalAttempt){
                            printFileNotExists(nomeOriginal);
                        }
                        if(testCaseAttempt){
                            printFileNotExists(nomeTestCase);
                        }
                    }
                }
                System.out.println("Deseja fazer outro caso de teste?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                controle = inputInt(sc);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
