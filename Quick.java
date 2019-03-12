import java.util.*;
public class Quick {
  public static int partition (int[] data, int start, int end) {
    int rand = (int) (Math.random() * (end - start + 1) + start);
    int pivot = data[rand];
    data[rand] = data[0];
    data[0] = pivot;
    while (start < end) {
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
      if (data[start] == pivot) {
        int rando = (int) (Math.random() * 2);
        if (rando == 0) {
          int s = data[start];
          int e = data[end];
          data[start] = e;
          data[end] = s;
        }
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
    System.out.println(Arrays.toString(data));
    return start;
  }
  public static int quickselect(int[] data, int k) {
    int start = 0;
    int end = data.length - 1;
    int compare = partition(data, start, end);
    while (compare != k) {
      if (compare < k) {
        start = compare;
      }
      if (compare > k) {
        end = compare;
      }
      compare = partition(data, start, end);
    }
    return data[compare];
  }
  public static void main(String[] args) {
    int[] ary = { 2, 10, 15, 23, 0,  5};
    int[] ary2 = {999,999,999,4,1,0,3,2,999,999,999};
    int[] ary3 = {17,61,67,47,93,12,20,4,44,78};
    int[] ary4 = {1, 2, 3, 4, 5, 6, 7, 8};
//    System.out.println(partition(ary3, 0, ary3.length - 1));
    System.out.println(partition(ary2, 0, ary.length - 1));
//    System.out.println(quickselect(ary4, 0));
//    System.out.println(quickselect(ary4, 1));
//    System.out.println(quickselect(ary4, 2));
//    System.out.println(quickselect(ary4, 3));
//    System.out.println(quickselect(ary4, 4));
//    System.out.println(quickselect(ary4, 5));
  }
}
