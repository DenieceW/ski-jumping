import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Jumper implements Comparable<Jumper>{
    private String name;
    private int points;
    private int jumpLength;
    List<Integer> jumps;

    public Jumper(String name, int point){
        this.name = name;
        this.points = point;
        this.jumpLength = 0;
        this.jumps = new ArrayList<Integer>();
    }

    public Jumper(String name){
        this(name, 0);
    }

    public void jump(){
        int min = 60;
        int max = 120;
        Random random = new Random();
        this.jumpLength = random.nextInt((max - min) + 1) + min;
        this.jumps.add(this.jumpLength);

    }

    public void printJumps(){
        System.out.print("            jump lengths: ");
        for (int jump: jumps){
            System.out.print(jump + " m ");

        }
    }

    public void votesForJump(){
        int[] judgeVotes = new int[5];
        Random rd = new Random(); // creating Random object
        int lower = 10; //votes have to be between 10 and 20
        int upper = 20;

        for (int i = 0; i < judgeVotes.length; i++) {
            judgeVotes[i] = rd.nextInt((upper - lower) + 1) + lower; // storing random integers in an array
        }

        Arrays.sort(judgeVotes);
        System.out.println("    judge votes: " + Arrays.toString(judgeVotes));
        this.points += this.jumpLength + (judgeVotes[1] + judgeVotes[2] + judgeVotes[3]);
    }

    public void getName(){
        System.out.println("  " + this.name);
    }

    public int getJumpLength(){
        return this.jumpLength;
    }

    public int getPoints(){
        return this.points;
    }

    public String toString(){
       return this.name + " (" + getPoints() + " points)";
    }

    @Override
    public int compareTo(Jumper jumper) {
        return this.getPoints() - jumper.getPoints();
    }
}
