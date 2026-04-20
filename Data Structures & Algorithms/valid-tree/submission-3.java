class Solution {
    public boolean validTree(int n, int[][] edges) {
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
                if (components > 1) return false;
                if (!dfs(adjMap, i, hash, -1)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(Map<Integer, List> adjMap, int node, int[] hash, int parent) {
        hash[node] = 2;
        List<Integer> nodes = adjMap.get(node);
        if (nodes != null) {
            for (int n : nodes) {
                if (n == parent) {
                    continue;   //skip
                }
                if (hash[n] == 2) {
                    return false;
                }
                if (hash[n] == 0) {
                    if (!dfs(adjMap, n, hash, node)){
                        return false;
                    }
                }
            }
        }
        hash[node] = 1;
        return true;
    }
}