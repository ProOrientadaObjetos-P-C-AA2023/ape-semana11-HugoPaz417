package Taller_11_2;

abstract class Menu {
    protected String nombrePlato;
    protected double valorMenu;
    protected double valorInicialMenu;
    public Menu(String nombrePlato, double valorMenu, double valorInicialMenu) {
        this.nombrePlato = nombrePlato;
        this.valorMenu = valorMenu;
        this.valorInicialMenu = valorInicialMenu;
    }
    public abstract double calcularSubtotal();
    public abstract String toString();
}
class MenuCarta extends Menu {
    private double valorGuarnicion;
    private double valorBebida;
    private double porcentajeAdicionalServicio;
    public MenuCarta(String nombrePlato, double valorMenu, double valorInicialMenu, double valorGuarnicion, double valorBebida, double porcentajeAdicionalServicio) {
        super(nombrePlato, valorMenu, valorInicialMenu);
        this.valorGuarnicion = valorGuarnicion;
        this.valorBebida = valorBebida;
        this.porcentajeAdicionalServicio = porcentajeAdicionalServicio;
    }
    public double calcularSubtotal() {
        return valorInicialMenu + valorGuarnicion + valorBebida + (valorInicialMenu * porcentajeAdicionalServicio);
    }

    public String toString() {
        return "Menú a la Carta - " + nombrePlato + "\nSubtotal: $" + calcularSubtotal();
    }
}
class MenuDia extends Menu {
    private double valorPostre;
    private double valorBebida;

    public MenuDia(String nombrePlato, double valorMenu, double valorInicialMenu, double valorPostre, double valorBebida) {
        super(nombrePlato, valorMenu, valorInicialMenu);
        this.valorPostre = valorPostre;
        this.valorBebida = valorBebida;
    }

    public double calcularSubtotal() {
        return valorInicialMenu + valorPostre + valorBebida;
    }

    public String toString() {
        return "Menú del Día - " + nombrePlato + "\nSubtotal: $" + calcularSubtotal();
    }
}
class MenuNinos extends Menu {
    private double valorHelado;
    private double valorPastel;

    public MenuNinos(String nombrePlato, double valorMenu, double valorInicialMenu, double valorHelado, double valorPastel) {
        super(nombrePlato, valorMenu, valorInicialMenu);
        this.valorHelado = valorHelado;
        this.valorPastel = valorPastel;
    }
    public double calcularSubtotal() {
        return valorInicialMenu + valorHelado + valorPastel;
    }
    public String toString() {
        return "Menú de Niños - " + nombrePlato + "\nSubtotal: $" + calcularSubtotal();
    }
}
class MenuEconomico extends Menu {
    private double porcentajeDescuento;
    public MenuEconomico(String nombrePlato, double valorMenu, double valorInicialMenu, double porcentajeDescuento) {
        super(nombrePlato, valorMenu, valorInicialMenu);
        this.porcentajeDescuento = porcentajeDescuento;
    }
    public double calcularSubtotal() {
        double descuento = valorInicialMenu * porcentajeDescuento;
        return valorInicialMenu - descuento;
    }
    public String toString() {
        return "Menú Económico - " + nombrePlato + "\nSubtotal: $" + calcularSubtotal();
    }
}
class Cuenta {
    private String nombreCliente;
    private double iva;
    private Menu[] menus;
    private double valorTotal;
    public Cuenta(String nombreCliente, double iva, Menu[] menus) {
        this.nombreCliente = nombreCliente;
        this.iva = iva;
        this.menus = menus;
        this.valorTotal = calcularValorTotal();
    }
    public double calcularValorTotal() {
        double subtotal = 0;
        for (Menu menu : menus) {
            subtotal += menu.calcularSubtotal();
        }
        return subtotal + (subtotal * iva);
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cliente: ").append(nombreCliente).append("\n");
        builder.append("Subtotal: $").append(valorTotal / (1 + iva)).append("\n");
        builder.append("IVA: $").append(valorTotal - (valorTotal / (1 + iva))).append("\n");
        builder.append("Menús:\n");
        for (Menu menu : menus) {
            builder.append(menu.toString()).append("\n");
        }
        builder.append("Valor a cancelar total: $").append(valorTotal).append("\n");
        return builder.toString();
    }
}
public class Ejecutor001 {
    public static void main(String[] args) {
        MenuNinos menuNinos1 = new MenuNinos("Pollo a la parrilla", 10.0, 7.5, 2.0, 1.5);
        MenuNinos menuNinos2 = new MenuNinos("Pescado empanizado", 12.0, 9.0, 2.5, 1.5);
        MenuEconomico menuEconomico = new MenuEconomico("Arroz con pollo", 8.0, 10.0, 0.2);
        MenuDia menuDia = new MenuDia("Lomo saltado", 15.0, 12.0, 3.0, 2.0);
        MenuCarta menuCarta = new MenuCarta("Ceviche", 20.0, 18.0, 3.0, 2.5, 0.1);

        Menu[] menus = {menuNinos1, menuNinos2, menuEconomico, menuDia, menuCarta};

        Cuenta cuenta = new Cuenta("Juan Perez", 0.12, menus);

        System.out.println(cuenta.toString());
    }
}