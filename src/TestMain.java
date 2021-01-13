
import java.time.LocalDate;
import java.util.Scanner;

public class TestMain {
    static ManageMaterial manageMaterial = new ManageMaterial();
    static Scanner sc = new Scanner(System.in);
    static final String REGEX_MANUFACTURING_DATE = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập số lượng đối tượng muốn thêm");
                    int amount = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < amount; i++) {
                       Material material = setInforObj();
                       manageMaterial.addNew(material);
                    }
                    break;
                case 2:
                    manageMaterial.showALl();
                    break;
                case 3:
                    manageMaterial.sortByCost();
                    break;
                case 4:
                    System.out.println("Nhập tên bạn muốn tìm kiếm");
                    String name = sc.nextLine();
                    manageMaterial.findByName(name);
                    break;
                case 5:
                    System.out.println("Nhập vị trí đối tượng bạn muốn xóa");
                    int index = Integer.parseInt(sc.nextLine());
                    manageMaterial.remove(index);
                    break;
                case 6:
                    System.out.println("Nhập vị trí đối tượng bạn muốn xóa");
                    int index1 = Integer.parseInt(sc.nextLine());
                    Material material = setInforObj();
                    manageMaterial.edit(index1,material);
                    break;
                case 7:
                    manageMaterial.writeFile();
                    break;
                case 8:
                    manageMaterial.readFile();
                    break;
                case 9:
                    break;
            }

        } while (choice !=0);

    }

    private static void showMenu() {
        System.out.println("1. Thêm đối tượng");
        System.out.println("2. Hiển thị tất cả đối tượng");
        System.out.println("3. Sắp xếp theo giá");
        System.out.println("4. Tìm kiếm theo tên");
        System.out.println("5. Xóa đối tượng");
        System.out.println("6. Sửa thuộc tính đối tượng");
        System.out.println("7. Ghi file");
        System.out.println("8. Đọc file");
        System.out.println("9. Thoát chương trinh");
        System.out.println("Nhập lựa trọn choice");
    }

    public static Material setInforObj() {
        Material material = null;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Nhập tên");
        String name = sc.nextLine();
        System.out.println("Nhập id sản phẩm");
        String id = sc1.nextLine();
        String birthdayOfProduct;
        LocalDate manufacturingDate = null;
        do {
            System.out.println("Nhập ngày sản xuất kiểu yyyy/MM/dd");
            birthdayOfProduct = sc.nextLine();
            try {
                manufacturingDate = LocalDate.parse(birthdayOfProduct);
            }catch (Exception e){}
        }while (!birthdayOfProduct.matches(REGEX_MANUFACTURING_DATE));
        System.out.println("Nhập giá sản phẩm");
        int cost = Integer.parseInt(sc1.nextLine());
        String kindofMaterial;
        boolean testCrispyFlour1 = false;
        boolean testMeat1 = false;
        do {
            System.out.println("Nhập kiểu nguyên liệu [CrispyFlour,Meat]");
            kindofMaterial = sc.nextLine();
            testMeat1 = kindofMaterial.equalsIgnoreCase("Meat");
            testCrispyFlour1 = kindofMaterial.equalsIgnoreCase("CrispyFlour");
            if (testMeat1) {
                System.out.println("Nhập số cân");
                double weight = Double.parseDouble(sc1.nextLine());
                material = new Meat(name, id, manufacturingDate, cost, weight);
            }
            if (testCrispyFlour1) {
                System.out.println("nhập số lượng");
                int quality = Integer.parseInt(sc.nextLine());
                material = new CrispyFlour(name, id, manufacturingDate, cost, quality);
            }
        } while (testMeat1 == false && testCrispyFlour1 == false);
        System.out.println("___________________________________________________________________");
        return  material;
    }
}
