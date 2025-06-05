//このクラスは、音楽のタイトル、再生時間、アルバムIDなどの情報を保持します
package com.example.music_management.form;
//@Data,LocalTimeクラスをインポートします
 import lombok.Data;
 import java.time.LocalTime;
 //このアノテーションは、getter、setter、toString、equals、hashCodeメソッドを自動生成します
 @Data
 public class MusicForm{
 //title,duration,albumIdフィールドを定義
 private String title;
 private LocalTime duration;
 private long albumId;

}