//このインターフェースは、音楽の作成、読み取り、更新、削除（CRUD）操作を定義します。
package com.example.music_management.mapper;
    //entity.Albumをインポート
    import com.example.music_management.entity.Music;
    //Mapper,Select,Insert,Options,Delete,Updateをインポート
    import org.apache.ibatis.annotations.Mapper;
    import org.apache.ibatis.annotations.Select;
    import org.apache.ibatis.annotations.Insert;
    import org.apache.ibatis.annotations.Options;
    import org.apache.ibatis.annotations.Delete;
    import org.apache.ibatis.annotations.Update;
    //Listをインポート
    import java.util.List;

    //このインターフェースがMyBatisのMapperであることを示します。
@Mapper
public interface MusicMapper {

    //指定されたアルバムIDに関連するすべての音楽を取得するメソッドを定義
    @Select("SELECT * FROM musics WHERE album_id = #{albumId}")
    List<Music> selectMusicsById(long album_id);
    //新しい音楽を挿入するメソッドを定義します。@Optionsアノテーションを使用して生成されたkeyをmusicIdに設定します。
    @Insert("INSERT INTO musics (title, duration, album_id) VALUES (#{title}, #{duration}, #{albumId})")
    @Options(useGeneratedKeys=true, keyProperty="musicId")
    void insertMusic(Music music);
    //指定されたIDの音楽を削除するメソッドを定義
    @Delete("DELETE FROM musics WHERE music_id = #{musicId}")
    void deleteMusicById(long musicId);
    //指定されたIDの音楽を更新するメソッドを定義
    @Update("UPDATE musics SET title = #{title}, duration = #{duration} WHERE music_id = #{musicId}")
    void updateMusic(Music music);
    //指定されたIDの音楽を取得するメソッドを定義
    @Select("SELECT * FROM musics WHERE music_id = #{musicId}")
    Music selectMusicById(long musicId);

}
