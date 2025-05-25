package ar.edu.unq.po2.tp7.state.mp3;

public class Song {
    private String title;

    public Song(String title) {
        this.title = title;
    }

    public void play() {
        System.out.println("Song '" + title + "' is now playing.");
    }

    public void pause() {
        System.out.println("Song '" + title + "' is now paused.");
    }

    public void stop() {
        System.out.println("Song '" + title + "' has stopped.");
    }

    public String getTitle() {
        return title;
    }
}