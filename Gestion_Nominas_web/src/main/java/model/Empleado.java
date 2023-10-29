package model;

import excepciones.DatosNoCorrectosException;

public class Empleado extends Persona{
    private int categoria;
    public double anyosTrabajados;

    /**
     * Constructor
     * @param nombre
     * @param dni
     * @param sexo
     * @param categoria
     * @param anyosTrabajados
     * @throws DatosNoCorrectosException
     */
    public Empleado(String nombre, String dni, char sexo, int categoria, double anyosTrabajados) throws DatosNoCorrectosException {
        super(nombre, dni, sexo);

        if (categoria >= 1 && categoria <= 10) {
            this.categoria = categoria;
        } else {
            this.categoria = 1;
        }

        if (anyosTrabajados >= 0) {
            this.anyosTrabajados = anyosTrabajados;
        } else {
            throw new DatosNoCorrectosException("Dato Erroneo");
        }

    }

    /**
     * Constructor
     * @param nombre
     * @param dni
     * @param sexo
     */
    public Empleado(String nombre, String dni, char sexo){
        super(nombre, dni, sexo);
        categoria = 1;
        anyosTrabajados = 0;
    }

    public Empleado() {

    }

    /**
     * Setter de categoria
     * @param categoria
     * @throws DatosNoCorrectosException
     */
    public void setCategoria (int categoria) throws DatosNoCorrectosException {
        if (categoria >= 1 && categoria <= 10) {
            this.categoria = categoria;
        } else {
            throw new DatosNoCorrectosException("La categoria tiene que estar entre 1 y 10 incluyendolos");
        }
    }

    public void setAnyosTrabajados(double anyosTrabajados) {
        this.anyosTrabajados = anyosTrabajados;
    }

    /**
     * Getter de categoría
     *
     * @return categoria
     */
    public int getCategoria () {
        return categoria;
    }

    public double getAnyosTrabajados () {
        return anyosTrabajados;
    }

    /**
     * Imprime los valores establecidos
     */
    public String obtenerInformacion () {
        return "Nombre: " + nombre + ", DNI: " + dni + ", sexo: " + sexo + ", Categoria: " + categoria + ", Anyos Trabajados: " + anyosTrabajados;
    }
}
