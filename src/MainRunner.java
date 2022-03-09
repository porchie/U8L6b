import java.util.Scanner;

public class MainRunner {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int row = scan.nextInt();
        int col = scan.nextInt();
        String crpyt = scan.nextLine();
        crpyt = crpyt.substring(1);

        Encryptor decrpytor = new Encryptor(row,col);
        System.out.println(decrpytor.decryptMessage(crpyt));
       // Encryptor encryptor = new Encryptor(row,col);
        //System.out.println(encryptor.encryptMessage(crpyt));

        scan.close();
    }
}
