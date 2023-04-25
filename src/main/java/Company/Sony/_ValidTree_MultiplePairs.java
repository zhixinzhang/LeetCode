package Company.Sony;

// import DataStructure.BinaryTree.TreeNode;

// https://www.1point3acres.com/bbs/thread-879046-1-1.html
// 真正的coding 题。输入是几个pair，每个pair（2个）里的node相当于连接的。问‍‌‌‌‌‍‌‌‍‍‌‌‍‌‌‍‌‍‌最后一共有几棵树，非常简单的union find题
public class _ValidTree_MultiplePairs {
    public static void main(String[] args){
        // findValidTree(new TreeNode[][]{
        //     {new TreeNode(1), new TreeNode(2)},
        //     {new TreeNode(1), new TreeNode(3)},
        //     {new TreeNode(4), new TreeNode(6)},
        //     {new TreeNode(8), new TreeNode(9)},
        //     {new TreeNode(8), new TreeNode(10)},
        //     {new TreeNode(9), new TreeNode(7)},
        //     {new TreeNode(11), new TreeNode(12)},
        //     {new TreeNode(12), new TreeNode(13)},
        //     {new TreeNode(13), new TreeNode(11)}
        // });

        findValidTree(3, new int[][]{
            {0, 1},
            {1, 2},
            {2, 0}
        });
    }

    private static int findValidTree(int n, int[][] edges){
        // if(edges.length != n - 1) 
        //     return 0;
        
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            uf.union(v, w);
            System.out.println("connecting: " + v + " " + w);
        }

        System.out.println("valid tree number is : " + uf.size);
        return uf.size;
    }
    
    static class UnionFind {
        int[] parents;
        int[] rank;
        int size;
        
        public UnionFind(int size){
            parents = new int[size];
            rank = new int[size];
            this.size = size;

            for (int i = 0; i < size; i++){
                parents[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int childA){
            if(childA == parents[childA]) 
                return childA;
            return parents[childA] = find(parents[childA]);
        }

        private void union(int x, int y){
            int rx = find(x);
            int ry = find(y);
            if(rx != ry) {
                this.size--;
                if(rank[rx] > rank[ry]) {
                    parents[ry] = rx;
                } else if (rank[rx] < rank[ry]) {
                    parents[rx] = ry;
                } else {
                    parents[ry] = rx;
                    rank[rx]++;
                }
            }
        }
    } 
}
