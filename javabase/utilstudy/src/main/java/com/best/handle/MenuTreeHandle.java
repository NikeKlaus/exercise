package com.best.handle;

import com.best.entity.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author cctv14
 * @data 2023/10/29 20:47
 * @description
 */
public class MenuTreeHandle {

    public static List<Menu> buildMenuTree() {
        List<Menu> menuTree = new ArrayList<>();
        List<Menu> oneChildMenu = new ArrayList<>();
        oneChildMenu.add(new Menu(11, "1-1", "1", "1-1",
                Arrays.asList(new Menu(111, "1-1-1", "1-1", "1-1-1", null),
                        new Menu(112, "1-1-2", "1-1", "1-1-2", null))));
        oneChildMenu.add(new Menu(12, "1-2", "1", "1-2",
                Arrays.asList(new Menu(121, "1-2-1", "1-2", "1-2-1", null),
                        new Menu(122, "1-2-2", "1-2", "1-2-2", null))));
        List<Menu> twoChildMenu = new ArrayList<>();
        twoChildMenu.add(new Menu(21, "2-1", "2", "2-1",
                Collections.singletonList(new Menu(211, "2-1-1", "2-1", "2-1-1", null))));
        List<Menu> threeChildMenu = new ArrayList<>();
        threeChildMenu.add(new Menu(31, "3-1", "3", "3-1",
                Arrays.asList(new Menu(311, "3-1-1", "3-1", "3-1-1", null),
                        new Menu(312, "3-1-2", "3-1", "3-1-2", null))));
        threeChildMenu.add(new Menu(32, "3-2", "3", "3-2", null));

        menuTree.add(new Menu(1, "1", null, "1", oneChildMenu));
        menuTree.add(new Menu(2, "2", null, "2", twoChildMenu));
        menuTree.add(new Menu(3, "3", null, "3", threeChildMenu));
        return menuTree;
    }


    public static List<Menu> buildMenuList() {
        List<Menu> menuTree = new ArrayList<>();
        menuTree.add(new Menu(1, "1", null, "1", null));

        menuTree.add(new Menu(11, "1-1", "1", "1-1", null));
        menuTree.add(new Menu(111, "1-1-1", "1-1", "1-1-1", null));
        menuTree.add(new Menu(112, "1-1-2", "1-1", "1-1-2", null));

        menuTree.add(new Menu(12, "1-2", "1", "1-2", null));
        menuTree.add(new Menu(121, "1-2-1", "1-2", "1-2-1", null));
        menuTree.add(new Menu(122, "1-2-2", "1-2", "1-2-2", null));

        menuTree.add(new Menu(2, "2", null, "2", null));
//        menuTree.add(new Menu(21,"2-1", "2", "2-1",null));
//        menuTree.add(new Menu(211,"2-1-1", "2-1", "2-1-1", null));

        menuTree.add(new Menu(3, "3", null, "3", null));
        menuTree.add(new Menu(31, "3-1", "3", "3-1", null));
        menuTree.add(new Menu(32, "3-2", "3", "3-2", null));
        menuTree.add(new Menu(311, "3-1-1", "3-1", "3-1-1", null));
        menuTree.add(new Menu(312, "3-1-2", "3-1", "3-1-2", null));

        return menuTree;
    }
}
