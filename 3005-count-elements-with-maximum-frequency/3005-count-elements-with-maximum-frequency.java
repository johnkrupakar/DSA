class Solution {
    public int maxFrequencyElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Calculate the frequency of each element
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find the maximum frequency
        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        // Count unique elements with the maximum frequency
        int count = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency == maxFrequency) {
                count++;
            }
        }

        return maxFrequency*count;
    }
}