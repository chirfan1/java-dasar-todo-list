import java.util.Scanner;

public class AplikasiTodoList {
    public static String[] models = new String[10];

    public static java.util.Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        viewTodoList();
    }

    public static void testModel(){
        addTodo("makan");
        addTodo("tidur");

        todoList();
        deleteTodo(1);
        todoList();
    }
    public static void todoList(){
        System.out.println("Todo List");

        for (int i = 0; i < models.length; i++) {
            var todo = models[i];
            var no = i+1;


            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }

    }
    public static void addTodo(String todo){
        var isFull = true;
        for (int i = 0; i < models.length; i++) {
            if (models[i] == null){
                isFull = false;
                break;
            }
        }

        if (isFull) {
            String[] temp = models;
            models = new String[models.length * 2];

            for (int i = 0; i < temp.length; i++) {
                models[i] = temp[i];
            }
        }

        for (int i = 0; i < models.length; i++) {
            if (models[i] == null){
                models[i] = todo;
                break;
            }
        }
    }

    public static boolean deleteTodo(int number){
        if ((number - 1) >= models.length){
            return false;
        } else if (models[number - 1] == null) {
            return false;
        } else {
            for (int i = number - 1; i < models.length; i++) {
                if (i == (models.length - 1)){
                    models[i] = null;
                } else {
                    models[i] = models[i + 1];
                }
            }
        }
        return true;
    }

    public static String input(String info){
        System.out.print(info +": ");
        String data = scanner.nextLine();
        return data;
    }
    public static void viewTodoList(){
        while (true){
            todoList();

            System.out.println("Menu Pilihan");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("'x' untuk keluar");

            var input = input("Pilih ");

            if (input.equals("1")){
                viewAddTodo();
            } else if (input.equals("2")) {
                viewDeleteTodo();
            } else if (input.equals("x")){
                break;
            } else {
                System.out.println("Pilihan Error");
                System.out.println(" ");
            }
        }
    }
    public static void viewAddTodo(){
        System.out.println("Add Todo List");
        var todo = input("x Jika batal ");

        if (todo.equals("x")){

        } else {
            addTodo(todo);
        }
        System.out.println(" ");
    }
    public static void viewDeleteTodo(){
        System.out.println("Hapus Todo List");
        var no = input("x Jika batal ");

        if (no.equals("x")){

        } else {
            boolean sucess = deleteTodo(Integer.valueOf(no));
            if(!sucess){
                System.out.println("Gagal Menghapus " + no);
            }
        }
    }

}