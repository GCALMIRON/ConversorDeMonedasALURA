import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.text.DecimalFormat;

public class PrincipalConversor {

    private static final String API_KEY = "2b2eadf593febf02fdcd3d97";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair";

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        // Moneda de origen
        System.out.print("Ingrese la moneda de origen (ejemplos: ARS, BRL, CLP, USD, EUR, GBP, JPY, AUD, CAD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        // Moneda de destino
        System.out.print("Ingrese la moneda de destino (ejemplos: ARS, BRL, CLP, USD, EUR, GBP, JPY, AUD, CAD): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        // Cantidad a convertir
        System.out.print("Ingrese la cantidad que desea convertir: ");
        double amount = scanner.nextDouble();

        // Conversión a monto con dos decimales
        double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("El monto convertido es: " + df.format(convertedAmount));
    }

    public static double convertCurrency(String from, String to, double amount) {
        try {
            // URL para la solicitud de la API
            String urlStr = BASE_URL + "/" + from + "/" + to;
            URL url = new URL(urlStr);

            // Conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Leer la respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();

            // Parsear el JSON usando Gson
            Gson gson = new Gson();
            RespuestaConversor response = gson.fromJson(content.toString(), RespuestaConversor.class);

            // Calculo del monto convertido
            return amount * response.getConversionRate();

        } catch (Exception e) {
            System.err.println("Error al realizar la conversión: " + e.getMessage());
        }
        return 0;
    }
}

