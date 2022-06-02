public class Hospital extends Edificios {
    //atriubutos
    private int pacientes;
    //metodo constructor
    public Hospital(String nombre,int numeroPlantas,int superficie, int pacientes){
        super(nombre,numeroPlantas,superficie, "hospital");
        this.pacientes = pacientes;
    }
    //getters y setters
    public int getPacientes() {
        return pacientes;
    }
    public void setPacientes(int pacientes) {
        this.pacientes = pacientes;
    }
    //otros metodos
    public void repartirComida(){
        int raciones = pacientes * 3;
        System.out.println("Se están repartiendo"+raciones+" raciones");
    }
    public String toString(){
        return "El hospital "+nombre+", de"+superficie+" m² y "+numeroPlantas+" plantas. En este momento tiene"+pacientes+" pacientes.";
    }
}
