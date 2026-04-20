class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List> adjMap = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            List<Integer> yList = adjMap.getOrDefault(x, new ArrayList<>());
            yList.add(y);
            adjMap.put(x, yList);
            List<Integer> xList = adjMap.getOrDefault(y, new ArrayList<>());
            xList.add(x);
            adjMap.put(y, xList);
        }
        int[] hash = new int[n];
        int components = 0;
        for(int i = 0; i<n; i++) {
            if (hash[i] == 0) {
                components++;
                dfs(adjMap, i, hash, -1);
            }
        }
        return components;
    }
    public void dfs(Map<Integer, List> adjMap, int node, int[] hash, int parent) {
        hash[node] = 2;
        List<Integer> nodes = adjMap.get(node);
        if (nodes != null) {
            for (int n : nodes) {
                if (n == parent) {
                    continue;   //skip
                }
                if (hash[n] == 2) {
                    continue;
                }
                if (hash[n] == 0) {
                    dfs(adjMap, n, hash, node);
                }
            }
        }
        hash[node] = 1;
    }
}
