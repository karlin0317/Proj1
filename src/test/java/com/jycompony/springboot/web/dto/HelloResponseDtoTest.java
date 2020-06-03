package com.jycompony.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void test_to_lombok_function() {
        //given
        String name = "name";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);


        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
