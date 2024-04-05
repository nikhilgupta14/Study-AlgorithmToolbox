package Week4;

public class BinarySearch {
  public static void main(String[] args) {
    binarySearch(1,127, 5);
  }

  static int binarySearch(int min, int max, int search) {

    int mid = (int) Math.floor((max- min)/2 + min);
    System.out.println(mid);

    if (mid == search) {
      System.out.printf("Found value %d", mid);
    }
    else if (mid > search){
      binarySearch(min, mid - 1, search);
    }
    else {
      binarySearch(1 + mid , max , search);
    }


    return max;

  }
}
