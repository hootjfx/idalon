package com.idalon.test;

import com.idalon.test.presentation.dto.ActionDto;
import com.idalon.test.presentation.resources.ActionController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.idalon.test.core.data.ActionFactory.createAction;
import static com.idalon.test.core.data.ActionFactory.createRandomAction;
import static org.junit.Assert.assertEquals;

/**
 * @author Siyar
 */
@SpringBootTest
public class ActionControllerTest {
    @Autowired
    private ActionController actionController;

    @Test
    public void addOneAction() {
        // given
        final ActionDto actionDto = createAction();
        // when
        actionController.addAction(actionDto);
        final List<ActionDto> actions = actionController.getAction(actionDto.action.substring(0, actionDto.action.indexOf(".") + 1));
        // then
        assertEquals(1, actions.size());
        assertEquals(actionDto.action, actions.get(0).action);
        assertEquals(false, actionController.addAction(actionDto).success);


    }

    @Test
    public void addMultipleAction() {
        // given
        final int n = 10000;
        final int m = 100;

        final List<ActionDto> actions = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            final ActionDto actionDto = createRandomAction();
            for (int j = 0; j < m; j++) {
                actions.add(actionDto);
            }
        }
        // when
        Collections.shuffle(actions);
        int res = actions.parallelStream().mapToInt(actionDto -> actionController.addAction(actionDto).success ? 1 : 0).sum();
        // then
        assertEquals(actions.stream().map(actionDto -> actionDto.binding).distinct().count(), res);
    }


}
