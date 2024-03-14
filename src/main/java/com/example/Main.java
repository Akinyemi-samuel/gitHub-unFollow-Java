package com.example;


public class Main {
    public static void main(String[] args) {
       UnfollowGithubUserConnection unfollowGithubUsers = new UnfollowGithubUserConnection("your-username", "your-token");

        unfollowGithubUsers.unfollowUsersNotFollowingBack();
    }
}