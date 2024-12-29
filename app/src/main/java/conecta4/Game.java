package conecta4;

import org.checkerframework.checker.units.qual.t;

public class Game {
    public final int LIBRE = 0;
    public final int AMARILLO = 1;
    public final int ROJO = 2;
    private int[][] tablero;
    private int filas;
    private int columnas;
    private int turno;

    // constructos para un tablero de cualquier tamaño
    public Game(int rows, int columns){
        filas = rows;
        columnas = columns;
        turno = ROJO;
        tablero = new int[filas][columnas];
        iniciarTablero();
    }

    // inicia el tablero con todas las casillas libres
    private void iniciarTablero(){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = LIBRE;
            }
        }
    }

    /**
    * @pre recibe la columna donde caera la ficha
    * @post retorna el numero de columna si se agrego la ficha,
    * o -1 si la columna ya estaba llena
    **/ 
    public int addToken(int columna){
        int i = 0;
        int fila = -1;

        // busco la casilla libre
        while (i < filas && tablero[i][columna] != 1 && tablero[i][columna] != 2){
            i++;
        }


        if (i > 0 && i <= filas)
            fila = i - 1;
        
        // si hay una casilla libre en esa columna, coloca una ficha y cambia el turno
        if (fila >= 0) {
            tablero[fila][columna] = turno;
            cambiarTurno();
        }

        return fila;
    }

    // cambia el turno de los jugadores
    private void cambiarTurno(){
        if (turno == ROJO)
            turno = AMARILLO;
        if (turno == AMARILLO)
            turno = ROJO;
    }

    public int getTurno(){
        return turno;
    }

    private boolean comprobarHorizontal(){
        final int CONECTA = 4;
        int jugadorActual = getTurno();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas - CONECTA; j++) {
                if (tablero[i][j] == jugadorActual &&
                    tablero[i][j+1] == jugadorActual &&
                    tablero[i][j+2] == jugadorActual &&
                    tablero[i][j+3] == jugadorActual)
                        return true;
            }
        }
        return false;
    }

    private boolean comprobarVertical(){
        final int CONECTA = 4;
        int jugadorActual = getTurno();

        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas - CONECTA; j++) {
                if (tablero[i][j] == jugadorActual &&
                    tablero[i][j+1] == jugadorActual &&
                    tablero[i][j+2] == jugadorActual &&
                    tablero[i][j+3] == jugadorActual)
                        return true;
            }
        }
        return false;
    }
}
