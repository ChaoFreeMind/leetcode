public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(k, n, 1, res, list);
        return res;
    }

    private void backtrack(int k, int target, int startNum, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == k) {
            if (target == 0) {
                res.add(new ArrayList(list));
            }
            return;
        }

        for (int i = startNum; i < 10; i++) {
            list.add(i);
            backtrack(k, target - i, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
}