
import java.util.*;

class Solution {

    class MedianWindow {

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        long leftSum = 0;
        long rightSum = 0;

        int leftSize = 0;
        int rightSize = 0;
        int target;

        MedianWindow(int x) {
            target = (x + 1) / 2;
        }

        void add(int num) {

            if (left.isEmpty() || num <= left.lastKey()) {
                left.put(num, left.getOrDefault(num, 0) + 1);
                leftSum += num;
                leftSize++;
            } else {
                right.put(num, right.getOrDefault(num, 0) + 1);
                rightSum += num;
                rightSize++;
            }

            balance();
        }

        void remove(int num) {

            if (left.containsKey(num)) {
                removeFromMap(left, num);
                leftSum -= num;
                leftSize--;
            } else {
                removeFromMap(right, num);
                rightSum -= num;
                rightSize--;
            }

            balance();
        }

        void removeFromMap(TreeMap<Integer, Integer> map, int num) {

            int count = map.get(num);

            if (count == 1) {
                map.remove(num);
            } else {
                map.put(num, count - 1);
            }
        }

        void balance() {

            int desiredLeft = Math.min(target, leftSize + rightSize);

            while (leftSize > desiredLeft) {

                int num = left.lastKey();

                removeFromMap(left, num);
                leftSum -= num;
                leftSize--;

                right.put(num, right.getOrDefault(num, 0) + 1);
                rightSum += num;
                rightSize++;
            }

            while (leftSize < desiredLeft) {

                int num = right.firstKey();

                removeFromMap(right, num);
                rightSum -= num;
                rightSize--;

                left.put(num, left.getOrDefault(num, 0) + 1);
                leftSum += num;
                leftSize++;
            }
        }

        long getCost() {

            long median = left.lastKey();

            return median * leftSize - leftSum
                 + rightSum - median * rightSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;
        int m = n - x + 1;

        long[] cost = new long[m];

        MedianWindow window = new MedianWindow(x);

        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        cost[0] = window.getCost();

        for (int i = 1; i < m; i++) {

            window.remove(nums[i - 1]);
            window.add(nums[i + x - 1]);

            cost[i] = window.getCost();
        }

        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int j = 1; j <= k; j++) {

            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                curr[i] = curr[i - 1];

                if (i >= x && prev[i - x] != INF) {

                    long take = prev[i - x] + cost[i - x];

                    curr[i] = Math.min(curr[i], take);
                }
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}
