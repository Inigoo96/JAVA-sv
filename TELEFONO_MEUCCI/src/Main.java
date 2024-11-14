import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // Mapeo de los dígitos romanos válidos
    private static final Map<String, String> romanDigits = new HashMap<>();
    static {
        romanDigits.put("X", "0");
        romanDigits.put("I", "1");
        romanDigits.put("II", "2");
        romanDigits.put("III", "3");
        romanDigits.put("IV", "4");
        romanDigits.put("V", "5");
        romanDigits.put("VI", "6");
        romanDigits.put("VII", "7");
        romanDigits.put("VIII", "8");
        romanDigits.put("IX", "9");
    }

    // Función para contar las combinaciones válidas
    public static int countCombinations(String romanStr, Map<String, Integer> memo) {
        // Si ya hemos calculado las combinaciones para esta cadena, retornamos el resultado
        if (memo.containsKey(romanStr)) {
            return memo.get(romanStr);
        }
        // Caso base: cadena vacía, una forma de segmentarla
        if (romanStr.isEmpty()) {
            return 1;
        }

        int count = 0;
        // Intentamos partir la cadena en segmentos válidos
        for (int i = 1; i <= romanStr.length(); i++) {
            String prefix = romanStr.substring(0, i);
            if (romanDigits.containsKey(prefix)) {
                // Contamos combinaciones en el resto de la cadena
                count += countCombinations(romanStr.substring(i), memo);
            }
        }

        // Guardamos el resultado en memo para evitar recálculos
        memo.put(romanStr, count);
        return count;
    }

    // Función principal para procesar los números de teléfono
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String phone = scanner.nextLine().trim();
            Map<String, Integer> memo = new HashMap<>(); // Reiniciamos memo para cada caso
            int result = countCombinations(phone, memo);
            System.out.println(result);
        }
        scanner.close();
    }
}
