package com.idalon.test.core.bl.data;

/**
 * @author Siyar
 */
public class Action {
    public final String operation;
    public final String category;
    public final String description;
    public final String binding;

    public Action(final String category,
                  final String operation,
                  final String description,
                  final String binding) {
        this.operation = operation;
        this.category = category;
        this.description = description;
        this.binding = binding;
    }

}
