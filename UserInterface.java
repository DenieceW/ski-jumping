import java.util.*;

public class UserInterface {
    private Scanner scanner;
    private List<Jumper> list;
    private int round;
    private int placeOfJumper;

    public UserInterface(){
        this.scanner = new Scanner(System.in);
        this.list = new ArrayList<Jumper>();
        this.round = 1;
        this.placeOfJumper = 0;
    }

    public void jumpingGame(){
        printTournamentIntroduction();

        while (true) {
            System.out.println("");
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String input = scanner.nextLine();

            if (!input.equals("jump")){
                printResults();
                break;
            }

            System.out.println("");
            System.out.println("Round " + round);
            System.out.println("");
            System.out.println("Jumping order: ");

            for(Jumper jumper : this.list){
                System.out.println(("  " + ++this.placeOfJumper) + ". " + jumper);
            }
            this.placeOfJumper = 0;

            System.out.println("");
            System.out.println("Results of round " + round);
            for (Jumper jumper : this.list) {
                    jumper.jump();
                    jumper.getName();
                System.out.println("    length: " + jumper.getJumpLength());
                    jumper.votesForJump();

            }

            Collections.sort(this.list);
            this.round++;
        }
    }

    public void printTournamentIntroduction(){
        System.out.println("Kumpula ski jumping week");
        System.out.println("");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        setPlayers();
        System.out.println("");
        System.out.println("The tournament begins!");
    }

    public void setPlayers(){
        while (true) {
            System.out.print("  Participant name: ");
            String userInput = this.scanner.nextLine();
            if (userInput.equals("" +
                    "")) {
                break;
            }
            this.list.add(new Jumper(userInput));
        }
    }

    public void printResults(){
        System.out.println(" ");
        System.out.println("Thanks!");
        System.out.println(" ");
        System.out.println("Tournament results: ");
        System.out.println("Position    Name");
        this.placeOfJumper = 1;
        Collections.reverse(this.list);

        for(Jumper jumper : this.list){
            System.out.println(this.placeOfJumper + "           " + jumper);
            jumper.printJumps();
            System.out.println("");
            this.placeOfJumper++;
        }

    }
}
