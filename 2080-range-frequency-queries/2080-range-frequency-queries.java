import java.util.*;

class RangeFreqQuery {

    HashMap<Integer, List<Integer>> mm = new HashMap<>();

    public RangeFreqQuery(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (mm.containsKey(arr[i])) {

                List<Integer> list = mm.get(arr[i]);
                list.add(i);

            } else {

                List<Integer> list = new ArrayList<>();
                list.add(i);
                mm.put(arr[i], list);
            }
        }
    }

    public int query(int left, int right, int value) {

        List<Integer> list = mm.get(value);

        if (list == null) {
            return 0;
        }

        int first = lowerBound(list, left);
        int last = upperBound(list, right);

        return last - first;
    }

    // First index where list[index] >= target
    public int lowerBound(List<Integer> list, int target) {

        int low = 0;
        int high = list.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // First index where list[index] > target
    public int upperBound(List<Integer> list, int target) {

        int low = 0;
        int high = list.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}