class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n == 0) {
            return true;
        }

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i<edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            List<Integer> yList = adjList.getOrDefault(x, new ArrayList<>());
            yList.add(y);
            adjList.put(x, yList);
            List<Integer> xList = adjList.getOrDefault(y, new ArrayList<>());
            xList.add(x);
            adjList.put(y, xList);
        }

        Set<Integer> visited = new HashSet<>();
        
        if (!dfs(0, -1, adjList, visited)) {
            return false;
        }

        return visited.size() == n;
    }
    public boolean dfs(int node, int parent, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);

        if (adjList.get(node) != null) {
            for (int nextNode : adjList.get(node)) {
                if (nextNode != parent) {
                    if (!dfs(nextNode, node, adjList, visited)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
