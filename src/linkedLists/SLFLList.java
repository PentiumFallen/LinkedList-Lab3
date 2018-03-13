package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.util.NoSuchElementException;

import linkedLists.LinkedList;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 

	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}


	public void addFirstNode(Node<E> nuevo) {
		if (first == null) {
			first = (SNode<E>) nuevo;
			last = (SNode<E>) nuevo;
			length++;
		}
		else {
			SNode<E> second = first;
			first = (SNode<E>) nuevo;
			first.setNext(second);
			length++;
		}
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		SNode<E> before = first;
		while (before != target) 
			before = before.getNext();
		SNode<E> after = before.getNext();
		before.setNext((SNode<E>) nuevo);
		before.getNext().setNext(after);
		if (last == target)
			last = before.getNext();
		length++;
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		if (first == target) {
			addFirstNode(nuevo);
			return;
		}
		else {
			SNode<E> before = first;
			while (before.getNext() != target) 
				before = before.getNext();
			SNode<E> after = before.getNext();
			before.setNext((SNode<E>) nuevo);
			before.getNext().setNext(after);
			length++;
		}
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		return first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		SNode<E> thisOne = first;
		while (thisOne != target) 
			thisOne = thisOne.getNext();
		return thisOne.getNext();
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		if (first == target) {
			throw new NoSuchElementException("Nothing before first node");
		}
		else {
			SNode<E> before = first;
			while (before.getNext() != target) 
				before = before.getNext();
			return before;
		}
	}

		public int length() {
			return length;
		}

		public void removeNode(Node<E> target) {
			SNode<E> remove;
			if (first == target) {
				remove = first;
				first = first.getNext();
				if (first == null)
					last = null;
			}
			else {
				SNode<E> before = first;
				while (before.getNext() != target) 
					before = before.getNext();
				remove = before.getNext();
				if (last == target) {
					last = before;
					last.setNext(null);
				}
				else 
					before.setNext(remove.getNext());
			}
			remove.clean();
			length--;
		}

		public Node<E> createNewNode() {
			return new SNode<E>();
		}

	}
