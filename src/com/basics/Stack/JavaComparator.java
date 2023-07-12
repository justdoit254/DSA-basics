package com.basics.Stack;

import java.util.*;

class Score{
    private String name;
    private int score;
    public Score(String  name, int score) {
        this.name = name;
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }

}

public class JavaComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //sc.nextLine();
        List<Score> ascore = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            Score points = new Score(name , score);
            ascore.add(points);
        }
        Collections.sort(ascore ,Comparator.comparing(Score :: getScore).reversed().thenComparing(Score :: getName));
        for (Score points : ascore) {
            System.out.print(points.getName() + " ");
            System.out.println(points.getScore());
        }
    }
}
