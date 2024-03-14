package com.example;


public class Main {
    public static void main(String[] args) {
       UnfollowGithubUserConnection unfollowGithubUsers = new UnfollowGithubUserConnection();

        //System.out.println(unfollowGithubUsers.getFollowing().size());
        unfollowGithubUsers.unfollowUsersNotFollowingBack();
    }
}