function solution(players, callings) {
    //처음에 선수들로 나열되있는데, callings가 불리면 자기앞에 선수와 바로 교체
    const playerIdx={};
    players.forEach((name, idx)=>{
        playerIdx[name]=idx;
    });
    
    for(let i=0; i<callings.length; i++){
        const called = callings[i];
        const idx = playerIdx[called];
        
        //called 선수가 자기 앞사람과 바꾸기
        const temp = players[idx-1];
        players[idx-1]=players[idx];
        players[idx]=temp;
        
        playerIdx[called]--;
        playerIdx[temp]++;
    }
    return players;
}