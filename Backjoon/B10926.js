const fs = require('fs');
const input= fs.readFileSync('input.txt').toString().trim();
//확인할 떄는 input.txt에 입력을 넣어서 터미널 창에 나오는 값으로 값을 확인
//제출할 때는 /dev/stdin으로 수정해서 제출하기
console.log(`${input}??!`);
