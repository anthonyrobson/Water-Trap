public class WaterTrap {
    public static void main(String[] args) {
        // int[] heights = {1,5,3,7,2};
        int[] heights = new int[args.length];
        for (int j = 0; j < heights.length; j++) {
            heights[j] = Integer.parseInt(args[j]);
        }

        int[] maxHeights = new int[heights.length];
        for (int k = 0; k < maxHeights.length; k++) {
            maxHeights[k] = eitherMax(heights, k) - heights[k];
            if (maxHeights[k] < 0) maxHeights[k] = 0;
        }

        System.out.println(sumArray(maxHeights));
    }
    // find minimum of maxLeft and maxRight
    public static int eitherMax(int[] xs, int pos) {
        int min = Math.min(maxLeft(xs, pos), maxRight(xs, pos));
        return min;
    }

    // find max on left of position
    public static int maxLeft(int[] xs, int pos) {
        if (pos == 0) return 0;
        int max = xs[pos - 1];
        for (int i = pos - 1; i >= 0; i--) {
            if (xs[i] > max)
                max = xs[i];
        }
        return max;
    }

    // find max on right of position
    public static int maxRight(int[] xs, int pos) {
        if (pos == xs.length) return 0;
        int max = 0;
        for (int i = pos + 1; i < xs.length; i++) {
            if (xs[i] > max)
                max = xs[i];
        }
        return max;
    }

    // sum an array
    public static int sumArray(int[] xs) {
        int sum = 0;
        for (int i = 0; i < xs.length; i++) {
            sum += xs[i];
        }
        return sum;
    }
}
