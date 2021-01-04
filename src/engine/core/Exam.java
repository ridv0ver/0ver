package src.engine.core;

import java.sql.*;

import src.engine.databaseMysql;
import src.processor.dataBaseController;

/**
 * Esta clase alberga los métodos relacionados con la evaluación de las preguntas.
 * @author Roberto Ignacio
 */
public class Exam {//begin Exam.java
    String nombreExamen;
    String usuario;
    Pregunta[] examen;
    int MAX_ARRAY = 10;
    int nPreguntas;
    int puntaje_MAX;
    int contador=0;
    double puntajeFinal = 0;
    int contadorCorrectas = 0;
    
    //metodo constructor
    /**
     * Genera un objeto de tipo Exam con su número de preguntas y puntaje máximo en 0 así como el arreglo de preguntas vacío.
     */

    public Exam() {
        examen = new Pregunta[MAX_ARRAY];
        nPreguntas = 0;
        puntaje_MAX = 0;
    }
    //metodos publicos
    public void insertaResultadoBasedeDatos(){
        try {
            dataBaseController m =new dataBaseController();
            int id = m.cuentaTotalResultados()+1;
            databaseMysql r = new databaseMysql();
            PreparedStatement rs = r.generaConexion().prepareStatement("INSERT INTO resultados VALUES (?,?,?,?)");
            rs.setInt(1, id);
            rs.setString(2, usuario);
            rs.setString(3, nombreExamen);
            rs.setDouble(4, ((puntajeFinal/puntaje_MAX)*100));
            rs.executeUpdate();
            } catch (SQLException e) {

            }
    }
    public int isFinal(){
        if(contador==nPreguntas){
            insertaResultadoBasedeDatos();
            System.out.println(puntajeFinal);
            contador=0;
            puntajeFinal = 0;
            contadorCorrectas =0;
            return 1;
        }else{
            return 0;
        }
    }
    public void setNombreExamen(String unNombre){
        this.nombreExamen = unNombre;
    }
    public String getNombreExamen(){
        return(nombreExamen);
    }
    public void setUsuario(String nombreUsuario){
        this.usuario = nombreUsuario;
    }
    public String getUsuario(){
        return(usuario);
    }
    public int getContador(){
        return(contador);
    }

    public void sumaPuntaje(int puntaje){
        puntajeFinal = puntajeFinal + puntaje;
    }

    public int evaluaPregunta(String respuesta){
        if(examen[contador].buscar(respuesta)==true){
            contadorCorrectas = contadorCorrectas + 1;
            return examen[contador].getPeso();
        }else{
            return 0;
        }
    }
    public void aumentaContador(){
        contador = contador +1;
    }
    /**
     * Este método agrega la pregunta entregada al final del arreglo de preguntas examen[].
     * @param unaPregunta Esta pregunta será la añadida al final del examen.
     */
    public void agregaPregunta(Pregunta unaPregunta){
        examen[nPreguntas]= unaPregunta;
        nPreguntas = nPreguntas + 1;
        puntaje_MAX = puntaje_MAX + unaPregunta.getPeso();    
    }
    /**
     * Este método toma el examen[] almacenado en un objeto de tipo Exam y lo evalúa al usuario.
     * @return int
     */
    public int darExam(){
        double puntajeFinal = 0;
        int contador=0;
        int contadorCorrectas = 0;
        while(contador<nPreguntas){
            if(examen[contador].buscar(examen[contador].getText())==true){
                puntajeFinal = puntajeFinal + examen[contador].getPeso();
                //System.out.println(puntajeFinal);
                contador = contador + 1;
                System.out.println("\n");
                contadorCorrectas = contadorCorrectas+1;
            }else{
                //System.out.println(puntajeFinal);
                contador = contador + 1;
                System.out.println("\n");
            }
        }
        int porcentaje = (int) ((puntajeFinal/puntaje_MAX)*100);
        System.out.println(contadorCorrectas+" Respuestas correctas de "+nPreguntas);
        return porcentaje;
    }

    public Pregunta retornaPregunta(int index){
        return(examen[index]);
    }
}//end Exam.java
