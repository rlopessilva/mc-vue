package fr.softeam.mc.resources;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class BaseResource {
}
