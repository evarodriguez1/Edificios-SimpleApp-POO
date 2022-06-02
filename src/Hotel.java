public class Hotel extends Edificios {
    //atributos
    private int numeroHabitaciones;
    //metodo cotructor
    public Hotel(String nombre, int numeroPlantas, int superficie,int numeroHabitaciones) {
        super(nombre, numeroPlantas, superficie, "hotel");
        this.numeroHabitaciones = numeroHabitaciones;
    }
    //demas metodos
    public void servicioHabitaciones(){
        int cantidadPersonal;
        int catidadTotalHabs = numeroHabitaciones * numeroPlantas;
        if (catidadTotalHabs > 20) {
            cantidadPersonal = catidadTotalHabs / 20;
            int costoTotalMantenimiento = cantidadPersonal * 1000;
            System.out.println("Para brindar servicio a " + catidadTotalHabs + " habitaciones, se necesitan " + cantidadPersonal + " personas para el mantenimiento del Hotel.");
            System.out.println("El coste total de mantenimiento sería " + costoTotalMantenimiento + " euros mensuales.");
        }else {
            System.out.println("Para brindar servicio a " + catidadTotalHabs + " habitaciones, se necesita 1 persona para el mantenimiento del Hotel.");
            System.out.println("El coste total de mantenimiento sería 1500 euros mensuales.");
        }
    }
    public void calcularCostoVigilancia(){
        int cantidadVigilantes = superficie/1000;
        int costoVigilancia = cantidadVigilantes * (1300+500);
        System.out.println("Se necesitan "+cantidadVigilantes+ " vigilantes.");
        System.out.println(" el costo total es de "+costoVigilancia+" euros por mes.");
    }
    public String toString(){
        return "El hotel "+nombre+". Tiene "+numeroHabitaciones+" habitaciones y "+numeroHabitaciones+" y una superficie de "+superficie
                +" m2.";
    }
}
