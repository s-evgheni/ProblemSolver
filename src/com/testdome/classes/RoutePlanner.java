package com.testdome.classes;

import java.util.Stack;

/*
As a part of the route planner, the routeExists method is used as a quick filter if the destination is reachable,
before using more computationally intensive procedures for finding the optimal route.

The roads on the map are rasterized and produce a matrix of boolean values - true if the road is present or false if it is not.
The roads in the matrix are connected only if the road is immediately left, right, below or above it.

Finish the routeExists method so that it returns true if the destination is reachable or false if it is not.
The fromRow and fromColumn parameters are the starting row and column in the mapMatrix.
The toRow and toColumn are the destination row and column in the mapMatrix.
The mapMatrix parameter is the above mentioned matrix produced from the map.

For example, for the given rasterized map, the code below should return true since the destination is reachable:

boolean[][] mapMatrix = {

    {true(0.0),  false(0.1), false(0.2)},
         |
         V
    {true(1.0), -> true(1.1),  false(1.2)},
                      |
                      V
    {false(2.0), true(2.1), -> true(2.2)}
};

routeExists(0, 0, 2, 2, mapMatrix); >>> output TRUE (via 0.0 -> 1.0 -> 1.1 -> 2.1 -> 2.2)

* */

//Use Breadth First Search algorithm to traverse the graph represented via the mapMatrix (won't work on disconnected graphs,
// needs tweaks to start at all known vertixes for traversal to work properly)
//see: https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
public class RoutePlanner {
    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
        int numRows = mapMatrix.length;
        int numColumns = mapMatrix[0].length;
        boolean[][] visited = new boolean[numRows][numColumns];
        Stack<Integer> stack = new Stack<>();
        //determine starting vertex number, based on provided "from" coordinates
        stack.push(fromRow * numColumns + fromColumn);
        while (!stack.empty()) {
            int vertexNumber = stack.pop();
            System.out.println("Current vertex #" + vertexNumber);
            //determine current vertex coordinates in the mapMatrix
            int row = vertexNumber / numColumns;
            int col = vertexNumber % numColumns;
            System.out.println("Vertex # " + vertexNumber + " is located @ position: [" + row + "][" + col + "]");
            if (row == toRow && col == toColumn) { //check if we'd reached the destination
                System.out.println("DESTINATION POINT HAS BEEN REACHED @ Vertex # " + vertexNumber + " with the following coordinates: [" + row + "][" + col + "]");
                return true;
            }
            if (visited[row][col]) { //have we visited this node already?
                System.out.println("THIS NODE HAS BEEN VISITED ALREADY {Vertex # " + vertexNumber + " @ [" + row + "][" + col + "]}. Moving to the next item in the stack...");
                continue;
            }
            visited[row][col] = true; //mark current position as visited
            System.out.println("Vertex #: " + vertexNumber + " @ position: [" + row + "][" + col + "] marked as visited");
            if (row > 0 && mapMatrix[row - 1][col]) { //can we move up from current position?
                int nodeNumber = (row - 1) * numColumns + col;
                stack.push(nodeNumber); //if yes add node number to stack
                System.out.println("Can move up to vertex # " + nodeNumber + " FROM: [" + row + "][" + col + "]. Adding node number to the stack...");
            }
            if (row < numRows - 1 && mapMatrix[row + 1][col]) { //can we move down from current position?
                int nodeNumber = (row + 1) * numColumns + col;
                stack.push(nodeNumber); //if yes add node number to stack
                System.out.println("Can move down to vertex #: " + nodeNumber + " FROM: [" + row + "][" + col + "]. Adding node number to the stack...");
            }
            if (col > 0 && mapMatrix[row][col - 1]) { //can we move left from current position?
                int nodeNumber = row * numColumns + col - 1;
                stack.push(nodeNumber); //if yes add node number to stack
                System.out.println("Can move left to vertex #: " + nodeNumber + " FROM: [" + row + "][" + col + "]. Adding node number to the stack...");
            }
            if (col < numColumns - 1 && mapMatrix[row][col + 1]) { //can we move right from current position?
                int nodeNumber = row * numColumns + col + 1;
                stack.push(nodeNumber); //if yes add node number to stack
                System.out.println("Can move right to vertex #: " + nodeNumber + " FROM: [" + row + "][" + col + "]. Adding node number to the stack...");
            }
        }
        return false;
    }
}