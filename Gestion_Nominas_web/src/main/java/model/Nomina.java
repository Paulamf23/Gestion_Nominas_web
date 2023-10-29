package model;

public class Nomina {

    public Nomina() { }

    private static final int SUELDO_BASE[] =
            {50000, 70000, 90000, 110000, 130000,
                    150000, 170000, 190000, 210000, 230000};

    /**
     * Calculo del sueldo
     *
     * @return sueldo
     */
    public double calculaSueldo(Empleado empleado) {
        double sueldo = SUELDO_BASE[empleado.getCategoria() - 1] + 5000 * empleado.anyosTrabajados;
        return sueldo;
    }
}
