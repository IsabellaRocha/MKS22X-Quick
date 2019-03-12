import java.util.*;
public class Quick {
  public static int partition (int[] data, int start, int end) {
    int rando = (int) (Math.random() * (end - start));
    int pivot = data[rando];
    data[rando] = data[0];
    data[0] = pivot;
    while (start < end) {
      System.out.println(Arrays.toString(data));
      start++;
      if (data[start] > pivot) {
        while (data[end] > pivot && end > start) {
          end--;
        }
        int s = data[start];
        int e = data[end];
        data[start] = e;
        data[end] = s;
      }
    }
    if (data[start] < pivot) {
      data[0] = data[start];
      data[start] = pivot;
    }
    else {
      data[0] = data[start - 1];
      data[start - 1] = pivot;
      start -= 1;
    }
    return start;
  }
  public static int quickselect(int[] data, int k) {
    int start = 1;
    int end = data.length - 1;
    int compare = partition(data, start, end);
    while (compare != k) {
      if (compare < k) {
        start = compare + 1;
        compare = partition(data, start, end);
      }
      else if (compare > k) {
        end = compare - 1;
        compare = partition(data, start, end);
      }
    }
    return data[compare];
  }
  public static void main(String[] args) {
    int[] ary = { 2, 10, 15, 23, 0,  5};
    int[] ary2 = {999,999,999,4,1,0,3,2,999,999,999};
    int[] ary3 = {17,61,67,47,93,12,20,4,44,78};
    System.out.println(partition(ary3, 0, ary3.length - 1));
//    System.out.println(partition(ary, 3, 4));
//    System.out.println(quickselect(ary, 0));
//    System.out.println(quickselect(ary, 1));
//    System.out.println(quickselect(ary, 2));
//    System.out.println(quickselect(ary, 3));
//    System.out.println(quickselect(ary, 4));
//    System.out.println(quickselect(ary, 5));
  }
}
