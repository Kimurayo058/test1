//このクラスは、ユーザーエンティティ（User）のデータベース操作を処理するリポジトリクラスとして機能します。UserMapperを使用してデータベース操作を行います
package com.example.music_management.repository;
//インポート
 import com.example.music_management.entity.User;
 import com.example.music_management.mapper.UserMapper;
 import org.springframework.stereotype.Repository;

 //このアノテーションは、このクラスがSpringのデータアクセスオブジェクト（DAO）として機能することを示します
@Repository
public class UserRepository {
    //UserMapperのフィールド
    private final UserMapper userMapper;
        //UserMapperのコンストラクタ
        public UserRepository(UserMapper userMapper) {
            this.userMapper = userMapper;
        }
        //指定されたユーザー名のユーザーを取得する
        public User selectUserByUsername(String username) {
            return userMapper.selectUserByUsername(username);
        }
        //新しいユーザーを挿入する
        public void insertUser(User user) {
            userMapper.insertUser(user);
        }

}
