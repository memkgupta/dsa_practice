/*
class Node {
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {

    public boolean isHeap(Node tree) {
        // code here
        // check completness using bfs

        if (!isComp(tree)) return false;
        return true;
    }

    boolean isComp(Node tree) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(tree);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean haveNull = false;
            for (int i = 0; i < size; i++) {
                Node p = q.poll();
                if (p.left == null) {
                    haveNull = true;
                } else {
                    if (haveNull) {
                        return false;
                    }
                    if (p.left.data > p.data) return false;
                    q.offer(p.left);
                }

                if (p.right == null) {
                    haveNull = true;
                } else {
                    if (haveNull) {
                        return false;
                    }
                    if (p.right.data > p.data) return false;
                    q.offer(p.right);
                }
            }
        }
        return true;
    }
}
