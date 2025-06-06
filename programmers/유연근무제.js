function solution(scheduels, timelogs, startday) {
  //시간 계산
  function calcTime(time) {
    let hour = Math.floor(time / 100);
    let minnute = time % 100;
    return hour * 60 + minnute;
  }

  //개수 체크
  let cnt = 0;

  //체크 알고리즘
  for (let i = 0; i < scheduels.length; i++) {
    let allowTime = calcTime(scheduels[i] + 10);
    let isSafe = true;

    //시작날짜를 기준으로 계산
    for (let j = 0; j < 7; j++) {
      let curDay = ((startday + j - 1) % 7) + 1;

      if (curDay === 6 || curDay === 7) continue;

      let realTime = calcTime(timelogs[i][j]);

      if (realTime < allowTime) {
        isSafe = false;
        break;
      }
    }
    if (isSafe) cnt++;
  }

  return cnt;
}
