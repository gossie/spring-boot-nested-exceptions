package com.github.gossie.nestedtransactions;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MediaService {

    private final MovieService movieService;
    private final SongService songService;

    public MediaService(MovieService movieService, SongService songService) {
        this.movieService = movieService;
        this.songService = songService;
    }

    @Transactional
    public void createBoth(String movieName, String songName) {
        movieService.createMovie(movieName);
        songService.createSong(songName);
    }

}
