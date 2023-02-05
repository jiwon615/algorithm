package algorithm.search.brute_force.programmers;

public class L1_최소직사각형 {

    public static void main(String[] args) {
//        int[][] sizes = {{60, 50}, {30,70}, {60,30}, {80,40}};
//        int[][] sizes = {{10, 7}, {12,3}, {8,15}, {14,7}, {5, 15}};
        int[][] sizes = {{14, 4}, {19,6}, {6,16}, {18,7}, {7, 11}};
        int solution = solution(sizes);
        System.out.println(solution);
    }

    public static int solution(int[][] sizes) {
        int answer = 0;
        int idx = 0;
        int width = 0;
        int height = 1;
        for (int[] size : sizes) {
            if (size[width] > size[height]) {
                // 두 수 swap
                int temp = size[width];
                size[width] = size[height];
                size[height] = temp;
            }
            idx++;
        }

        // width의 max
        int widthMax = getMaxForTargetIdx(sizes, width);

        // height 의 max
        int heightMax = getMaxForTargetIdx(sizes, height);

        return widthMax * heightMax;
    }

    public static int getMaxForTargetIdx(int[][] sortedSizes, int targetIdx) {
        int max = sortedSizes[0][targetIdx];
        for (int i=0; i<sortedSizes.length; i++) {
            int target = sortedSizes[i][targetIdx];
            if (max < target) {
                max = target;
            }
        }
        return max;
    }
}
