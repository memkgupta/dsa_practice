//User function Template for Java

class Pair {

    Node node;
    int index;

    Pair(Node node, int index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {

    //Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair e = q.poll();

            map.put(e.index, e.node.data);

            if (e.node.left != null) {
                Pair p = new Pair(e.node.left, e.index - 1);
                q.add(p);
            }
            if (e.node.right != null) {
                Pair p = new Pair(e.node.right, e.index + 1);
                q.add(p);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
            //   System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        return list;
    }
}
