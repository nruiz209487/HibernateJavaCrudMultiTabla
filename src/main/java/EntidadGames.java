
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Games")
public class EntidadGames implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idGames")
	private int idGames;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "tiempoJugado")
	private int tiempoJugado;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EntidadCompras> compras;

	public EntidadGames() {
	}

	public EntidadGames(String nombre) {
		this.nombre = nombre;
	}

	public EntidadGames(int tiempoJugado) {
		this.tiempoJugado = tiempoJugado;
	}

	public EntidadGames(String nombre, int tiempoJugado) {

		this.nombre = nombre;
		this.tiempoJugado = tiempoJugado;
	}

	public int getIdGames() {
		return idGames;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTiempoJugado() {
		return tiempoJugado;
	}

	public void setTiempoJugado(int tiempoJugado) {
		this.tiempoJugado = tiempoJugado;
	}

	@Override
	public String toString() {
	    return String.format(
	        "Juego:\n" +
	        "  ID: %d\n" +
	        "  Nombre: %s\n" +
	        "  Tiempo Jugado: %d horas\n",
	        idGames, nombre, tiempoJugado
	    );
	}

}
