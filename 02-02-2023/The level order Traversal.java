	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
        Queue<Node> que = new LinkedList<>();
        if(root==null)
            return ;
        que.add(root);
        System.out.print(root.data+" ");
        while(!que.isEmpty()){
            int size =que.size();
            for (int i=0;i<size;i++){
                Node curr = que.poll();
                if(curr.left!=null){
                    que.add(curr.left);
                    System.out.print(curr.left.data+" ");
                }
                if(curr.right!=null){
                    que.add(curr.right);
                    System.out.print(curr.right.data+" ");
                }
            }
        }
        
      
    }
