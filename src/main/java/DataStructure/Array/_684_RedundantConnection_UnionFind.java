//package DataStructure.Tree.Array;
//import java.util.*;
//
//
////Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
////Output: [1,4]
//public class _684_RedundantConnection_UnionFind{
//	   public int[] findRedundantConnection(int[][] edges) {
//
//			int[] parents = new int[edges.length + 1];
//			for(int i = 1; i<edges.length;i++){
//				parents[i] = i;
//			}
//			for(int[] edge : edges){
//				int pa = find(parents,edges[0]);
//				int pb = find(parents,edges[1]);
//				if(pa == pb) return edge;
//				parents[pa] = pb;
//			}
//		return new int[2];
//	}
//	private int find(int[] parents, int n){
//		if(parents[n] == n) return n;
//		return parents[n] = getParent(parents, parents[n]);
//	}
//}