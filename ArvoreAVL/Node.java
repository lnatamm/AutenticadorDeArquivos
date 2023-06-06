package ArvoreAVL;
import java.security.*;
public class Node{
    private String data;

    private String hash;

    private Node left;

    private Node right;

    private int factor;

    public Node(String data){
        this.data = data;
        left = null;
        right = null;
        sha1();
        factor = 0;
    }

    public void incFactor(){
        factor++;
    }

    public void decFactor(){
        factor--;
    }

    public String getData(){
        return data;
    }

    public String getHash(){
        return hash;
    }

    public Node getLeft(){
        return left;
    }

    public Node getRight(){
        return right;
    }

    public int getFactor(){
        return factor;
    }

    public void setData(String data){
        this.data = data;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public void setRight(Node right){
        this.right = right;
    }

    public void setFactor(int factor){
        this.factor = factor;
    }

    private void sha1(){
        try {
            // Cria uma instância do algoritmo de criptografia SHA1
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");

            // Converte a String em bytes
            byte[] dataBytes = data.getBytes();

            // Calcula o hash SHA1 dos bytes
            byte[] sha1Hash = sha1.digest(dataBytes);

            // Converte o hash em uma representação hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : sha1Hash) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // Retorna a representação hexadecimal do hash
            data = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return;
        }
    }

}