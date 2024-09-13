package Ueb08;

/**
 * Fasst diverse Methoden für Arrays zusammen. Keine dieser Methoden darf
 * ein im Parameter gegebenes Array verändern!
 */
public class ArrayUtils {
    /**
     * Liefert den Index der Zelle mit der höchsten Zahl.
     *
     * @param arr Das zu durchsuchende Array.
     * @return Der Index der Zelle mit der höchsten Zahl.
     */
    static public int maximumIndex(int[] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Diese Methode ist eine Variante eines "normalen" Sortieralgorithmus.
     * Anstelle die Werte in absteigender Sortierung zurückzugeben, liefert sie
     * die Indizees der korrespondierenden Werte. Die Übergabe von [4,0,3,1,2]
     * würde also zum Ergebnis [0,2,4,3,1] führen: Jeder Wert im Ergebnis
     * bezeichnet den Index des sortierten Wertes im Ausgangsarray.
     * <p>
     * Der einfachste Weg, dies zu implementieren, ist eine Variation eines
     * Selectionsort-Algorithmus: Durchsuche das Array wiederholt nach dem
     * aktuell höchsten Wert. Nach jeder Iteration wird der Wert, der gerade
     * als höchster ermittelt wurde, mit einem äußerst kleinen Wert überschrieben,
     * so dass er in Folge nicht mehr betrachtet wird.
     *
     * @param arr Das Array mit den zu untersuchenden Werten.
     * @return Die Indizees der aus dem gegebenen Array absteigend sortierten Werte.
     */
    static public int[] buildOrderIndex(int[] arr) {
        int[] numbersToSort = arr.clone();
        int[] sortedIndices = new int[arr.length];
        for (int i = 0; i < numbersToSort.length; i++) {
            sortedIndices[i] = maximumIndex(numbersToSort);
            numbersToSort[sortedIndices[i]] = -1;
        }
        return sortedIndices;
    }

    /**
     * Eliminiert alle Vorkommen eines bestimmten Wertes aus dem gegebenen Array.
     *
     * @param arr   Das zu filternde Array.
     * @param value Der auszufilternde Wert.
     * @return Ein neues Array, das alle Werte des übergebenen Arrays in
     * gleicher Reihenfolge enthält - mit Ausnahme des gefilterten Wertes.
     */
    static public int[] filterValue(int[] arr, int value) {
        int sizeOfNewArr = 0;
        for (int element : arr) {
            if (element != value) {
                sizeOfNewArr++;
            }
        }
        int[] result = new int[sizeOfNewArr];
        int newIndex = 0;

        for (int element : arr) {
            if (element != value) {
                result[newIndex] = element;
                newIndex++;
            }
        }
        return result;
    }
}
