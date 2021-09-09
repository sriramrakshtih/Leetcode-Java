import java.util.*;

public class domino {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    while(t != 0){
        int n = s.nextInt();
        String str = s.next();
        res(str);
        t--;
    }
    
  }
  
  private static void res(String args){
    StringBuilder sb = new StringBuilder();
		for(int i = 0; i < args.length(); i++){
      if(args.charAt(i) == 'L'){
        sb.append('L');
      }
      else if(args.charAt(i) == 'R'){
        sb.append('R');
      }
      else if(args.charAt(i) == 'U'){
        sb.append('D');
      } else {
        sb.append('U');
      }
    }
    //System.out.print(list.toString());
    System.out.println(sb.toString());
  }
}
