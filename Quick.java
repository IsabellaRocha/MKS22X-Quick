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
  private static int[] partitionDutch(int[] data, int start, int end) {
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
    if (end - start <= 43) {
      insertionsort(data, start, end);
    }
    else {
      int pivot[] = partitionDutch(data, start, end);
      quicksortH(data, start, pivot[0] - 1);
      quicksortH(data, pivot[1] + 1, end);
    }
  }
  public static void insertionsort(int[] ary, int start, int end) {
    for (int idx = start + 1; idx < end + 1; idx++) {
      int current = ary[idx]; // Storing value for later to move
      int curIdx = idx - 1;
      while (curIdx >= 0 && ary[curIdx] > current) {
        ary[curIdx + 1] = ary[curIdx]; // Shifting values over
        curIdx--;
      }
      ary[curIdx + 1] = current;
    //  System.out.println(Arrays.toString(ary));
    }
  }
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
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
}
}
