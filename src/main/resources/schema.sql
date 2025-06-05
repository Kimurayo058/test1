-- albumsテーブルの作成
CREATE TABLE albums (
  -- アルバムID（自動増分、主キー）
   album_id INTEGER AUTO_INCREMENT PRIMARY KEY,
   -- タイトル（最大255文字、NULL不可）
   title VARCHAR(255) NOT NULL,
   -- アーティスト（最大255文字）
   artist VARCHAR(255) ,
   -- リリース日（日付型）
   release_date DATE,
   -- 作成日時（デフォルトで現在のタイムスタンプ）
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
 );

 -- musicsテーブルの作成
 CREATE TABLE musics (
  -- 音楽ID（自動増分、主キー）
   music_id INTEGER AUTO_INCREMENT PRIMARY KEY,
   -- タイトル（最大255文字、NULL不可）
   title VARCHAR(255) NOT NULL,
   -- デュレーション（時間型）
   duration TIME,
   -- アルバムID（外部キー、NULL不可）
   album_id INTEGER NOT NULL,
   -- 作成日時（デフォルトで現在のタイムスタンプ）
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   -- albumsテーブルのalbum_idを参照する外部キー制約（カスケード削除)
   FOREIGN KEY (album_id) REFERENCES albums(album_id) ON DELETE CASCADE
 );

 -- usersテーブルの作成
 CREATE TABLE users (
  -- ユーザーID（自動増分、主キー）
  user_id INTEGER AUTO_INCREMENT PRIMARY KEY,
  -- ユーザー名（最大255文字、ユニーク、NULL不可）
  username VARCHAR(255) UNIQUE NOT NULL,
  -- パスワード（最大60文字、NULL不可）
  password VARCHAR(60) NOT NULL,
  -- 作成日時（デフォルトで現在のタイムスタンプ）
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
 );
  