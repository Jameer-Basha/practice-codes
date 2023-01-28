class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        List<Integer> lst= new ArrayList<Integer>();        
        if(root== null){
            return lst;
        }
        que.add(root);
        while(!que.isEmpty()){            
            int size = que.size();
            for(int i=0;i<size;i++){
            TreeNode curr = que.poll();
                if(i==0){
                    lst.add(curr.val);
                }
                
                if(curr.left!=null){
                    que.add(curr.left);
                    }
                if(curr.right!=null){
                    que.add(curr.right);
                    }
            }
            

        }
        return lst;
    }
}
