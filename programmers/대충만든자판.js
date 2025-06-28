function solution(keymap, targets) {
    let ans = [];

    targets.map((target) => {
        let press = 0;
        for (let i = 0; i < target.length; i++) {
            let cnt = Infinity;
            keymap.map((key) => {
                const idx = key.indexOf(target[i]);
                if (idx > -1) cnt = Math.min(cnt, idx + 1);
            });
            if (cnt === Infinity) {
                // 현재 target은 만들 수 없음
                press = -1;
                break;
            }
            press += cnt;
        }
        ans.push(press);
    });

    return ans;
}
