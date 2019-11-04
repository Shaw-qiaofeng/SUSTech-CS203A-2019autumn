import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lab6DCutTheStick2{
    public static void main(String[] args){
        Scanner sk = new Scanner(System.in);
        int rep = sk.nextInt();
        for(int i = 0; i < rep; i++){
            int nds = sk.nextInt();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < nds; j++){
                list.add(sk.nextInt());
            }
            long sum = 0;
            for(int j = 0; j < nds-1; j++){
                int minW1 = Integer.MAX_VALUE;
                int minW2 = Integer.MAX_VALUE;
                int minI1 = 0;
                int minI2 = 0;
                for(int k = 0; k < list.size(); k++){
                    int tmp = list.get(k);
                    if(tmp < minW1){
                        minW2 = minW1;
                        minI2 = minI1;//IMPORTANT: Line 24&25 were ignored by me in the beginning, which resulted in WA;
                        minW1 = tmp;
                        minI1 = k;
                    }else if(tmp < minW2){
                        minW2 = tmp;
                        minI2 = k;
                    }
                }
                sum += minW1 + minW2;
                list.remove(Integer.max(minI1, minI2));
                list.remove(Integer.min(minI1, minI2));
                list.add(minW1 + minW2);
            }
            System.out.println(sum);
        }
        sk.close();
    }
    
}
