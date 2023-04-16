package frey.house.ega.controller;

import frey.house.ega.dto.ClientDto;
import frey.house.ega.servicesImplementations.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(this.clientService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        ClientDto clientDto = this.clientService.findById(id);
        return new ResponseEntity<ClientDto>(clientDto, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody ClientDto clientDto) {

        if (clientDto == null){
            return new ResponseEntity<>("Données requises manquantes!", HttpStatus.BAD_REQUEST);
        }
        ClientDto createdClient = this.clientService.save(clientDto);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ClientDto clientDto,
                                    @PathVariable("id") Long id) {
        if (clientDto == null) {
            return new ResponseEntity<>("Données requises manquantes!", HttpStatus.BAD_REQUEST);
        }
        ClientDto updated = this.clientService.update(clientDto, id);
        return new ResponseEntity<ClientDto>(updated, HttpStatus.OK);
    }
}
