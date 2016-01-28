import java.util.*;

interface DoublyLinkedListInterface<T> {
	boolean	add(T e);//Appends the specified element to the end of this list.
	void display();//print the contents from head to tail
}

class Node <T> {
	T data;
	Node<T> before;
	Node<T> after;

	Node(T data, Node<T> before, Node<T> after){
		this.data=data;
		this.before=before;
		this.after=after;
	}

	void setAfter(Node<T> after){
		this.after=after;
	}

	void setBefore(Node<T> before){
		this.before=before;
	}

	T getData(){
		return this.data;
	}

	Node<T> getAfter(){
		return this.after;
	}
}

class DoublyLinkedListImpl<T> implements DoublyLinkedListInterface<T> {
	Node<T> head;
	Node<T> tail;
	int size=0;

	public boolean add(T data){
		Node<T> newNode = new Node<T>(data,head,null);
		if(head==null) head=newNode;
		else{
			head.setAfter(newNode);
			newNode.setBefore(head);
		}
		size++;
		return true;
	}

	public void display(){
		Node<T> temp=head;
		for(int i=0;i<size;i++){
			if(temp!=null) {
				System.out.println("Node["+i+"] # "+temp.getData());
				temp=temp.getAfter();
			}
		}
	}
}

public class Dll{
	public static void main(String args[]){
		DoublyLinkedListImpl<Object> dll = new DoublyLinkedListImpl<Object> ();
		dll.add("asghasasa");
		dll.add(12);
		dll.display();
	}
}