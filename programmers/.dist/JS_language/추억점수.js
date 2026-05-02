function solution(name, yearning, photo) {
  // 이름과 점수를 객체 배열로 묶기
  let nameyear = [];
  for (let i = 0; i < name.length; i++) {
    nameyear.push({ name: name[i], year: yearning[i] });
  }

  let result = [];

  for (let p of photo) {
    let sum = 0;
    for (let person of p) {
      // nameyear 배열에서 해당 이름 찾기
      let found = nameyear.find((ny) => ny.name === person);
      if (found) {
        sum += found.year;
      }
    }
    result.push(sum);
  }

  return result;
}
