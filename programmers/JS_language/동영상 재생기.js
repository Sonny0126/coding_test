function solution(video_len, pos, op_start, op_end, commands) {
  //prev 10초 전 이동
  //next 10초 후 이동
  //동영상 길이 video_len, 재생위치 pos,
  //시작시간 op_start, 종료시간 op_end

  const [vmin, vsec] = video_len.split(":").map(Number);
  let vTime = vmin * 60 + vsec;

  const [min, sec] = pos.split(":").map(Number);

  let realTime = min * 60 + sec;

  const [start_min, start_sec] = op_start.split(":").map(Number);
  const [end_min, end_sec] = op_end.split(":").map(Number);

  const realStart = start_min * 60 + start_sec;
  const realEnd = end_min * 60 + end_sec;

  //오프닝 사이인 경우
  if (realTime >= realStart && realTime <= realEnd) {
    realTime = realEnd;
  }

  for (let i of commands) {
    // prev
    if (i === "prev") realTime = Math.max(0, realTime - 10);
    // next
    if (i === "next") realTime = Math.min(vTime, realTime + 10);

    //오프닝 사이인 경우 재확인인
    if (realTime >= realStart && realTime <= realEnd) {
      realTime = realEnd;
    }
  }

  let changeMin = Math.floor(realTime / 60);
  let changeSec = realTime % 60;

  // 두 자리 문자열로 포맷 (선택)
  changeMin = String(changeMin).padStart(2, "0");
  changeSec = String(changeSec).padStart(2, "0");

  return [changeMin, changeSec].join(":");
}
