
import javax.persistence.*;
import java.io.Serializable;

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
		return "EntidadGames [idGames=" + idGames + ", nombre=" + nombre + ", tiempoJugado=" + tiempoJugado + "]";
	}

}
