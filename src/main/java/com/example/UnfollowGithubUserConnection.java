package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class UnfollowGithubUserConnection extends UnfollowGithubUsersApi {

    private static final Logger logger = Logger.getLogger(UnsupportedClassVersionError.class.getName());


    @Override
    public void unfollowUsersNotFollowingBack() {
        logger.info("⏳ Processing... ⏳\n");

        List<Github> following = getFollowing();
        List<Github> followers = getFollowers();

        List<Github> usersNotFollowingBack = new ArrayList<>(following);

        usersNotFollowingBack.removeIf(user -> followers.stream().anyMatch(follower -> follower.getFollowers_url().equals(user.getFollowers_url())));

        // Print the usernames of users not following you back
        if (!usersNotFollowingBack.isEmpty()) {
            System.out.println("Users not following you back (: :");
           int i = 0;
            for (Github user : usersNotFollowingBack) {
                i++;
                // unfollowUser(user);
            }
            System.out.println(i);
        } else {
            System.out.println("All users are following you back.");
        }
    }

    @Override
    public List<Github> getFollowing() {

        List<Github> allFollowing = new ArrayList<>();
        int currentPage = 1;
        boolean hasNextPage = true;

        while (hasNextPage) {
            String url = GITHUB_API_BASE_URL + "/users/" + username + "/following?page=" + currentPage;
            List<Github> pageFollowings = sendGetRequest(url);

            // If the current page returned no followers, stop pagination
            if (pageFollowings.isEmpty()) {
                hasNextPage = false;
            } else {
                allFollowing.addAll(pageFollowings);
                currentPage++;
            }
        }

        return allFollowing;
    }


    @Override
    public List<Github> getFollowers() {

        List<Github> allFollowers = new ArrayList<>();
        int currentPage = 1;
        boolean hasNextPage = true;

        while (hasNextPage) {
            String url = GITHUB_API_BASE_URL + "/users/" + username + "/followers?page=" + currentPage;
            List<Github> pageFollowers = sendGetRequest(url);

            // If the current page returned no followers, stop pagination
            if (pageFollowers.isEmpty()) {
                hasNextPage = false;
            } else {
                allFollowers.addAll(pageFollowers);
                currentPage++;
            }
        }

        return allFollowers;

    }

    private void unfollowUser(String user) {
        String url = GITHUB_API_BASE_URL + "/user/following/" + user;
        sendDeleteRequest(url);
        System.out.println("Unfollowed user: " + user);
    }

}
