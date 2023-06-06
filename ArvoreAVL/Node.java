package ArvoreAVL;

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
        hash();
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

    private void hash(){
        hash = data.replace(data.charAt(data.length() - 1), data.charAt(0));
    }

}