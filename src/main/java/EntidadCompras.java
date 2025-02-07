
/**
 * 
 */

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Compras")
public class EntidadCompras implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCompra")
	private int idCompra;

	@ManyToOne
	@JoinColumn(name = "idPlayer", nullable = false)
	private EntidadPlayer player;

	@ManyToOne
	@JoinColumn(name = "idGames", nullable = false)
	private EntidadGames game;

	@Column(name = "Cosa", length = 25)
	private String cosa;

	@Column(name = "Precio", precision = 6, scale = 2)
	private double precio;

	@Temporal(TemporalType.DATE)
	@Column(name = "FechaCompra")
	private Date fechaCompra;

	public EntidadCompras() {
	}

	public EntidadCompras(int idCompra, EntidadPlayer player, EntidadGames game, String cosa, double precio,
			Date fechaCompra) {
		this.idCompra = idCompra;
		this.player = player;
		this.game = game;
		this.cosa = cosa;
		this.precio = precio;
		this.fechaCompra = fechaCompra;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public EntidadPlayer getPlayer() {
		return player;
	}

	public void setPlayer(EntidadPlayer player) {
		this.player = player;
	}

	public EntidadGames getGame() {
		return game;
	}

	public void setGame(EntidadGames game) {
		this.game = game;
	}

	public String getCosa() {
		return cosa;
	}

	public void setCosa(String cosa) {
		this.cosa = cosa;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	@Override
	public String toString() {
		return "EntidadCompras [idCompra=" + idCompra + ", player=" + player + ", game=" + game + ", cosa=" + cosa
				+ ", precio=" + precio + ", fechaCompra=" + fechaCompra + "]";
	}

}
