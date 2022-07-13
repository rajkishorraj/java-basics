package com.myjavacode.designpattern.behaviourial;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        AbcNewsChannel abcNewsChannel = new AbcNewsChannel();
        newsAgency.addObserver(abcNewsChannel);
        newsAgency.setNews("some news");
    }

}

class NewsAgency {
    private String news;
    private List<Channel> newsChannels = new ArrayList<>();

    public void addObserver(Channel channel) {
        newsChannels.add(channel);
    }

    public void removeObserver(Channel channel) {
        newsChannels.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        newsChannels.forEach(channel -> channel.update(news));
    }


}

interface Channel {
    void update(String news);
}

class AbcNewsChannel implements Channel {
    private String news;

    @Override
    public void update(String news) {
        this.news = news;
    }
}