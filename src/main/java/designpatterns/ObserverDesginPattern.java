package designpatterns;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;

public class ObserverDesginPattern {

    public static void main(String[] args) {

        NewAgency agency = new NewAgency();
        agency.addObserver(new NewsChannel("Chanakya"));
        agency.addObserver(new NewsChannel("Polimer"));
        agency.addObserver(new NewsChannel("Discovery"));
        agency.addObserver(new NewsChannel("Republic"));

        agency.setNews("DMK failed");
        agency.setNews("Dravidam destroyed");
    }


}


class NewAgency{
    private String news;
    List<Observer> channelList = new ArrayList<>();

    public void addObserver(Observer c){
        channelList.add(c);
    }

    public void removeObserver(Observer c){
        channelList.remove(c);
    }

    public void setNews(String n){
        this.news = n;
        for(Observer o : channelList){
            o.update(n);
        }

    }

}

interface Observer{
    public void update(String n);
}
class NewsChannel implements Observer{
    private String name;
    public NewsChannel(String name){
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " - news received - " + news);
    }
}
