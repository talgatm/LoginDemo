package kg.shtraf.logindemo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeList {

    @SerializedName("result")
    @Expose
    private List<Result> result = null;
    @SerializedName("number")
    @Expose
    private String number;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}