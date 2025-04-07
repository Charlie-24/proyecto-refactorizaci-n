package clase;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


public class GestorFutbol {
	
	  // Atributos del equipo
    private  String equipoNombre;       // Nombre del equipo
    private static int puntos;                // Puntos acumulados por el equipo

    // Se crea el logger
    private static final Logger logger = Logger.getLogger(GestorFutbol.class.getName());

    public static void main(String[] args) {
        // Se crea una instancia del equipo principal con su nombre
        GestorFutbol equipoPrincipal = new GestorFutbol("Atlético Madrid");

        // Lista de resultados de partidos durante la temporada
        List<String> resultadosTemporada = Arrays.asList(
            "victoria local", "empate visitante", "derrota local",
            "victoria visitante!", "empate", "victoria!",
            "derrota", "empate local", "victoria local"
        );

        // Procesar los resultados y calcular puntos
        equipoPrincipal.procesarTemporada(resultadosTemporada);

        // Verificación de si hay resultados y salida del programa si se cumple
        if (!resultadosTemporada.isEmpty() ) {
            System.exit(1);
        }

        // Se crea otro equipo para comparar con el principal
        GestorFutbol otroEquipo = new GestorFutbol("Real Madrid");
        
        
        // Comparación entre dos equipos (por nombre)
        
        
            logger.info("Comparación entre equipos: " + equipoPrincipal.compareTo(otroEquipo));
        
      
    }

    // Constructor que inicializa el equipo con su nombre y puntos en 0
    public GestorFutbol(String nombreEquipo) {
    	GestorFutbol.equipoNombre=nombreEquipo;
    	GestorFutbol.puntos=0;
    }
    //Conatructor Copia
    public GestorFutbol(GestorFutbol otro) {
    	GestorFutbol.equipoNombre=otro.equipoNombre;
    	GestorFutbol.puntos=0;
    }

    // Procesa la lista de resultados y actualiza los puntos del equipo
    public static void procesarTemporada(List<String> resultados) {
        for (String resultado : resultados) {

            // Se suman los puntos según el tipo de resultado
        	switch(resultado) {
        	case "victoria" -> {	
        		puntos+=3;
        		logger.info("Victoria. Puntos acumulados: " + puntos);
        	}
        	case "empate" -> {
        		 puntos += 1;
                 logger.info("Empate. Puntos acumulados: " + puntos);
        	}
        	case "derrota" -> {
        		logger.info("Derrota. Puntos acumulados: " + puntos);
        	}
        	default -> {
        		logger.info("Partido no registrado");
        	}
        	}
            // Detecta si el resultado tiene un signo de énfasis (!)
            if (resultado.endsWith("!")) {
                logger.info("¡Resultado enfatizado!");
            
        }
        	 
        	localOvisitante(resultados);

            clasificResult(resultados);

         
            // Separador visual entre partidos
            logger.info("----------------------");
        }
       
    }
    	private static void localOvisitante(List<String> resultados) {
    		for (String resultado : resultados) {
	
    		// Se muestra si el partido fue como local o visitante
    			if (resultado.contains("local")) {
    				logger.info("Jugado como local.");
    			if (resultado.length() > 10) {
    				logger.info("Detalle adicional: " + resultado);
        }
    			} else if (resultado.contains("visitante")) {
    				logger.info("Jugado como visitante.");
    			if (resultado.length() > 8) {
    				logger.info("Comentario: " + resultado);
    			}
    		}	
    	}
	}
    	private static void clasificResult(List<String> resultados) {
    		for (String resultado : resultados) {
    			 // Clasifica el resultado según su longitud
                switch (resultado.length()) {
                    case 7:
                        logger.info("Resultado corto.");
                        break;
                    case 14:
                        logger.info("Resultado medio.");
                        break;
                    default:
                        logger.info("Resultado de longitud estándar.");
                        break;
                }
    		}		
    	}
    	
    // Método para comparar si dos objetos GestorFutbol representan el mismo equipo
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GestorFutbol)) return false;
        GestorFutbol otro = (GestorFutbol) obj;
        return equipoNombre.equals(otro.equipoNombre);
    }
    
    @Override
    public int hashCode() {
        return equipoNombre != null ? equipoNombre.hashCode() : 0;
    }

    // Compara dos objetos GestorFutbol por su nombre de equipo
    	
    public boolean compareTo(GestorFutbol otro) {
        return equipoNombre != null && otro.equipoNombre != null;
    }

}
