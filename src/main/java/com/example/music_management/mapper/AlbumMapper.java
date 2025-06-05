//このインターフェースは、アルバムエンティティ（Album）のデータベース操作を定義するマッピングインターフェースとして機能します。MyBatisの注釈を使用してSQLクエリを定義します
//アルバムの作成、読み取り、更新、削除（CRUD）操作を定義します。
//アルバムと関連する音楽の数を取得する複合クエリを定義します。
package com.example.music_management.mapper;

//entity.Albumをインポート
import com.example.music_management.entity.Album;

//Delate,Insert,Mapper,Options,Select,Update,AlbumViewModelをインポート
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.music_management.viewmodel.AlbumViewModel;

//Listをインポート
import java.util.List;

//このインターフェースがMyBatisのMapperであることを示します。
@Mapper
public interface AlbumMapper {

    //すべてのアルバムを取得します
    @Select("SELECT * FROM albums")
   List<Album> selectAllAlbums();

        //新しいアルバムを挿入します、()内がSQL、戻り値はvoid
        @Insert("INSERT INTO albums (title, artist, release_date) VALUES (#{title}, #{artist}, #{releaseDate})")
        @Options(useGeneratedKeys = true, keyProperty = "albumId")
        void insertAlbum(Album album);

        //指定されたIDのアルバムを取得します
        @Select("SELECT * FROM albums WHERE album_id = #{albumId}")
        Album selectAlbumById(long albumId);

        //指定されたIDのアルバムを削除します
        @Delete("DELETE FROM albums WHERE album_id = #{albumId}")
        void deleteAlbumById(long albumId);

        //指定されたIDのアルバムを更新します
        @Update("UPDATE albums SET title = #{title}, artist = #{artist}, release_date = #{releaseDate} WHERE album_id = #{albumId}")
        void updateAlbum(Album album);

        //すべてのアルバムと関連する音楽の数を取得します
        @Select("""
            SELECT albums.album_id, albums.title, artist, release_date, count(musics.music_id) AS music_count
            FROM albums
            LEFT OUTER JOIN musics ON albums.album_id = musics.album_id
            GROUP BY albums.album_id, albums.title, artist, release_date
            """)    
            //すべてのアルバムと関連する音楽の数を取得するメソッドを定義します 
        public List<AlbumViewModel> selectAllAlbumsWithMusicCount();
} 

