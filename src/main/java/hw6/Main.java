package hw6;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        createTrees(1000, 4, 25);
    }

    private static void createTrees(int trees, int level, int range) {

        int balancedTrees = 0;
        int notBalancedTrees = 0;
        int customBalancedTrees = 0;
        int customNotBalancedTrees = 0;

        Random random = new Random();

        for (int i = 0; i < trees; i++) {
            Tree<Integer> tree = new TreeImpl<>();
            for (int j = 0; j < Math.pow(2, level) - 1; j++) {
                tree.addByLevel(random.nextInt(2 * range) - range, level);
            }
//            tree.display(level);
            if (tree.customBalanced(level)) {
                customBalancedTrees++;
            } else {
                customNotBalancedTrees++;
            }
            if (tree.isBalanced()) {
                balancedTrees++;
            } else {
                notBalancedTrees++;
            }
        }

        System.out.println("Total number of trees = " + trees + System.lineSeparator());

        System.out.println("Balanced trees = " + balancedTrees);
        System.out.println("Not balanced trees = " + notBalancedTrees);
        System.out.printf("Success percent = %.2f%%\r\n\r\n", (double) balancedTrees/trees * 100);

        System.out.println("[My method]Balanced trees = " + customBalancedTrees);
        System.out.println("[My method]Not balanced trees = " + customNotBalancedTrees);
        System.out.printf("[My method]Success percent = %.2f%%", (double) customBalancedTrees/trees * 100);
    }
}
