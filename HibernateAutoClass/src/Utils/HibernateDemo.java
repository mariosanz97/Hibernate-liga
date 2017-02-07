package Utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jpa.internal.HEMLogging;

import primero.Jugadores;
import primero.Equipos;
import primero.Partidos;

import java.util.List;

public class HibernateDemo {
	static HashMap<Integer, Jugadores> HJugadores = new HashMap<Integer, Jugadores>();
	static HashMap<Integer, Equipos> HEquipos = new HashMap<Integer, Equipos>();
	static HashMap<Integer, Partidos> HPartidos = new HashMap<Integer, Partidos>();

	
	public static void main(String[] args) {

		System.out.println(
				".......................... \n" + ".  1 Jugadores \n" + ".  2 Equipos  \n" + ".  3 Partidos \n");

		Scanner sc = new Scanner(System.in);
		int keyS = sc.nextInt();

		switch (keyS) {
		case 1:
			Jugadores();
			break;
		case 2:
			Equipos();
			break;
		case 3:
			Partidos();
			break;
		}

		main(args);
	}

	public static void Jugadores() {
		System.out.println(".......................... \n" + ".  0 atras \n" + ".  1 Leer \n" + ".  2 Insert  \n"
				+ ".  3 Update \n" + ".  4 Delete \n");

		Scanner sc = new Scanner(System.in);
		int keyS = sc.nextInt();

		
		
		
		switch (keyS) {
		case 1:
			Session s1 = HibernateUtil.getSessionFactory().openSession();

			Query q = s1.createQuery("select e from Jugadores e");
			List results = q.list();

			Iterator homr = results.iterator();
			while (homr.hasNext()) {
				Jugadores e = (Jugadores) homr.next();
				//System.out.println(e.getNombre() + " " + e.getApellido());
				HJugadores.put(e.getIdJugador(), e);
				System.out.println(HJugadores.get(e.getIdJugador()).toString());

			}

			s1.close();

			break;

		case 2:
			int id = 0;
			System.out.println("Escribe su nombre");
			String nombre = sc.next();

			System.out.println("Escribe su apellido");
			String apellido = sc.next();

			System.out.println("Escribe su puesto");
			String puesto = sc.next();

			System.out.println("Escribe id capitan");
			int idc = sc.nextInt();

			System.out.println("Escribe salario");
			int salary = sc.nextInt();

			System.out.println("Escribe equipo");
			int team = sc.nextInt();

			Equipos teamtin = new Equipos();
			teamtin.setIdEquipo(team);

			System.out.println("Escribe altura");
			BigDecimal height = sc.nextBigDecimal();

			Jugadores e2 = new Jugadores();

			// System.out.println("---Inicio Consulta---");
			Session s2 = HibernateUtil.getSessionFactory().openSession();

			Query q2 = s2.createQuery("select e from Jugadores e");
			List results2 = q2.list();

			Iterator homr2 = results2.iterator();
			while (homr2.hasNext()) {
				Jugadores e = (Jugadores) homr2.next();
				id = e.getIdJugador();

			}
			Calendar fecha = Calendar.getInstance();

			// System.out.println("---Fin Consulta---");

			id++;
			e2.setIdJugador(id);
			e2.setNombre(nombre);
			e2.setApellido(apellido);
			e2.setPuesto(puesto);
			e2.setIdCapitan(idc);
			e2.setFechaAlta(fecha.getTime());
			e2.setSalario(salary);
			e2.setEquipos(teamtin);
			e2.setAltura(height);

			s2.close();

			SessionFactory sf2 = new Configuration().configure().buildSessionFactory();
			Session s3 = sf2.openSession();
			s3.beginTransaction();
			s3.save(e2);
			s3.getTransaction().commit();
			s3.close();

			break;
		case 3:

			System.out.println("---Inicio Consulta---");
			Session s5 = HibernateUtil.getSessionFactory().openSession();

			Query q5 = s5.createQuery("select e from Jugadores e");
			List results5 = q5.list();

			Iterator homr5 = results5.iterator();
			while (homr5.hasNext()) {
				Jugadores e = (Jugadores) homr5.next();
				System.out.println("		Apellido " + e.getApellido() + " y nombre " + e.getNombre() + " id -----> "
						+ e.getIdJugador());

			}

			s5.close();

			System.out.println("Escribe la id de la persona que quieres modificar");
			Scanner sc3 = new Scanner(System.in);
			int id2 = sc3.nextInt();
			System.out.println("Escribe nombre");
			String nombre6 = sc.next();
			System.out.println("Escribe apellido");
			String apellido6 = sc.next();
			System.out.println("Escribe puesto");
			String puesto2 = sc.next();
			System.out.println("Escribe id capitan");
			int idc2 = sc.nextInt();

			System.out.println("Escribe salario");
			int salary2 = sc.nextInt();

			System.out.println("Escribe equipo");
			int equipoup = sc.nextInt();
			Equipos equipo2 = new Equipos();
			equipo2.setIdEquipo(equipoup);

			System.out.println("Escribe altura");
			BigDecimal height2 = sc.nextBigDecimal();

			Session s7 = HibernateUtil.getSessionFactory().openSession();
			Calendar fecha2 = Calendar.getInstance();

			Jugadores e22 = (Jugadores) s7.get(Jugadores.class, id2);
			e22.setNombre(nombre6);
			e22.setApellido(apellido6);
			e22.setFechaAlta(fecha2.getTime());
			e22.setSalario(salary2);
			e22.setEquipos(equipo2);
			e22.setAltura(height2);

			Transaction tx = s7.beginTransaction();
			s7.update(e22);
			s7.getTransaction().commit();
			s7.close();

			System.out.println("---up---");

			break;
		case 4:

			System.out.println("---Inicio Consulta---");
			Session s4 = HibernateUtil.getSessionFactory().openSession();

			Query q4 = s4.createQuery("select e from Jugadores e");
			List results4 = q4.list();

			Iterator homr4 = results4.iterator();
			while (homr4.hasNext()) {
				Jugadores e = (Jugadores) homr4.next();
				System.out.println("		Apellido " + e.getApellido() + " y nombre " + e.getNombre() + " id -----> "
						+ e.getIdJugador());

			}
			s4.close();

			System.out.println("Fin Consulta");

			System.out.println("Inicio Borrado");
			Session s9 = HibernateUtil.getSessionFactory().openSession();
			s9.beginTransaction();

			System.out.println("Escribe la id de la persona que quieres borrar");
			Scanner sc2 = new Scanner(System.in);
			int id22 = sc2.nextInt();

			Query q22 = s9.createQuery("delete from Jugadores where id = " + id22 + "");
			q22.executeUpdate();

			s9.getTransaction().commit();
			s9.close();
			System.out.println("---Fin Borrado---");

			break;
		default:
			break;

		}
	}

	public static void Equipos() {
		System.out.println(".......................... \n" + ".  0 atras \n" + ".  1 Leer \n" + ".  2 Insert  \n"
				+ ".  3 Update \n" + ".  4 Delete \n");

		Scanner sc = new Scanner(System.in);
		int keyS = sc.nextInt();

		switch (keyS) {
		case 1:
			System.out.println("---Inicio Consulta---");
			Session s1 = HibernateUtil.getSessionFactory().openSession();

			Query q = s1.createQuery("select e from Equipos e");
			List results = q.list();

			Iterator homr = results.iterator();
			while (homr.hasNext()) {
				Equipos e = (Equipos) homr.next();
				//System.out.println(e.getNombre());
				HEquipos.put(e.getIdEquipo(), e);
				System.out.println(HEquipos.get(e.getIdEquipo()).toString());
			}

			s1.close();

			System.out.println("---Fin Consulta---");

			break;

		case 2:
			int id = 0;
			System.out.println("Escribe su nombre");
			String nombre = sc.next();

			System.out.println("Escribe su ciudad");
			String ciudad = sc.next();

			System.out.println("Escribe su web");
			String wb = sc.next();

			System.out.println("Escribe sus puntos");
			int pnt = sc.nextInt();

			Equipos e2 = new Equipos();

			System.out.println("---Inicio Consulta---");
			Session s2 = HibernateUtil.getSessionFactory().openSession();

			Query q2 = s2.createQuery("select e from Equipos e");
			List results2 = q2.list();

			Iterator homr2 = results2.iterator();
			while (homr2.hasNext()) {
				Equipos e = (Equipos) homr2.next();
				id = e.getIdEquipo();

			}

			System.out.println("---Fin Consulta---");

			id++;
			e2.setIdEquipo(id);
			e2.setNombre(nombre);
			e2.setCiudad(ciudad);
			e2.setWeb(wb);
			e2.setPuntos(pnt);
			s2.close();

			SessionFactory sf2 = new Configuration().configure().buildSessionFactory();
			Session s3 = sf2.openSession();
			s3.beginTransaction();
			s3.save(e2);
			s3.getTransaction().commit();

			s3.close();

			break;
		case 3:

			System.out.println("---Inicio Consulta---");
			Session s5 = HibernateUtil.getSessionFactory().openSession();

			Query q5 = s5.createQuery("select e from Equipos2" + " e");
			List results5 = q5.list();

			Iterator homr5 = results5.iterator();
			while (homr5.hasNext()) {
				Equipos e = (Equipos) homr5.next();
				System.out.println(e.getNombre() + " id -----> " + e.getIdEquipo());

			}

			s5.close();

			System.out.println("Escribe la id del Equipo que quieres modificar");
			Scanner sc3 = new Scanner(System.in);
			int id2 = sc3.nextInt();

			System.out.println("Escribe nombre");
			String nombre6 = sc.next();
			System.out.println("Escribe ciudad");
			String apellido6 = sc.next();
			System.out.println("Escribe web");
			String puesto2 = sc.next();
			System.out.println("Escribe puntos");
			int puntos = sc.nextInt();

			Session s7 = HibernateUtil.getSessionFactory().openSession();

			Equipos empleado = (Equipos) s7.get(Equipos.class, id2);
			empleado.setNombre(nombre6);
			empleado.setCiudad(apellido6);
			empleado.setWeb(puesto2);
			empleado.setPuntos(puntos);

			Transaction tx = s7.beginTransaction();
			s7.update(empleado);
			s7.getTransaction().commit();
			s7.close();

			System.out.println("---up---");

			break;
		case 4:

			System.out.println("---Inicio Consulta---");
			Session s4 = HibernateUtil.getSessionFactory().openSession();

			Query q4 = s4.createQuery("select e from Equipos e");
			List results4 = q4.list();

			Iterator homr4 = results4.iterator();
			while (homr4.hasNext()) {
				Equipos e = (Equipos) homr4.next();
				System.out.println(e.getNombre() + " id -----> " + e.getIdEquipo());

			}
			s4.close();

			System.out.println("Fin Consulta");

			System.out.println("Inicio Borrado");
			Session s9 = HibernateUtil.getSessionFactory().openSession();
			s9.beginTransaction();

			System.out.println("Escribe la id del equipp  que quieres borrar");
			Scanner sc2 = new Scanner(System.in);
			int id22 = sc2.nextInt();

			Query q22 = s9.createQuery("delete from Equipos where id = " + id22 + "");

			q22.executeUpdate();
			s9.getTransaction().commit();
			s9.close();
			System.out.println("---Fin Borrado---");

			break;
		default:
			break;

		}
	}

	public static void Partidos() {
		System.out.println(".......................... \n" + ".  0 atras \n" + ".  1 Leer \n" + ".  2 Insert  \n"
				+ ".  3 Update \n" + ".  4 Delete \n");

		Scanner sc = new Scanner(System.in);
		int keyS = sc.nextInt();

		switch (keyS) {
		case 1:
			System.out.println("---Inicio Consulta---");
			Session s1 = HibernateUtil.getSessionFactory().openSession();

			Query q = s1.createQuery("select e from Partidos e");
			List results = q.list();

			Iterator homr = results.iterator();
			while (homr.hasNext()) {
				Partidos e = (Partidos) homr.next();
				//System.out.println(e.getIdPartido() + ",  " + e.getResultado());
				HPartidos.put(e.getIdPartido(), e);
				System.out.println(HPartidos.get(e.getIdPartido()).toString());

			}

			s1.close();

			System.out.println("---Fin Consulta---");

			break;

		case 2:
			int id = 0;
			System.out.println("Escribe id local");
			int idl = sc.nextInt();

			Equipos l = new Equipos();
			l.setIdEquipo(idl);

			System.out.println("Escribe id visitante");
			int idv = sc.nextInt();

			Equipos v = new Equipos();
			v.setIdEquipo(idv);

			System.out.println("Escribe su resultado");
			String result = sc.next();

			System.out.println("Escribe id arbitro");
			String arby = sc.next();

			Partidos e2 = new Partidos();

			Session s2 = HibernateUtil.getSessionFactory().openSession();

			Query q2 = s2.createQuery("select e from Partidos e");
			List results2 = q2.list();

			Iterator homr2 = results2.iterator();
			while (homr2.hasNext()) {
				Partidos e = (Partidos) homr2.next();
				id = e.getIdPartido();

			}

			Calendar fecha2 = Calendar.getInstance();
			id++;
			e2.setIdPartido(id);
			e2.setEquiposByElocal(l);
			e2.setEquiposByEvisitante(v);
			e2.setResultado(result);
			e2.setFecha(fecha2.getTime());
			e2.setArbitro(arby);
			s2.close();

			SessionFactory sf2 = new Configuration().configure().buildSessionFactory();
			Session s3 = sf2.openSession();
			s3.beginTransaction();
			s3.save(e2);
			s3.getTransaction().commit();

			s3.close();

			break;
		case 3:

			System.out.println("---Inicio Consulta---");
			Session s5 = HibernateUtil.getSessionFactory().openSession();

			Query q5 = s5.createQuery("select e from Partidos e");
			List results5 = q5.list();

			Iterator homr5 = results5.iterator();
			while (homr5.hasNext()) {
				Partidos e = (Partidos) homr5.next();
				System.out.println("Id local  " + e.getEquiposByElocal() + " e id Visitante "
						+ e.getEquiposByEvisitante() + " id -----> " + e.getIdPartido());

			}

			s5.close();

			System.out.println("Escribe la id del partido que quieres modificar");
			Scanner sc3 = new Scanner(System.in);
			int id2 = sc3.nextInt();
			System.out.println("Escribe id local");
			int idl1 = sc.nextInt();

			Equipos ll = new Equipos();
			ll.setIdEquipo(idl1);

			System.out.println("Escribe id visitante");
			int idvv = sc.nextInt();

			Equipos vv = new Equipos();
			vv.setIdEquipo(idvv);

			System.out.println("Escribe su resultado");
			String result2 = sc.next();

			System.out.println("Escribe  arbitro");
			String arby2 = sc.next();

			Session s7 = HibernateUtil.getSessionFactory().openSession();
			Calendar fecha22 = Calendar.getInstance();
			Partidos p = (Partidos) s7.get(Partidos.class, id2);
			p.setEquiposByElocal(ll);
			p.setEquiposByEvisitante(vv);
			p.setResultado(result2);
			p.setFecha(fecha22.getTime());
			p.setArbitro(arby2);

			Transaction tx = s7.beginTransaction();
			s7.update(p);
			s7.getTransaction().commit();
			s7.close();

			System.out.println("---up---");

			break;
		case 4:

			System.out.println("---Inicio Consulta---");
			Session s4 = HibernateUtil.getSessionFactory().openSession();

			Query q4 = s4.createQuery("select e from Partidos e");
			List results4 = q4.list();

			Iterator homr4 = results4.iterator();
			while (homr4.hasNext()) {
				Partidos e = (Partidos) homr4.next();
				System.out.println("id-------> " + e.getIdPartido() + " la id equipo local " + e.getEquiposByElocal()
						+ " id del visitante " + e.getEquiposByEvisitante() + " y resultado " + e.getResultado());

			}
			s4.close();

			System.out.println("Fin Consulta");

			System.out.println("Inicio Borrado");
			Session s33 = HibernateUtil.getSessionFactory().openSession();
			s33.beginTransaction();

			System.out.println("Escribe la id del partido que quieres borrar");
			Scanner sc2 = new Scanner(System.in);
			int idd = sc2.nextInt();

			Query q22 = s33.createQuery("delete from Partidos where id = " + idd + "");

			q22.executeUpdate();
			s33.getTransaction().commit();
			s33.close();
			System.out.println("---Fin Borrado---");

			break;
		default:
			break;

		}
	}

}