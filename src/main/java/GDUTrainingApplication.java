import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GDUTrainingApplication {
    public static void main(String[] args) {
        buoi23_6();
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