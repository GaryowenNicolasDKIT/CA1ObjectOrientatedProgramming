public class Youtuber extends Runner{

    private String ChannelName;

    public Youtuber(String name, String game, int runs_Amount, double community_Rating, boolean has_world_Record,String ChannelName){
        super(name, game, runs_Amount, community_Rating, has_world_Record);
        this.ChannelName = ChannelName;
    }

    public String getChannelName() {
        return ChannelName;
    }

    public void setChannelName(String channelName) {
        ChannelName = channelName;
    }
}
