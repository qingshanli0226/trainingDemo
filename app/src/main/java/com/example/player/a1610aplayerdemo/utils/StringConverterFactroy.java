package com.example.player.a1610aplayerdemo.utils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by Lmz on 2019/06/14
 *  创建数据重构工具类
 */
public class StringConverterFactroy extends Converter.Factory{

        public static StringConverterFactroy onCreate(){
            return  new StringConverterFactroy();
        }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            if (String.class.equals(type)){
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
