import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lab6DCutTheStick{
    public static void main(String[] args){
        Scanner sk = new Scanner(System.in);
        int rep = sk.nextInt();
        for(int i = 0; i < rep; i++){
            int nds = sk.nextInt();
            int[] arr = new int[nds];
            for(int j = 0; j < nds; j++){
                arr[j] = sk.nextInt();
            }
            Arrays.sort(arr);
            Huffman nodes[] = new Huffman[2*nds-1];
            for(int j = 0; j < nds; j++){
                nodes[j] = new Huffman(arr[j]);
            }
            for(int j = nds; j < 2*nds-1; j++){
                nodes[j] = new Huffman();
            }
            int pnt = nds;//A pointer, which represents where a new HuffmanNode should be generated;
            for(int j = 0; j < nds-1; j++){
                select(nodes,pnt);
                pnt++;
            }
            long sum = 0;
            for(int j = nds; j < 2*nds-1; j++){
                sum += nodes[j].wt;
            }
            System.out.println(sum);

        }
        sk.close();
    }
    public static void select(Huffman[] nodes, int pnt){//Find two HuffmanNodes with smallest weight which have not had a parent yet; Then generate a new HuffmanNode by adding the two HuffmanNodes' weight;
        int minW1 = Integer.MAX_VALUE;
        int minI1 = 0;
        int minW2 = Integer.MAX_VALUE;
        int minI2 = 0;
        for(int j = 0; j < pnt; j++){
            if(nodes[j].wt > 0){
                if(nodes[j].prt == -1){
                    if(nodes[j].wt < minW1){
                        minW2 = minW1;
                        minI2 = minI1;
                        minW1 = nodes[j].wt;
                        minI1 = j;
                    }else if(nodes[j].wt < minW2){
                        minW2 = nodes[j].wt;
                        minI2 = j;
                    }
                }                
            }
        }
        nodes[pnt].wt = minW1+minW2;
        nodes[pnt].lch = minI1;
        nodes[pnt].rch = minI2;
        nodes[minI1].prt = pnt;
        nodes[minI2].prt = pnt;
    }
}
class Huffman{
    int wt;//weight;
    int lch;//leftChild;
    int rch;//rightChild;
    int prt;//parent;
    Huffman(){
        this.wt = -1;
        this.lch = -1;
        this.rch = -1;
        this.prt = -1;
    }
    Huffman(int wt){
        this();
        this.wt = wt;
    }
    
}