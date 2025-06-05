// このクラスは、アルバムのタイトル、アーティスト、リリース日などの情報を保持します。
package com.example.music_management.form;
//@Data, LocalDateクラスをインポートします。
 import lombok.Data;
 import java.time.LocalDate;
 //@Dataアノテーションを使用して、getter、setter、toString、equals、hashCodeメソッドを自動生成します
 @Data
 public class AlbumForm {
  //title,artist,releaseDateフィールドを定義
   private String title;
   private String artist;
   private LocalDate releaseDate;

 }