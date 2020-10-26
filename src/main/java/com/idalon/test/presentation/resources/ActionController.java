package com.idalon.test.presentation.resources;

import com.idalon.test.core.bl.service.ActionService;
import com.idalon.test.core.util.Mapper;
import com.idalon.test.presentation.dto.ActionDto;
import com.idalon.test.presentation.dto.StatusDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.idalon.test.TestApplication.REST_API_VERSION;

/**
 * @author Siyar
 */
@RestController
@RequestMapping(REST_API_VERSION)
public class ActionController {
    private final ActionService actionService;

    public ActionController(final ActionService actionService) {
        this.actionService = actionService;
    }
    // TODO: Add Some validation
    @GetMapping("actions/category/{category}")
    public List<ActionDto> getAction(@PathVariable String category) {
        return Mapper.map(actionService.get(category), ActionDto::createDto, ArrayList::new);
    }

    // TODO: Add Some validation
    @PostMapping("actions")
    public StatusDto addAction(@RequestBody ActionDto actionDto) {
        return new StatusDto(actionService.add(actionDto.toAction()));
    }

}
