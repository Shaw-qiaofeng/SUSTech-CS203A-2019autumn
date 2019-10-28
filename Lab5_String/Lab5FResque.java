import java.util.*;


public class Lab5FResque{
    public static void main(String[] args){
        Scanner sk = new Scanner(System.in);
        //Creat a reflection form to translate the plaintext;
        int[] map = new int[26];
        for(int i = 0; i < 26; i++){
            map[sk.next().charAt(0) - 'a'] = i;
        }
        //Translate the whole input as a new string, connect the string with the original input at the end;
        //Therefore, we can know where the plaintext ends by finding the biggest similar prefix and suffix;
        String msg = sk.next();
        StringBuilder rmsg = new StringBuilder();
        int lgth = msg.length();
        for(int i = 0; i < lgth; i++){
            rmsg.append(translate(msg.charAt(i), map));
        }
        rmsg.append(msg);
        String str = rmsg.toString();
        int[] arr = adjointArr(str);
        //Result;
        System.out.println(lgth-arr[arr.length-1]);
    }

    public static int[] adjointArr(String str){
        int[] arr = new int[str.length()];
        int index = 0;
        for(int i = 1; i < str.length();){
            if(str.charAt(i) == str.charAt(index)){
                arr[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = arr[index-1];
                }else{
                    arr[i] =0;
                    i++;
                }
            }
        }
        return arr;
    }

    public static char translate(char ltr, int[] map){
        String aphbt = "abcdefghijklmnopqrstuvwxyz";
        return aphbt.charAt(map[ltr-'a']);
    }

    
}