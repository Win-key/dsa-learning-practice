package Y2020.ds;

import java.util.Objects;

import Y2020.ds.BinaryTree.Node;

public class BST{

	public Node<Integer> root;
	public Node<Integer> current;
	
	public Node<Integer> getRoot() {
		return root;
	}

	public void setRoot(Node<Integer> root) {
		this.root = root;
	}

	public Node<Integer> insert(Integer data, Node<Integer> node) {
		if(Objects.isNull(node)) {
			node = new Node<Integer>(data);
			System.out.println("Data inserted : "+data);
			return node;
		}
		if(data.compareTo(node.getData())==0) {
			System.out.println("Data "+data+" already there!");
		}
		else if(data.compareTo(node.getData())<0) {
			node.setLeft(insert(data, node.getLeft()));
		}else {
			node.setRight(insert(data, node.getRight()));
		}
		return node;
		
	}
	
	public void search(Integer data, Node<Integer> node, StringBuffer sb) throws Exception {
		if(Objects.isNull(node)) {
			throw new Exception("Value doesn't exist");
		}
		if(data.compareTo(node.getData())==0) {
			sb.append(node.getData());
			return;
		}
			
		sb.append(node.getData()+"->");
		if(data.compareTo(node.getData())<0)
			search(data, node.getLeft(), sb);
		else 
			search(data, node.getRight(), sb);
		
	}
	
	private Node<Integer> delete(Integer data, Node<Integer> node) throws Exception {
		
		if(Objects.isNull(node)) {
			throw new Exception("Value doesn't exist");
		}else if(data.compareTo(node.getData())<0) {
			node.setLeft(delete(data, node.getLeft()));
		}else if(data.compareTo(node.getData())>0) {
			node.setRight(delete(data, node.getRight()));
		}else {
			if(Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight())) {
				return null;
			}else if(Objects.isNull(node.getLeft())) {
				return node.getRight();
			}else if(Objects.isNull(node.getRight())){
				return node.getLeft();
			}else {
				return getLeftLargeElement(node);
			}
		}
		
		return node;
	}
	
	
	
	public static Node<Integer> getLeftLargeElement(Node<Integer> node){
		if(node.getRight()==null) {
			return node;
		}
		return getLeftLargeElement(node.getRight());
	}
	
	
	
	// left-root-right
	public void inOrderTraversal(Node<Integer> root) {
		if(Objects.isNull(root)) return;
		
		inOrderTraversal(root.getLeft());
		System.out.print(root.getData() + " ");
		inOrderTraversal(root.getRight());
	}
	
	public static void main(String[] args) throws Exception{
		int[] intAr = new int[] {5,3,4,6,2,7,2,10};
		BST bst = new BST();
		bst.root = bst.insert(intAr[0],bst.root);
		
		for (int i = 1; i < intAr.length; i++) {
			bst.insert(intAr[i], bst.root);
		}
		bst.inOrderTraversal(bst.root);
		
		System.out.println("\nSearching 7");
		System.out.println(bst.pathFinder(7));
		Node<Integer> node = getLeftLargeElement(bst.root.getRight());
		System.out.println(node);
		System.out.println("Searching 10");
		System.out.println(bst.pathFinder(10));
		bst.delete(10, bst.root);
		bst.inOrderTraversal(bst.root);
		System.out.println(bst.pathFinder(10));
		
	}
	
	public String pathFinder(int data) throws Exception {
		StringBuffer stringBuffer = new StringBuffer();
		this.search(data, this.root, stringBuffer);
		return stringBuffer.toString();
	}
	
	public Node<Integer> next(){
		if(Objects.isNull(current))
			current = root;
		else
			current.getRight();
		
		return current;
	}
	
	
}
