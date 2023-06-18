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

    public void incFactor(int i){
        factor+=i;
    }

    public void decFactor(int i){
        factor-=i;
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
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");

            byte[] dataBytes = data.getBytes();

            byte[] sha1Hash = sha1.digest(dataBytes);

            StringBuilder hexString = new StringBuilder();
            for (byte b : sha1Hash) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            hash = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println();
        }
    }

}