// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        if (pairs.isEmpty()) {
            return new ArrayList<>();
        }

        List<List<Pair>> res = new ArrayList<>();
        res.add(new ArrayList<>(pairs));
        
        for (int i = 1; i < pairs.size(); i++) {
            int currentIndex = i;

            for (int j = i - 1; j >= 0; j--) {

                if (pairs.get(currentIndex).key < pairs.get(j).key) {
                    // swap
                    Pair temp = pairs.get(currentIndex);

                    pairs.set(currentIndex, pairs.get(j));
                    pairs.set(j, temp);

                    currentIndex = j;
                }
            }
            res.add(new ArrayList<>(pairs));
        }

        return res;
    }
}
