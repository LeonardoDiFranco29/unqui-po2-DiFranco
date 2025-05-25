package ar.edu.unq.po2.tp7.state.mp3;

public class PausedState implements PlayerState {
    @Override
    public void handlePlay(MP3Player player) {
        player.getCurrentSong().play(); // Llama al método de Song
        System.out.println("Resuming song."); // EL REPRODUCTOR IMPRIME
        player.setState(new PlayingState());
    }

    @Override
    public void handlePause(MP3Player player) {
        System.out.println("Error: Song is already paused.");
    }

    @Override
    public void handleStop(MP3Player player) {
        player.getCurrentSong().stop(); // Llama al método de Song
        System.out.println("Song stopped. Returning to song selection."); // EL REPRODUCTOR IMPRIME
        player.setState(new SelectionState());
        player.selectSong(null);
    }
}