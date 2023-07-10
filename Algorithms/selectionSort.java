public class selectionSort {

  public static int[] sort(int[] array) {
    for (int i = 0; i <= array.length - 1; i++) {
      int smallIndx = i;
      for (int j = i + 1; j <= array.length - 1; j++) {
        if (array[j] < array[smallIndx]) {
          smallIndx = j;
        }
      }
      swap(array, smallIndx, i);

    }
    return array;
  }

  public static void swap(int[] array, int smallIndx, int i) {
    int temp = array[smallIndx];
    array[smallIndx] = array[i];
    array[i] = temp;
  }

  public static void display(int[] array) {
    for (int i = 0; i <= array.length - 1; i++) {
      System.out.print(array[i] + "   ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = { 54, 2, 66, 1, 888, 0 };
    display(arr);
    display(sort(arr));

  }
}