
class Solution {

    public int minOperations(int[] nums) {
        int arrayLength = nums.length;
        int zeroIndex = 0;

        for (int index = 0; index < arrayLength; index++) {
            if (nums[index] == 0) {
                zeroIndex = index;
                break;
            }
        }

        int minimumOperations = Integer.MAX_VALUE;

        if (isIncreasingFromZero(nums, zeroIndex, 1)) {
            minimumOperations = Math.min(
                minimumOperations,
                zeroIndex
            );

            minimumOperations = Math.min(
                minimumOperations,
                arrayLength - zeroIndex + 2
            );
        }

        if (isIncreasingFromZero(nums, zeroIndex, -1)) {
            minimumOperations = Math.min(
                minimumOperations,
                zeroIndex + 2
            );

            minimumOperations = Math.min(
                minimumOperations,
                arrayLength - zeroIndex
            );
        }

        if (minimumOperations == Integer.MAX_VALUE) {
            return -1;
        }

        return minimumOperations;
    }

    private boolean isIncreasingFromZero(
            int[] nums,
            int zeroIndex,
            int direction) {

        int arrayLength = nums.length;

        for (int expectedValue = 0;
             expectedValue < arrayLength;
             expectedValue++) {

            int currentIndex =
                (zeroIndex + expectedValue * direction + arrayLength)
                % arrayLength;

            if (nums[currentIndex] != expectedValue) {
                return false;
            }
        }

        return true;
    }
}
