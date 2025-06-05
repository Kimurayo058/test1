//このクラスは、アルバムエンティティ（Album）のビジネスロジックを処理するサービスクラスとして機能します。AlbumRepositoryを使用してデータベース操作を行います。
package com.example.music_management.service;
//インポート
 import com.example.music_management.repository.AlbumRepository;
 import com.example.music_management.entity.Album;
 import org.springframework.stereotype.Service;
 import com.example.music_management.form.AlbumForm;
 import com.example.music_management.viewmodel.AlbumViewModel;
//Listをインポート
 import java.util.List;

 //このアノテーションは、このクラスがSpringのサービス Bean として機能することを示します
 @Service
public class AlbumService {
    //AlbumRepositoryのフィールド
    private final AlbumRepository albumRepository;
      //AlbumServiceのコンストラクタ
      public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
      }
      //すべてのアルバムを取得する
      public List<Album> getAllAlbums() {
        return albumRepository.getAllAlbums();
      }
      //新しいアルバムを作成する
      public void createAlbum(AlbumForm albumForm) {
        Album album = new Album();
        album.setTitle(albumForm.getTitle());
        album.setArtist(albumForm.getArtist());
        album.setReleaseDate(albumForm.getReleaseDate());
        albumRepository.insertAlbum(album);
      }
      //指定されたIDのアルバムを取得する
      public Album getAlbumById(long albumId) {
        return albumRepository.getAlbumById(albumId);
      }
      //指定されたIDのアルバムを削除する
      public void deleteAlbum(long albumId) {
        albumRepository.deleteAlbum(albumId);
      }
      // 指定されたIDのアルバムを更新する
      public void updateAlbum(long albumId, Album album) {
        if (albumId != album.getAlbumId()) {
          throw new IllegalArgumentException("Album ID does not match");
        }
        albumRepository.updateAlbum(album);
      }
      //すべてのアルバムと関連する音楽の数を取得する
      public List<AlbumViewModel> getAllAlbumsWithMusicCount() {
        return albumRepository.getAllAlbumsWithMusicCount();
      }

}
