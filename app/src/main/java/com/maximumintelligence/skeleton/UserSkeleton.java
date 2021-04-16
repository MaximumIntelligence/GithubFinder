package com.maximumintelligence.skeleton;

import com.google.gson.annotations.SerializedName;

public class UserSkeleton {

    @SerializedName("login")
    private String login;

    @SerializedName("company")
    private String company;

    @SerializedName("location")
    private String location;

    @SerializedName("blog")
    private String blog;

    @SerializedName("twitter_username")
    private String twitter_username;


    public UserSkeleton(String login, String company, String location, String blog, String twitter_username) {
        this.login = login;
        this.company = company;
        this.location = location;
        this.blog = blog;
        this.twitter_username = twitter_username;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return blog;
    }

    public void setWebsite(String blog) {
        this.blog = blog;
    }

    public String getTwitter() {
        return twitter_username;
    }

    public void setTwitter(String twitter_username) {
        this.twitter_username = twitter_username;
    }

}
