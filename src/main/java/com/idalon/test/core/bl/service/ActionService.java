package com.idalon.test.core.bl.service;

import com.idalon.test.core.bl.data.Action;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Siyar
 */
@Service
public class ActionService {
    private final Map<String, Action> actions;
    private final Map<String, List<Action>> categories;

    public ActionService() {
        this.actions = new HashMap<>();
        this.categories = new HashMap<>();
    }

    public boolean add(final Action action) {
        synchronized (actions) {
            if (actions.containsKey(action.binding)) {
                return false;
            }
            actions.put(action.binding, action);
            if (!categories.containsKey(action.category)) {
                categories.put(action.category, new LinkedList<>());
            }
            categories.get(action.category).add(action);
        }
        return true;
    }

    public List<Action> get(final String category) {
        return categories.get(category);
    }
}
