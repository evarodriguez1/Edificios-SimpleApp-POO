public class Cine extends Edificios {
    //atributos
    private int aforo;
    //metodo contructor
    public Cine (String nombre, int numeroPlantas, int superficie, int aforo) {
        super(nombre, numeroPlantas, superficie, "cine");
        this.aforo = aforo;
    }
    //demas metodos
    public void proyectarSesion(int butacas, int precioEntrada) {
        aforo = 30;
        int ganancia;
        if (butacas < aforo){
            ganancia= butacas*precioEntrada;
            System.out.println("Se han recaudado "+ganancia+" euros.");
        }else{
            System.out.println("Imposible. Supera el aforo maximo");
        }
    }
    public void calcularCostoVigilancia() {
        int cantidadVigilantes = superficie/3000;
        if (superficie<3000){
            cantidadVigilantes = 1;
        }
        int costoVigilancia = cantidadVigilantes*1300;
        System.out.println("Se necesitan "+cantidadVigilantes+ " vigilantes.");
        System.out.println(" el costo total es de "+costoVigilancia+" euros por mes.");
    }
    public String toString(){
        return"El cine"+nombre+ "de "+superficie+" m² y "+numeroPlantas+" plantas. En este momento tiene un aforo máximo de"+aforo+" personas.";
    }
}
