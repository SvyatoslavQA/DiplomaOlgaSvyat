package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;

    @EqualsAndHashCode.Exclude
    private int id;

    private String email;
    private int type;

    @SerializedName(value = "is_api")
    @JsonProperty("is_api")
    private boolean isApi;

    @SerializedName(value = "role_id")
    @JsonProperty("role_id")
    private int roleId;
}