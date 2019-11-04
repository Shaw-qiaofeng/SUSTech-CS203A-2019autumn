import java.util.*;
public class Lab6CPreInAndPost{
    public static void main(String[] args) {
		Scanner sk = new Scanner(System.in);
        int rep = sk.nextInt();
        for(int i = 0; i < rep; i++){
            int nds = sk.nextInt();
            ArrayList<Node> nodes = new ArrayList<Node>();
            for(int j = 0; j < nds; j++){
                nodes.add(new Node(j));
            }
            int[] preOrder = new int[nds];
            int[] inOrder = new int[nds];
            for(int j = 0; j < nds; j++){
                preOrder[j] = sk.nextInt();
            }
            for(int j = 0; j < nds; j++){
				inOrder[j] = sk.nextInt();	
            }
			Tree tree = new Tree();
			Node root = tree.initTree(preOrder, 0, preOrder.length-1, inOrder, 0,inOrder.length-1);
			tree.postOrder(root);
			System.out.println();
		}
    }
    
}
class Node{
    int val;
    Node prnt;//A node's parent;
    Node left;//The left child of a node;
    Node right;//The right child of a node;
    Node(){

    }
    Node(int val){
        this();
        this.val = val;
    }
    
}
class Tree {
	public Node root;
	public Tree(){
		root = null;
	}
	public void postOrder(Node root){
		if(root != null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.val+" ");
		}
	}
    public Node initTree(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int rootData = preOrder[preStart];
        Node head = new Node(rootData);
        //Find root according to inorder traverse
        int rootIndex = findIndexInArray(inOrder,rootData,inStart,inEnd);
        int offset = rootIndex-inStart-1;
        //Construct a left subtree
        Node left = initTree(preOrder,preStart+1,preStart+offset+1,inOrder,inStart,inStart+offset);
        //Construct a right subtree
        Node right = initTree(preOrder,preStart+offset+2,preEnd,inOrder,rootIndex+1,inEnd);
        head.left = left;
        head.right = right;
        return head;
    }
    //Find root according to inorder traverse
    private int findIndexInArray(int[] inOrder, int rootData, int inStart, int inEnd) {
        for (int i = inStart; i <= inEnd; i++) {
            if(inOrder[i] == rootData){
                return i;
            }
        }
        return -1;
    }
}
