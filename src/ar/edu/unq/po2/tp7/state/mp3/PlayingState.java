package ar.edu.unq.po2.tp7.state.mp3;

public class PlayingState implements PlayerState {
    @Override
    public void handlePlay(MP3Player player) {
        System.out.println("Error: Already playing a song.");
    }

    @Override
    public void handlePause(MP3Player player) {
        player.getCurrentSong().pause(); // Llama al método de Song
        System.out.println("Song paused."); // EL REPRODUCTOR IMPRIME
        player.setState(new PausedState());
    }

    @Override
    public void handleStop(MP3Player player) {
        player.getCurrentSong().stop(); // Llama al método de Song
        System.out.println("Song stopped. Returning to song selection."); // EL REPRODUCTOR IMPRIME
        player.setState(new SelectionState());
        player.selectSong(null);
    }
}