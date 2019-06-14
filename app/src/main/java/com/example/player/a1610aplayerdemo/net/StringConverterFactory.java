package com.example.player.a1610aplayerdemo.net;


import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by liqingshan on 2017/7/23.
 */

public class StringConverterFactory extends Converter.Factory {
	//private static final MediaType MEDIA_TYPE = MediaType.parse("text/plain");

    public static StringConverterFactory create() {
		return new StringConverterFactory();
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