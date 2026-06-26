class BinaryIndexedTree {
    int n;
    int[] bit;

    public BinaryIndexedTree(int n) {
        this.n = n;
        bit = new int[n + 2];
    }

    public void update(int idx, int val) {
        while (idx <= n) {
            bit[idx] += val;
            idx += idx & -idx;
        }
    }

    public int query(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= idx & -idx;
        }
        return sum;
    }
}

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        BinaryIndexedTree tree = new BinaryIndexedTree(2 * n + 2);

        int prefix = n + 1;     
        tree.update(prefix, 1);

        long ans = 0;

        for (int num : nums) {
            if (num == target)
                prefix++;
            else
                prefix--;

            ans += tree.query(prefix - 1);
            tree.update(prefix, 1);
        }

        return ans;
    }
}