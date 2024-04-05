package Week6;

import java.util.*;

public class Partition3RD {

  static boolean partition(int[] A, int n, int a, int b, int c) {
    if(a==0 && b==0 && c==0)
      return true;
    if(n<0)
      return false;
    boolean first = false;
    if(a-A[n] >= 0)
      first = partition(A,n-1,a-A[n],b,c);
    boolean second = false;
    if(!first && ((b-A[n]) >= 0))
      second = partition(A,n-1,a,b-A[n],c);
    boolean third = false;
    if((!first && !second) && ((c-A[n]) >= 0))
      third = partition(A,n-1,a,b,c-A[n]);
    return first || second || third;
  }
  static boolean divisible(int[] A,int total){
    if(A.length < 3)
      return false;
    else if(total%3 != 0)
      return false;
    return partition(A,A.length-1,total/3,total/3,total/3);
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] A = new int[n];
    int total = 0;
    for (int i = 0; i < n; i++) {
      A[i] = scanner.nextInt();
      total += A[i];
    }
    if(divisible(A,total))
      System.out.println(1);
    else
      System.out.println(0);
  }
}