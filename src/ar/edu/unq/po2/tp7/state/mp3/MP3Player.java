package ar.edu.unq.po2.tp7.state.mp3;

public class MP3Player {
    private PlayerState state;      // El estado actual del reproductor
    private Song currentSong;       // La canción actualmente seleccionada/reproduciéndose

    // Constructor: Inicializa el reproductor en el estado de selección
    public MP3Player() {
        this.state = new SelectionState();
        this.currentSong = null; // No hay canción seleccionada al inicio
    }

    // Setter para cambiar el estado del reproductor
    public void setState(PlayerState state) {
        this.state = state;
    }

    // Getter para obtener el estado actual (útil para tests)
    public PlayerState getState() {
        return state;
    }

    // Getter para obtener la canción actual
    public Song getCurrentSong() {
        return currentSong;
    }

    // Método para seleccionar una canción. Esto cambia la canción actual.
    public void selectSong(Song song) {
        this.currentSong = song;
        // Si el reproductor estaba en un estado que no era "Selection",
        // y seleccionamos una nueva canción, podríamos querer volver a SelectionState
        // para asegurar que la nueva canción se empiece desde cero.
        // Para este ejercicio, asumiremos que seleccionar una canción solo la "carga"
        // y el estado debe ser manejado por las operaciones de play/pause/stop.
        // Si el "selectSong" implicara un reseteo de estado, se haría aquí.
        // Por la consigna actual, solo cambia el currentSong.
    }

    // Métodos que delegan la acción al estado actual
    public void play() {
        state.handlePlay(this);
    }

    public void pause() {
        state.handlePause(this);
    }

    public void stop() {
        state.handleStop(this);
    }

    // Nota: No incluimos un main method aquí, ya que los tests JUnit se encargarán de la ejecución.
}