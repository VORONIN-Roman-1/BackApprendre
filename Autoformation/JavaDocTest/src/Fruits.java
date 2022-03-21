/** Класс служит для хранения объектов-фруктов со свойствами
 <b>name</b> и <b>color</b>
 @author vitaly
 @version 1.0
 */
public class Fruits {
    /** Свойство - цвет */
    String color;
    /** Свойство - имя */
    String name;
    /** Создает новый объект
     @see Fruits#Fruits(String)
     @see Fruits#Fruits(String, String)
     */
    public Fruits() {

    }
    /** Создает новый объект
     @param name Имя фрукта
     @see Fruits#Fruits()
     @see Fruits#Fruits(String, String)
     */
    public Fruits(String name) {
        this.name = name;
    }
    /** Создает новый объект
     @param name Имя фрукта
     @param color Цвет фрукта
     @see Fruits#Fruits()
     @see Fruits#Fruits(String)
     */
    public Fruits(String name, String color) {
        this.name = name;
        this.color = color;
    }
    /** Задает значение свойства name, которое можно получить при помощи метода {@link #getName()}
     @param name Новое значение свойства name
     */
    public void setName(String name) {
        this.name = name;
    }
    /** Получает значение свойства name, которое можно задать с помощью метода {@link #setName(String)}
     @return Значение свойства name
     */
    public String getName() {
        return name;
    }
    /** Задает значение свойства color, которое можно получить при помощи метода {@link #getColor()}
     @param color Новое значение свойства color
     */
    public void setColor(String color) {
        this.color = color;
    }
    /** Получает значение свойства color, которое можно задать с помощью метода {@link #setColor(String)}
     @return Значение свойства color
     */
    public String getColor() {
        return color;
    }
    /** Главный метод программы. Создает 3 объекта: apple, orange и lemon и устанавливает для них значения свойств, а затем выводит на экран
     @params args Параметры командной строки
     */
    public static void main(String[] args) {
        Fruits apple = new Fruits();
        apple.setName("Apple");
        apple.setColor("Red");

        Fruits orange = new Fruits("Orange");
        orange.setColor("Orange");

        Fruits lemon = new Fruits("Lemon", "Yellow");

        System.out.println("Значение объекта apple:\nname = " + apple.name + "\ncolor = " + apple.color + "\n");
        System.out.println("Значение объекта orange:\nname = " + orange.name + "\ncolor = " + orange.color + "\n");
        System.out.println("Значение объекта lemon:\nname = " + lemon.name + "\ncolor = " + lemon.color + "\n");
    }
}
