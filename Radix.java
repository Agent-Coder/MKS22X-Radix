public class Radix{
  public static void radixsort(int[]data){
    MyLinkedList<Integer>[] bucket=new MyLinkedList<>()[10];
    int max=findMax(data);
    int counter=0;
    while (counter<max){
      for (int i=0;i<data.length;i++) {
        bucket[data[i]%(int)(Math.pow(10.0,1.0*counter))].add(data[i]);
      }
      for (int i=0;i<bucket.length;i++ ) {

      }
    }
  }
  public static void findMax(int[] data){
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

}
