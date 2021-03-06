package primero;
// Generated 06-feb-2017 13:15:25 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Equipos generated by hbm2java
 */
@Entity
@Table(name = "equipos", catalog = "liga", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class Equipos implements java.io.Serializable {

	@Override
	public String toString() {
		return "Equipos [idEquipo=" + idEquipo + ", nombre=" + nombre + ", ciudad=" + ciudad + ", web=" + web
				+ ", puntos=" + puntos + "]";
	}

	private int idEquipo;
	private String nombre;
	private String ciudad;
	private String web;
	private Integer puntos;
	private Set<Partidos> partidosesForEvisitante = new HashSet<Partidos>(0);
	private Set<Jugadores> jugadoreses = new HashSet<Jugadores>(0);
	private Set<Partidos> partidosesForElocal = new HashSet<Partidos>(0);

	public Equipos() {
	}

	public Equipos(int idEquipo, String nombre, String ciudad) {
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.ciudad = ciudad;
	}

	public Equipos(int idEquipo, String nombre, String ciudad, String web, Integer puntos,
			Set<Partidos> partidosesForEvisitante, Set<Jugadores> jugadoreses, Set<Partidos> partidosesForElocal) {
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.web = web;
		this.puntos = puntos;
		this.partidosesForEvisitante = partidosesForEvisitante;
		this.jugadoreses = jugadoreses;
		this.partidosesForElocal = partidosesForElocal;
	}

	@Id

	@Column(name = "id_equipo", unique = true, nullable = false)
	public int getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	@Column(name = "nombre", unique = true, nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "ciudad", nullable = false, length = 45)
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Column(name = "web", length = 250)
	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Column(name = "puntos")
	public Integer getPuntos() {
		return this.puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equiposByEvisitante")
	public Set<Partidos> getPartidosesForEvisitante() {
		return this.partidosesForEvisitante;
	}

	public void setPartidosesForEvisitante(Set<Partidos> partidosesForEvisitante) {
		this.partidosesForEvisitante = partidosesForEvisitante;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipos")
	public Set<Jugadores> getJugadoreses() {
		return this.jugadoreses;
	}

	public void setJugadoreses(Set<Jugadores> jugadoreses) {
		this.jugadoreses = jugadoreses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equiposByElocal")
	public Set<Partidos> getPartidosesForElocal() {
		return this.partidosesForElocal;
	}

	public void setPartidosesForElocal(Set<Partidos> partidosesForElocal) {
		this.partidosesForElocal = partidosesForElocal;
	}

}
