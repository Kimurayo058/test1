//Albumの作成、読み取り、更新、削除（CRUD）操作を処理する。
//また、アルバムに関連する音楽（Music）の操作も処理します

package com.example.music_management.controller;

 //AlbumServiceとMusicServiceをインポートし使用する
 //@GetMapping, @PostMapping, @RequestMappingなどのアノテーションを使用
    import com.example.music_management.entity.Album;
    import com.example.music_management.service.AlbumService;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import com.example.music_management.form.AlbumForm;
    import org.springframework.web.bind.annotation.PostMapping;
    import com.example.music_management.entity.Music;
    import com.example.music_management.service.MusicService;
    import com.example.music_management.form.MusicForm;
    import com.example.music_management.viewmodel.AlbumViewModel;
    

    import java.util.List;


    ///////

    @Controller
    @RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;
    private final MusicService musicService;

     public AlbumController(AlbumService albumService,MusicService musicService) {
       this.albumService = albumService;
       this.musicService = musicService;
    }
    //albumsメソッド　AlbumServiceを使用してすべてのアルバムを取得し、AlbumViewModelのリストをモデルに追加して、album/album-listビューを返します
     @GetMapping
   public String albums(Model model) {
       List<AlbumViewModel> albums = albumService.getAllAlbumsWithMusicCount();
       model.addAttribute("albums", albums);
       return "album/album-list";
   }
   //albumFormメソッド　空のAlbumFormオブジェクトを作成し、モデルに追加して、album/album-formビューを返します
    @GetMapping("/new")
   public String albumForm(Model model) {
       AlbumForm albumForm = new AlbumForm();
       model.addAttribute("albumForm", albumForm);
       return "album/album-form";
   }
   //createAlbumメソッド　AlbumServiceを使用して新しいアルバムを作成し、/albumsにリダイレクトします
    @PostMapping("/new")
   public String createAlbum(AlbumForm albumForm) {//, Model model) {
       albumService.createAlbum(albumForm);
       return "redirect:/albums";
   }

    //album(@PathVariable long albumId, Model model)　指定されたIDのアルバムの詳細を表示します
    @GetMapping("/{albumId}")
    public String album(@PathVariable long albumId, Model model) {
         Album album = albumService.getAlbumById(albumId);
         List<Music> musics =musicService.getMusicsByAlbumId(albumId);
        model.addAttribute("album", album);
        model.addAttribute("musics", musics);
        return "album/album-detail";
    }

    //deleteAlbumメソッド　AlbumServiceを使用してアルバムを削除し、/albumsにリダイレクトします
     @PostMapping("/{albumId}/delete")
    public String deleteAlbum(@PathVariable long albumId) {
        albumService.deleteAlbum(albumId);
        return "redirect:/albums";
    }

    //editAlbum(@PathVariable long albumId, Model model)　AlbumServiceとMusicServiceを使用してアルバムと関連する音楽を取得し、モデルに追加して、album/album-editビューを返します
     @GetMapping("/{albumId}/edit")
    public String editAlbum(@PathVariable long albumId, Model model) {
        Album album = albumService.getAlbumById(albumId);
        List<Music> musics = musicService.getMusicsByAlbumId(albumId);
        model.addAttribute("album", album);
        model.addAttribute("musics", musics);
        return "album/album-edit";
    }

    //updateAlbum(@PathVariable long albumId, Album album)　AlbumServiceを使用してアルバムを更新し、/albumsにリダイレクトします
     @PostMapping("/{albumId}/edit")
    public String updateAlbum(@PathVariable long albumId, Album album) {
        albumService.updateAlbum(albumId, album);
        return "redirect:/albums";
    }

    //createMusicForm(@PathVariable long albumId, Model model)　空のMusicFormオブジェクトを作成し、アルバムIDを設定してモデルに追加し、music/music-formビューを返します
    @GetMapping("/{albumId}/musics/new")
    public String createMusicForm(@PathVariable long albumId, Model model) {
    MusicForm musicForm = new MusicForm();
    musicForm.setAlbumId(albumId);
    model.addAttribute("musicForm", musicForm);
    return "music/music-form";
    }

    //createMusic(@PathVariable long albumId, MusicForm musicForm)　MusicServiceを使用して新しい音楽を作成し、/albums/{albumId}にリダイレクトします
    @PostMapping("/{albumId}/musics/new")
    public String createMusic(@PathVariable long albumId, MusicForm musicForm) {
    musicService.createMusic(musicForm);
    return "redirect:/albums/" + albumId;
    }

    //deleteMusic(@PathVariable long albumId, @PathVariable long musicId)　MusicServiceを使用して音楽を削除し、/albums/{albumId}にリダイレクトします
    @PostMapping("/{albumId}/musics/{musicId}/delete")
    public String deleteMusic(@PathVariable long albumId, @PathVariable long musicId) {
    musicService.deleteMusic(musicId);
    return "redirect:/albums/" + albumId;
    }

    //editMusic(@PathVariable long albumId, @PathVariable long musicId, Model model)　MusicServiceを使用して音楽を取得し、モデルに追加して、music/music-editビューを返します
    @GetMapping("/{albumId}/musics/{musicId}/edit")
    public String editMusic(@PathVariable long albumId, @PathVariable long musicId, Model model) {
    Music music = musicService.getMusicById(musicId);
    model.addAttribute("music", music);
    return "music/music-edit";
    }

    //updateMusic(@PathVariable long albumId, @PathVariable long musicId, Music music) MusicServiceを使用して音楽を更新し、/albums/{albumId}にリダイレクトします
    @PostMapping("/{albumId}/musics/{musicId}/edit")
    public String updateMusic(@PathVariable long albumId, @PathVariable long musicId, Music music) {
    musicService.updateMusic(musicId, music);
    return "redirect:/albums/" + albumId;
    }

}
