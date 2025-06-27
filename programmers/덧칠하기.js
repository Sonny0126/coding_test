//최소 롤러 횟수를 알려줌
//n은 총 길이, m은 롤러 길이
//section은 총 칠해야 할 부분
//최소 사용 횟수 구하기
function solution(n, m, sections) {
  let ans = 0;
  let painted = 0; //현재까지 롤러롤 칠한 마지막 위치
  for (let section of sections) {
    //section은 이번에 칠해야 하는 위치
    if (painted < section) {
      //아직 안 칠해졌으면 롤러를 새로 시작
      ans++;
      painted = section + m - 1;
    }
  }
  return ans;
}
