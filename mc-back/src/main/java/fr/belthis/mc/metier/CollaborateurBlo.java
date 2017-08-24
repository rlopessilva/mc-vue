package fr.belthis.mc.metier;

import fr.belthis.mc.metier.dto.CollaborateurDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CollaborateurBlo {

    public List<CollaborateurDTO> recupererCollaborateurs() {

        CollaborateurDTO collaborateurDTO = new CollaborateurDTO();
        collaborateurDTO.withNom("Lopes").withPrenom("Ricardo");

        CollaborateurDTO collaborateurDTO2 = new CollaborateurDTO();
        collaborateurDTO2.withNom("Le Galludec").withPrenom("Sébastien");

        List<CollaborateurDTO> collaborateurDTOList = new ArrayList<>();
        collaborateurDTOList.add(collaborateurDTO);
        collaborateurDTOList.add(collaborateurDTO2);

        return collaborateurDTOList;

    }

    public CollaborateurDTO recupererCollaborateur(final String idCollaborator) {
        CollaborateurDTO collaborateurDTO = new CollaborateurDTO();
        collaborateurDTO.withNom("Lopes").withPrenom("Ricardo");

        return collaborateurDTO;
    }
}
