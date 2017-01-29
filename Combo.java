import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jack on 1/18/2017.
 */
public class Combo {

    static String[][] arr = {
            {"quick", "lazy"},
            {"brown", "black", "grey"},
            {"fox", "dog"}
    };

    public static void main(String[] args) {
        printCombos(arr);
    }

    static void printCombos(String[][] arr) {
        StringBuilder sb = new StringBuilder();
        Set<String> combos = new HashSet<>();

        int[] sizes = new int[arr.length];
        int[] counter = new int[arr.length];

        // populate arrays for sizes and counting
        int combosPossible = 1;
        for (int i = 0; i < arr.length; i++) {
            sizes[i] = arr[i].length;
            combosPossible *= arr[i].length;
            counter[i] = 0;
        }

        for (int index = 0; index < combosPossible; index++) {

            sb.delete(0, sb.length());
            // get current combo based on counter array
            for (int i = 0; i < sizes.length; i++) {
                sb.append(arr[i][counter[i]]).append(" ");
            }
            combos.add(sb.toString());

            // increment counter array to next combo
            for (int currArr = arr.length-1; currArr >= 0; --currArr) {
                if (counter[currArr] + 1 < sizes[currArr]) {
                    ++counter[currArr];
                    break;
                }
                counter[currArr] = 0;
            }


            System.out.println("Counter: ");
            for (int i : counter) {
                System.out.print(i + " ");
            }
            System.out.println();

        }

        for (String s : combos) {
            System.out.println(s);
        }
    }
}
