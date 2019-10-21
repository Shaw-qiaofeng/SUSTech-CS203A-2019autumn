import java.util.Scanner;

public class Lab5AHowManySubstring{
    public static void main(String[] args){
        Scanner sk = new Scanner(System.in);
        int rep = sk.nextInt();
        for(int i = 0; i < rep; i++){
            String str = sk.next();
            System.out.println((1+str.length())*str.length()/2);
        }
    }
}