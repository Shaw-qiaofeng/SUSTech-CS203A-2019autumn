import java.util.Scanner;

public class Lab5CRepeat{
    public static void main(String[] args){
        Scanner sk = new Scanner(System.in);
        int num = sk.nextInt();
        int cnt = 0;
        for(int i = 0; i < num; i++){
            String amym = sk.next();
            String rptr = sk.next();
            amym = amym.substring(0, amym.length()/3+2);
            if(KMP(rptr, amym)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    /*
    The KMP algorithm is learnt from https://www.bilibili.com/video/av3246487?from=search&seid=16183356840759144519
    and https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
    */

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

    public static boolean KMP(String drg, String str){
        
        int arr[] = adjointArr(str);
        int i = 0;
        int j = 0;
        while(i < drg.length() && j < str.length()){
            if(drg.charAt(i) == str.charAt(j)){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = arr[j-1];
                }else{
                    i++;
                }
            }
        }

        return j == str.length();
    }
}


