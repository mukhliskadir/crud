package com.example.mosque;

import java.io.Serializable;

public class Topic implements Serializable {


    private static final long serialVersionUID = 1L;
    public int id;
    public String topicName;
    public String topicTheme;

    public Topic() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicTheme() {
        return topicTheme;
    }

    public void setTopicTheme(String topicTheme) {
        this.topicTheme = topicTheme;
    }
}