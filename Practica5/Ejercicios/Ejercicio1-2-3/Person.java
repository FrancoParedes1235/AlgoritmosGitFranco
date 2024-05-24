public class Person implements Comparable<Person> {
    private String nombre;
    private String apellidos;
    private int edad;

    public Person() {
        this.nombre = "";
        this.apellidos = "";
        this.edad = 0;
    }

    public Person(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public int compareTo(Person o) {
        if (this.edad < o.getEdad()) {
            return -1;
        } else if (this.edad > o.getEdad()) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Person o) {
        if (this.nombre.equals(o.getNombre()) && this.edad == o.getEdad() && this.apellidos.equals(o.getApellidos())) {
            return true;
        } else {
            return false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Person [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + "]";
    }

}
