//このクラスは、音楽エンティティ（Music）のデータベース操作を処理するリポジトリクラスとして機能します。MusicMapperを使用してデータベース操作を行います
package com.example.music_management.repository;
//インポート
 import com.example.music_management.entity.Music;
 import com.example.music_management.mapper.MusicMapper;
 import org.springframework.stereotype.Repository;
//Listをインポート
 import java.util.List;

 //このアノテーションは、このクラスがSpringのデータアクセスオブジェクト（DAO）として機能することを示します
 @Repository
 public class MusicRepository{
   //MusicMapperのフィールド
   private final MusicMapper musicMapper;
      //MusicRepositoryのコンストラクタ
      public MusicRepository(MusicMapper musicMapper) {
         this.musicMapper =musicMapper;
      }
      //指定されたアルバムIDに関連するすべての音楽を取得する
      public List<Music> getMusicsByAlbumId(long albumId) {
         return musicMapper.selectMusicsById(albumId);
      }
      //新しい音楽を挿入する
      public void insertMusic(Music music) {
         musicMapper.insertMusic(music);
      }
      //指定されたIDの音楽を削除する
      public void deleteMusicById(long musicId) {
         musicMapper.deleteMusicById(musicId);
      }
      //指定されたIDの音楽を更新する
      public void updateMusic(Music music) {
         musicMapper.updateMusic(music);
      }
      //指定されたIDの音楽を取得する
      public Music selectMusicById(long musicId) {
         return musicMapper.selectMusicById(musicId);
      }

}