package com.example.android.latestnews;

public class News {
    /**
     * News Title
     */
    private String mTitle;

    /**
     * News Section
     */
    private String mSection;

    /**
     * News Date
     */
    private String mDate;

    /**
     * NewsWebsite URL
     */
    private String mUrl;

    /**
     * News Author
     */
    private String mAuthor;

    public News(String section, String title, String date, String url, String author) {
        mSection = section;
        mTitle = title;
        mDate = date;
        mUrl = url;
        mAuthor = author;
    }


    public String getSection() {
        return mSection;
    }


    public String getTitle() {
        return mTitle;
    }


    public String getDate() {
        return mDate;
    }


    public String getUrl() {
        return mUrl;
    }

    public String getAuthor() {
        return mAuthor;
    }
}
