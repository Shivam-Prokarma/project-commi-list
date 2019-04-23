package com.shivam.gitcommits.data.models;

import com.google.gson.annotations.SerializedName;

public class CommitData {

    @SerializedName("sha")
    private String commitHash;

    @SerializedName("commit")
    private CommitDetails commitDetails;

    public String getCommitHash() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Commit: ").append(commitHash);
        return stringBuilder.toString();
    }

    public String getCommitMessage() {
        return commitDetails.message;
    }

    public String getAuthorName() {
        return commitDetails.getAuthor().getName();
    }

    public static class CommitDetails {

        private AuthorDetails author;
        private String message;

        public String getMessage() {
            return message;
        }

        public AuthorDetails getAuthor() {
            return author;
        }
    }

    public static class AuthorDetails {

        private String name;

        public String getName() {
            return name;
        }
    }
}



