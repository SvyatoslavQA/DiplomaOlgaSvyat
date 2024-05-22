package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Run {
        private int id;

        @SerializedName(value = "project_id")
        @JsonProperty("project_id")
        private int projectID;

        private String name;

        @SerializedName(value = "is_completed")
        @JsonProperty("is_completed")
        private boolean iScompleted;
}
