package www.technovimal.com.webapi.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by vimalcvs on 10/01/2021.
 */
public class SecondData {

    @SerializedName("author")
    @Expose
    private String english;
    public String getEnglish() {
        return english;
    }

    @SerializedName("width")
    @Expose
    private String hindi;
    public String getHindi() {
        return hindi;
    }
}
