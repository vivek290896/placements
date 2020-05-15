package com.company;

public class EggSolver {
    public static void main(String[] a){
        System.out.println(new EggSolver().solveEgg(10,4));
    }

    public int solveEgg(int n, int k){
        int result[][] = new int[n+1][k+1];

        for(int i=0;i<=n;i++)
            result[i][1] = i;
        for (int i=0;i<=k;i++)
            result[1][i] = 1;

        for (int i=2;i<=n;i++){
            for (int j=2;j<=k;j++){
                result[i][j] = Integer.MAX_VALUE;
                for (int x=1;x<i;x++){
                    int eggBroke = result[x-1][j-1];
                    int eggNotBroken = result[i-x][j];
                    int temp = Math.max(eggBroke,eggNotBroken)+1;
                    if (temp < result[i][j])
                        result[i][j] = temp;
                }
            }
        }
        return result[n][k];
    }
}
