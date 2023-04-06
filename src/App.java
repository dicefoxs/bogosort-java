import java.util.ArrayList;
import java.util.Random;

public class App {

    static boolean ceks(ArrayList<Integer> randoms, int numbers) {
        for (int i = 0; i < randoms.size(); i++) {
            if (randoms.get(i).equals(numbers)) {
                return false;
            }
        }
        return true;
    }

    static void bogosort(ArrayList<Integer> list) {
        int z = 1;
        do {
            ArrayList<Integer> lists = new ArrayList<Integer>();
            Random aRandom = new Random();
            ArrayList<Integer> randoms = new ArrayList<Integer>();
            int J = 0;
            int numbers;
            do {
                if (J == 0) {
                    numbers = aRandom.nextInt(list.size());
                    randoms.add(numbers);

                    J++;
                } else {
                    numbers = aRandom.nextInt(list.size());
                    if (ceks(randoms, numbers)) {
                        randoms.add(numbers);
                        J++;
                    }
                }
            } while (J < list.size());
            for (int i = 0; i < list.size(); i++) {
                lists.add(list.get(randoms.get(i)));
            }

            list = lists;
            System.out.print("Perulangan Ke" + z + " : ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(" " + list.get(i));
            }
            System.out.println("");
            z++;
        } while (!cekSort(list));

    }

    static boolean cekSort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(19);
        list.add(78);
        list.add(12);
        list.add(13);
        list.add(6);
        bogosort(list);
    }
}
