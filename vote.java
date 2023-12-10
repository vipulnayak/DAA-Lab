import java.util.Scanner;

public class Election {
    // define candidates
    private static final String CANDIDATE1 = "Ganesh";
    private static final String CANDIDATE2 = "Mahesh";
    private static final String CANDIDATE3 = "Rathan";
    private static final String CANDIDATE4 = "Abhishek";
    private static final String NOTA = "None";
    private static final String SPOILEDVOTES = "Error";

    // initialise vote counts of candidates to zero
    private static int votesCount1 = 0, votesCount2 = 0, votesCount3 = 0, votesCount4 = 0, notavotes = 0, spoiledvotes = 0;

    // create an array with boolean type and initially set to false
    private static boolean[] voted = new boolean[300];

    // This function is to choose the candidate of their choice
    private static void castVote() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Please choose your Candidate !!");
        System.out.println("1. " + CANDIDATE1);
        System.out.println("2. " + CANDIDATE2);
        System.out.println("3. " + CANDIDATE3);
        System.out.println("4. " + CANDIDATE4);
        System.out.println("5. " + NOTA);
        System.out.print("Input your choice (1 - 5): ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                votesCount1++;
                break;
            case 2:
                votesCount2++;
                break;
            case 3:
                votesCount3++;
                break;
            case 4:
                votesCount4++;
                break;
            case 5:
                notavotes++;
                break;
            default:
                spoiledvotes++;
        }
        System.out.println("Thanks for your valuable vote !!");
    }

    // This function provides the votes earned by candidates
    private static void votesCount() {
        System.out.println("Voting Statistics !!");
        System.out.println(CANDIDATE1 + " - " + votesCount1);
        System.out.println(CANDIDATE2 + " - " + votesCount2);
        System.out.println(CANDIDATE3 + " - " + votesCount3);
        System.out.println(CANDIDATE4 + " - " + votesCount4);
        System.out.println(NOTA + " - " + notavotes);
        System.out.println(SPOILEDVOTES + " - " + spoiledvotes);
    }

    // This function provides the leading candidate
    private static void getLeadingCandidate() {
        if (votesCount1 > votesCount2 && votesCount1 > votesCount3 && votesCount1 > votesCount4 && votesCount1 > notavotes && votesCount1 > spoiledvotes)
            System.out.println("[" + CANDIDATE1 + "] has won the election with " + votesCount1 + " votes !!");
        else if (votesCount2 > votesCount3 && votesCount2 > votesCount4 && votesCount2 > votesCount1 && votesCount2 > notavotes && votesCount2 > spoiledvotes)
            System.out.println("[" + CANDIDATE2 + "] has won the election with " + votesCount2 + " votes !!");
        else if (votesCount3 > votesCount4 && votesCount3 > votesCount2 && votesCount3 > votesCount1 && votesCount3 > notavotes && votesCount3 > spoiledvotes)
            System.out.println("[" + CANDIDATE3 + "] has won the election with " + votesCount3 + " votes !!");
        else if (votesCount4 > votesCount1 && votesCount4 > votesCount2 && votesCount4 > votesCount3 && votesCount4 > notavotes && votesCount4 > spoiledvotes)
            System.out.println("[" + CANDIDATE4 + "] has won the election with " + votesCount4 + " votes !!");
        else if (notavotes > votesCount1 && notavotes > votesCount2 && notavotes > votesCount3 && notavotes > votesCount4 && notavotes > spoiledvotes)
            System.out.println("None of the above option having higher votes !! Go for re-election !!");
        else if (spoiledvotes > votesCount1 && spoiledvotes > votesCount2 && spoiledvotes > votesCount3 && spoiledvotes > votesCount4 && spoiledvotes > notavotes)
            System.out.println("Election spoiled due to invalid choices !! Go for re-election !!");
        else
            System.out.println("There is a tie !! Go for re-election !!");
    }

    public static void main(String[] args) {
        int i = 1, usn;
        long startTime = System.currentTimeMillis();
        // duration of election = 2 hours in this election
        double duration = 60.0 * 120.0;
        while (i <= 200) {
            long currentTime = System.currentTimeMillis();
            // checks difference between current and start times
            // if it exceeds duration then voting time has ended otherwise voting continues till the end of the while loop or expiry of time
            if ((currentTime - startTime) <= duration) {
                System.out.println("\n\nWELCOME TO CSE BRANCH PRESIDENT ELECTION 2024 !!");
                System.out.print("Enter last three digits of your usn: ");
                Scanner scanner = new Scanner(System.in);
                usn = scanner.nextInt();
                if (!voted[usn]) {
                    castVote();
                    i++;
                    voted[usn] = true;
                } else {
                    System.out.println("You have already voted!");
                }
            } else {
                System.out.println("Election period has ended !!");
                break;
            }
        }

        int s;
        int k = 0;
        // To the use of CSE department for the result of the election
        System.out.println("\n\nFOR CSE DEPARTMENT ACCESS ONLY !!\n");
        while (k < 4) {
            System.out.print("Enter the password: ");
            Scanner scanner = new Scanner(System.in);
            s = scanner.nextInt();
            // set password=456
            if (s == 456) {
                votesCount();
                getLeadingCandidate();
                break;
            } else {
                if (k < 3)
                    System.out.println("Wrong password!! Retry !!");
                else
                    System.out.println("Wrong password !!");
            }
            k++;
        }
        if (k == 4)
            System.out.println("Limit reached and you failed to access the result !!");
    }
}
