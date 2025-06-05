//このクラスは、ユーザーのID、ユーザー名、パスワード、作成日時などの情報を保持します
package com.example.music_management.entity;
//@Data、LocalDateTimeクラスをインポートします
 import lombok.Data;
 import java.time.LocalDateTime;

 //このアノテーションは、getter、setter、toString、equals、hashCodeメソッドを自動生成します
 @Data
public class User {
    //userId,username,password,createdAtフィールドを定義
    private long userId;
    private String username;
    private String password;
    private LocalDateTime createdAt;
    
}
