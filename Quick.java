import java.util.*;
public class Quick {
  public static int partition (int[] data, int start, int end) {
    if (start == end) return start;
    Random rand = new Random();
    int pivot = findMedian(data, start, end);
    swap(data, pivot, start);
    pivot = start;
    start++;
    while (start != end) {
      int check = -1;
      if (data[start] == data[pivot]) {
        check = rand.nextInt(2);
      }
      if (data[start] < data[pivot] || check == 0) {
        start++;
      }
      else if (data[start] > data[pivot] || check == 1) {
        swap(data, start, end);
        end--;
      }
    }
    if (data[start] < data[pivot]) {
      swap(data, start, pivot);
      return start;
    }
    else {
      swap(data, start - 1, pivot);
      return start - 1;
    }
  }
  public static int[] partitionDutch(int[] data, int start, int end) {
    int pivot = findMedian(data, start, end);
    swap(data, start, pivot);
    int lo = start;
    int hi = start;
    start++;
    while(start <= end) {
      if (data[start] > data[lo]) {
        swap(data, start, end);
        end--;
      }
      else if (data[start] < data[lo]) {
        swap(data, start, lo);
        hi = start;
        start++;
        lo++;
      }
      else {
        start++;
        hi++;
      }
    }
    int[] output = {lo, hi};
    return output;
  }
  public static int quickselect(int[] data, int k) {
    int start = 0;
    int end = data.length - 1;
    int[] compare = partitionDutch(data, start, end);
    while (!(compare[0] <= k && compare[1] >= k)) {
      if (compare[1] < k) {
        start = compare[1] + 1;
      }
      if (compare[0] > k) {
        end = compare[0] - 1;
      }
      compare = partitionDutch(data, start, end);
    }
    return data[compare[0]];
  }
  private static int findMedian(int[] data, int start, int end) {
    int idx = 0;
    int mid = ((end + start) / 2);
    if ((data[start] <= data[mid] && data[mid] <= data[end]) ||
        (data[end] <= data[mid] && data[mid] <= data[start])) idx = mid;
    else if ((data[end] < data[start] && data[start] < data[mid]) ||
        (data[mid] < data[start] && data[start] < data[end])) idx = start;
    else idx = end;
    return idx;
  }
  private static void swap(int[] data, int x, int y){
    int temp = data[x];
    data[x] = data[y];
    data[y] = temp;
  }
  public static void quicksort(int[] data) {
    quicksortH(data, 0, data.length - 1);
  }
  private static void quicksortH(int[] data, int start, int end) {
    if (start >= end) {
      return;
    }
    int pivot[] = partitionDutch(data, start, end);
    quicksortH(data, start, pivot[0] - 1);
    quicksortH(data, pivot[1] + 1, end);
  }
  public static void main(String[] args) {
    int[] ary = {2, 10, 15, 23, 0,  5};
    int[] ary2 = {999,999,999,4,1,0,3,2,999,999,999};
    int[] ary3 = {17,61,67,47,93,12,20,4,44,78};
    int[] ary4 = {1, 2, 3, 4, 5, 6, 7, 8};
    quicksort(ary);
    System.out.println(Arrays.toString(ary));
    quicksort(ary2);
    System.out.println(Arrays.toString(ary2));
    quicksort(ary3);
    System.out.println(Arrays.toString(ary3));
    quicksort(ary4);
    System.out.println(Arrays.toString(ary4));
//    System.out.println(findMedian(ary3, 4, 5));
//    System.out.println(partitionDutch(ary3, 0, ary3.length - 1));
//    System.out.println(partitionDutch(ary, 0, ary.length - 1));
    System.out.println();
    System.out.println(quickselect(ary, 0));
    System.out.println(quickselect(ary, 1));
    System.out.println(quickselect(ary, 2));
    System.out.println(quickselect(ary, 3));
    System.out.println(quickselect(ary, 4));
    System.out.println(quickselect(ary, 5));

}
}
