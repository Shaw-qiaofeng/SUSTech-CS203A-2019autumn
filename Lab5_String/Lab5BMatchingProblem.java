import java.util.Scanner;

public class Lab5BMatchingProblem{
    public static void main(String[] args){
        Scanner sk = new Scanner(System.in);
        int rep = sk.nextInt();
        for(int i = 0; i < rep; i++){
            int sN = sk.nextInt();
            int tN = sk.nextInt();
            String s = sk.next();
            String t = sk.next();

            //When s is too long(sN-tN>=2);
            if(sN>tN+1){
                System.out.println("NO");
                continue;
            }

            //Find whether s has a star and if so, where the star is;
            int star = -1;
            for(int j = 0; j < sN; j++){
                if(s.charAt(j)=='*'){
                    star = j;
                    break;
                }
            }

            //The case when s does not have a star;
            if(star == -1){//Since s has no star, s and t should be completely the same;
                if(s.equals(t)){
                    System.out.println("YES");
                    continue;
                }else{
                    System.out.println("NO");
                    continue;
                }
            }

            //Normal case: s has a star;
            if(star==0)
                s = s.substring(1);
            else if(star==sN)
                s = s.substring(0,sN);
            else
                s = s.substring(0,star) + s.substring(star+1);
            t = t.substring(0,star) + t.substring(tN-sN+star+1);

            if(s.equals(t)){
                System.out.println("YES");
                continue;
            }else{
                System.out.println("NO");
                continue;
            }
            

        }

    }
}