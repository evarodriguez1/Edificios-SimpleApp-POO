import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<Edificios> baseDatosEdificios = new ArrayList<>();

    public static void main (String[]args){
        elegirFuncion();
    }
    //metodos del menu
    static void elegirFuncion(){
        int opcionElegida = 1;
        String tipoEdificio;
        while (opcionElegida!=0){
            mensajeMenu();
            opcionElegida=ingresarNumeroInt("Selecciona la función: ");
            switch (opcionElegida){
                case 1:
                    crearEdificio(ingresarPalabra("Qué tipo de edificio quieres crear? hospital, cine u hotel:"));
                    break;
                case 2:
                    tipoEdificio = ingresarPalabra("Qué tipo de edificio quieres mostrar? hospital, cine u hotel:");
                    mostrarEdificio(tipoEdificio);
                    break;
                case 3:
                    tipoEdificio = ingresarPalabra("Qué tipo de edificio quieres eliminar? hospital, cine u hotel:");
                    eliminarEdificio(tipoEdificio);
                    break;
                case 0:
                    System.out.println("Has seleccionado la opción para salir. Vuelve pronto.");
                    break;
                default:
                    opcionNoValida();
            }
        }
    }
    static void crearEdificio(String tipoEdificio){
        switch (tipoEdificio){
            case "hospital":
                String nombreHospital = ingresarPalabra("Ingresa el nombre del hospital:");
                int numeroPlantas = ingresarNumeroInt("Ingresa la cantidad de plantas:");
                int superficie = ingresarNumeroInt("Ingresa la superficie:");
                int pacientes = ingresarNumeroInt("Ingresa la cantidad de pacientes:");
                if (verificaEdificioPorTipoYNombre(tipoEdificio,nombreHospital) < 0){
                    Hospital hospital = new Hospital(nombreHospital,numeroPlantas,superficie,pacientes);
                    baseDatosEdificios.add(hospital);
                    edificioAñadidoBaseDatos();
                }else {
                    yaExiste();
                }
                break;
            case "cine":
                String nombreCine = ingresarPalabra("Ingresa el nombre del cine:");
                int numeroPlantasCine = ingresarNumeroInt("Ingresa l cantidad de plantas:");
                int superficieCine = ingresarNumeroInt("Ingresa la superficie: ");
                int aforo = ingresarNumeroInt("Ingresa el numero de aforo:");
                if (verificaEdificioPorTipoYNombre(tipoEdificio,nombreCine) < 0){
                    Cine cine = new Cine(nombreCine,numeroPlantasCine,superficieCine,aforo);
                    baseDatosEdificios.add(cine);
                    edificioAñadidoBaseDatos();
                }else {
                    yaExiste();
                }
                break;
            case "hotel":
                String nombreHotel = ingresarPalabra("Ingresa el nombre del hotel:");
                System.out.println();
                int numeroPlantasHotel= ingresarNumeroInt("Ingresa el numero de platas:");
                System.out.println();
                int superficieHotel = ingresarNumeroInt("Inresa la superficie del hotel:");
                int cantidadHabitaciones = ingresarNumeroInt("Ingresa la cantidad de habitaciones:");
                if (verificaEdificioPorTipoYNombre(tipoEdificio,nombreHotel) < 0) {
                    Hotel hotel = new Hotel(nombreHotel, numeroPlantasHotel, superficieHotel, cantidadHabitaciones);
                    baseDatosEdificios.add(hotel);
                    edificioAñadidoBaseDatos();
                }
                break;
            default:
                opcionNoValida();
        }
    }
    static void mostrarEdificio(String tipoEdificio) {
        switch (tipoEdificio){
            case "hospital":
                String nombreHospital = ingresarPalabra("Ingresa el nombre del hospital:");
                int encuentraHospital = verificaEdificioPorTipoYNombre(tipoEdificio,nombreHospital);
                if (encuentraHospital >= 0){
                    System.out.println(baseDatosEdificios.get(encuentraHospital).toString());
                    baseDatosEdificios.get(encuentraHospital).limpieza();
                    baseDatosEdificios.get(encuentraHospital).calcularCostoVigilancia();
                    ((Hospital)baseDatosEdificios.get(encuentraHospital)).repartirComida();
                }else {
                    noSeEncuentra();
                }
                break;
            case "cine":
                String nombreCine = ingresarPalabra("Ingresa el nombre del cine:");
                int encuentraCine = verificaEdificioPorTipoYNombre(tipoEdificio,nombreCine);
                if (encuentraCine >= 0){
                    System.out.println(baseDatosEdificios.get(encuentraCine).toString());
                    baseDatosEdificios.get(encuentraCine).limpieza();
                    baseDatosEdificios.get(encuentraCine).calcularCostoVigilancia();
                    ((Cine) baseDatosEdificios.get(encuentraCine)).proyectarSesion(ingresarNumeroInt("Ingresa el numero de butacas:"),
                            ingresarNumeroInt("Ingresa el precio de la entrada: "));
                }else {
                    noSeEncuentra();
                }
                break;
            case "hotel":
                String nombreHotel = ingresarPalabra("Ingresa el nombre del hotel:");
                int encuentraHotel = verificaEdificioPorTipoYNombre(tipoEdificio,nombreHotel);
                if(encuentraHotel >= 0){
                    System.out.println(baseDatosEdificios.get(encuentraHotel).toString());
                    baseDatosEdificios.get(encuentraHotel).limpieza();
                    baseDatosEdificios.get(encuentraHotel).calcularCostoVigilancia();
                    ((Hotel) baseDatosEdificios.get(encuentraHotel)).servicioHabitaciones();
                }else {
                    noSeEncuentra();
                }
                break;
            default:
                opcionNoValida();
        }
    }
    static void eliminarEdificio(String tipoEdificio) {
        switch (tipoEdificio) {
                case "hospital":
                    String nombreHospital = ingresarPalabra("Ingresa el nombre del hospital que desea eliminar:");
                    int encuentraHospital = verificaEdificioPorTipoYNombre(tipoEdificio, nombreHospital);
                    if (encuentraHospital >= 0) {
                        baseDatosEdificios.remove(encuentraHospital);
                        edificioEliminadoBaseDatos();
                    } else {
                        noSeEncuentra();
                    }
                    break;
                case "cine":
                    String nombreCine = ingresarPalabra("Ingresa el nombre del cine: ");
                    int encuentraCine = verificaEdificioPorTipoYNombre(tipoEdificio, nombreCine);
                    if (encuentraCine >= 0) {
                        baseDatosEdificios.remove(encuentraCine);
                        edificioEliminadoBaseDatos();
                    } else {
                        noSeEncuentra();
                    }
                    break;
                case "hotel":
                    String nombreHotel = ingresarPalabra("Ingresa el nombre del hotel:");
                    int encuentraHotel = verificaEdificioPorTipoYNombre(tipoEdificio, nombreHotel);
                    if (encuentraHotel >= 0) {
                        baseDatosEdificios.remove(encuentraHotel);
                        edificioEliminadoBaseDatos();
                    } else {
                        noSeEncuentra();
                    }
                    break;
                default:
                    opcionNoValida();
        }

    }
    //metodos que verifican
    static int verificaEdificioPorTipoYNombre(String tipoEdificio, String nombreEdificio){
        boolean encontrado = false;
        int i = 0;
        int contador = -1;
        while (encontrado != true && i < baseDatosEdificios.size()){
            if (nombreEdificio.equalsIgnoreCase(baseDatosEdificios.get(i).getNombre()) &&
                    tipoEdificio.equalsIgnoreCase(baseDatosEdificios.get(i).getTipoEdificio())) {
                encontrado = true;
                contador = i;
            }
            i++;
        }
        return contador;
    }
    //metodos para ingresar datos
    public static int ingresarNumeroInt(String mensaje) {
        System.out.println(mensaje);
        Scanner input = new Scanner (System.in);
        int numero = input.nextInt();
        return  numero;
    }
    public static String ingresarPalabra(String mensaje) {
        System.out.println(mensaje);
        Scanner input = new Scanner (System.in);
        String palabra = input.nextLine();
        return  palabra;
    }
    //metodos mensajes
    static void mensajeMenu(){
        System.out.println("Bienvenido/a elige una opcion:");
        System.out.println("1-Crear un edificio");
        System.out.println("2-Mostrar edificio");
        System.out.println("3-Eliminar edificio");
        System.out.println("0-Salir del programa");
    }
    static void yaExiste() {
        System.out.println("No se puede crear porque ya existe.");
    }
    static void noSeEncuentra(){
        System.out.println("Lo sentimos, lo que buscas no se encuentra en la base de datos.");
    }
    static void edificioAñadidoBaseDatos(){
        System.out.println("Se ha añadido correctamente a la base de datos.");
    }
    static void edificioEliminadoBaseDatos(){
        System.out.println("Se ha eliminado de la base de datos.");
    }
    static void opcionNoValida(){
        System.out.println("La opción elegida no es válida, inténtalo nuevamente.");
    }
}
