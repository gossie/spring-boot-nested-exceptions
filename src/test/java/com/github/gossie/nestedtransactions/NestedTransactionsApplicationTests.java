package com.github.gossie.nestedtransactions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
class NestedTransactionsApplicationTests {

	@Autowired
	private MediaService mediaService;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private SongRepository songRepository;

	@Test
	void contextLoads() {
	    assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> mediaService.createBoth("Stirb langsam", "Don't stop believing"));

		assertThat(movieRepository.count()).isEqualTo(0L);
		assertThat(songRepository.count()).isEqualTo(0L);
	}

}
