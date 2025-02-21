
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Player")
public class EntidadPlayer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPlayer")
	private int idPlayer;

	@Column(name = "nick", nullable = false, length = 45)
	private String nick;

	@Column(name = "password", nullable = false, length = 128)
	private String password;

	@Column(name = "email", nullable = false, length = 100)
	private String email;
	
	@OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EntidadCompras> compras;

	public EntidadPlayer() {
	}

	public EntidadPlayer(String nick, String password, String email) {
		super();
		this.nick = nick;
		this.password = password;
		this.email = email;
	}

	public EntidadPlayer(int idPlayer, String nick, String password, String email) {
		super();
		this.idPlayer = idPlayer;
		this.nick = nick;
		this.password = password;
		this.email = email;
	}

	public int getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
	    return String.format(
	        "Jugador:\n" +
	        "  ID: %d\n" +
	        "  Nick: %s\n" +
	        "  Contraseña: %s\n" +
	        "  Email: %s\n",
	        idPlayer, nick, password, email
	    );
	}

}
