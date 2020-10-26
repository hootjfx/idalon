package com.idalon.test.presentation.dto;

import com.idalon.test.core.bl.data.Action;

/**
 * @author Siyar
 */
public class ActionDto {
    public final String action;
    public final String description;
    public final String binding;

    public ActionDto(final String action,
                     final String description,
                     final String binding) {
        this.action = action;
        this.description = description;
        this.binding = binding;
    }

    public static ActionDto createDto(final Action action) {
        return new ActionDto(action.category + action.operation, action.description, action.binding);
    }

    public Action toAction() {
        final String[] cName = action.split("\\.");
        return new Action(cName[0] + ".", cName[1], description, binding);
    }
}
