package com.mckz.modelocursos.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateConfig {
    public static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZER = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));

    /**
     * Configura e retorna uma instância personalizada de ObjectMapper para serialização e desserialização de objetos JSON.
     * Este método configura um ObjectMapper com suporte para serialização/desserialização de objetos Java com tipos relacionados
     * ao Java 8, como LocalDate, LocalDateTime e outros. Ele também define um módulo JavaTime para manipular tipos de data e hora do Java 8.
     *
     * @return Uma instância personalizada de ObjectMapper configurada com suporte a tipos de data e hora do Java 8.
     */
    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LOCAL_DATETIME_SERIALIZER);
        return new ObjectMapper().registerModule(module);
    }

}