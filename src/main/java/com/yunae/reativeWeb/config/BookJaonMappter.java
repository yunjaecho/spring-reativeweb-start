package com.yunae.reativeWeb.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.yunae.reativeWeb.entity.Book;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * Response json Serialize 변환 작업 가능
 */
@JsonComponent
public class BookJaonMappter {

    public static class BookSerializer extends JsonSerializer<Book> {

        @Override
        public void serialize(Book book, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("isbn", book.getIsbn());
            jsonGenerator.writeEndObject();
        }
    }
}
