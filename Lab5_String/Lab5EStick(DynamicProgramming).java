import java.util.Scanner;

public class Lab5EStick{
    //Dynamic Programming
    //Though this method obtained "memory exceeded in OJ", it is the most practical method from my point of view.
    public static void main(String[] args){
        Scanner sk = new Scanner(System.in);
        int cnt = 0;
        String str1 = sk.next();
        int lgth1 = str1.length();
        String str2 = sk.next();
        int lgth2 = str2.length();
        int[][] arr = new int[lgth1+1][lgth2+1];
        for(int i = 1; i < lgth1+1; i++){
            for( int j = 1; j < lgth2+1; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1]+1;
                }else{
                    arr[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < lgth1+1; i++){
            for(int j = 1; j < lgth2+1;j++){
                if(cnt < arr[i][j]){
                    cnt = arr[i][j];
                }
            }
        }
        System.out.println(cnt);

    }
}

