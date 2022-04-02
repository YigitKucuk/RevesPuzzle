import java.util.Scanner;

public class RevesPuzzle {
    
    private static void replaceDisk(int n, int k, String from_peg, String helper_peg, String to_peg) {
        
        if (n == 0) {
             System.out.println();
             return;
        }

        replaceDisk(n - 1, k, from_peg, to_peg, helper_peg);
        System.out.print("Take disk number " + (n + k) + " from peg " + from_peg + " to peg " + to_peg);
        replaceDisk(n - 1, k, helper_peg, from_peg, to_peg);

    }

    private static void revReplace(int n, String from_peg, String helper_peg1, String to_peg, String helper_peg2) {

        int k = (int) (n + 1 - Math.round(Math.sqrt(2 * n + 1)));
        if (k == 0){
            System.out.print("Take disk number  " + 1  + " from peg " + from_peg + " to peg " + to_peg);
            return;
        }

        revReplace(k, from_peg , to_peg, helper_peg1 , helper_peg2);
        replaceDisk(n-k, k, from_peg, helper_peg2, to_peg);
        revReplace(k, helper_peg1, from_peg, to_peg, helper_peg2);
    }
    public static void main(String[] args) {

        System.out.println("\n");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int numberOfDisks;

        try{
            numberOfDisks = input.nextInt();
            revReplace(numberOfDisks, "A", "B", "C", "D");
        }catch (Exception e){
            System.out.println("Enter a valid integer!");
        }finally{
            System.out.println("\nCompleted!");
        }

        input.close();

    }
    
}
