class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] left = new int[26];
        int[] right = new int[26];

        Arrays.fill(left, n);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            left[c] = Math.min(left[c], i);
            right[c] = i;
        }

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        for (int i = 0; i < n; i++) {

            if (i != left[s.charAt(i) - 'a'])
                continue;

            int end = getRight(s, i, left, right);

            if (end == -1)
                continue;

            if (i > prevEnd) {
                ans.add(s.substring(i, end + 1));
            } else {
                ans.set(ans.size() - 1, s.substring(i, end + 1));
            }

            prevEnd = end;
        }

        return ans;
    }

    private int getRight(String s, int start, int[] left, int[] right) {

        int end = right[s.charAt(start) - 'a'];

        for (int i = start; i <= end; i++) {

            int c = s.charAt(i) - 'a';

            if (left[c] < start)
                return -1;

            end = Math.max(end, right[c]);
        }

        return end;
    }
}