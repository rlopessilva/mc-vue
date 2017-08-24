package fr.belthis.mc.resources;


import fr.belthis.mc.metier.CollaborateurBlo;
import fr.belthis.mc.metier.dto.CollaborateurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollaborateurResource extends BaseResource{

    @Autowired
    private CollaborateurBlo collaborateurBlo;

    @GetMapping(path = "/collaborateurs", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CollaborateurDTO> recupererCollaborateurs() {
        return collaborateurBlo.recupererCollaborateurs();
    }

    @GetMapping(path = "/collaborateurs/{id_collaborateur}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CollaborateurDTO recupererCollaborateur(@PathVariable(name="id_collaborateur") final String idCollaborateur) {
        return collaborateurBlo.recupererCollaborateur(idCollaborateur);
    }

}
