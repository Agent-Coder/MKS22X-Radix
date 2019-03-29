public class MyLinkedList<E>{
 private int size;
 private Node start,end;
 public MyLinkedList(){
  size=0;
 }
 public void clear(){
   this.size=0;
   this.start=null;
   this.end=null;
 }
 public E removeFront(){
   return this.remove(0);
 }
 public void extend(MyLinkedList<E> other){
    this.end.setNext(other.start);
    other.start.setPrev(this.end);
    this.end=other.end;
    this.size+=other.size;
    other.size=0;
    other.start=null;
    other.end=null;
      //in O(1) runtime, move the elements from other onto the end of this
      //The size of other is reduced to 0
      //The size of this is now the combined sizes of both original lists
  }
  public boolean add(E value){
    Node x=new Node(null,value,null);
    if (this.size==0){
      this.start=x;
    }
    else{
      this.end.setNext(x);
    }
    this.end=x;
    this.size++;
    return true;
  }
  //create new node with inputed value, if there is nothing in list, make the end and start point to the value
  //else just make the current end point to new node and also make the end point to that new Node
  //change size and return true
  public int size(){
    return size;
   }
  public String toString(){
    String s="[";
    int count=this.size;
    if (count==0){
      return s+"]";
    }
    Node x=this.start;
    while (count>1){
      s+=x.getdata()+",";
      x=x.next();
      count--;
    }
    return s+x.getdata()+"]";
  }
  //check if list is empty and return []
  //else make node and kepp adding the node and then doing next while subtracting from count
  //count represents Size
  //loop out before last element to add bracket (no commas)
  public E get(int index){
    if(index < 0 || index > this.size){
      throw new IndexOutOfBoundsException();
    }
    return this.getNthNode(index).getdata();
  }
  //return the data at the nth node using index
  private Node getNthNode(int Index){
    Node x=this.start;
    int i=0;
    while (Index!=i){
      x=x.next();
      i++;
    }
    return x;
  }
  //loop through linked list using int i to the index and then return the node
  public E set(int index, E value){
    if(index < 0 || index > this.size){
      throw new IndexOutOfBoundsException();
    }
    this.getNthNode(index).setData(value);
    return value;
  }
  //throw exception and get node at the index to set it as the value given and then return value
  public boolean contains(E value){
    if (this.indexOf(value)!=-1){
      return true;
    }
    else{
      return false;
    }
  }
  //see if u can indexOf the value so if it returns doesnt -1 its true, else its false
  public int indexOf(E value){
    int x=0;
    Node n=this.start;
    while (x<this.size){
      if(n.getdata().equals(value)){
        return x;
      }
      n=n.next();
      x++;
    }
    return -1;
  }
  //loop through starting from nth node and while x is less than size
  //check the data to see if they are equal and return x if it is
  //return -1 if it loops out
  public void add(int index,E value){
    if(index < 0 || index > this.size()){
      throw new IndexOutOfBoundsException();
    }
    Node n= new Node(null,value,null);
    if(index==0){
      n.setNext(this.start);
      this.start.setPrev(n);
      this.start=n;
    }
    else{
      Node i=this.getNthNode(index-1);
      Node f=i.next();
      f.setPrev(n);
      n.setNext(f);
      i.setNext(n);
      n.setPrev(i);
    }
    this.size++;
  }
  //throw exceptionand create new node with that value
  //if size is 0, set start as the new Node
  //else set the pre of the current node as the new Node
  //and set next of the pre node as the new node
  //set current nodes next and pre as the index and index-1
  public E remove(int index){
    if(index < 0 || index > this.size){
      throw new IndexOutOfBoundsException();
    }
    Node n=this.getNthNode(index);
    E r=n.getdata();
    if (index==0){
      this.start=n.next();
      this.start.setPrev(null);
    }
    else if (index==this.size-1){
      this.end=this.getNthNode(index-1);
      this.end.setNext(null);
    }
    else{
      Node x=n.prev();
      Node y=n.next();
      y.setPrev(x);
      x.setNext(y);
    }
    this.size--;
    return r;
  }
  //throw exception and save the value at node we are removing
  //if it is the final node, then set the previous node's next as null and set the end of list as that node
  //else, set the pre of the next node as the pre node
  //and then the next of the prenode ase the next node
  public boolean removeVal(E value){
    if (this.indexOf(value)!=-1){
      this.remove(this.indexOf(value));
      return true;
    }
    return false;
  }
}
//finds index of this value and if it is not -1, then remove it,return true
//else return false ;
class Node{
 private E data;
 private Node next,prev;
 public Node(Node before,E datas,Node after){
   data=datas;
   next=after;
   prev=before;
 }
 public Node(E datas){
   data=datas;
   next=null;
   prev=null;
 }
 public E getdata(){
   return data;
 }
 public Node next(){
   return next;
 }
 public Node prev(){
   return prev;
 }
 public void setData(E num){
   data=num;
 }
 public void setNext(Node other){
   next=other;
 }
 public void setPrev(Node other){
   prev=other;
 }
 public String toString(){
   String s=""+this.data;
   return s;
 }
}
