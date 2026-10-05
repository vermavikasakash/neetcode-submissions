class Solution {
    countComponents(n, edges) {
        
        // create graph 
        let graph = Array.from({ length: n }, () => []);
        for (let [u, v] of edges) {
            graph[u].push(v);
            graph[v].push(u);
        }

       let visited = new Set();
        let count = 0;
        for (let i = 0; i < n; i++) {
            if (visited.has(i) == false) {
                count++;
                bfs(i);
            }
        }
        return count;

// bfs
        function bfs(startNode) {     
            let queue = [startNode];  

            while (queue.length) {
                let node = queue.shift();
                visited.add(node);
                for (let nei of graph[node]) {
                    if (visited.has(nei) == false) {
                        
                        queue.push(nei);
                    }
                }
            }

        }

    }
}