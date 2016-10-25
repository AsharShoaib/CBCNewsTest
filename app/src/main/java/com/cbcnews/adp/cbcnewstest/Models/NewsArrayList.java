package com.cbcnews.adp.cbcnewstest.Models;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by asharshoaib on 2016-10-24.
 */

public class NewsArrayList extends RealmObject {

    public RealmList<News> NewsList;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (News n : NewsList)
        {
            sb.append(n);
            sb.append("\n");
        }

        return "NewsArrayList{" +
                "NewsList=" + NewsList +
                '}';
    }

    public RealmList<News> getNewsList() {
        return NewsList;
    }

    public void setNewsList(RealmList<News> newsList) {
        this.NewsList = newsList;
    }

    public NewsArrayList(RealmList<News> NewsList) {

        this.NewsList = NewsList;
    }
    public NewsArrayList() {

    }
}