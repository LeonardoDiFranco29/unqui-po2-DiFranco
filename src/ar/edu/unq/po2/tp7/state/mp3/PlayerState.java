package ar.edu.unq.po2.tp7.state.mp3;

public interface PlayerState {
    void handlePlay(MP3Player player);
    void handlePause(MP3Player player);
    void handleStop(MP3Player player);
}