package py.com.domainsoft.web.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import py.com.domainsoft.entidad.dtos.ClienteDTO;
import py.com.domainsoft.entidad.services.ClienteService;

@RestController
@RequestMapping(value = "/api/v1/clientes")
public class ClienteRestController {

    private final ClienteService clienteService;

    public ClienteRestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/find-by-params")
    public List<ClienteDTO> home(Principal principal,
            @RequestParam("cliente") String cliente) {
        return clienteService.findClienteByParams(cliente);
    }
    
    @GetMapping("/find-by-documento")
    public ClienteDTO findByDoc(Principal principal,
            @RequestParam("documento") String documento) {
        return clienteService.findByDocumento(documento);
    }

}
