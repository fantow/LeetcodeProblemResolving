package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class NodeTwo {
    public int val;
    public NodeTwo left;
    public NodeTwo right;

    public NodeTwo(){

    }

    public NodeTwo(int val){
        this.val = val;
    }

    public NodeTwo(int val,NodeTwo left,NodeTwo right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
