//このクラスは、アルバムのID、タイトル、アーティスト、リリース日、関連する音楽の数などの情報を保持します
package com.example.music_management.viewmodel;
//インポート
import lombok.Data;
import java.time.LocalDate;
//このアノテーションは、getter、setter、toString、equals、hashCodeメソッドを自動生成します
@Data
public class AlbumViewModel {
    //フィールド
    private long albumId;
    private String title;
    private String artist;
    private LocalDate releaseDate;
    private int musicCount;
        
}
