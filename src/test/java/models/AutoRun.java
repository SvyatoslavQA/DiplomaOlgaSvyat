package models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AutoRun {

    @SerializedName(value = "name")
    private String autoRunName;

    @SerializedName(value = "source")
    private String sourceName;
}
