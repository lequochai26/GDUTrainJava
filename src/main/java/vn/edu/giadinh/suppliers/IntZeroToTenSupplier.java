package vn.edu.giadinh.suppliers;

import vn.edu.giadinh.interfaces.Supplier;

import java.util.List;

public class IntZeroToTenSupplier implements Supplier<List<Integer>> {
    @Override
    public List<Integer> supply() {
        return List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }
}
