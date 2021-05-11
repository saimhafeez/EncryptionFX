package com.hacktivist.encryption;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FreshRandomGenerator<T> {
    private List<T> itemList;
    private List<Integer> generatedList = new ArrayList<>();

    public FreshRandomGenerator(List<T> itemList) {
        this.itemList = itemList;
    }

    public Integer generate() {
        Random randomGenerator = new Random();
        int size = itemList.size();

        if (generatedList.size() == size) {
            generatedList.clear();
        }

        while (true) {
            int random = randomGenerator.nextInt(size);
            if (!generatedList.contains(random)) {
                generatedList.add(random);

                return random;
            }
        }
    }

    public T generateItem() {
        Integer random = generate();
        return itemList.get(random);
    }
}

