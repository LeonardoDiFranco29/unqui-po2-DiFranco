package ar.edu.unq.po2.tp7.state.mp3;

public class SelectionState implements PlayerState {
    @Override
    public void handlePlay(MP3Player player) {
        if (player.getCurrentSong() != null) {
            player.getCurrentSong().play(); // Llama al método de Song
            System.out.println("Playing song..."); // EL REPRODUCTOR IMPRIME
            player.setState(new PlayingState());
        } else {
            System.out.println("Error: No song selected to play.");
        }
    }
    

    @Override
    public void handlePause(MP3Player player) {
        System.out.println("Error: Nothing is playing or paused to resume/pause.");
    }

    @Override
    public void handleStop(MP3Player player) {
        System.out.println("Already in song selection. No action needed.");
        // O no imprimir nada si "no hace nada" significa literalmente nada.
        // Según la consigna "no hace nada", no imprimiré nada.
        // System.out.println("No action needed.");
    }
}