package Y2020.ds;

import java.util.List;
import java.util.Objects;

public class BinaryTree<T> {

	private Node<T> root;
	
	
	public BinaryTree(Node<T> root) {
		super();
		this.root = root;
	}
	
	
	// root-left-right
	public void preOrderTraversal(Node<T> root) {
		if(Objects.isNull(root)) return;
		
		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	// left-root-right
	public void inOrderTraversal(Node<T> root) {
		if(Objects.isNull(root)) return;
		
		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}
	
	// left-root-right
	public void sortDec(Node<Integer> node, List<Node<Integer>> sortedNodes) {
		if(Objects.isNull(node)) return;
		
		sortDec(node.right, sortedNodes);
		sortedNodes.add(node);
		sortDec(node.left, sortedNodes);
	}
	
	public static int maxSum(Node<Integer> node, int sum) {
		if(Objects.isNull(node)) return sum;
		
		sum = maxSum(node.right, sum);
		int temp = node.data;
		node.data = sum;
		sum += temp;
		sum = maxSum(node.left, sum);
		return sum;
	}
	
	// left-right-root
	public void postOrderTraversal(Node<T> root) {
		if(Objects.isNull(root)) return;
		
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}
	
	public static void sumup(List<Node<Integer>> nodes) {
		int sum = 0;
		for (int i = 0; i < nodes.size(); i++) {
			Integer temp = nodes.get(i).data;
			if(sum == 0)
				nodes.get(i).data = 0;
			else
				nodes.get(i).data = sum;
			
			sum += temp;
			
		}
	}
	

	public static void main(String[] args) {
	
		BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(new Node<Integer>(11));
		
		binaryTree.root.left = new Node<Integer>(2);
		binaryTree.root.right = new Node<Integer>(29);
		binaryTree.root.left.left = new Node<Integer>(1);
		binaryTree.root.left.right = new Node<Integer>(7);
		binaryTree.root.right.left = new Node<Integer>(15);
		binaryTree.root.right.right = new Node<Integer>(40);
		binaryTree.root.right.right.left = new Node<Integer>(35);
		
		binaryTree.preOrderTraversal(binaryTree.root);
		System.out.println();
		binaryTree.inOrderTraversal(binaryTree.root);
		System.out.println();
		binaryTree.postOrderTraversal(binaryTree.root);
		System.out.println();
		/*List<Node<Integer>> sortedNodes = new ArrayList<Node<Integer>>();
		binaryTree.sortDec(binaryTree.root, sortedNodes);
		sumup(sortedNodes);*/
		maxSum(binaryTree.root,0);
		System.out.println(binaryTree.root);
	}
	
	static class Node<T>{
		private T data;
		private Node<T> right;
		private Node<T> left;
		
		public Node() {}
		public Node(T data) {
			super();
			this.data = data;
		}
		
		public boolean hasNext(){
			return right != null;
		}
		
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("[\n"+ data);
			if(Objects.nonNull(right))
				sb.append(",\n right="+right);
			if (Objects.nonNull(left))
				sb.append(",\n left="+left);
			sb.append("]");
			return sb.toString();
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}
		
	}
	
}

