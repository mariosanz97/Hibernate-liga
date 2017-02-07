package primero;
// Generated 06-feb-2017 13:15:25 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Jugadores generated by hbm2java
 */
@Entity
@Table(name = "jugadores", catalog = "liga")
public class Jugadores implements java.io.Serializable {

	private int idJugador;
	private Equipos equipos;
	private String nombre;
	private String apellido;
	private String puesto;
	private Integer idCapitan;
	private Date fechaAlta;
	private Integer salario;
	private BigDecimal altura;

	public Jugadores() {
	}

	public Jugadores(int idJugador, String puesto) {
		this.idJugador = idJugador;
		this.puesto = puesto;
	}

	public Jugadores(int idJugador, Equipos equipos, String nombre, String apellido, String puesto, Integer idCapitan,
			Date fechaAlta, Integer salario, BigDecimal altura) {
		this.idJugador = idJugador;
		this.equipos = equipos;
		this.nombre = nombre;
		this.apellido = apellido;
		this.puesto = puesto;
		this.idCapitan = idCapitan;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.altura = altura;
	}

	@Id

	@Column(name = "id_jugador", unique = true, nullable = false)
	public int getIdJugador() {
		return this.idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipo")
	public Equipos getEquipos() {
		return this.equipos;
	}

	public void setEquipos(Equipos equipos) {
		this.equipos = equipos;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido", length = 45)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "puesto", nullable = false, length = 45)
	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	@Column(name = "id_capitan")
	public Integer getIdCapitan() {
		return this.idCapitan;
	}

	public void setIdCapitan(Integer idCapitan) {
		this.idCapitan = idCapitan;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_alta", length = 19)
	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Column(name = "salario")
	public Integer getSalario() {
		return this.salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

	@Column(name = "altura", precision = 4)
	public BigDecimal getAltura() {
		return this.altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Jugadores [idJugador=" + idJugador + ", equipos=" + equipos.getNombre() + ", nombre=" + nombre + ", apellido="
				+ apellido + ", puesto=" + puesto + ", idCapitan=" + idCapitan + ", fechaAlta=" + fechaAlta
				+ ", salario=" + salario + ", altura=" + altura + "]";
	}
	
	

}
