public class Graph {
	private int MAX_VERTS;
	private Vertex vertexList[]; // Array of vertices.
	private int adjMat[][];      // Adjacency matrix.
	private Stack pathStack;
	private int nVerts;          // Number of vertices.
	
	public Graph(int vertices) {
		MAX_VERTS = vertices;
		vertexList = new Vertex[MAX_VERTS];     // This array is used to map array keys to actual vertex objects.
		adjMat = new int[MAX_VERTS][MAX_VERTS]; // Basic DS which models the actual edges of graph.
		nVerts = 0;
		
		for (int row = 0; row < MAX_VERTS; row++)
			for (int col = 0; col < MAX_VERTS; col++)
				adjMat[row][col] = 0;
		pathStack = new Stack(MAX_VERTS);
	}
	
	public void addVertex(char label) {
		vertexList[nVerts] = new Vertex(label);
		nVerts++;
	}
	
	/** Adds an undirected edge between vertices v and w in the adjacency matrix. */
	public void addUndirectedEdge(int v, int w) {
		adjMat[v][w] = 1;
		adjMat[w][v] = 1;
	}
	
	/** Adds a directed edge between vertices v and w in the adjacency matrix. */
	pulic void addDirectedEdge(int v, int w){
		adjMat[v][w] = 1;
	}
	
	public int getAdjUnvisitedVertex(int row) {
		for (int col = 0; col < nVerts; col++)
			if (adjMat[row][col] == 1 && vertexList[col].wasVisited == false)
				return col; // Return the next unvisited adjacent vertex in row (i.e., for given vertex).
		return -1;      // -1 means there are no more adjacent (col) vertices for given vertex (row).
	}
	
	/** Finds all reachable vertices from initial vertex. */
	public void recursiveDepthFirstSearch(int start) {
		vertexList[start].wasVisited = true;
		displayVertex(start);
		pathStack.push(start);
		
		for (int col = 0; col < nVerts; col++)
			if (adjMat[start][col] == 1 && vertexList[col].wasVisited ==false)
				recursiveDepthFirstSearch(col);		
	}
	
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

}
