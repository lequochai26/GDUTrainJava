import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GDUTrainingApplication {
    public static void main(String[] args) {
        buoi4FileReader();
    }

    public static void buoi4FileReader() {
        Path path = Path.of("c.txt");
        File file = path.toFile();

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);

            String content = "";
            do {
                int c = fileReader.read();

                if (c == -1) {
                    break;
                }

                char character = (char)c;
                content += character;
            }
            while (true);

            System.out.println("Nội dung tệp tin này là: ");
            System.out.println(content);
        }
        catch (IOException e) {
            System.out.println("Xảy ra lỗi trong quá trình đọc tệp tin!");
            e.printStackTrace();
        }

        if (fileReader != null) {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void buoi4FileInputStreamOutputStream() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Nhập vào đường dẫn tuyệt đối bất kỳ (rỗng để thoát): ");
            String path = scanner.nextLine();

            if (path.isBlank()) {
                break;
            }

            File file = new File(path);

            if (!file.exists()) {
                System.out.println("Tệp tin không tồn tại!");
                break;
            }

            byte[] content = null;

            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);

                content = fileInputStream.readAllBytes();
            }
            catch (IOException e) {
                System.out.println("Xảy ra lỗi trong quá trình đọc tệp tin!");
                e.printStackTrace();
            }

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (content != null) {
                String fileName = file.getName();

                Path writePath = Path.of(fileName);
                File writeFile = writePath.toFile();

                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = new FileOutputStream(writeFile);

                    fileOutputStream.write(content);

                    System.out.println("Ghi tệp thành công!");
                }
                catch (IOException e) {
                    System.out.println("Xảy ra lỗi trong quá trình ghi tệp!");
                    e.printStackTrace();
                }

                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                System.out.println("Không tìm thấy nội dung tệp!");
            }

            System.out.println();
        }
        while(true);

        scanner.close();
    }

    public static void buoi4FileWriter() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Nhập vào đường dẫn tuyệt đối bất kỳ (rỗng để thoát): ");
            String path = scanner.nextLine();

            if (path.isBlank()) {
                break;
            }

            System.out.println("Nhập nội dung tệp tin (rỗng để thoát):");
            String content = scanner.nextLine();

            if (content.isBlank()) {
                break;
            }

            File file = new File(path);

            if (!file.exists()) {
                File parentFile = file.getParentFile();

                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
            }

            FileWriter fileWriter = null;

            try {
                fileWriter = new FileWriter(file);

                fileWriter.write(content);

                System.out.println("Ghi tệp thành công!");
            } catch (IOException e) {
                System.out.println("Ghi tệp không thành công!");
                e.printStackTrace();
            }

            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println();
        }
        while(true);

        scanner.close();
    }

    public static void buoi4GetAbsolutePath() {
        Path path = Path.of("b.txt");
        File file2 = path.toFile();

        System.out.println(file2.getAbsolutePath());
    }

    public static void buoi4RenameTo() {
        Path bTxtPath = Path.of("b.txt");
        File bTxtFile = bTxtPath.toFile();

        Path cTxtPath = Path.of("c.txt");
        File cTxtFile = cTxtPath.toFile();

        boolean ketQua = bTxtFile.renameTo(cTxtFile);
        if (ketQua) {
            System.out.println("Đổi tên thành công!");
        }
        else {
            System.out.println("Đổi tên không thành công!");
        }
    }

    public static void buoi4Delete() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Nhập vào đường dẫn bất kỳ (rỗng để thoát): ");
            String path = scanner.nextLine();

            if (path.isBlank()) {
                break;
            }

            File file = new File(path);

            if (file.exists()) {
                boolean thanhCong = file.delete();
                if (thanhCong) {
                    System.out.println("Xóa thành công!");
                }
                else {
                    System.out.println("Xóa không thành công!");
                }
            }
            else {
                System.out.println("Tệp tin hoặc thư mục này không tồn tại!");
            }
            System.out.println();
        }
        while(true);

        scanner.close();
    }

    public static void buoi4Mkdirs() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Nhập vào đường dẫn bất kỳ (rỗng để thoát): ");
            String path = scanner.nextLine();

            if (path.isBlank()) {
                break;
            }

            File file = new File(path);

            if (!file.exists()) {
                file.mkdirs();
            }
            else {
                System.out.println("Dường dẫn này đã tồn tại, không cần tạo!");
            }
            System.out.println();
        }
        while(true);

        scanner.close();
    }

    public static void buoi4Exists() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Nhập vào đường dẫn bất kỳ (rỗng để thoát): ");
            String path = scanner.nextLine();

            if (path.isBlank()) {
                break;
            }

            File file = new File(path);

            if (file.exists()) {
                System.out.println("Đường dẫn này tồn tại.");
            }
            else {
                System.out.println("Đường dẫn này không tồn tại!");
            }
            System.out.println();
        }
        while(true);

        scanner.close();
    }

    public static void buoi4CreateNewFile() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Nhập tên tệp tin (rỗng để thoát): ");
            String fileName = scanner.nextLine();

            if (fileName.isBlank()) {
                break;
            }

            Path path = Path.of(fileName);
            File file = path.toFile();

            try {
                boolean fileCreated = file.createNewFile();

                if (fileCreated) {
                    System.out.println("Tạo tệp tin thành công!");
                }
                else {
                    System.out.println("Tạo tệp tin không thành công!");
                }
            }
            catch (IOException e) {
                System.out.println("Đã có lỗi xảy ra trong lúc tạo tệp tin!");
            }

            System.out.println();
        }
        while(true);

        scanner.close();
    }

    public static void buoi4IsDirectory() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Nhập vào đường dẫn bất kỳ (rỗng để thoát): ");
            String path = scanner.nextLine();

            if (path.isBlank()) {
                break;
            }

            File file = new File(path);

            if (file.isDirectory()) {
                System.out.println("Đường dẫn bạn vừa cung cấp trỏ tới thư mục.");
            }
            else {
                System.out.println("Đường dẫn bạn vừa cung cấp không trỏ tới thư mục!");
            }
            System.out.println();
        }
        while(true);

        scanner.close();
    }

    public static void buoi4FileNew() {
        // Cách 1:
        // Absolute path: Đường dẫn tuyệt đối -> Trỏ đến một tệp tin hoặc thư mục bên ngoài dự án
        File file = new File("C:\\Users\\lequochai\\Desktop\\a.txt");

        // Cách 2
        // Relative path: Đường dẫn tương đối -> Trỏ đến một tệp tin hoặc thư mục bên trong dự án
        Path path = Path.of("b.txt");
        File file2 = path.toFile();
    }

    public static void demoJavaStream() {
        List<String> strings = new ArrayList<>();

        strings.add("Nguyễn Văn A");
        strings.add("Trần Thị B");
        strings.add("Lê Văn C");
        strings.add("Phạm Thị D");
        strings.add("Nguyễn Đình E");

        strings = strings.stream()
                .filter(
                        str -> str.startsWith("Nguyễn")
                )
                .toList();

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void buoi4DateTimeFormatterFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH-mm-ss");

        LocalDateTime ngayVaGioHienTai = LocalDateTime.now();

        String ngayVaGioHienTaiDaDinhDang = formatter.format(ngayVaGioHienTai);
        System.out.println(ngayVaGioHienTaiDaDinhDang);
    }

    public static void buoi4DateTimeFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH-mm-ss");

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhập vào ngày và giờ (dd/MM/yyyy HH-mm-ss): ");
            String content = scanner.nextLine();

            try {
                LocalDateTime ngayVaGio = LocalDateTime.from(
                        formatter.parse(content)
                );

                int ngay = ngayVaGio.getDayOfMonth();
                int thang = ngayVaGio.getMonthValue();
                int nam = ngayVaGio.getYear();
                int gio = ngayVaGio.getHour();
                int phut = ngayVaGio.getMinute();
                int giay = ngayVaGio.getSecond();

                System.out.println("Ngày: " + ngay);
                System.out.println("Tháng: " + thang);
                System.out.println("Năm: " + nam);
                System.out.println("Giờ: " + gio);
                System.out.println("Phút: " + phut);
                System.out.println("Giây: " + giay);

                break;
            }
            catch (Exception e) {
                System.out.println("Nội dung bạn nhập không hợp lệ!");
                System.out.println();
            }
        }
        while(true);

        scanner.close();
    }

    public static void buoi4LocalTimeAtDate() {
        LocalTime gioHienTai = LocalTime.now();
        LocalDate ngay5Thang6Nam2024 = LocalDate.of(2024, 6, 5);

        LocalDateTime ngay5Thang6Nam24GioHienTai = gioHienTai.atDate(ngay5Thang6Nam2024);
        System.out.println(ngay5Thang6Nam24GioHienTai);
    }

    public static void buoi4LocalTimeNow() {
        LocalTime gioHienTai = LocalTime.now();
        System.out.println(gioHienTai);
    }

    public static void buoi4LocalTimeOf() {
        LocalTime gioChiDinh = LocalTime.of(15, 35, 23);
        System.out.println(gioChiDinh);
    }

    public static void buoi4LocalDateAtTime() {
        LocalDate ngayHienTai = LocalDate.now();
        LocalDateTime ngayHienTaiLuc7Gio = ngayHienTai.atTime(19, 35, 21);

        System.out.println(ngayHienTaiLuc7Gio);
    }

    public static void buoi4LocalDateMonth() {
        LocalDate ngayHienTai = LocalDate.now();
        int thang = ngayHienTai.getMonthValue();
        System.out.println("Tháng hiện tại: " + thang);

        LocalDate ngayNaoDo = LocalDate.of(2024, 5, 25);
        int thangNaoDo = ngayNaoDo.getMonthValue();
        System.out.println("Tháng nào đó: " + thangNaoDo);
    }

    public static void buoi4LocalDayOfMonth() {
        LocalDate ngayHienTai = LocalDate.now();
        int ngayTrongThang = ngayHienTai.getDayOfMonth();
        System.out.println("Ngày trong tháng: " + ngayTrongThang);

        LocalDate ngayNaoDo = LocalDate.of(2024, 7, 25);
        int ngayTrongThangNaoDo = ngayNaoDo.getDayOfMonth();
        System.out.println("Ngày trong tháng của ngày nào đó: " + ngayTrongThangNaoDo);
    }

    public static void buoi4LocalDateNow() {
        LocalDate ngayHienTai = LocalDate.now();
        System.out.println(ngayHienTai);
    }

    public static void buoi4LocalDateNew() {
        LocalDate ngayNaoDo = LocalDate.of(2024, 7, 30);
        System.out.println(ngayNaoDo);
    }

    public static void buoi4MapValues() {
        Map<String, Double> diemSinhViens = new HashMap<>();

        diemSinhViens.put("2108110118", 8.0);
        diemSinhViens.put("2108110119", 10.0);
        diemSinhViens.put("2108110320", 5.0);

        Collection<Double> diemSinhVienValues = diemSinhViens.values();
        for (Double diemSinhVien : diemSinhVienValues) {
            System.out.println(diemSinhVien);
        }
    }

    public static void buoi4MapKeySet() {
        Map<String, Double> diemSinhViens = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Nhập mã sinh viên (rỗng để thoát): ");
            String maSinhVien = scanner.nextLine();

            if (maSinhVien.isBlank()) {
                break;
            }

            String diemSinhVien = null;
            double diemSinhVienDouble = 0;

            do {
                try {
                    System.out.print("Nhập điểm số của sinh viên (" + maSinhVien + ") [rỗng để thoát]: ");
                    diemSinhVien = scanner.nextLine();

                    if (diemSinhVien.isBlank()) {
                        break;
                    }

                    diemSinhVienDouble = Double.parseDouble(diemSinhVien);
                }
                catch (Exception e) {
                    System.out.print("Điểm số bắt buộc phải là một số thực!");
                    System.out.println();
                }

                if (diemSinhVienDouble < 0 || diemSinhVienDouble > 10) {
                    System.out.print("Điểm số không hợp lệ!");
                    System.out.println();
                }

                break;
            }
            while (true);

            if (diemSinhVien == null || diemSinhVien.isBlank()) {
                break;
            }

            diemSinhViens.put(maSinhVien, diemSinhVienDouble);
        }
        while (true);

        System.out.print("Nhập mã sinh viên bất kỳ (rỗng để thoát): ");
        String maSinhVienKiemTra = scanner.nextLine();

        if (maSinhVienKiemTra.isBlank()) {
            return;
        }

        Set<String> maSinhViens = diemSinhViens.keySet();
        if (maSinhViens.contains(maSinhVienKiemTra)) {
            System.out.println("Sinh viên này có điểm!");
        }
        else {
            System.out.println("Sinh viên này không có điểm!");
        }
    }

    public static void buoi4MapRongKhong() {
        Map<String, Double> diemSinhViens = new HashMap<>();
        Map<String, Double> diemSinhViens2 = new HashMap<>();

        diemSinhViens.put("2108110118", 8.0);
        diemSinhViens.put("2108110119", 10.0);
        diemSinhViens.put("2108110320", 5.0);

        System.out.println(diemSinhViens.isEmpty());
        System.out.println(diemSinhViens2.isEmpty());
    }

    public static void buoi4MapDuyet() {
        Map<String, Double> diemSinhViens = new HashMap<>();

        diemSinhViens.put("2108110118", 8.0);
        diemSinhViens.put("2108110119", 10.0);
        diemSinhViens.put("2108110320", 5.0);

        Set<Map.Entry<String, Double>> entries = diemSinhViens.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void buoi4MapPut() {
        Map<String, Double> diemSinhViens = new HashMap<>();

        diemSinhViens.put("2108110118", 8.0);
        diemSinhViens.put("2108110119", 10.0);
        diemSinhViens.put("2108110320", 5.0);
    }

    public static void buoi4MapNew() {
        Map<String, Double> diemSinhViens = new HashMap<>();
    }

    public static void buoi4SetRemove() {
        Set<String> contents = new LinkedHashSet<>();

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhập vào nội dung bất kỳ (rỗng để thoát): ");

            String content = scanner.nextLine();

            if (content.isBlank()) {
                break;
            }

            contents.add(content);
            System.out.println();
        }
        while(true);

        do {
            System.out.println("Nhập vào nội dung cần loại bỏ: ");

            String content = scanner.nextLine();

            if (contents.remove(content)) {
                break;
            }
            else {
                System.out.println("Nội dung này bạn chưa từng nhập!");
                System.out.println();
            }
        }
        while(true);

        System.out.println("Danh sách những nội dung bạn đã nhập: ");
        for (String content : contents) {
            System.out.println(content);
        }

        scanner.close();
    }

    public static void buoi4SetSize() {
        Set<String> contents = new LinkedHashSet<>();

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhập vào nội dung bất kỳ (rỗng để thoát): ");

            String content = scanner.nextLine();

            if (content.isBlank()) {
                break;
            }

            contents.add(content);
            System.out.println();
        }
        while(true);

        System.out.println("Tổng số nội dung bạn đã nhập: " + contents.size());

        scanner.close();
    }

    public static void buoi4SetContains() {
        Set<String> contents = new LinkedHashSet<>();

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhập vào nội dung bất kỳ (rỗng để thoát): ");

            String content = scanner.nextLine();

            if (content.isBlank()) {
                break;
            }

            contents.add(content);
            System.out.println();
        }
        while(true);

        System.out.println("Nhập vào một chuỗi bất kỳ để kiểm tra: ");
        String checkContent = scanner.nextLine();

        if (contents.contains(checkContent)) {
            System.out.println("Nội dung này bạn đã nhập.");
        }
        else {
            System.out.println("Bạn chưa từng nhập nội dung này.");
        }

        scanner.close();
    }

    public static void buoi4SetRongHayKhong() {
        Set<String> maSinhViens = new LinkedHashSet<>();
        Set<String> maSinhViens2 = new LinkedHashSet<>();

        maSinhViens.add("2108110118");
        maSinhViens.add("2108110119");
        maSinhViens.add("2108110118");

        System.out.println(maSinhViens.isEmpty());
        System.out.println(maSinhViens2.isEmpty());
    }

    public static void buoi4SetDuyet() {
        Set<String> maSinhViens = new LinkedHashSet<>();

        System.out.println(maSinhViens.add("2108110118"));
        System.out.println(maSinhViens.add("2108110119"));
        System.out.println(maSinhViens.add("2108110118"));

        for (String maSinhVien : maSinhViens) {
            System.out.println(maSinhVien);
        }
    }

    public static void buoi4SetAdd2() {
        Set<DanhSachSinhVien> danhSachSinhViens = new LinkedHashSet<>();

        DanhSachSinhVien danhSachSinhVien1 = new DanhSachSinhVien();
        DanhSachSinhVien danhSachSinhVien2 = new DanhSachSinhVien();

        boolean ketQua1 = danhSachSinhViens.add(danhSachSinhVien1);
        boolean ketQua2 = danhSachSinhViens.add(danhSachSinhVien2);

        System.out.println("Kết quả 1: " + ketQua1);
        System.out.println("Kết quả 2: " + ketQua2);
    }

    public static void buoi4SetAdd() {
        Set<String> maSinhViens = new LinkedHashSet<>();

        System.out.println(maSinhViens.add("2108110118"));
        System.out.println(maSinhViens.add("2108110119"));
        System.out.println(maSinhViens.add("2108110118"));

        String a = "2108110118";
        String b = "2108110119";

        if (a.equals(b)) {
            System.out.println("");
        }
    }

    public static void buoi4SetNew() {
        Set<String> maSinhViens = new LinkedHashSet<>();
    }

    public static void buoi4ListRemove() {
        List<String> strings = new ArrayList<>();

        strings.add("Nguyễn Văn A");
        strings.add("Trần Thị B");
        strings.add("Lê Văn C");
        strings.add("Phạm Thị D");

        strings.remove(3);
        strings.remove("Nguyễn Văn A");

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void buoi4ListSize() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        System.out.println(a.size());
    }

    public static void buoi4ListIndexOf() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        System.out.println(a.indexOf(2));
        System.out.println(a.indexOf(100));
    }

    public static void buoi4ListContains() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        System.out.println(a.contains(2));
        System.out.println(a.contains(100));
    }

    public static void buoi4ListIsEmpty() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);

        System.out.println(a.isEmpty());

        List<Integer> b = new ArrayList<>();
        System.out.println(b.isEmpty());
    }

    public static void buoi4ListGet() {
        List<String> strings = new ArrayList<>();

        strings.add("Nguyễn Văn A");
        strings.add("Trần Thị B");
        strings.add("Lê Văn C");
        strings.add("Phạm Thị D");

        String string = strings.get(2);
        System.out.println(string);
    }

    public static void buoi4ListAdd() {
        List<String> strings = new ArrayList<>();

        strings.add("Nguyễn Văn A");
        strings.add("Trần Thị B");
        strings.add("Lê Văn C");
        strings.add("Phạm Thị D");

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void buoi4MangCoDinh() {
        String[] strings = {
            "Nguyễn Văn A",
            "Trần Thị B",
            "Lê Văn C"
        };

        strings[3] = "Phạm Thị D";

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void buoi3ForEach2() {
        DanhSachSinhVien danhSachSinhVien = new DanhSachSinhVien();

        for (String sinhVien : danhSachSinhVien) {
            System.out.println(sinhVien);
        }
    }

    public static void buoi3ForEach() {
        String[] sinhViens = {
                "Nguyễn Văn A",
                "Trần Thị B",
                "Lê Văn C",
                "Phạm Thị D",
                "Hoàng Văn E"
        };

        System.out.println("Danh sách sinh viên:");
        for (String sinhVien : sinhViens) {
            System.out.println(sinhVien);
        }
    }

    public static void buoi3DoWhile() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Nhập vào một nội dung bất kỳ: ");
            String content = scanner.nextLine();

            if (content.equals("exit")) {
                break;
            }

            System.out.println(content);
            System.out.println();
        }
        while (true);

        scanner.close();
    }

    public static void buoi3While() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(9);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void buoi3For2() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào một số nguyên bất kỳ: ");
            int a = scanner.nextInt();

            int i = 0;
            for ( ; ; ) {
                if (a < 0 && i < a) {
                    break;
                }

                if (a >= 0 && i > a) {
                    break;
                }

                System.out.println(i);

                if (a < 0) {
                    i--;
                }
                else {
                    i++;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3For1() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào một số nguyên bất kỳ: ");
            int a = scanner.nextInt();

            if (a < 0) {
                for (int i = 0 ; i >= a ; i--) {
                    System.out.println(i);
                }
            }
            else {
                for (int i = 0 ; i <= a ; i++) {
                    System.out.println(i);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3ToanTuDieuKien() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào một số thực bất kỳ: ");
            double a = scanner.nextDouble();

            double ketQua = (a % 2 == 0 ? a / 2 : a);
            System.out.println("Kết quả: " + ketQua);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3SwitchCase() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào một số nguyên bất kỳ: ");
            int a = scanner.nextInt();

            switch (a) {
                case 2: {
                    System.out.println("Bạn vừa nhập vào con số 2!");
                    break;
                }

                case 4: {
                    System.out.println("Bạn vừa nhập vào con số 4!");
                    break;
                }

                case 6: {
                    System.out.println("Bạn vừa nhập vào con số 6!");
                    break;
                }

                default: {
                    System.out.println("Con số bạn vừa nhập không nằm trong danh sách!");
                }
            }
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3IfElseIfElse() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào một số nguyên bất kỳ: ");
            int a = scanner.nextInt();

            if (a % 2 == 0) {
                System.out.println("Số nguyên bạn vừa nhập là số chia hết cho 2!");
            }
            else if (a % 3 == 0) {
                System.out.println("Số nguyên bạn vừa nhập là số chia hết cho 3!");
            }
            else {
                System.out.println("Số nguyên bạn vừa nhập không chia hết cho 2 cũng không chia hết cho 3!");
            }
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3IfElse() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào một số nguyên bất kỳ: ");
            int a = scanner.nextInt();

            if (a % 2 == 0) {
                System.out.println("Số nguyên bạn vừa nhập là số chẵn!");
            }
            else {
                System.out.println("Số nguyên bạn vừa nhập là số lẻ!");
            }
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3DauCuaSo() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào số nguyên A: ");
            int a = scanner.nextInt();

            int dauCuaA = (int)Math.signum(a);
            System.out.println("Dấu của A: " + dauCuaA);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3SoMu() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào số nguyên A: ");
            int a = scanner.nextInt();

            System.out.print("Nhập vào số nguyên N: ");
            int b = scanner.nextInt();

            int aMuB = (int) Math.pow(a, b);
            System.out.println("Kết quả của A mũ B: " + aMuB);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3CanBac3() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào số thực A: ");
            double a = scanner.nextDouble();

            double aCanBac3 = Math.cbrt(a);
            System.out.println("Căn bậc 3 của số thức A: " + aCanBac3);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3LamTron() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào số thực A: ");
            double a = scanner.nextDouble();

            double aLamTron = Math.round(a);
            System.out.println("Số thực A sau khi làm tròn: " + aLamTron);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3LamTronXuong() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào số thực A: ");
            double a = scanner.nextDouble();

            double aLamTronXuong = Math.floor(a);
            System.out.println("Số thực A sau khi làm tròn xuống: " + aLamTronXuong);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3LamTronLen() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào số thực A: ");
            double a = scanner.nextDouble();

            double aLamTronLen = Math.ceil(a);
            System.out.println("Số thực A sau khi làm tròn lên: " + aLamTronLen);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3NgauNhien() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập giá trị đầu khoảng: ");
            int from = scanner.nextInt();

            System.out.print("Nhập giá trị cuối khoảng: ");
            int to = scanner.nextInt();

            if (to <= from) {
                System.out.println("Giá trị cuối khoảng phải lớn hơn giá trị đầu khoảng!");
                scanner.close();
                return;
            }

            int random = (int) ((Math.random() * (to - from)) + from);
            System.out.println("Số ngẫu nhiên trong khoảng từ " + from + " đến " + to + " là: " + random);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3GiaTriTuyetDoi() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào số nguyên A: ");
            int a = scanner.nextInt();

            int giaTriTuyetDoiA = Math.abs(a);
            System.out.println("Giá trị tuyệt đối của A là: " + giaTriTuyetDoiA);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3CanBac2() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào số nguyên A: ");
            int a = scanner.nextInt();

            double canBac2CuaA = Math.sqrt(a);
            System.out.println("Căn bậc 2 của số nguyên A là: " + canBac2CuaA);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3Min() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào số nguyên A: ");
            int a = scanner.nextInt();

            System.out.print("Nhập vào số nguyên B: ");
            int b = scanner.nextInt();

            int min = Math.min(a, b);
            System.out.println("Số nhỏ nhất là: " + min);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi3Max() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào số nguyên A: ");
            int a = scanner.nextInt();

            System.out.print("Nhập vào số nguyên B: ");
            int b = scanner.nextInt();

            int max = Math.max(a, b);
            System.out.println("Số lớn nhất là: " + max);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi23_6() {
        String regex = "(\\w+)@(\\w+\\.\\w+)";

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào một email bất kỳ: ");
            String email = scanner.nextLine();

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);

            // Trường hợp không khớp
            if (!matcher.matches()) {
                System.out.println("Email không hợp lệ!");
                scanner.close();
                return;
            }

            // Lấy username và domain name
            String username = matcher.group(1);
            String domainName = matcher.group(2);

            // Thông báo kết quả
            System.out.println("Email bạn nhập là một email hợp lệ!");
            System.out.println("Username: " + username);
            System.out.println("Domain name: " + domainName);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi23_5() {
        String regex = "\\d{5,7}";
        String content = "1234";

        System.out.println(content.matches(regex));
    }

    public static void buoi23_4() {
        String regex = "([cC]hao|[hH]i)";
        String content = "hello";
        System.out.println(content.matches(regex));
    }

    public static void buoi23_3() {
        String regex = "[ayxzB7]";
        // Ý nghĩa: Chuỗi chỉ có 1 ký tự và ký tự đó chỉ có thể là 'a' hoặc 'y' hoặc 'z' hoặc ...
        String content = "77";
        System.out.println(content.matches(regex));

        String regex2 = "[a-z][a-z][a-z]";
        // Ý nghĩa: Chuỗi chỉ có 3 ký tự và 3 ký tự đó là 3 ký tự chữ cái viết thường
        String content2 = "aBj";
        System.out.println(content2.matches(regex2));

        String regex3 = "[^0-9]\\w";
        // Ý nghĩa: Chuỗi chỉ có 2 ký tự và 2 ký tự đó là 2 ký tự chữ số
        String content3 = "Ax";
        System.out.println(content3.matches(regex3));
    }

    public static void buoi2RegularExpressionMatches() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào một email bất kỳ: ");
            String email = scanner.nextLine();

            if (!email.matches("(\\w+)@(\\w+\\.\\w+)")) {
                System.out.println("Email không hợp lệ!");
                scanner.close();
                return;
            }

            System.out.println("Email bạn nhập là một email hợp lệ!");
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2NoRegularExpression() {
        String invalidMessage = "Email bạn vừa nhập không hợp lệ!";

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Vui lòng nhập vào một email: ");
            String email = scanner.nextLine();

            // Kiểm tra không rỗng
            if (email.isBlank()) {
                System.out.println(invalidMessage);
                scanner.close();
                return;
            }

            // Kiểm tra chứa @
            if (!email.contains("@")) {
                System.out.println(invalidMessage);
                scanner.close();
                return;
            }

            // Tách email dựa trên dấu "@" để lấy username và domain name
            String[] splittedEmail = email.split("@");

            // Kiểm tra có đúng 2 phần tử
            if (splittedEmail.length != 2) {
                System.out.println(invalidMessage);
                scanner.close();
                return;
            }

            // Lấy username và domainName
            String username = splittedEmail[0];
            String domainName = splittedEmail[1];

            // Kiểm tra và đảm bảo username có ít nhất 1 ký tự
            if (username.isEmpty()) {
                System.out.println(invalidMessage);
                scanner.close();
                return;
            }

            // Kiểm tra và đảm bảo domain name có ít nhất 1 ký tự
            if (domainName.isEmpty()) {
                System.out.println(invalidMessage);
                scanner.close();
                return;
            }

            // Tách domain name thông qua dấu phân cách là dấu .
            String[] splittedDomainName = domainName.split("\\.");

            if (splittedDomainName.length < 2) {
                System.out.println(invalidMessage);
                scanner.close();
                return;
            }

            if (splittedDomainName[0].isEmpty()) {
                System.out.println(invalidMessage);
                scanner.close();
                return;
            }

            // Kết luận email hợp lệ
            System.out.println("Email bạn nhập là một email hợp lệ!");
            System.out.println("Username là: " + username);
            System.out.println("Domain name là: " + domainName);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2Split() {
        String a = "1,2,3,4,5,6,7,8,9,10";
        String[] numbers = a.split(",");

        for (String number : numbers) {
            System.out.println(number);
        }
    }

    public static void buoi2Replace() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào chuỗi A: ");
            String a = scanner.nextLine();

            System.out.print("Nhập vào chuỗi B: ");
            String b = scanner.nextLine();

            System.out.print("Nhập vào chuỗi C: ");
            String c = scanner.nextLine();

            String ketQua = a.replace(b, c);
            System.out.println("Kết quả: " + ketQua);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2IsEmpty() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Vui lòng nhập vào một nội dung gì đó mà không phải rỗng:");
            String a = scanner.nextLine();

            if (!a.isBlank()) {
                System.out.println("Cảm ơn bạn!");
            }
            else {
                System.out.println("Tôi đã yêu cầu bạn nhập không rỗng cơ mà!");
            }
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2LastIndexOf() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào nội dung A: ");
            String a = scanner.nextLine();

            System.out.print("Nhập vào nội dung B: ");
            String b = scanner.nextLine();

            System.out.println(a.lastIndexOf(b));
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2IndexOf() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào nội dung A: ");
            String a = scanner.nextLine();

            System.out.print("Nhập vào nội dung B: ");
            String b = scanner.nextLine();

            System.out.println(a.indexOf(b));
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2Date() {
        Date date = new Date();

        // Ngày, tháng, năm giờ:phút:giây
        String format = "%td, %<tm, %<tY %<tH:%<tM:%<tS";

        String ketQua = String.format(format, date);

        System.out.println("Kết quả: ".concat(ketQua));
    }

    public static void buoi2Double() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Vui lòng nhập vào một số thực: ");
            double a = scanner.nextDouble();

            String format = "Số nguyên bạn vừa nhập là: %.3f";
            String ketQua = String.format(format, a);

            System.out.println("Kết quả: " + ketQua);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2Integer() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Vui lòng nhập vào một số nguyên: ");
            int a = scanner.nextInt();

            // 00010
            // 00255
            String format = "Số nguyên bạn vừa nhập là: %05d";
            String ketQua = String.format(format, a);

            System.out.println("Kết quả: " + ketQua);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2FormatString() {
        String a = "Hello, %-6s. Tôi là %s, rất vui được gặp bạn!";
        String name = "Hải";
        String myName = "Văn A";

        String hoanChinh = String.format(a, name, myName);
        System.out.println("Hoàn chỉnh: " + hoanChinh);
    }

    public static void buoi2Contains() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào email bạn mong muốn: ");
            String a = scanner.nextLine();

            boolean hopLe = a.contains("@") && a.contains(".");
            System.out.println("Email hợp lệ: " + hopLe);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    // Postfix
    // 2108110118_cntt
    // 2108110125_ktqt
    public static void buoi2EndsWith() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào nội dung A: ");
            String a = scanner.nextLine();

            System.out.print("Nhập vào nội dung B: ");
            String b = scanner.nextLine();

            System.out.println(a.endsWith(b));
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    // Prefix
    // cntt_2108110118
    // ktqt_2108110125
    public static void buoi2StartsWith() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào nội dung A: ");
            String a = scanner.nextLine();

            System.out.print("Nhập vào nội dung B: ");
            String b = scanner.nextLine();

            System.out.println(a.startsWith(b));
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2CharAt() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập một nội dung bất kỳ: ");
            String a = scanner.nextLine();

            if (a.isBlank()) {
                System.out.println("Nội dung bạn nhập vào rỗng!");
            }
            else {
                int doDaiA = a.length();

                int viTriDauTien = 0;
                int viTriGiua = doDaiA / 2;
                int viTriCuoiCung = doDaiA-1;

                char kyTuDauTien = a.charAt(viTriDauTien);
                char kyTuGiua = a.charAt(viTriGiua);
                char kyTuCuoiCung = a.charAt(viTriCuoiCung);

                System.out.println("Ký tự đầu tiên: " + kyTuDauTien);
                System.out.println("Ký tự giữa: " + kyTuGiua);
                System.out.println("Ký tự cuối cùng: " + kyTuCuoiCung);
            }
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2Length() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập một nội dung bất kỳ: ");
            String a = scanner.nextLine();

            System.out.println("Độ dài của nội dung bạn nhập là: " + a.length());
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2CompareToIgnoreCase() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào nội dung A: ");
            String a = scanner.nextLine();

            System.out.print("Nhập vào nội dung B: ");
            String b = scanner.nextLine();

            System.out.println(a.compareToIgnoreCase(b));
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2CompareTo() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào nội dung A: ");
            String a = scanner.nextLine();

            System.out.print("Nhập vào nội dung B: ");
            String b = scanner.nextLine();

            System.out.println(a.compareTo(b));
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2EqualsIgnoreCase() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào nội dung A: ");
            String a = scanner.nextLine();

            System.out.print("Nhập vào nội dung B: ");
            String b = scanner.nextLine();

            System.out.println(a.equalsIgnoreCase(b));
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2Equals() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập vào nội dung A: ");
            String a = scanner.nextLine();

            System.out.print("Nhập vào nội dung B: ");
            String b = scanner.nextLine();

            System.out.println(a.equals(b));
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2NoiChuoiConcat() {
        // Xin chào, tôi là Lê Quốc Hải!
        String xinChao = "Xin chào";
        String xinChaoHoanChinh = xinChao.concat(", tôi là Lê Quốc Hải!");
        System.out.println(xinChaoHoanChinh);
    }

    public static void buoi2NoiChuoiJoin() {
        String a = "Xin chào";
        String b = "tất cả các bạn";
        String c = "chào mừng các bạn đến với GDU!";
        // Xin chào, tất cả các bạn, chào mừng các bạn đến với GDU!

        String ketQua = String.join(", ", a, b, c);
        System.out.println(ketQua);
    }

    public static void buoi2PhepPhuDinh() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số nguyên A: ");
            int a = scanner.nextInt();

            System.out.print("Nhập số nguyên B: ");
            int b = scanner.nextInt();

            boolean ketQua = !(a <= b);
            System.out.println("A có bé hơn B hoặc lớn hơn C không ? Kết quả là: " + ketQua);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2PhepHoac() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số nguyên A: ");
            int a = scanner.nextInt();

            System.out.print("Nhập số nguyên B: ");
            int b = scanner.nextInt();

            System.out.print("Nhập số nguyên C: ");
            int c = scanner.nextInt();

            boolean ketQua = a < b || a > c;
            System.out.println("A có bé hơn B hoặc lớn hơn C không ? Kết quả là: " + ketQua);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2PhepVa() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số nguyên A: ");
            int a = scanner.nextInt();

            System.out.print("Nhập số nguyên B: ");
            int b = scanner.nextInt();

            boolean ketQua = a < b && a != 0;
            System.out.println("A có bé hơn B và khác 0 không ? Kết quả là: " + ketQua);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2SoSanhLonHonHoacBang() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số nguyên A: ");
            int a = scanner.nextInt();

            System.out.print("Nhập số nguyên B: ");
            int b = scanner.nextInt();

            boolean ketQua = a >= b;
            System.out.println("A có nhỏ hơn hoặc bằng B không ? Kết quả là: " + ketQua);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2SoSanhNhoHonHoacBang() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số nguyên A: ");
            int a = scanner.nextInt();

            System.out.print("Nhập số nguyên B: ");
            int b = scanner.nextInt();

            boolean ketQua = a <= b;
            System.out.println("A có nhỏ hơn hoặc bằng B không ? Kết quả là: " + ketQua);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2SoSanhLonHon() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số nguyên A: ");
            int a = scanner.nextInt();

            System.out.print("Nhập số nguyên B: ");
            int b = scanner.nextInt();

            boolean ketQua = a > b;
            System.out.println("A có lớn hơn B không ? Kết quả là: " + ketQua);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2SoSanhNhoHon() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số nguyên A: ");
            int a = scanner.nextInt();

            System.out.print("Nhập số nguyên B: ");
            int b = scanner.nextInt();

            boolean ketQua = a < b;
            System.out.println("A có nhỏ hơn B không ? Kết quả là: " + ketQua);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2SoSanhKhac() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số nguyên A: ");
            int a = scanner.nextInt();

            System.out.print("Nhập số nguyên B: ");
            int b = scanner.nextInt();

            boolean ketQua = a != b;
            System.out.println("A có khác B không ? Kết quả là: " + ketQua);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2SoSanhBang() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số nguyên A: ");
            int a = scanner.nextInt();

            System.out.print("Nhập số nguyên B: ");
            int b = scanner.nextInt();

            boolean ketQua = a == b;
            System.out.println("Kết quả: " + ketQua);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2PhepTangLenMotDonVi() {
        int a = 1;
        System.out.println("A: " + a);

        a++;
        System.out.println("A: " + a);

        ++a;
        System.out.println("A: " + a);

        int b = a++;
        System.out.println("B: " + b);

        int c = ++a;
        System.out.println("C: " + c);
    }

    public static void buoi2PhepChiaLayDu2() {
        int a = 10;
        int b = 2;
        int c = 3;

        a %= b;
        c %= b;

        System.out.println("A: " + a);
        System.out.println("C: " + c);
    }

    public static void buoi2PhepChiaLayDu() {
        int a = 10;
        int b = 2;
        int c = 3;

        System.out.println("A chia hết cho B: " + a % b);
        System.out.println("A chia hết cho C: " + a % c);
    }

    public static void buoi2PhepChia() {
        double a = 1;
        double b = a / 2;

        b /= 2;

        System.out.println("Kết quả của B: " + b);
    }

    public static void buoi2PhepNhan() {
        double a = 0.25;
        double b = a * 2;

        b *= 2;

        System.out.println("Giá trị biến B: " + b);
    }

    public static void buoi2PhepTru() {
        double a = 10.2;
        double b = 0.25;

        double ketQua = a - b;

        a -= b;

        System.out.println("Kết quả: " + ketQua);
        System.out.println("Giá trị biến A: " + a);
    }

    public static void buoi2PhepCong2() {
        int soNguyen = 154;

        String chuoi = "Số nguyên là: ";

        String ketQua = soNguyen + chuoi;

        System.out.println(ketQua);
    }

    public static void buoi2PhepCong() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số nguyên A: ");
            int a = scanner.nextInt();

            System.out.print("Nhập số nguyên B: ");
            int b = scanner.nextInt();

            int ketQua = a + b;
            System.out.println("Kết quả: " + ketQua);

            a += b;
            System.out.println("A sau khi cộng dồn B: " + a);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        scanner.close();
    }

    public static void buoi2Xuat() {
        System.out.print("Xuất nhưng không xuống dòng nè!");
        System.out.println("Xuất xong xuống dòng nè!");
        System.err.println("Đây là thông báo lỗi nè!");
    }

    public static void buoi2NhapDouble() {
        // Khởi tạo đối tượng Scanner
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập vào một con số nguyên và in ra màn hình
        System.out.println("Bạn hãy nhập một con số nguyên double: ");

        try {
            double soThucDaNhap = scanner.nextDouble();
            System.out.println("Số thực double bạn đã nhập: " + soThucDaNhap);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        // Dùng xong nhớ đóng Scanner
        scanner.close();
    }

    public static void buoi2NhapInt() {
        // Khởi tạo đối tượng Scanner
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập vào một con số nguyên và in ra màn hình
        System.out.println("Bạn hãy nhập một con số nguyên int: ");

        try {
            int soNguyenDaNhap = scanner.nextInt();
            System.out.println("Số nguyên int bạn đã nhập: " + soNguyenDaNhap);
        }
        catch (Exception e) {
            System.out.println("Nội dung bạn nhập không hợp lệ!");
        }

        // Dùng xong nhớ đóng Scanner
        scanner.close();
    }

    public static void buoi2NhapChuoi() {
        // Khởi tạo đối tượng Scanner
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập gì đó và in ra
        System.out.println("Bạn hãy nhập cái gì đó: ");
        String noiDungDaNhap = scanner.nextLine();
        System.out.println("Nội dung bạn đã nhập: " + noiDungDaNhap);

        // Đóng đối tượng scanner
        scanner.close();
    }

    public static void buoi1() {
//        char aVietThuong = 'a';
//        char aVietHoa = Character.toUpperCase(aVietThuong);
//
//        System.out.println("A viet thuong: " + aVietThuong);
//        System.out.println("A viet hoa: " + aVietHoa);

//        char cVietHoa = 'C';
//        char cVietThuong = Character.toLowerCase(cVietHoa);
//
//        System.out.println("C viet hoa: " + cVietHoa);
//        System.out.println("C viet thuong: " + cVietThuong);

//        char hVietHoa = 'H';
//        boolean hVietHoaNhi = Character.isUpperCase(hVietHoa);
//        boolean hVietThuongNhi = Character.isLowerCase(hVietHoa);
//
//        System.out.println("H viet hoa: " + hVietHoa);
//        System.out.println("H viet hoa nhỉ? " + hVietHoaNhi);
//        System.out.println("H viet thuong nhỉ? " + hVietThuongNhi);

//        char a = ' ';
//        boolean aLaChuNhi = Character.isLetter(a);
//        boolean aLaKhoangTrangNhi = Character.isWhitespace(a);
//        boolean aLaSoNhi = Character.isDigit(a);
//
//        System.out.println("A: " + a);
//        System.out.println("A la chu nhỉ? " + aLaChuNhi);
//        System.out.println("A la khoang trang nhỉ? " + aLaKhoangTrangNhi);
//        System.out.println("A la so nhỉ? " + aLaSoNhi);

//        char a = 'a';
//        boolean aLaChuNhi = Character.isLetter(a);
//        boolean aLaKhoangTrangNhi = Character.isWhitespace(a);
//        boolean aLaSoNhi = Character.isDigit(a);
//
//        System.out.println("A: " + a);
//        System.out.println("A la chu nhỉ? " + aLaChuNhi);
//        System.out.println("A la khoang trang nhỉ? " + aLaKhoangTrangNhi);
//        System.out.println("A la so nhỉ? " + aLaSoNhi);

//        char a = '1';
//        boolean aLaChuNhi = Character.isLetter(a);
//        boolean aLaKhoangTrangNhi = Character.isWhitespace(a);
//        boolean aLaSoNhi = Character.isDigit(a);
//
//        System.out.println("A: " + a);
//        System.out.println("A la chu nhỉ? " + aLaChuNhi);
//        System.out.println("A la khoang trang nhỉ? " + aLaKhoangTrangNhi);
//        System.out.println("A la so nhỉ? " + aLaSoNhi);

//        String[] strs = {
//                "Xin chào",
//                "GDUers",
//                "Chào mừng đến với",
//                "GDU!"
//        };
    }
}
