package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseListModel {

    private int page;
    @JsonProperty("per_page")
    private int perPage;
    private int total;
    @JsonProperty("total_pages")
    private int totalPages;
    private UserModel[] data;
    private Support support;

    @Data
    public static class Support {
        private String url;
        private String text;
    }
}
