import java.util.Scanner;

public class Lab5DNecklace{
    public static void main(String[] args){
        Scanner sk = new Scanner(System.in);
        int rep = sk.nextInt();
        for(int i = 0; i < rep; i++){
            String nklc = sk.next();//The necklace;
            int lgth = nklc.length();
            int dmd = 0;//The number of diamonds we should add to the necklace;
            int[] adj = adjointArr(nklc);
            int lgst = adj[lgth-1];

            dmd = (-1*lgth)%(lgth-lgst);

            //Module operation can generate negative value;
            if(dmd<0){
                dmd += (lgth-lgst);
            }
            //The original necklace can have no repetition at all. Therefore, we should add a whole repetitive section to it;
            if(lgst==0){
                dmd += lgth;
            }
            System.out.println(dmd);
        }

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
        if(j == str.length()){
            return true;
        }
        return false;
    }
}