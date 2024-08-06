package vn.edu.giadinh.suppliers;

import vn.edu.giadinh.interfaces.Supplier;

import java.util.List;

public class IntTenToTwentySupplier implements Supplier<List<Integer>> {
    @Override
    public List<Integer> supply() {
        return List.of(10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
    }
}
