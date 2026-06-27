class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                int d1 = Math.abs(a - x);
                int d2 = Math.abs(b - x);

                if (d1 == d2) {
                    return b - a; // larger value first
                }

                return d2 - d1;   // larger distance first
            }
        );

        for (int num : arr) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        Collections.sort(ans);

        return ans;
    }
}