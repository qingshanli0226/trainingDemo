package com.example.player.a1610aplayerdemo.net;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

class StringConvterterFactory extends Converter.Factory {
    //private static final MediaType MEDIA_TYPE = MediaType.parse("text/plain");

    public static StringConvterterFactory create() {
        return new StringConvterterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (String.class.equals(type)) {
            return new Converter<ResponseBody, String>() {
                @Override
                public String convert(ResponseBody value) throws IOException {
                    return value.string();
                }
            };
        }
        return null;
    }
}