import java.util.Iterator;

public class DanhSachSinhVien implements Iterable<String> {

    private String[] sinhViens;
    private int index;

    public DanhSachSinhVien() {
        sinhViens = new String[]{
            "Nguyen Van A",
            "Nguyen Van B",
            "Nguyen Van C",
            "Nguyen Van D",
            "Nguyen Van E",
            "Nguyen Van F",
            "Nguyen Van G",
            "Nguyen Van H",
            "Nguyen Van I",
            "Nguyen Van K",
        };

        index = -1;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return index < sinhViens.length;
            }

            @Override
            public String next() {
                index++;
                return sinhViens[index];
            }
        };
    }

}
