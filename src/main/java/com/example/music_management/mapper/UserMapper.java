//ユーザーの作成、読み取り（ユーザー名による検索）操作を定義します。
package com.example.music_management.mapper;
    //entity.Albumをインポート
    import com.example.music_management.entity.User;
    //Insert,Mapper,Options,Selectをインポート
    import org.apache.ibatis.annotations.Insert;
    import org.apache.ibatis.annotations.Mapper;
    import org.apache.ibatis.annotations.Options;
    import org.apache.ibatis.annotations.Select;

    //このインターフェースがMyBatisのMapperであることを示します。
 @Mapper
 public interface UserMapper {
        //指定されたユーザー名のユーザーを取得するメソッドを定義
        @Select("SELECT user_id, username, password, created_at FROM users WHERE username = #{username}")
        User selectUserByUsername(String username);
        //新しいユーザーを挿入するメソッドを定義 @Optionsアノテーションを使用して生成されたキーをuserIdに設定します。
        @Insert("INSERT INTO users (username, password) VALUES (#{username}, #{password})")
        @Options(useGeneratedKeys = true, keyProperty = "userId")
        void insertUser(User user);

}
