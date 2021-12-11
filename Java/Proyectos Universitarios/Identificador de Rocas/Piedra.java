/**
 * Esta clase almacena las piedras aisladas y posee los metodos que las delimitan y las analizan.
 * 
 * @author Daniel Pérez.
 * @author Randy Sancho.
 * @author Yerlan Irola.
 * @version 16/11/2021
 */
public class Piedra
{
    private int piedra[][];
    private int manchas;
    private int pesoMetales;
    private int pesoRoca;
    private int pesoFondo;
    private int fondo;
    private int colorDeBorde;
    private int colorFondoRoca; 
    private int porcentajeMetal;
    
    /**
     * Este constructor recibe una matriz y crea la piedra mediante los metodos llamados.  
     */
    public Piedra(int[][]matriz)
    {
        piedra = new int[matriz.length][matriz[0].length];
        this.fondo = matriz[0][0];
        InicializarFondo(fondo); 
        delimitacion(matriz, fondo);
        int fondoMomentaneo = colorDistinto(); 
        cambiarFondo(piedra, fondo, fondoMomentaneo);
        rellenarPiedra(matriz);
        cambiarFondo(piedra, fondoMomentaneo,fondo);
    }

    /**
     * Este metodo llama a los limites para delimitar la roca de la matriz original.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param colorDeFondo
     * este parametro es el color de fondo de la imagen original.
     */
    private void delimitacion(int[][]matriz, int colorDeFondo){
        boolean encontrado = false;
        for(int i = 0; i < matriz.length && !encontrado; ++i){
           for(int j = 0; j < matriz[i].length && !encontrado; j++ ){
                if(matriz[i][j] != colorDeFondo){
                    colorDeBorde = matriz[i][j]; 
                    piedra[i][j] = matriz[i][j];
                    limites(matriz, i, j, colorDeBorde, fondo, piedra);
                    encontrado = true;
                }
           }
        }
    }
    
    /**
     * Este metodo llama a otros metodos para delimitar los bordes de la roca.
     * @param matriz
     * este parametro es la matriz de la imagen.
     * @param filaRoca
     * este parametro es la fila en la que se encuentra la roca que se va a delimitar.
     * @param columnaRoca
     * este parametro es la columna en la que se encuentra la roca.
     * @param colorBuscar
     * este parametro es el color que el metodo va a buscar para encontrar la roca.
     * @param fondo
     * este parametro es el color de fondo.
     * @param piedra
     * este parametro es la matriz de la piedra especifica.
     */
    private void limites(int[][]matriz, int filaRoca,int columnaRoca,int colorBuscar, int fondo, int piedra [][]){
        oeste(matriz, filaRoca,columnaRoca,colorBuscar, fondo, piedra);
        este(matriz, filaRoca,columnaRoca,colorBuscar, fondo, piedra);
        surOeste(matriz, filaRoca,columnaRoca,colorBuscar, fondo, piedra);
        sur(matriz, filaRoca,columnaRoca,colorBuscar, fondo, piedra);
        surEste(matriz, filaRoca,columnaRoca,colorBuscar, fondo, piedra);
        norEste(matriz, filaRoca,columnaRoca,colorBuscar, fondo, piedra);
        norte(matriz, filaRoca,columnaRoca,colorBuscar, fondo, piedra);
        norOeste(matriz, filaRoca,columnaRoca,colorBuscar, fondo, piedra);
    }
    
        /**
     * Este metodo delimita a la roca por la izquierda.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param filaRoca
     * este parametro es el color de fondo de la imagen original.
     * @param columnaRoca
     * este parametro es la columna por la que se encuentra la roca
     * @param colorBuscar
     * este parametro es el color que debe buscar el metodo
     * @param fondo
     * este parametro es el fondo de la imagen
     * @param piedra
     * este parametro es la matriz de la piedra.
     */
    private void oeste(int[][]matriz, int filaRoca,int columnaRoca,int colorBuscar, int fondo, int piedra [][]){
        if(columnaRoca - 1 > 0){
            if(colorBuscar == matriz[filaRoca][columnaRoca - 1] && piedra[filaRoca][columnaRoca - 1] == fondo){
                columnaRoca--;
                piedra[filaRoca][columnaRoca] = colorBuscar;
                limites(matriz,filaRoca,columnaRoca, colorBuscar,fondo,piedra);
            }
        }    
    }
    
    /**
     * Este metodo delimita a la roca por la derecha.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param filaRoca
     * este parametro es el color de fondo de la imagen original.
     * @param columnaRoca
     * este parametro es la columna por la que se encuentra la roca
     * @param colorBuscar
     * este parametro es el color que debe buscar el metodo
     * @param fondo
     * este parametro es el fondo de la imagen
     * @param piedra
     * este parametro es la matriz de la piedra.
     */
    private void este(int[][]matriz, int filaRoca,int columnaRoca,int colorBuscar, int fondo, int piedra [][]){
        if(columnaRoca + 1 < matriz[0].length - 1){
            if(colorBuscar == matriz[filaRoca][columnaRoca + 1] && piedra[filaRoca][columnaRoca + 1] == fondo){
                columnaRoca++;
                piedra[filaRoca][columnaRoca] = colorBuscar;
                limites(matriz,filaRoca,columnaRoca, colorBuscar, fondo,piedra);
            }
        }
    }
    
    /**
     * Este metodo delimita a la roca por abajo en la diagonal izquierda.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param filaRoca
     * este parametro es el color de fondo de la imagen original.
     * @param columnaRoca
     * este parametro es la columna por la que se encuentra la roca
     * @param colorBuscar
     * este parametro es el color que debe buscar el metodo
     * @param fondo
     * este parametro es el fondo de la imagen
     * @param piedra
     * este parametro es la matriz de la piedra.
     */
    private void surOeste(int[][]matriz, int filaRoca,int columnaRoca,int colorBuscar, int fondo, int piedra [][]){
        if(filaRoca + 1 < matriz.length - 1 && columnaRoca - 1 > 0){
            if(colorBuscar == matriz[filaRoca + 1][columnaRoca - 1] && piedra[filaRoca + 1][columnaRoca - 1] == fondo){
                filaRoca++;
                columnaRoca--;
                piedra[filaRoca][columnaRoca] = colorBuscar;
                limites(matriz,filaRoca,columnaRoca, colorBuscar,fondo,piedra);
            }
        }
    }
    
        /**
     * Este metodo delimita a la roca por abajo.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param filaRoca
     * este parametro es el color de fondo de la imagen original.
     * @param columnaRoca
     * este parametro es la columna por la que se encuentra la roca
     * @param colorBuscar
     * este parametro es el color que debe buscar el metodo
     * @param fondo
     * este parametro es el fondo de la imagen
     * @param piedra
     * este parametro es la matriz de la piedra.
     */
    private void sur(int[][]matriz, int filaRoca,int columnaRoca,int colorBuscar, int fondo, int piedra [][]){
        if(filaRoca + 1 < matriz.length - 1){    
            if(colorBuscar == matriz[filaRoca + 1][columnaRoca] && piedra[filaRoca + 1][columnaRoca] == fondo){
                filaRoca++;
                piedra[filaRoca][columnaRoca] = colorBuscar;
                limites(matriz,filaRoca,columnaRoca, colorBuscar,fondo,piedra);
            }
        }
    }
    
    /**
     * Este metodo delimita a la roca por abajo en la diagonal derecha.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param filaRoca
     * este parametro es el color de fondo de la imagen original.
     * @param columnaRoca
     * este parametro es la columna por la que se encuentra la roca
     * @param colorBuscar
     * este parametro es el color que debe buscar el metodo
     * @param fondo
     * este parametro es el fondo de la imagen
     * @param piedra
     * este parametro es la matriz de la piedra.
     */
    private void surEste(int[][]matriz, int filaRoca,int columnaRoca,int colorBuscar, int fondo, int piedra [][]){
        if(filaRoca + 1 < matriz.length - 1 && columnaRoca + 1 < matriz[0].length - 1){    
            if(colorBuscar == matriz[filaRoca + 1][columnaRoca + 1] && piedra[filaRoca + 1][columnaRoca + 1] == fondo){
                 filaRoca++;
                 columnaRoca++;
                 piedra[filaRoca][columnaRoca] = colorBuscar;
                 limites(matriz,filaRoca,columnaRoca, colorBuscar,fondo,piedra);
            }
        }
    }
    
    /**
     * Este metodo delimita a la roca por arriba en la diagonal derecha.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param filaRoca
     * este parametro es el color de fondo de la imagen original.
     * @param columnaRoca
     * este parametro es la columna por la que se encuentra la roca
     * @param colorBuscar
     * este parametro es el color que debe buscar el metodo
     * @param fondo
     * este parametro es el fondo de la imagen
     * @param piedra
     * este parametro es la matriz de la piedra.
     */
    private void norEste(int[][]matriz, int filaRoca,int columnaRoca,int colorBuscar, int fondo, int piedra [][]){
        if(filaRoca - 1 > 0 && columnaRoca + 1 < matriz[0].length - 1){    
            if(colorBuscar == matriz[filaRoca - 1][columnaRoca + 1] && piedra[filaRoca - 1][columnaRoca + 1] == fondo){
                 filaRoca--;
                 columnaRoca++;
                 piedra[filaRoca][columnaRoca] = colorBuscar;
                 limites(matriz,filaRoca,columnaRoca, colorBuscar,fondo,piedra);
            }
        }
    }
    
    /**
     * Este metodo delimita a la roca en la parte de arriba.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param filaRoca
     * este parametro es el color de fondo de la imagen original.
     * @param columnaRoca
     * este parametro es la columna por la que se encuentra la roca
     * @param colorBuscar
     * este parametro es el color que debe buscar el metodo
     * @param fondo
     * este parametro es el fondo de la imagen
     * @param piedra
     * este parametro es la matriz de la piedra.
     */
    private void norte(int[][]matriz, int filaRoca,int columnaRoca,int colorBuscar, int fondo, int piedra [][]){
        if(filaRoca - 1 > 0){
            if(colorBuscar == matriz[filaRoca - 1][columnaRoca] && piedra[filaRoca - 1][columnaRoca] == fondo){
                 filaRoca--;
                 piedra[filaRoca][columnaRoca] = colorBuscar;
                 limites(matriz,filaRoca,columnaRoca, colorBuscar,fondo,piedra);
            }
        }
    }
    
    /**
     * Este metodo delimita a la roca por arriba en la diagonal izquierda.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param filaRoca
     * este parametro es el color de fondo de la imagen original.
     * @param columnaRoca
     * este parametro es la columna por la que se encuentra la roca
     * @param colorBuscar
     * este parametro es el color que debe buscar el metodo
     * @param fondo
     * este parametro es el fondo de la imagen
     * @param piedra
     * este parametro es la matriz de la piedra.
     */
    private void norOeste(int[][]matriz, int filaRoca,int columnaRoca,int colorBuscar, int fondo, int piedra [][]){
        if(filaRoca - 1 > 0 && columnaRoca - 1 > 0){    
            if(colorBuscar == matriz[filaRoca - 1][columnaRoca - 1] && piedra[filaRoca - 1][columnaRoca - 1] == fondo){
                 filaRoca--;
                 columnaRoca--;
                 piedra[filaRoca][columnaRoca] = colorBuscar;
                 limites(matriz,filaRoca,columnaRoca, colorBuscar,fondo,piedra);
            }
        }
    }
    
    /**
     * Este metodo borra a la piedra encontrada de la matriz original.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     */
    public void borrarPiedra(int[][]matriz){
        int fondoMatriz = matriz[0][0];
        for(int i = 0; i < piedra.length; i++){
            for(int j = 0; j < piedra[i].length; j++){
                if(piedra[i][j] == matriz[i][j]){
                    matriz[i][j] = fondo; 
                }
            }
        }
    }
    
    /**
     * Este metodo rellena a la piedra con la matriz ingresada.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     */
    private void rellenarPiedra(int[][]matriz){
        for(int i = 0; i < piedra.length; i++){
            for(int j = 0; j < piedra[i].length; j++){
                if(piedra[i][j] == fondo){
                    piedra[i][j] = matriz[i][j];
                }
            }
        }
    }
    
    /**
     * Este metodo rellena el fondo de la piedra con el color ingresado.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     */
    private void InicializarFondo (int colorRellenar){ 
         for(int i = 0; i < piedra.length; i++){
            for(int j = 0; j < piedra[i].length; j++){
                piedra[i][j] = colorRellenar; 
            }
        }
    }
    
    /**
     * Este metodo cambia el fondo de la matriz por el nuevo color ingresado utilizando el metodo nuevoFondo.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param colorDeFondoActual
     * este parametro es un numero indicando cual color está puesto actualmente en la matriz.
     * @param nuevoColor
     * este parametro es un numero indicando cual será el nuevo color en la matriz.
     */
    public void cambiarFondo(int matriz [][], int colorDeFondoActual,int nuevoColor){
        nuevoFondo(matriz ,nuevoColor, 0, 0, colorDeFondoActual);
    }
    
    /**
     * Este metodo cambia el fondo de la matriz por el nuevo color ingresado mediante los metodos llamados.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param nuevoColor
     * este parametro es un numero indicando cual será el nuevo color en la matriz.
     * @param filaRoca
     * este parametro indica la fila en la que se encuentra la roca.
     * @param columnaRoca
     * este parametro indica la columna en la que se encuentra la roca.
     * @param colorBuscar
     * este parametro indica el color que debe de buscar en la piedra.
     */
    private void nuevoFondo(int matriz [][], int nuevoColor,int filaRoca,int columnaRoca,int colorBuscar){
        if(columnaRoca > 0){
            if(matriz[filaRoca][columnaRoca - 1] == colorBuscar){
                fondoOeste(matriz, nuevoColor, filaRoca, columnaRoca, colorBuscar);    
            }
        }
        if(columnaRoca < matriz[0].length - 1){
            if(matriz[filaRoca][columnaRoca + 1] == colorBuscar){
               fondoEste(matriz, nuevoColor, filaRoca, columnaRoca, colorBuscar); 
            }
        }
        if(filaRoca < matriz.length - 1 && columnaRoca > 0){
            if(matriz[filaRoca + 1][columnaRoca - 1] == colorBuscar && matriz[filaRoca + 1][columnaRoca] == colorBuscar && matriz[filaRoca][columnaRoca - 1] == colorBuscar){
                fondoSurOeste(matriz, nuevoColor, filaRoca, columnaRoca, colorBuscar);
            }    
        }
        if(filaRoca < matriz.length - 1){
            if(matriz[filaRoca + 1][columnaRoca] == colorBuscar){
                fondoSur(matriz, nuevoColor, filaRoca, columnaRoca, colorBuscar);
            }
        }
        if(filaRoca < matriz.length - 1 && columnaRoca < matriz[0].length - 1){
            if(matriz[filaRoca + 1][columnaRoca + 1] == colorBuscar && matriz[filaRoca + 1][columnaRoca] == colorBuscar && matriz[filaRoca][columnaRoca + 1] == colorBuscar){
                fondoSurEste(matriz, nuevoColor, filaRoca, columnaRoca, colorBuscar);
            }
        }   
        if(filaRoca > 0 && columnaRoca < matriz[0].length - 1){
            if(matriz[filaRoca - 1][columnaRoca + 1] == colorBuscar && matriz[filaRoca - 1][columnaRoca] == colorBuscar && matriz[filaRoca][columnaRoca + 1] == colorBuscar){
                fondoNorEste(matriz, nuevoColor, filaRoca, columnaRoca, colorBuscar);
            }
        }
        if(filaRoca > 0){
            if(matriz[filaRoca - 1][columnaRoca] == colorBuscar){
                fondoNorte(matriz, nuevoColor, filaRoca, columnaRoca, colorBuscar);
            }
        }
        if(filaRoca > 0 && columnaRoca > 0){
            if(matriz[filaRoca - 1][columnaRoca - 1] == colorBuscar && matriz[filaRoca - 1][columnaRoca] == colorBuscar && matriz[filaRoca][columnaRoca - 1] == colorBuscar){
                fondoNorOeste(matriz, nuevoColor, filaRoca, columnaRoca, colorBuscar);
            }
        }
    }
    
    /**
     * Este metodo cambia el fondo de la matriz por el nuevo color ingresado y resta la columna en la que se mueve en la matriz.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param nuevoColor
     * este parametro es un numero indicando cual será el nuevo color en la matriz.
     * @param filaRoca
     * este parametro indica la fila en la que se encuentra la roca.
     * @param columnaRoca
     * este parametro indica la columna en la que se encuentra la roca.
     * @param colorBuscar
     * este parametro indica el color que debe de buscar en la piedra.
     */
    private void fondoOeste(int matriz [][], int nuevoColor,int filaRoca,int columnaRoca,int colorBuscar){
        columnaRoca--;
        matriz[filaRoca][columnaRoca] = nuevoColor;
        nuevoFondo(matriz, nuevoColor,filaRoca,columnaRoca, colorBuscar);
    }
    
    /**
     * Este metodo cambia el fondo de la matriz por el nuevo color ingresado y suma la columna en la que se mueve en la matriz.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param nuevoColor
     * este parametro es un numero indicando cual será el nuevo color en la matriz.
     * @param filaRoca
     * este parametro indica la fila en la que se encuentra la roca.
     * @param columnaRoca
     * este parametro indica la columna en la que se encuentra la roca.
     * @param colorBuscar
     * este parametro indica el color que debe de buscar en la piedra.
     */
    private void fondoEste(int matriz [][], int nuevoColor,int filaRoca,int columnaRoca,int colorBuscar){
        columnaRoca++;
        matriz[filaRoca][columnaRoca] = nuevoColor;
        nuevoFondo(matriz,nuevoColor,filaRoca,columnaRoca, colorBuscar);
    }
    
    /**
     * Este metodo cambia el fondo de la matriz por el nuevo color ingresado, suma la fila y resta la columna en la que se mueve en la matriz.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param nuevoColor
     * este parametro es un numero indicando cual será el nuevo color en la matriz.
     * @param filaRoca
     * este parametro indica la fila en la que se encuentra la roca.
     * @param columnaRoca
     * este parametro indica la columna en la que se encuentra la roca.
     * @param colorBuscar
     * este parametro indica el color que debe de buscar en la piedra.
     */
    private void fondoSurOeste(int matriz [][], int nuevoColor,int filaRoca,int columnaRoca,int colorBuscar){
        filaRoca++;
        columnaRoca--;
        matriz[filaRoca][columnaRoca] = nuevoColor;
        nuevoFondo(matriz,nuevoColor,filaRoca,columnaRoca, colorBuscar);
    }
    
    /**
     * Este metodo cambia el fondo de la matriz por el nuevo color ingresado y suma la fila en la que se mueve en la matriz.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param nuevoColor
     * este parametro es un numero indicando cual será el nuevo color en la matriz.
     * @param filaRoca
     * este parametro indica la fila en la que se encuentra la roca.
     * @param columnaRoca
     * este parametro indica la columna en la que se encuentra la roca.
     * @param colorBuscar
     * este parametro indica el color que debe de buscar en la piedra.
     */
    private void fondoSur(int matriz [][], int nuevoColor,int filaRoca,int columnaRoca,int colorBuscar){    
        filaRoca++;
        matriz[filaRoca][columnaRoca] = nuevoColor;
        nuevoFondo(matriz,nuevoColor,filaRoca,columnaRoca, colorBuscar);
    }
    
        /**
     * Este metodo cambia el fondo de la matriz por el nuevo color ingresado, suma la columna y la fila en la que se mueve en la matriz.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param nuevoColor
     * este parametro es un numero indicando cual será el nuevo color en la matriz.
     * @param filaRoca
     * este parametro indica la fila en la que se encuentra la roca.
     * @param columnaRoca
     * este parametro indica la columna en la que se encuentra la roca.
     * @param colorBuscar
     * este parametro indica el color que debe de buscar en la piedra.
     */
    private void fondoSurEste(int matriz [][], int nuevoColor,int filaRoca,int columnaRoca,int colorBuscar){
        filaRoca++;
        columnaRoca++;
        matriz[filaRoca][columnaRoca] = nuevoColor;
        nuevoFondo(matriz,nuevoColor,filaRoca,columnaRoca, colorBuscar);
    }
    
    /**
     * Este metodo cambia el fondo de la matriz por el nuevo color ingresado, resta la fila y suma la columna en la que se mueve en la matriz.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param nuevoColor
     * este parametro es un numero indicando cual será el nuevo color en la matriz.
     * @param filaRoca
     * este parametro indica la fila en la que se encuentra la roca.
     * @param columnaRoca
     * este parametro indica la columna en la que se encuentra la roca.
     * @param colorBuscar
     * este parametro indica el color que debe de buscar en la piedra.
     */
    private void fondoNorEste(int matriz [][], int nuevoColor,int filaRoca,int columnaRoca,int colorBuscar){    
        filaRoca--;
        columnaRoca++;
        matriz[filaRoca][columnaRoca] = nuevoColor;
        nuevoFondo(matriz,nuevoColor,filaRoca,columnaRoca, colorBuscar);
    }
    
        /**
     * Este metodo cambia el fondo de la matriz por el nuevo color ingresado, resta la fila en la que se mueve en la matriz.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param nuevoColor
     * este parametro es un numero indicando cual será el nuevo color en la matriz.
     * @param filaRoca
     * este parametro indica la fila en la que se encuentra la roca.
     * @param columnaRoca
     * este parametro indica la columna en la que se encuentra la roca.
     * @param colorBuscar
     * este parametro indica el color que debe de buscar en la piedra.
     */
    private void fondoNorte(int matriz [][], int nuevoColor,int filaRoca,int columnaRoca,int colorBuscar){
        filaRoca--;
        matriz[filaRoca][columnaRoca] = nuevoColor;
        nuevoFondo(matriz,nuevoColor,filaRoca,columnaRoca, colorBuscar);
    }
    
    /**
     * Este metodo cambia el fondo de la matriz por el nuevo color ingresado, resta la fila y la columna en la que se mueve en la matriz.
     * @param matriz
     * este parametro es la matriz de la imagen ingresada.
     * @param nuevoColor
     * este parametro es un numero indicando cual será el nuevo color en la matriz.
     * @param filaRoca
     * este parametro indica la fila en la que se encuentra la roca.
     * @param columnaRoca
     * este parametro indica la columna en la que se encuentra la roca.
     * @param colorBuscar
     * este parametro indica el color que debe de buscar en la piedra.
     */
    private void fondoNorOeste(int matriz [][],int nuevoColor, int filaRoca,int columnaRoca, int colorBuscar){ 
        filaRoca--;
        columnaRoca--;
        matriz[filaRoca][columnaRoca] = nuevoColor;
        nuevoFondo(matriz,nuevoColor,filaRoca,columnaRoca, colorBuscar);
    }

    /**
     * Este metodo devuelve un fondo distindo del color del borde de la piedra y del fondo.
     * @return nuevoFondo
     * devuelve un valor que será el nuevo fondo de la imagen.
     */
    private int colorDistinto (){ 
      boolean in = true; 
      int nuevoFondo = 0; 
       while (in){
        if ( nuevoFondo != fondo && nuevoFondo != colorDeBorde){
            in= false; 
        }else{ 
            nuevoFondo++;
          }
      }
      return nuevoFondo; 
    }
    
    /**
     * Este metodo selecciona un color diferente de todos los colores implementados..
     * @return nuevoFondo
     * devuelve un valor que será el nuevo fondo de la imagen.
     */
    private int colorDistintoAnalisis(){ 
         boolean in = true; 
         boolean sirve = true;
         int nuevoFondo = 0; 
         while (in){
            sirve=true; 
            for(int i = 0; i < piedra.length; i++){
                for(int j = 0; j < piedra[0].length; j++){
                   if (piedra[i][j] == nuevoFondo){
                      nuevoFondo++;
                      i=piedra.length;
                      j= piedra[0].length;
                      sirve = false;
                   }
                   if (i == piedra.length-1 && j == piedra[0].length-1 && sirve == true){
                       in=false; 
                   }
                }
            }
         } 
         return nuevoFondo; 
    }
    
    /**
     * Este metodo devuelve una matriz piedra.
     * @return piedra
     * devuelve la matriz piedra.
     */
    public int[][] getPiedra(){
        return piedra;
    }
    
    /**
     * Este metodo Analiza la matriz y devuelve una copia de la piedra con su porcentaje de metal y la cantidad de metal en la piedra especifica.
     * @return copiapiedra
     * devuelve la matriz.
     */
    public int[][] analisis(){ 
        int copiaPiedra[][] = copiaPiedra();
        int colorFondoDif = colorDistintoAnalisis();
        cambiarFondo(copiaPiedra, fondo, colorFondoDif);
        encontrarFondoDeRoca(copiaPiedra, colorFondoDif);
        canatidadDeMetalDeUnaPiedra(copiaPiedra, colorFondoDif);
        cambiarParaAnalisis(copiaPiedra, colorFondoDif);
        porcentajeDeMetal (); 
        return copiaPiedra;
    }
    
    /**
     * Este metodo encuentra el fondo de una piedra.
     * @param matriz
     * Este parametro es la matriz de la imagen ingresada
     * @param colorFondo
     * es el color que tiene de fondo la imagen.
     */
    private void encontrarFondoDeRoca(int matriz [][], int colorFondo){ 
       boolean continuar = false;
        for(int i = 0; i < matriz.length && !continuar; i++){
           for(int j = 0; j < matriz[i].length && !continuar; j++){
                if( matriz[i][j] != colorFondo && matriz[i][j] != colorDeBorde){ 
                colorFondoRoca = matriz[i][j]; 
                continuar = true;
              }
           }
       }
      }
      
    /**
     * Este metodo encuentra la cantidad de metal que posee una piedra.
     * @param matriz
     * Este parametro es la matriz de la imagen ingresada
     * @param colorFondo
     * es el color que tiene de fondo la imagen.
     */
    private void canatidadDeMetalDeUnaPiedra (int matriz [][],int colorFondo){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                if (matriz [i][j] != colorFondo && matriz [i][j] != colorDeBorde && matriz [i][j] !=  colorFondoRoca){
                   pesoMetales++; 
                }
                if ( matriz [i][j] != colorFondo){ 
                    pesoRoca++;
                }
            }
        }
    }
    
    /**
     * Este metodo saca el porcentaje de metal de la roca.
     */
    private void porcentajeDeMetal (){
       porcentajeMetal=(pesoMetales*100)/pesoRoca;
    }
    
        /**
     * Este metodo crea una copia de la matriz piedra.
     * @return copiaPiedra
     * regresa la copia de matriz de la roca.
     */
     public int[][] copiaPiedra(){
        int copiaPiedra[][] = new int[piedra.length][piedra[0].length];
        for(int i = 0; i < piedra.length; ++i){
           for(int j = 0; j < piedra[i].length; ++j ){
                copiaPiedra[i][j] = piedra[i][j];
           }
        }    
        return copiaPiedra; 
    }
    
    /**
     * Este metodo cambia momentaneamente el fondo de la matriz 
     * @param matriz
     * Este parametro es la matriz de la imagen ingresada
     * @param fondoDeMomento
     * es el color que tendrá provicionalmente la roca.
     */
    private void cambiarParaAnalisis (int matriz[][],int fondoDeMomento){ 
        for(int i = 0; i < matriz.length; ++i){
           for(int j = 0; j < matriz[i].length; ++j ){
                 if(matriz [i][j] == colorFondoRoca || matriz [i][j] == colorDeBorde){
                   matriz [i][j] = fondoDeMomento;
               } 
          }
        }
    }

    /**
     * Este metodo se utiliza para establecer cuantas manchas posee una roca.
     * @param cantidad
     * Este parametro es el numero de manchas que se contó en la piedra
     */
    public void setManchas(int cantidad){
        manchas = cantidad;
    }
    
    /**
     * Este metodo se utiliza para obtener el peso de una roca.
     * @return pesoRoca
     * Este parametro es el peso de la piedra.
     */
    public int getPesoRoca(){
        return pesoRoca; 
    }
    
    /**
     * Este metodo se utiliza para obtener porcentaje del metal de una roca.
     * @return porcentajeMetal
     * Este parametro es el porcentaje del metal de la piedra.
     */
    public int getPorcentajeMetal(){     
     return porcentajeMetal; 
    }
    
    /**
     * Este metodo se utiliza para obtener las filas de la matriz piedra.
     * @return piedra.length
     * Este parametro son las filas de la matriz piedra.
     */
    public int getFilasNum(){
        return piedra.length; 
    }
    
    /**
     * Este metodo se utiliza para obtener las columnas de la matriz piedra.
     * @return piedra[0].length
     * Este parametro son las columnas de la matriz piedra.
     */
    public int getColumnasNum(){
        return piedra[0].length; 
    }
    
    /**
     * Este metodo se utiliza para obtener las manchas de la piedra.
     * @return manchas
     * Este parametro son las manchas de la piedra.
     */
    public int getManchas(){
        return manchas; 
    }
    
    /**
     * Este metodo se utiliza para obtener el fondo de la piedra.
     * @return fondo
     * Este parametro es el fondo que se regresa.
     */
    public int getFondo (){
        return fondo;
    }
}