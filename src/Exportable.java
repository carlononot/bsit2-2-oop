// Exportable.java
public interface Exportable {

    // TODO 1
    String toCsv();

    // TODO 2
    default void printExport() {
        System.out.println(toCsv());
    }
}