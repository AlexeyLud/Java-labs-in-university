import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DopTask6 {
    public static void main(String[] args) {

        // 6.Программе на вход подается имя каталога.
        // Необходимо найти все текстовые файлы в этом каталоге, считать их содержимое и записать в новый файл.
        // Полученный файл нужно упаковать в zip-архив.

        // catalog name on input
        File mydir = new File("D:\\Lab2\\src");
        if(mydir.isDirectory()){
            System.out.println(mydir.getPath() + " является каталогом. Продолжаем");
        }
        else{
            System.out.println(mydir.getPath() + " не является каталогом. Укажите другой путь");
            System.exit(0);
        }

        // all .txt file in catalog
        String[] listTxtFiles = listTxtFilesInMyDir(mydir);
        System.out.println("List of .txt files in my Dir = " + Arrays.toString(listTxtFiles) + "\n");

        String textForEndFile = "";

        // read text in our files
        for(String filename : listTxtFiles){
            File file = new File(mydir.getPath()+"\\"+filename);
            System.out.println("file = " + file.getPath());
            System.out.println("-------------------------------------");
            System.out.println("|Text in file " + file.getPath() + "|");
            System.out.println("-------------------------------------");
            List<String> list = listFromFile(file);
            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
                textForEndFile += list.get(i)+"\n";
            }
            System.out.println("\n");
        }

        System.out.println("textForEndFile");
        System.out.println("---------------------------------------------");
        System.out.println(textForEndFile + "\n");

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");
        String randomNomberName = sdf.format(new Date());

        // create new file
        String pathForNewFile = mydir + "\\" + randomNomberName + ".txt";
        File newFile = createNewFile(pathForNewFile);
        if(newFile.exists() && newFile.isFile()){
            System.out.println(newFile.getPath() + " существует и является файлом. Продолжаем\n");
        }
        else{
            System.out.println(newFile.getPath() + " не существует или не является файлом");
            System.out.println("Возможно вы ошиблись при создании. Попробуйте в другой раз");
            System.exit(0);
        }

        // write all text in new file
        File endFile = writeTextInFile(newFile,textForEndFile);
        if(endFile.length() != 0){
            System.out.println("Запись прошла успешно! Продолжаем\n");
        }
        else{
            System.out.println("Возникла какая-то проблема при записи файла попробуйте в другой раз");
            System.exit(0);
        }

        //zip out file
        zipArchFile(mydir,endFile,randomNomberName);
        String[] listZipFiles = listZipFilesInMyDir(mydir);
        System.out.println("Кол zip файлов в каталоге = " + listZipFiles.length);
        if(listZipFiles.length > 0){
            System.out.println("Новый архив был успешно создан! Проверим его наличие в каталоге:");
        }
        else {
            System.out.println("Возникла какая-то проблема при создании архива попробуйте в другой раз");
            System.exit(0);
        }
        System.out.println("List of .zip files in my Dir = " + Arrays.toString(listZipFiles) + "\n");
        for(String filename : listZipFiles){
            File file = new File(mydir.getPath()+"\\"+filename);
            System.out.println("file = " + file.getPath());
        }

        System.exit(0);

    }

    public static String[] listTxtFilesInMyDir(File mydir){
        String[] listTXT = mydir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        return listTXT;
    }

    public static String[] listZipFilesInMyDir(File mydir){
        String[] listZip = mydir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".zip");
            }
        });
        return listZip;
    }

    public static List<String> listFromFile(File file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    public static File createNewFile(String path){
        File newFile = new File(path);
        try
        {
            boolean created = newFile.createNewFile();
            if(created) {
                System.out.println("Файл " + newFile.getPath() + " был успешно создан");
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return newFile;
    }

    public static File writeTextInFile(File myfile, String text){
        try {
            FileWriter fileWriter = new FileWriter(myfile);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(text);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myfile;
    }

    public static void zipArchFile(File dir, File file, String name){
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(dir + "\\" + name + ".zip"));
            FileInputStream fis = new FileInputStream(file);)
        {
            ZipEntry zentry = new ZipEntry(file.getName());
            zout.putNextEntry(zentry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
