import java.util.*;
public class Radix{
  @SuppressWarnings("unchecked")
  public static void radixsort(int[]data){
    if (data.length==0){
      return;
    }
    MyLinkedList<Integer>[] bucket=new MyLinkedList[19];
    int max=findMax(data);
    int counter=0;
    while (counter<max){
      for (int i=0;i<bucket.length ;i++ ) {
        bucket[i]=new MyLinkedList<Integer>();
      }
      for (int i=0;i<data.length;i++) {
        int temp=(data[i]/(int)(Math.pow(10,counter)))%10;
          bucket[temp+9].add(data[i]);
      }
      int datacount=0;
      for (int i=0;i<bucket.length;i++) {
        for (int j=0;j<bucket[i].size() ;j++ ) {
          data[datacount]=bucket[i].get(j);
          datacount++;
        }
      }
      /*MyLinkedList<Integer> all= new MyLinkedList<Integer>();
      for (int i=0;i<bucket.length;i++) {
        all.extend(bucket[i]);
      }
      for (int i=0;i<all.size();i++ ) {
        data[i]=all.get(i);
      }*/
      counter++;
    }
  }
  public static int findMax(int[] data){
    int max=0;
    String s="";
    for (int i=0;i<data.length;i++) {
      s+=data[i];
      if(data[i]<0){
        s=s.substring(0,s.length()-1);
      }
      if(s.length()>max){
        max=s.length();
      }
      s="";
    }
    return max;
  }
public static void main(String[] args) {
  int[] x={-2,3,5,6,-17,-198,1232,14};
  radixsort(x);
  System.out.println(Arrays.toString(x));
}
}
