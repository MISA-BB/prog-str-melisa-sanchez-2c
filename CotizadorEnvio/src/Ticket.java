public class Ticket {
    public void imprimirTicket(int servicio, double peso, int distancia, boolean remota, ShippingCalculator calculadora) {
        System.out.println("---TICKET---");
        System.out.println("servicio: " + servicio);
        System.out.println("peso: " + peso);
        System.out.println("distancia: " + distancia);
        System.out.println("zona remota: " + (remota ? "Si" : "no"));
        System.out.println("subtotal (antes de IVA): " + calculadora.subtotal);
        System.out.println("IVA: " + calculadora.iva);
        System.out.println("total final: " + calculadora.total);
    }
}