package com.cat;

import java.io.IOException;

public class Main {
    private static final String URL_POSTS = "https://jsonplaceholder.typicode.com/posts/";
    private static final String URL_COMMENTS = "https://jsonplaceholder.typicode.com/comments/";
    private static final String URL_ALBUMS = "https://jsonplaceholder.typicode.com/albums/";
    private static final String URL_PHOTOS = "https://jsonplaceholder.typicode.com/photos/";
    private static final String URL_USERS = "https://jsonplaceholder.typicode.com/users/";
    private static final String URL_TODOS = " https://jsonplaceholder.typicode.com/todos/";
    private static final String URL_COMMENTS_POST_ID = "https://jsonplaceholder.typicode.com/comments?postId=";
    private static final String URL_POSTS_USER_ID = "https://jsonplaceholder.typicode.com/posts?userId=";


    public static void main(String[] args) throws IOException {
        ApiService apiService = ApiService.getApiService();
        System.out.println(apiService.getAll(URL_POSTS));
        System.out.println(apiService.getAll(URL_COMMENTS));
        System.out.println(apiService.getAll(URL_ALBUMS));
        System.out.println(apiService.getAll(URL_PHOTOS));
        System.out.println(apiService.getAll(URL_USERS));
        System.out.println(apiService.getAll(URL_TODOS));
        System.out.println(apiService.getClassById(URL_POSTS, 5));
        System.out.println(apiService.getClassById(URL_COMMENTS, 6));
        System.out.println(apiService.getClassById(URL_ALBUMS, 7));
        System.out.println(apiService.getClassById(URL_PHOTOS, 8));
        System.out.println(apiService.getClassById(URL_USERS, 9));
        System.out.println(apiService.getClassById(URL_TODOS, 10));
        apiService.postPosts(URL_POSTS);
        apiService.putPosts(URL_POSTS, 5);
        System.out.println(apiService.getAll(URL_POSTS_USER_ID, 1));
        System.out.println(apiService.getAll(URL_COMMENTS_POST_ID, 1));
        apiService.deletePostById(URL_POSTS, 5);
    }
}
