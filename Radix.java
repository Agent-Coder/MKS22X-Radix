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
    int temp;
    for (int i=0;i<bucket.length ;i++ ) {
      bucket[i]=new MyLinkedList<Integer>();
    }
    for (int i=0;i<data.length;i++) {
      temp=(data[i]%10);
        bucket[temp+9].add(data[i]);
    }
    MyLinkedList<Integer> all= new MyLinkedList<Integer>();
    while (counter<max){
      //System.out.println(bucket[13].size());
      if(counter!=0){
        while (all.size()>0) {
          int num=all.removeFront();
          //System.out.println(num);
          temp=(num/(int)(Math.pow(10,counter)))%10;
          bucket[temp+9].add(num);
        }
      }
      all= new MyLinkedList<Integer>();
      for (int i=0;i<bucket.length;i++) {
          //System.out.println(bucket[i].size());
          //System.out.println(bucket[i].size());
          all.extend(bucket[i]);
          //System.out.println("total"+all.size());
      }
      //System.out.println(all.size());
      //System.out.println(all.size());
      counter++;
    }
    temp=0;
    while (all.size()>0) {
      data[temp]=all.removeFront();
      temp++;
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
