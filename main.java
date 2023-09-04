import java.io.*;

public class FileManager {
    // Метод для чтения файла
    public String readFile(String filePath) throws FileNotFoundException, IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    // Метод для записи текста в файл
    public void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    // Метод для копирования файла
    public void copyFile(String sourcePath, String destinationPath) throws IOException {
        try (InputStream in = new FileInputStream(sourcePath);
             OutputStream out = new FileOutputStream(destinationPath)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        try {
            // Примеры:
            
            // Чтение файла
            String content = fileManager.readFile("example.txt");
            System.out.println("Содержимое файла:\n" + content);

            // Запись в файл
            fileManager.writeFile("newFile.txt", "Привет, мир!");

            // Копирование файла
            fileManager.copyFile("sourceFile.txt", "destinationFile.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода: " + e.getMessage());
        }
    }
}
