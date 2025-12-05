public class Streamer extends Runner{

    private String StreamerName;

    public Streamer(String name, String game, int runs_Amount, double community_Rating, boolean has_world_Record,String StreamerName){
        super(name, game, runs_Amount, community_Rating, has_world_Record);
        this.StreamerName = StreamerName;
    }

    public String getStreamerName() {
        return StreamerName;
    }

    public void setStreamerName(String streamerName) {
        StreamerName = streamerName;
    }
}
