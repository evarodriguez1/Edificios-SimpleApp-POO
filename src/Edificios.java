public class Edificios {
    //atributos
    protected String nombre;
    protected int numeroPlantas;
    protected int superficie;
    protected String tipoEdificio;
    //metodo constructor
    public Edificios (String nombre,int numeroPlantas,int superficie, String tipoEdificio){
        this.nombre = nombre;
        this.numeroPlantas = numeroPlantas;
        this.superficie = superficie;
        this.tipoEdificio = tipoEdificio;
    }
    //getters
    public String getNombre() {
        return nombre;
    }
    public String getTipoEdificio() {
        return tipoEdificio;
    }
    // otros metodos
    public void limpieza() {
        int minutos = superficie/5;
        int tiempoEscaleras = (numeroPlantas-1)/2;
        int tiempoTotal = minutos + tiempoEscaleras;
        int costoMensual = tiempoTotal*30;
        int minutosAHoras = tiempoTotal/60;
        System.out.println("Son necesarias aproximadamente: "+minutosAHoras+" horas, para limpar el edificio.");
        System.out.println("El costo mensual de mantenimiento es: "+costoMensual+".");
    }
    public void calcularCostoVigilancia() {
        int cantidadVigilantes = (superficie/1000);
        int costoVigilancia = cantidadVigilantes *1300;
        System.out.println("Se necesitan "+cantidadVigilantes+ " vigilantes.");
        System.out.println(" el costo total es de "+costoVigilancia+" euros por mes.");
    }

}
