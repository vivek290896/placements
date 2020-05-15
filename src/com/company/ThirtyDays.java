package com.company;

public class ThirtyDays { //10.25 17 5
    static double meal_cost = 10.25;
    static int tip_percent = 17;
    static int tax_percent = 5;

    static void solve() {
        double total_percent = (tip_percent + tax_percent);
        double calculate = meal_cost*(total_percent/100);
        double result = calculate+ meal_cost;
        int var = (int) Math.round(result);
        System.out.println(var);
    }
    public static void main(String[] args){
        solve();
    }
}
