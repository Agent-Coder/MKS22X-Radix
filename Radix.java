import java.util.*;
public class Radix{
  @SuppressWarnings("unchecked")
  public static void radixsort(int[]data){
    if (data.length==0){
      return;
    }
    MyLinkedList<Integer>[] bucket=new MyLinkedList[10];
    int max=findMax(data);
    int counter=0;
    while (counter<max){
      for (int i=0;i<bucket.length ;i++ ) {
        bucket[i]=new MyLinkedList<Integer>();
      }
      for (int i=0;i<data.length;i++) {
        int temp=(data[i]/(int)(Math.pow(10,counter)))%10;
        bucket[temp].add(data[i]);
      }
      int datacount=0;
      for (int i=0;i<bucket.length;i++) {
        for (int j=0;j<bucket[i].size();j++ ) {
            data[datacount]=bucket[i].get(j);
          datacount++;
        }
      }
      counter++;
    }
  }
  public static int findMax(int[] data){
    int max=0;
    String s="";
    for (int i=0;i<data.length;i++) {
      s+=data[i];
      if(s.length()>max){
        max=s.length();
      }
      s="";
    }
    return max;
  }
public static void main(String[] args) {
  int[] x={2,3,5,6,7,8,12,14};
  radixsort(x);
  System.out.println(Arrays.toString(x));
}
}
