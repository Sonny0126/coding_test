class Solution {
    public int solution(int[] a) {
        int n = a.length;
        if (n <= 2) return n; // 풍선이 1개 또는 2개면 모두 남길 수 있음

        //최종으로 3개 남은 경우 X가 양쪽 최소값보다 모두 크면, 작은 값을 없애는 것은 한번 가능한데 두번써야 하므로 이는 불가능하기에 이 조건을 피하면서 조건을 만족시키면 된다

        // 1. 왼쪽에서의 최솟값 배열 구하기
        int[] leftMin = new int[n];
        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        // 2. 오른쪽에서의 최솟값 배열 구하기
        int[] rightMin = new int[n];
        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        // 3. 각 풍선이 살아남을 수 있는지 검사
        int answer = 0;
        for (int i = 0; i < n; i++) {
            // 왼쪽 최솟값보다 작거나, 오른쪽 최솟값보다 작으면 생존 가능
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }

        return answer;
    }
}