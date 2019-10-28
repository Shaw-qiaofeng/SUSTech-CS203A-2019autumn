import java.util.Scanner;

public class Lab6AKaryTree{
    public static void main(String[] args){
        Scanner sk = new Scanner(System.in);
        int rep = sk.nextInt();
        for(int i = 0; i < rep; i++){
            int num = sk.nextInt();
            int ary = sk.nextInt();

            //Method 1: Explore step by step, according to definition;
            //Drawback: Too slow;
            /*
            int mns = 1;
            int layer = 0;
            while(num>=mns){
                num -= mns;
                layer++;
                mns *= ary;
            }
            System.out.println(mns/ary-(num-1)/ary-1+num);
            */

            //Method 2: Find the rule
            /*
            /Take ary = 4 as an example:
            /As num increases from 1 to very big,
            /the number of leaves is 1, 1, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9......
            /The numbers are divided into groups of 4;
            /In each group, the first number repeat once, and the following numbers do not repeat;
            /We define a rmdr(remainder) which represents the four number in the 0th group(1 1 2 3);
            /The number of leaves equals to [rmdr+(groupIndex)*(ary-1)];
            */
            
            int rmdr = 1;
            if((num+ary-1)%ary != 0){
                rmdr = (num+ary-1)%ary;
            }
            System.out.println((num-1)/ary*(ary-1)+rmdr);
        }
    }
}