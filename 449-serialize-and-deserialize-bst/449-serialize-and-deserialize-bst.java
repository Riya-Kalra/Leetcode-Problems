/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.regex.Pattern;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb =new StringBuilder();
        Queue<TreeNode> q =new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int sz= q.size();
            for(int i=0;i<sz;i++){
                TreeNode t = q.poll();
                if(t!=null)
                    sb.append(t.val);
                else
                    sb.append(-1);
                if(i==sz-1)
                    sb.append("#");
                else
                    sb.append(".");
                if(t!=null){
                    q.offer(t.left);
                    q.offer(t.right);
                }
                
            }
            
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       // System.out.println(data);
        Queue<TreeNode> q = new LinkedList<>();
        String arr[]= data.split("#");
        String a[]=arr[0].split(Pattern.quote("."));
        if(a[0].equals("-1")) return null;
        TreeNode  root = new TreeNode(Integer.parseInt(a[0]));
        q.add(root);
        int k=0;
        while(!q.isEmpty()){
            int sz=q.size();
            String val[]=arr[k+1].split(Pattern.quote("."));
            int j=0;
            for(int i=0;i<sz;i++){
                TreeNode t=q.poll();
                if(val[j].equals("-1"))
                    t.left=null;
                else{
                    t.left=new TreeNode(Integer.parseInt(val[j]));
                    q.add(t.left);
                }
                j++;
                if(val[j].equals("-1"))
                    t.right=null;
                else{
                    t.right=new TreeNode(Integer.parseInt(val[j]));
                    q.add(t.right);
                }
                j++;
            }
            k++;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;