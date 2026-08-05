class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        long currentSum = 0;
        long maxSum = 0;

        // Build the first window
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Check the first window
        if (map.size() == k) {
            maxSum = currentSum;
        }

        // Slide the window
        for (int right = k; right < nums.length; right++) {

            // Add new element
            currentSum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // Remove old element
            int leftElement = nums[right - k];
            currentSum -= leftElement;

            if (map.get(leftElement) == 1) {
                map.remove(leftElement);
            } else {
                map.put(leftElement, map.get(leftElement) - 1);
            }

            // Check if current window has all distinct elements
            if (map.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}