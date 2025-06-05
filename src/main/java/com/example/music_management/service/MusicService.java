//このクラスは、音楽エンティティ（Music）のビジネスロジックを処理するサービスクラスとして機能します。MusicRepositoryを使用してデータベース操作を行います。
package com.example.music_management.service;
//インポート
 import com.example.music_management.entity.Music;
 import com.example.music_management.repository.MusicRepository;
 import org.springframework.stereotype.Service;
 import com.example.music_management.form.MusicForm;
//Listをインポート
 import java.util.List;
//
 @Service
public class MusicService{
    //MusicRepositoryフィールド
    private final MusicRepository musicRepository;
    //MusicServiceコンストラクタ
    public MusicService(MusicRepository musicRepository) {
    this.musicRepository =musicRepository;
    }
        // 指定されたアルバムIDに関連するすべての音楽を取得する
        public List<Music> getMusicsByAlbumId(long albumId) {
        return musicRepository.getMusicsByAlbumId(albumId);
        }
        //新しい音楽を作成する
        public void createMusic(MusicForm musicForm) {
        Music music = new Music();
        music.setTitle(musicForm.getTitle());
        music.setDuration(musicForm.getDuration());
        music.setAlbumId(musicForm.getAlbumId());
        musicRepository.insertMusic(music);
        }
        //指定されたIDの音楽を削除する
        public void deleteMusic(long musicId) {
        musicRepository.deleteMusicById(musicId);
        }
        //指定されたIDの音楽を取得する
        public Music getMusicById(long musicId) {
        return musicRepository.selectMusicById(musicId);
        }
        //指定されたIDの音楽を更新する
        public void updateMusic(long musicId, Music music) {
        if(musicId !=music.getMusicId()) {
        throw new IllegalArgumentException("Music ID does not match");
        }
        musicRepository.updateMusic(music);
        }

}
 