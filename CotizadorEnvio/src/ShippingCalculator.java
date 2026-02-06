public class ShippingCalculator {
    public double subtotal;
    public double total;
    public double iva;
    private final double PRECIO_ESTANDAR = 50;
    private final double PRECIO_EXPRES = 90;

    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {
        this.subtotal = 0;

        if (tipoServicio == 1) {
            this.subtotal += PRECIO_ESTANDAR;
        } else {
            this.subtotal += PRECIO_EXPRES;
        }

        this.subtotal += (pesoKg * 12.0);

        if (distanciaKm <= 50) {
            this.subtotal += 20;
        } else if (distanciaKm <= 200) {
            this.subtotal += 60;
        } else {
            this.subtotal += 120;
        }

        if (zonaRemota) {
            this.subtotal *= 1.10;
        }

        return this.subtotal;
    }

    public double calcularIVA(double subtotal) {
        this.iva = subtotal * 0.16;
        return this.iva;
    }

    public double calcularTotal(double subtotal, double iva) {
        this.total = subtotal + iva;
        return this.total;
    }
}