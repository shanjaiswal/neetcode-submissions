class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            List<Integer> yList = adjList.getOrDefault(x, new ArrayList<>());
            yList.add(y);
            adjList.put(x, yList);
            List<Integer> xList = adjList.getOrDefault(y, new ArrayList<>());
            xList.add(x);
            adjList.put(y, xList);
        }
        Set<Integer> visited = new HashSet<>();
        int connectedCount = 0;
        for (int node = 0; node<n; node++) {
            if (visited.contains(node)) {
                continue;
            }
            connectedCount++;
            dfs(node, -1, adjList, visited);
        }
        return connectedCount;
    }
    public void dfs(int node, int parent, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        if (adjList.get(node) == null) {
            return;
        }
        for (int nextNode : adjList.get(node)) {
            if (nextNode == parent) {
                continue;
            }
            dfs(nextNode, node, adjList, visited);
        }
    }
}
