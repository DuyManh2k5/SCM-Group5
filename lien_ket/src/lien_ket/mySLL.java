package lien_ket;
import java.util.*;

class Node {
	int data;
	Node next;
	Node(int x){
		data = x;
		next = null;
	}
	Node (int x, Node t){
		data = x;
		next =t;
	}
	public String toString() {
		return data + " -> ";
	}
}

public class mySLL {
	Node head = null;
	void nhap() {
		int x;
		Scanner o = new Scanner(System.in);
		Node cuoi = null; head = null;
		while(true) {
			System.out.print("Nhap x de them vao danh sach : ");
			x = o.nextInt();
			if(x==0) break;
			Node t = new Node(x);
			if(head == null)
				head = cuoi = t;
			else {
				cuoi.next = t;
				cuoi = t;
			}
		}
	}
	void chendau(int x) {
		head = new Node(x, head);
	}
	void chencuoi(int x) {
		if(head== null) {
			head = new Node (x);
		}
		else {
			Node p = head;
			while(p.next!=null) {
				p=p.next;
			}
			p.next = new Node(x);
		}
	}
	void chenbk (int x, int k) {
		if(k<0) {
			System.out.println("Vi tri chen khong hop le!");
		}
		else if(k==0) head = new Node(x, head);
		else {
			int vt=0;
			Node p = head;
			while(p!=null && vt<k-1) {
				vt++;
				p=p.next;
			}
			if(p==null) System.out.println("Vi tri chen khong hop le!");
			else {
				Node t =new Node(x, p.next);
				p.next=t;
			}
		}
	}
	void xoad() {
		if(head==null) System.out.println("Khong xoa duoc!");
		else head = head.next;
	}
	void xoac() {
		if(head==null) System.out.println("Khong xoa duoc!");
		else if(head.next == null) head = null;
		else {
			Node p =head;
			while(p.next.next!=null) {
				p=p.next;
			}
			p.next=null;
		}
	}
	void xoak(int k) {
		if(head==null) System.out.println("Khong xoa duoc!");
		else if(k == 0) head = head.next;
		else {
			int vt=0;
			Node p =head;
			while(p!=null && vt<k-1) {
				p=p.next;
				vt++;
			}
			if(p==null || p.next==null) System.out.println("Khong xoa duoc!");
			else p.next=p.next.next;
		}
	}
	void in() {
		Node p = head;
		System.out.println("Noi dung danh sach la : ");
		while(p!=null) {
			System.out.print(p);
		
			p = p.next;
		}
		System.out.println("Null.");
	}
	public static void main(String[] args) {
		mySLL L = new mySLL();
		L.nhap();
		L.in();
		L.chendau(2);
		L.chencuoi(7);
		System.out.println("Danh sach sau khi chen dau cuoi la :");
		L.in();
		L.chenbk(8,6);
		System.out.println("Danh sach sau khi chen so 8 vao vi tri thu 6 la : ");
		L.in();
		L.xoak(6);
		L.xoad();
		L.xoac();
		System.out.println("Danh sau khi xoa dau cuoi va vi tri so 6 la : ");
		L.in();
		System.out.println("xong!");
	}
}
