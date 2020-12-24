package models;

import lombok.Data;

@Data
public class Fact {
    private Status status;
    private String type;
    private boolean deleted;
    private String _id;
    private String user;
    private String text;
    private int __v;
    private String source;
    private String updatedAt;
    private String createdAt;
    private boolean used;

}

@Data
class Status {
    private boolean verified;
    private int sentCount;
    private String feedback;

}
