package id.resurrect.androidchallenge.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yoga Agung Kurnia on 3/17/2018.
 */

public abstract class Client {
    private static String BASE_URL = "https://api.github.com/";

    private static Retrofit retrofit;

    public static Retrofit getClient(){
       if(retrofit==null){
           retrofit = new Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
       }
       return retrofit;
    }
}
