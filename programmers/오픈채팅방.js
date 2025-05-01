function solution(record){
  const nicknameMap={};
  const action=[];
  
  record.forEach(line => {
      const [cmd, uid, nickname] = line.split(' ');
      if(cmd==='Enter' || cmd === 'Change'){
          nicknameMap[uid]=nickname;
      }
      if(cmd==='Enter'){
          action.push({uid, msg:'님이 들어왔습니다.'});
      } else if(cmd==='Leave'){
          action.push({uid, msg:'님이 나갔습니다.'});
      }
  });
  return action.map(action=> `${nicknameMap[action.uid]}${action.msg}`);
}