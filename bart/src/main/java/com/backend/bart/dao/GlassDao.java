package com.backend.bart.dao;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface GlassDao {
    @Bean
    Map<String, ArrayList<List>> getGlass(Long qi, Long id);
}
