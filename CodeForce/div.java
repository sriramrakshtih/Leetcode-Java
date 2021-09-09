import java.util.*;

//742
public class div {
    private static String str;
    private static int n;
    private static boolean [] prime = new boolean [100];
    public static void main(String[] args) {
        for(int i = 2; i < 100; i++){
            prime[i] = true;
            for(int j = 2; j * j <= i; j++) {
                if(i % j == 0) {
                    prime[i] = false;
                }
            }
        }

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t != 0){
            n = s.nextInt();
            str = s.next();
            res();
            t--;
        }    
    }  
    
    private static void res() {
        for(int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if(c == '1' || c == '4' || c == '6' || c == '8' || c == '9') {
                System.out.println("1");
                System.out.println(c);
                return;
            }
        }

        for(int i = 0; i < n; i++){
            char ci = str.charAt(i);
            for(int  j = i + 1; j < n; j++) {
                char cj = str.charAt(j);
                if(!prime[(ci - '0') * 10 + (cj - '0')]) {
                    System.out.println("2");
                    System.out.println(ci + "" + cj);
                    return;
                }
            }
        }
    }
}
