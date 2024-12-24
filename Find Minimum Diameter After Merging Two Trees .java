class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {

        int d1 = calculateDiameter(edges1); 
        int d2 = calculateDiameter(edges2); 


        return Math.max(d1, Math.max(d2, (d1 + 1) / 2 + (d2 + 1) / 2 + 1));
    }

    private int calculateDiameter(int[][] edges) {
        int n = edges.length + 1;
        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int level = 0, remainingNodes = n;

        while (remainingNodes > 2) {
            int size = queue.size();
            remainingNodes -= size;
            level++;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbor : adj.get(node)) {
                    if (--degree[neighbor] == 1) { 
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return (remainingNodes == 2) ? 2 * level + 1 : 2 * level;
    }
}
