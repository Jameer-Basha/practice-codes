class Decoding{
    void decode(String s, Node root) {
        int i=0;
        Node curr=root;
        while(i<s.length()){
            
            if (s.charAt(i)=='1'){
                
                if(root.right==null){
                System.out.print(root.data);
                root=curr;
                }
                else{
                    root=root.right;
                    i++;
                }
                
                
            }
            else if (s.charAt(i)=='0'){
                if(root.left==null){
                System.out.print(root.data);
                root=curr;
                }
                else{
                    root=root.left;
                    i++;
                }
            }
            
            
            
        }
        if(root!=curr)
            System.out.println(root.data);


    }
}
