package study.array;

import java.util.ArrayList;

public class SearchMaze {
	
	public static void main(String[] args) {
        int[][] arr = {
            {1, 0, 1, 1},
            {1, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 1, 1}
        };

        ArrayList<String> paths = findPaths(arr);

        for (String path : paths) {
            System.out.println(path);
        }
    }
	
	public static ArrayList<String> findPaths(int[][] arr) {
        ArrayList<String> ans = new ArrayList<>();
        int n = arr.length;
        boolean[][] visited = new boolean[n][n];
        solve(0, 0, arr, n, ans, visited, "");
        return ans;
    }

    private static void solve(int x, int y, int[][] arr, int n, ArrayList<String> ans, boolean[][] visited, String path) {
        if (x == n - 1 && y == n - 1) {
            ans.add(path);
            return;
        }

        visited[x][y] = true;
        
        // Down
        if (isValid(x + 1, y, n, visited, arr)) {
            solve(x + 1, y, arr, n, ans, visited, path + "D");
        }
        
        // Left
        if (isValid(x, y - 1, n, visited, arr)) {
            solve(x, y - 1, arr, n, ans, visited, path + "L");
        }

        // Right
        if (isValid(x, y + 1, n, visited, arr)) {
            solve(x, y + 1, arr, n, ans, visited, path + "R");
        }

        // Up
        if (isValid(x - 1, y, n, visited, arr)) {
            solve(x - 1, y, arr, n, ans, visited, path + "U");
        }

        visited[x][y] = false;
    }
    
    private static boolean isValid(int x, int y, int n, boolean[][] visited, int[][] arr) {
        return x >= 0 && x < n && y >= 0 && y < n && !visited[x][y] && arr[x][y] == 1;
    }


    public ArrayList<String> searchMaze(ArrayList<ArrayList<Integer>> adj, int n) {
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<ArrayList<Boolean>> visited = new ArrayList<>();
        String path = "";

        // Initialize the 'visited' grid
        for (int i = 0; i < n; i++) {
            ArrayList<Boolean> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(false);
            }
            visited.add(row);
        }

        // Check if the starting cell is not blocked (0)
        if (adj.get(0).get(0) == 0)
            return ans;

        solve(0, 0, adj, n, ans, visited, path);
        return ans;
    }

    private void solve(int x, int y, ArrayList<ArrayList<Integer> > arr, int n, ArrayList<String> ans,
                      ArrayList<ArrayList<Boolean> > visited, String path) {
        // D, L, R, U
        if (x == n - 1 && y == n - 1)
            ans.add(path);

        visited.get(x).set(y, true);

        // Down
        if (isSafe(x + 1, y, visited, arr, n)) {
            solve(x + 1, y, arr, n, ans, visited, path + 'D');
        }

        // Left
        if (isSafe(x, y - 1, visited, arr, n)) {
            solve(x, y - 1, arr, n, ans, visited, path + 'L');
        }

        // Right
        if (isSafe(x, y + 1, visited, arr, n)) {
            solve(x, y + 1, arr, n, ans, visited, path + 'R');
        }

        // UP
        if (isSafe(x - 1, y, visited, arr, n)) {
            solve(x - 1, y, arr, n, ans, visited, path + 'U');
        }

        visited.get(x).set(y, false);
    }

    private boolean isSafe(int newX, int newY, ArrayList<ArrayList<Boolean> > visited,
                           ArrayList<ArrayList<Integer> > arr, int n) {
        if (newX >= 0 && newX < n && newY >= 0 && newY < n && arr.get(newX).get(newY) == 1 && !visited.get(newX).get(newY)) {
            return true;
        }
        return false;
    }
}
