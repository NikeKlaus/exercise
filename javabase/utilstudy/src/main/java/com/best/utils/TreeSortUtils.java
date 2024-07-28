package com.best.utils;

import com.best.entity.Menu;
import com.best.handle.MenuTreeHandle;

import java.util.*;

/**
 * @author cctv14
 * @data 2023/10/29 20:44
 * @description
 */
public class TreeSortUtils {

    public static void main(String[] args) {
        TreeSortUtils treeSortUtils = new TreeSortUtils();
        System.out.println(treeSortUtils.deleteIdList("1"));
    }

    public List<Integer> deleteIdList(String nodeId) {
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        List<Menu> allMenus = MenuTreeHandle.buildMenuList();
        Map<String, List<Menu>> map = new HashMap<>();
        for (Menu menu : allMenus) {
            if (menu.getPid() != null) {
                if (map.containsKey(menu.getPid())) {
                    map.get(menu.getPid()).add(menu);
                } else {
                    map.put(menu.getPid(), new ArrayList<>(Collections.singleton(menu)));
                }
            }
        }
        for (Menu menu : allMenus) {
            if (!map.containsKey(menu.getNodeId())) {
                map.put(menu.getNodeId(), new ArrayList<>());
            }
        }
        dfs(nodeId, idList, map);
        return idList;
    }

    private void dfs(String nodeId, List<Integer> idList, Map<String, List<Menu>> map) {
        List<Menu> childMenus = map.get(nodeId);
        if (childMenus == null || childMenus.isEmpty()) {
            return;
        }
        for (Menu childMenu : childMenus) {
            idList.add(childMenu.getId());
            dfs(childMenu.getNodeId(), idList, map);
        }
    }

    public Map<String, List<Menu>> getChildMenu(List<Menu> allMenus) {
        Map<String, List<Menu>> map = new HashMap<>();
        for (Menu curMenu : allMenus) {
            List<Menu> child = new ArrayList<>();
            for (Menu menu : allMenus) {
                if (curMenu.getNodeId().equals(menu.getPid())) {
                    child.add(menu);
                }
            }
            if (!child.isEmpty()) {
                map.put(curMenu.getName(), child);
            }
        }
        return map;
    }

}


