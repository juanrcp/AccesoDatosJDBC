package app.conex;

import javax.naming.Context;
import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

	public static void main(String[] args) {
		
		//Establecemos el context con el bean.xml que hemos creado
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		BeanFactory factory = context;
		
		//Hacemos la inyeccion de la propiedad que nos interesa del bean
		AlumnoImplement alumInsertar = (AlumnoImplement)factory.getBean("inserta");
		System.out.println("Bean e inyeccion realizada con exito!!!!!!!!!!!!");
		
		//Alumno a insertar
		Alumno al = new Alumno(3, "Juan", "Perez", "asda@gmail.com");
		
		//Realizamos insercion
		alumInsertar.insertar(al);

	}

}
