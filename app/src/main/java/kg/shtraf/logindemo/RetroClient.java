package kg.shtraf.logindemo;

/**
 * Created by User on 25.04.2018.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import kg.shtraf.logindemo.ApiService;

public class RetroClient {

    private static final String ROOT_URL = "http://shtrafy.vhosts.pro/api/v1/getdata/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}