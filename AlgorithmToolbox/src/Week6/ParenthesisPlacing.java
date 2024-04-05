package Week6;

import java.util.*;

public class ParenthesisPlacing {
  static long getMaximValue(String exp) {
    List<Integer> digits = new ArrayList<>(exp.length() / 2);
    List<String> opers = new ArrayList<>(exp.length() / 2);
    int i = 0;
    while (i < exp.length()) {
      digits.add(Integer.parseInt("" + exp.charAt(i)));
      if (i < exp.length() - 1) {
        i++;
        opers.add("" + exp.charAt(i));
      }
      i++;
    }
    if (digits.size() == 1)
      return digits.get(0);
    long [][] MAX = new long[digits.size()][digits.size()];
    long [][] MIN = new long[digits.size()][digits.size()];
    for (i = 0; i < digits.size(); i++) {
      for(int j = 0; j <digits.size(); j++) {
        MAX[i][j] = Long.MIN_VALUE;
        MIN[i][j] = Long.MAX_VALUE;
      }
    }
    for(int s = 1; s <= digits.size(); s++) {
      for(i = 0; i<= digits.size() - s; i++) {
        int j = i + s - 1;
        if (i == j) {
          MAX[i][j] = digits.get(i);
          MIN[i][j] = digits.get(i);
        } else {
          int k = i;
          while (k<j) {
            if (opers.get(k).equalsIgnoreCase("+")) {
              MAX[i][j] = Math.max(MAX[i][j], MAX[i][k] + MAX[k+1][j]);
              MIN[i][j] = Math.min(MIN[i][j], MIN[i][k] + MIN[k+1][j]);
            } else if (opers.get(k).equalsIgnoreCase("*")) {
              long a = MAX[i][k] * MAX[k+1][j];
              long b = MAX[i][k] * MIN[k+1][j];
              long c = MIN[i][k] * MAX[k+1][j];
              long d = MIN[i][k] * MIN[k+1][j];
              MAX[i][j] = max(MAX[i][j], a,b,c,d);
              MIN[i][j] = min(MIN[i][j], a,b,c,d);
            } else if (opers.get(k).equalsIgnoreCase("-")) {
              MAX[i][j] = Math.max(MAX[i][j], MAX[i][k] - MIN[k+1][j]);
              MIN[i][j] = Math.min(MIN[i][j], MIN[i][k] - MAX[k+1][j]);
            }
            k++;
          }
        }
      }
    }

    return MAX[0][digits.size() - 1];
  }

  public static long min(long ...arr) {
    long minimum = arr[0];
    for (int i = 1; i< arr.length; i++){
      minimum = Math.min(minimum, arr[i]);
    }
    return minimum;
  }

  public static long max(long ...arr) {
    long maximum = arr[0];
    for (int i = 1; i< arr.length; i++){
      maximum = Math.max(maximum, arr[i]);
    }
    return maximum;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String exp = scanner.next();
    System.out.println(getMaximValue(exp));
  }
}