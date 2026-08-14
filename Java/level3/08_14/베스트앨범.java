import java.util.*;

class Solution {

    static class Song {
      int id;
      int plays;

      Song(int id, int plays){
        this.id=id;
        this.plays=plays;
      }
    }

    public int[] solution(String[] genres, int[] plays) {

        //1. 속한 노래가 많이 재생된 장르 먼저 수록
        //2. 장르내에서 많이 재생된 노래 먼저 수록
        //3. 장르 내에서 재생 횟수가 같은 노래 중에서 고유 번호가 낮은 노래 먼저 수록

        //장르별 총 재생 횟수
        Map<String, Integer>genreAll = new HashMap<>();
        //장르별 노래 목록
        Map<String, List<Song>> genreSong = new HashMap<>();

        //1. 장르별 총 재생 횟수
        for(int i=0; i<genres.length; i++){
          genreAll.put(genres[i], genreAll.getOrDefault(genres[i], 0)+plays[i]);
  
          genreSong.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }

        //2. 장르를 총 재생 횟수가 많은 순서로 정렬
        List<String> genreList = new ArrayList<>(genreAll.keySet());

        genreList.sort((a,b)-> Integer.compare(genreAll.get(b), genreAll.get(a)));

        //결과를 담을 list
        List<Integer> answer = new ArrayList<>();

        //3. 장르별로 노래 정렬 후 최대 2곡 선택
        for(String genre : genreList){
          List<Song> songs = genreSong.get(genre);

          //재생 횟수 내림차순
          //재생 횟수 같으면 고유 번호 오름차순
          songs.sort((a,b)->{
            if(a.plays != b.plays){
              return Integer.compare(b.plays, a.plays);
            }
            return Integer.compare(b.plays, a.plays);
          });

          //최대 2곡
          for(int i=0;i <Math.min(2, songs.size()); i++){
            answer.add(songs.get(i).id);
          }
        }

        //List<Integer -> int[]
        int [] result = new int[answer.size()];

        for(int i=0; i<answer.size(); i++){
          result[i]=answer.get(i);
        }

        return result;
    }
}