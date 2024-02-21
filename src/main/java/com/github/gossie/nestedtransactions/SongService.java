package com.github.gossie.nestedtransactions;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Transactional
    public Song createSong(String name) {
        songRepository.save(new Song(null, name));
        throw new RuntimeException();
    }

}
