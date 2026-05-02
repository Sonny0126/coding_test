function solution(friends, gifts) {
  const len = frineds.length;
  const NameMap = new Map();
  const giftTable = new Array(len).fill(0).map((_) => new Array(len).fill(0));
  const rankInfo = new Array(len).fill(0);
  const nextMonth = new Array(len).fill(0);

  //친구들 이름 저장
  frineds.forEach((name, idx) => {
    NameMap.set(name, idx);
  });

  //주고 받은거 저장
  gifts.forEach((info) => {
    const [from, to] = info.split(" ");
    giftTable[NameMap.get(from)][NameMap.get(to)]++;
  });

  //선물 지수 저장
  for (let i = 0; i < len; i++) {
    rankInfo[i] = giftTable[i].reduce((acc, cur) => (acc += cur), 0);
    for (let j = 0; j < len; j++) {
      rankInfo[i] -= giftTable[j][i]; //모든 친구 j가 나 i에게 준 선물 총합합
    }
  }

  for (let i = 0; i < len; i++) {
    for (let j = i + 1; j < len; j++) {
      if (i === j) continue;
      if (giftTable[i][j] > giftTable[j][i]) nextMonth[i]++;
      if (giftTable[i][j] < giftTable[j][i]) nextMonth[j]++;
      if (giftTable[i][j] === giftTable[j][i]) {
        if (rankInfo[i] > rankInfo[j]) nextMonth[i]++;
        if (rankInfo[i] < rankInfo[j]) nextMonth[j]++;
      }
    }
  }

  return Math.max(...nextMonth);
}
