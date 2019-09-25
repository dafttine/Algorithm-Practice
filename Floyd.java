import java.util.Scanner;

public class Floyd {

private static double inf = Double.POSITIVE_INFINITY;


private final static double [][] W = new double[][]{
{0, 1, inf, 1, 5},
{9, 0, 3, 2, inf},
{inf, inf, 0 , 4, inf},
{inf, inf, 2 , 0, 3},
{3, inf, inf, inf, 0},
};


private static double [][] D = new double[W.length][W[0].length];
private static double [][] P = new double[W.length][W[0].length];

public static void  printArr(double[][] arr) {
  System.out.println();
  for(int i = 0; i < arr.length; i++) {
    String row = "[ ";
    for(int j = 0; j < arr[0].length; j++) {
      row += String.format("%.0f", arr[i][j]);
      row += ", ";
    }
    row += "]";
    System.out.println(row);
  }  
}

public static void FloydAl(){
 
  for(int i = 0; i < W.length; i++) {
    for(int j = 0; j < W.length; j++) {
      P[i][j] = inf;
    }
  }
  
  D = W;
  int x;
  for(int i = 0; i < W.length; i++) {
    for(int j = 0; j < W.length; j++) {
      for(int k = 0; k < W.length; k++) {
        if(D[j][i] + D[i][k] < D[j][k]) {
          x = i + 1;
          P[j][k] = x;
          D[j][k] = D[j][i] + D[i][k];
        }
      }
    }
  }
}

public static void printShortestPath(int x, int y) {
   if(P[x-1][y-1] == inf) {
     System.out.print("<" + x + ", " + y + ">");
   }
   else{
     System.out.print("<" + x + ", " + (int)P[x-1][y-1] + ">" + ",");
     printShortestPath((int)P[x-1][y-1], y);
   }
}

public static void main(String[] args) {
  
  System.out.print("Floyd's Algorithm will be performed on the given Matrix: ");
  printArr(W);
  
  FloydAl();
  
  System.out.print("\n Matrix D: ");
  printArr(D);
  System.out.print("\n Matrix P: ");
  printArr(P);
  
  Scanner input = new Scanner(System.in);
  System.out.println("\nFinding the shortest path between " + D.length + " vertices starting with vertex 1.");
  System.out.println("Enter the first vertex: ");
  
  int x = input.nextInt();
  
  System.out.println("Enter the second vertex: ");
  
  int y = input.nextInt();
  
  System.out.print("This is the shortest path: {");
  
  printShortestPath(x,y);
  
  System.out.print("}");
  

}

}
