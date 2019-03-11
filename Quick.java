import java.util.*;
public class Quick {
  public static int partition (int[] data, int start, int end) {
    int rando = (int) (Math.random() * (end - start));
    int pivot = data[rando];
    data[rando] = data[0];
    data[0] = pivot;
    while (start < end) {
      if (data[start] > pivot) {
        while (data[end] > pivot && end > start) {
          end--;
        }
        int s = data[start];
        int e = data[end];
        data[start] = e;
        data[end] = s;
      }
      start++;
    }
    if (data[start] < pivot) {
      data[0] = data[start];
      data[start] = pivot;
    }
    else if (data[start - 1] < pivot){
      data[0] = data[start - 1];
      data[start - 1] = pivot;
      start -= 1;
    }
    else {
      data[0] = data[start - 2];
      data[start - 2] = pivot;
      start -= 2;
    }
    System.out.println(pivot);
    System.out.println(Arrays.toString(data));
    return start;
  }
  public static int quickselect(int[] data, int k ) {
    int compare = partition(data, 1, data.length - 1);
    while (
  }
  public static void main(String[] args) {
    int[] ary = { 2, 10, 15, 23, 0,  5};
    int[] ary2 = {999,999,999,4,1,0,3,2,999,999,999};
    partition(ary, 1, ary.length - 1);
    partition(ary2, 1, ary2.length - 1);
  }
}
