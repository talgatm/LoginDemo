package kg.shtraf.logindemo;

/**
 * Created by User on 25.04.2018.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import kg.shtraf.logindemo.EmployeeList;
import kg.shtraf.logindemo.CheckFine;

public interface ApiService {

    CheckFine checkfine = new CheckFine();

    @GET("checkfine.textFill.getText()")
    Call<EmployeeList> getMyJSON();
}