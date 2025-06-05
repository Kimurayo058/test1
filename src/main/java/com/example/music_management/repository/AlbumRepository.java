//このクラスは、アルバムエンティティ（Album）のデータベース操作を処理するリポジトリクラスとして機能します。AlbumMapperを使用してデータベース操作を行います
package com.example.music_management.repository;
//インポート
 import com.example.music_management.mapper.AlbumMapper;
 import com.example.music_management.entity.Album;
 import org.springframework.stereotype.Repository;
 import com.example.music_management.viewmodel.AlbumViewModel;

//Listをインポート
 import java.util.List;

 //このアノテーションは、このクラスがSpringのデータアクセスオブジェクト（DAO）として機能することを示します
 @Repository
public class AlbumRepository {
    //AlbumMapperのフィールド
    private final AlbumMapper albumMapper;
    //AlbumMapperのコンストラクタ
    public AlbumRepository(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }
    //すべてのアルバムを取得
    public List<Album> getAllAlbums() {
        return albumMapper.selectAllAlbums();
    }
    //新しいアルバムを挿入する
    public void insertAlbum(Album album) {
        albumMapper.insertAlbum(album);
    }
    //指定されたIDのアルバムを取得する
    public Album getAlbumById(long albumId) {
        return albumMapper.selectAlbumById(albumId);
    }
    //指定されたIDのアルバムを削除する
    public void deleteAlbum(long albumId) {
        albumMapper.deleteAlbumById(albumId);
    }
    //指定されたIDのアルバムを更新する
    public void updateAlbum(Album album) {
        albumMapper.updateAlbum(album);
    }
    //すべてのアルバムと関連する音楽の数を取得する
    public List<AlbumViewModel> getAllAlbumsWithMusicCount() {
        return albumMapper.selectAllAlbumsWithMusicCount();
    }

}
