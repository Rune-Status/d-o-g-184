package com.jagex;

public class Inventory extends Node {

    static NodeTable cache = new NodeTable(32);

    int[] ids;
    int[] stackSizes;

    Inventory() {
        this.ids = new int[]{-1};
        this.stackSizes = new int[]{0};
    }

    static int getCountIncludingStacks(int key, int itemId) {
        Inventory inventory = (Inventory) cache.lookup((long) key);
        if (inventory == null) {
            return 0;
        } else if (itemId == -1) {
            return 0;
        }

        int total = 0;
        for (int i = 0; i < inventory.stackSizes.length; ++i) {
            if (inventory.ids[i] == itemId) {
                total += inventory.stackSizes[i];
            }
        }
        return total;
    }

    static int getItemIdAt(int key, int index) {
        Inventory inventory = (Inventory) cache.lookup((long) key);
        if (inventory == null) {
            return -1;
        }
        return index >= 0 && index < inventory.ids.length ? inventory.ids[index] : -1;
    }

    static void addItem(int key, int index, int id, int stack) {
        Inventory inventory = (Inventory) cache.lookup((long) key);
        if (inventory == null) {
            inventory = new Inventory();
            cache.put(inventory, (long) key);
        }

        if (inventory.ids.length <= index) {
            int[] ids = new int[index + 1];
            int[] stacks = new int[index + 1];

            for (int i = 0; i < inventory.ids.length; ++i) {
                ids[i] = inventory.ids[i];
                stacks[i] = inventory.stackSizes[i];
            }

            for (int i = inventory.ids.length; i < index; ++i) {
                ids[i] = -1;
                stacks[i] = 0;
            }

            inventory.ids = ids;
            inventory.stackSizes = stacks;
        }

        inventory.ids[index] = id;
        inventory.stackSizes[index] = stack;
    }

    static void clear(int key) {
        Inventory inventory = (Inventory) cache.lookup((long) key);
        if (inventory != null) {
            for (int i = 0; i < inventory.ids.length; ++i) {
                inventory.ids[i] = -1;
                inventory.stackSizes[i] = 0;
            }

        }
    }

    static int getItemStackSizeAt(int key, int index) {
        Inventory inventory = (Inventory) cache.lookup((long) key);
        if (inventory == null) {
            return 0;
        }
        return index >= 0 && index < inventory.stackSizes.length ? inventory.stackSizes[index] : 0;
    }
}
