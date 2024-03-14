package com.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

record Github(String login, int id, String node_id, String avatar_url, String gravatar_id, String url, String html_url,
              String followers_url, String following_url, String gists_url, String starred_url,
              String subscriptions_url, String organizations_url, String repos_url, String events_url,
              String received_events_url, String type, boolean site_admin) {
    @JsonCreator
    Github(@JsonProperty("login") String login,
           @JsonProperty("id") int id,
           @JsonProperty("node_id") String node_id,
           @JsonProperty("avatar_url") String avatar_url,
           @JsonProperty("gravatar_id") String gravatar_id,
           @JsonProperty("url") String url,
           @JsonProperty("html_url") String html_url,
           @JsonProperty("followers_url") String followers_url,
           @JsonProperty("following_url") String following_url,
           @JsonProperty("gists_url") String gists_url,
           @JsonProperty("starred_url") String starred_url,
           @JsonProperty("subscriptions_url") String subscriptions_url,
           @JsonProperty("organizations_url") String organizations_url,
           @JsonProperty("repos_url") String repos_url,
           @JsonProperty("events_url") String events_url,
           @JsonProperty("received_events_url") String received_events_url,
           @JsonProperty("type") String type,
           @JsonProperty("site_admin") boolean site_admin) {
        this.login = login;
        this.id = id;
        this.node_id = node_id;
        this.avatar_url = avatar_url;
        this.gravatar_id = gravatar_id;
        this.url = url;
        this.html_url = html_url;
        this.followers_url = followers_url;
        this.following_url = following_url;
        this.gists_url = gists_url;
        this.starred_url = starred_url;
        this.subscriptions_url = subscriptions_url;
        this.organizations_url = organizations_url;
        this.repos_url = repos_url;
        this.events_url = events_url;
        this.received_events_url = received_events_url;
        this.type = type;
        this.site_admin = site_admin;
    }

    @Override
    public String toString() {
        return "Github{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", node_id='" + node_id + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", gravatar_id='" + gravatar_id + '\'' +
                ", url='" + url + '\'' +
                ", html_url='" + html_url + '\'' +
                ", followers_url='" + followers_url + '\'' +
                ", following_url='" + following_url + '\'' +
                ", gists_url='" + gists_url + '\'' +
                ", starred_url='" + starred_url + '\'' +
                ", subscriptions_url='" + subscriptions_url + '\'' +
                ", organizations_url='" + organizations_url + '\'' +
                ", repos_url='" + repos_url + '\'' +
                ", events_url='" + events_url + '\'' +
                ", received_events_url='" + received_events_url + '\'' +
                ", type='" + type + '\'' +
                ", site_admin=" + site_admin +
                '}';
    }
}
