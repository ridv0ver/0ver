
package src.engine.core;

/**
 * Esta clase alberga el método conversor.
 * @author Roberto Ignacio
 */
public class conversorAlternativa { //begin conversorAlternativa.java
    /**
    *Al método conversor se le entrega un entero con la posición numérica en el alfabeto de una letra en particular retornando el String con la letra correspondiente.
    * @param valor valor numérico que almacena la posición numérica en el alfabeto de una letra en particular.
    * @return String 
    */
    public static String conversor(int valor){
        String alternativa = new String();
        if(valor==1){
            alternativa = "a";   
            return alternativa;   
        }else if(valor==2){
            alternativa = "b";
            return alternativa;   
        }else if(valor==3){
            alternativa = "c";
            return alternativa;   
        }else if(valor==4){
            alternativa ="d";
            return alternativa;   
        }else if(valor==5){
            alternativa = "e";
            return alternativa;   
        }else if(valor==6){
            alternativa = "f";
            return alternativa;   
        }else if(valor==7){
            alternativa = "g";
            return alternativa;   
        }else if(valor==8){
            alternativa = "h";
            return alternativa;   
        }else if(valor==9){
            alternativa = "i";
            return alternativa;   
        }else if(valor==10){
            alternativa = "j";
            return alternativa;   
        }else if(valor==11){
            alternativa = "k";
            return alternativa;   
        }else if(valor==12){
            alternativa = "l";
            return alternativa;   
        }else if(valor==13){
            alternativa = "m";
            return alternativa;   
        }else if(valor==14){
            alternativa = "n";
            return alternativa;   
        }else if(valor==15){
            alternativa = "o";
            return alternativa;   
        }else if(valor==16){
            alternativa = "p";
            return alternativa;   
        }else if(valor==17){
            alternativa = "q";
            return alternativa;   
        }else if(valor==18){
            alternativa = "r";
            return alternativa;   
        }else if(valor==19){
            alternativa = "s";
            return alternativa;   
        }else if(valor==20){
            alternativa = "t";
            return alternativa;   
        }else if(valor==21){
            alternativa = "u";
            return alternativa;   
        }else if(valor==22){
            alternativa = "v";
            return alternativa;   
        }else if(valor==23){
            alternativa = "w";
            return alternativa;   
        }else if(valor==24){
            alternativa = "x";
            return alternativa;   
        }else if(valor==25){
            alternativa = "y";
            return alternativa;   
        }else if(valor==26){
            alternativa = "z";
            return alternativa;   
        }else{
            System.out.println("numero ingresado demasiado grande. intente un número entre 1-26.");
            return alternativa;
        }
    } 
}//end conversorAlternativa.java
