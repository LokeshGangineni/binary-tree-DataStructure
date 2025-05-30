 //1 2 4 -1 -1 5 -1 -1 3 -1 6 -1 -1
package binary_tree;

import java.util.*;
public class BinaryTreeImplementation {
	static class Node
	{
		int data;
		Node left;
		Node right;
		Node(int data)
		{
			this.data=data;
			this.left=null;
			this.right=null;
			
		}
		
	}
	//Building tree
	public static class BinaryTree
	{
		static int idx=-1;
		
		public static Node buildTree(int [] nodes)
		{
			
			idx++;
			if(nodes[idx]==-1)
			{
				return null;
			}
			Node newNode=new Node( nodes[idx]);
//			System.out.print(nodes[idx]+" ");
			newNode.left=buildTree(nodes);
			
			newNode.right=buildTree(nodes);
			return newNode;
		}
	}
	
//  Building another tree
	public static class BinaryTree1
	{
		static int idx=-1;
		
		public static Node buildTree(int [] nod)
		{
			
			idx++;
			if(nod[idx]==-1)
			{
				return null;
			}
			Node newNode=new Node( nod[idx]);
			
			newNode.left=buildTree(nod);
			newNode.right=buildTree(nod);
			return newNode;
		}
	}
	
	//preOrder
	
	public static void preOrder(Node root)
	{
		if(root==null)
		{
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	//inOrder
	
	public static void inOrder(Node root)
	{
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	//preorder
	
	public static void postOrder(Node root)
	{
		if(root==null)
		{
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	//Level Order
	public static void levelOrder(Node root)
	{
		Queue<Node> q= new LinkedList<>();
		if(root==null)
		{
			return;
		}
		q.add(root);
		q.add(null);
		while(!q.isEmpty())
		{
			Node currNode= q.remove();
			if(currNode==null)
			{
				System.out.println();
				if(q.isEmpty())
				{
					break;
				}
				else
				{
					q.add(null);
				}
			}
			else
			{
				System.out.print(currNode.data+ " ");
				if(currNode.left!=null)
				{
					q.add(currNode.left);
				}
				if(currNode.right!=null)
				{
					q.add(currNode.right);
				}
			}
		}
		
	}
	
	//count of Nodes
	public static int countNodes(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		int countLeft=countNodes(root.left);
		int countRight=countNodes(root.right);
		int finalCount=countLeft+countRight+1;
		return finalCount;
	}
	
	//Sum of Nodes
	public static int sumOfNodes(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		int sumLeft=sumOfNodes(root.left);
		int sumRight=sumOfNodes(root.right);
		int sumCount=sumLeft+sumRight+root.data;
		return sumCount;
	}
	
	//height of tree
	public static int findHeight(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		int leftHeight=findHeight(root.left);
		int rightHeight=findHeight(root.right);
		int height=Math.max(leftHeight,rightHeight)+1;
		return height;
		
	}
	
	//diameter of Binary tree
	public static int findDiameter(Node root) 
	{
		if(root==null)
		{
			return 0;
		}
		int dia1=findDiameter(root.left);
		int dia2=findDiameter(root.right);
		int dia3=findHeight(root.left)+findHeight(root.right)+1;
		return Math.max(Math.max(dia2, dia1), dia3);

	}
	public static void findDiameter2()
	{
		
		
		
		
	}
	
	//subTree
	
	public static boolean isIdentical(Node root,Node subRoot)
	{
		if(root==null && subRoot==null)
		{
			return true;
		}
		if(subRoot==null || root==null)
		{
			return false;
		}
		if(subRoot.data==root.data)
		{
			return(root.left==subRoot.left && root.right==subRoot.right);
		}
		return false;
	}
	
// checking for sub tree
	public static boolean isSubTree(Node root,Node subRoot)
	{
		if(subRoot==null)
		{
			return true;
		}
		if(root==null)
		{
			return false;
		}
		if(root.data==subRoot.data)
		{
			if(isIdentical(root,subRoot))
			{
				return true;
			}
		}
		return isSubTree(root.left,subRoot.left) ||isSubTree( root.right,subRoot.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nodes= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		Node root=BinaryTree.buildTree(nodes);
		int []  nod= {2,4,-1,-1,5,-1,-1};
		Node subRoot=BinaryTree1.buildTree(nod);
		System.out.println(root.data);
//		preOrder(root);
//		System.out.println();
//		inOrder(root);
		System.out.println();
		postOrder(root);
//		System.out.println();
//		levelOrder(root);
//		System.out.println();
//		int count=countNodes(root);
//		System.out.println(count);
//		System.out.println();
//		int sum=sumOfNodes(root);
//		System.out.println(sum);
//		System.out.println(findHeight(root));
//		System.out.println(findDiameter(root));
//		
//		
//		System.out.println(isSubTree(root,subRoot));
		
	}

}
