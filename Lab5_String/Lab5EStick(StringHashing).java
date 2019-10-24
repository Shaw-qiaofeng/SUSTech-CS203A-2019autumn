import java.util.Arrays;
import java.util.Scanner;

public class Lab5EStick{
    public static void main(String[] args){
        Scanner sk = new Scanner(System.in);
        String shtr = sk.next();
        String lngr = sk.next();
        if(shtr.length()>lngr.length()){
            String tmp = shtr;
            shtr = lngr;
            lngr = tmp;
        }//shtr is the shorter one of the two strings. lngr is longer;

        //Binary search for the longest similar part of the two strings;
        int min = 0;//The two string can have no similar char;
        int max = shtr.length();
        int mid = (min+max+1)>>1;//Round up to an integer, incase min = 2k while max = 2k+1 which makes the program go to endless loop;
        while(min<max){
            if(checkStick(mid, shtr, lngr)){
                min = mid;
                mid = (min+max+1)>>1;
            }else{
                max = mid-1;
                mid = (min+max+1)>>1;
            }
        }
        System.out.println(mid);
    }
    public static boolean checkStick(int num, String shtr, String lngr){//num is the expected length of a pair of similar parts;
        long[] arrS = new long[shtr.length()-num+1];
        long tmp = pow(139,num-1);
        for(int i = 0; i < arrS.length; i++){
            if(i == 0){
                arrS[i] = hash(shtr.substring(0, num));
            }else{
                arrS[i] = (arrS[i-1] - shtr.charAt(i-1)*tmp)*139+shtr.charAt(i+num-1);//To save time, do not use pow() to calculate all the hashing value;
            }
        }
        long[] arrL = new long[lngr.length()-num+1];
        for(int i = 0; i < arrL.length; i++){
            if(i == 0){
                arrL[i] = hash(lngr.substring(0, num));
            }else{
                arrL[i] = (arrL[i-1] - lngr.charAt(i-1)*tmp)*139+lngr.charAt(i+num-1);
            }
        }
        Arrays.sort(arrL);
        for(int i = 0; i < arrS.length; i++){
            if(Arrays.binarySearch(arrL, arrS[i])>-1){
                return true;//To see if a pair of similar parts of expected length exists;
            }
        }
        return false;
    }
    public static long hash(String str){
        long hsh = 0;
        for(int i = 0; i < str.length(); i++){
            hsh = hsh * 139 + str.charAt(i);
        }
        return hsh;
    }
    public static long pow(int base, int pow){
        long rst = 1;
        if(pow>0)
            for(int i = 0; i < pow; i++){
                rst *= base;
            }
        return rst;
    }
}