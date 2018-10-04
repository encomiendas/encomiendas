/**
 * 
 */
package py.com.domainsoft.entidad.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.entidad.dtos.ClienteDTO;
import py.com.domainsoft.entidad.entities.ClienteEntity;
import py.com.domainsoft.entidad.mapper.ClienteMapper;
import py.com.domainsoft.entidad.repositories.ClienteRepository;
import py.com.domainsoft.entidad.services.ClienteService;
import py.com.domainsoft.seguridad.mapper.PersonaMapper;
import py.com.domainsoft.seguridad.services.PersonaService;

/**
 * @author jaime
 *
 */
@Service
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepo;
    
    private final ClienteMapper clienteMapper;
    
    private final PersonaService personaService;
    
    private final PersonaMapper personaMapper;

    public ClienteServiceImpl(ClienteRepository clienteRepo,
            PersonaService personaService,
            PersonaMapper personaMapper,
            ClienteMapper clienteMapper) {
        this.clienteRepo = clienteRepo;
        this.clienteMapper = clienteMapper;
        this.personaService = personaService;
        this.personaMapper = personaMapper;
    }
    
    @Override
    public Page<ClienteDTO> findAllPageable(Pageable pageable) {
        Page<ClienteEntity> pageResponse = clienteRepo.findAll(pageable);
        return pageResponse.map(clienteMapper::entityToDto);
    }

    @Override
    public void grabarCliente(ClienteDTO cliente) {
        
        cliente.getPersona().setEstado(cliente.isEstado());
        cliente.setPersona(personaMapper.entityToDto(personaService.grabarPersona(cliente.getPersona())));
        clienteRepo.save(clienteMapper.dtoToEntity(cliente));
        
        
    }

    @Override
    public List<ClienteDTO> findAll() {
        return clienteMapper.entityListToDtoList(WebUtils.toList(clienteRepo.findAll()));
    }

    @Override
    public ClienteDTO findByIdCliente(Integer idCliente) {
        return clienteMapper.entityToDto(clienteRepo.getOne(idCliente));
    }

    @Override
    public List<ClienteDTO> findClienteByParams(String json) {
        Gson gson =  new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        ClienteDTO cliente = gson.fromJson(json, ClienteDTO.class);
        
        if (cliente.getPersona().getDocumento() == null || cliente.getPersona().getDocumento().equals("")) {
            if(cliente.getPersona().getNombres() == null || cliente.getPersona().getNombres().equals("")){
                
                return clienteMapper.entityListToDtoList(WebUtils.toList(
                        clienteRepo.findByPersonaApellidosIgnoreCaseContaining(
                                cliente.getPersona().getApellidos())));
            }else if(cliente.getPersona().getApellidos() == null || cliente.getPersona().getApellidos().equals("")){
                return clienteMapper.entityListToDtoList(WebUtils.toList(
                        clienteRepo.findByPersonaNombresIgnoreCaseContaining(
                                cliente.getPersona().getNombres())));
            }else{                
                return clienteMapper.entityListToDtoList(WebUtils.toList(
                        clienteRepo.findByPersonaNombresOrPersonaApellidosIgnoreCaseContaining(
                                cliente.getPersona().getNombres(), cliente.getPersona().getApellidos())));
            }
        }else{
            return clienteMapper.entityListToDtoList(WebUtils.toList(
                    clienteRepo.findByPersonaTipoDocumentoIdTipoDocumentoAndPersonaDocumento(
                            cliente.getPersona().getTipoDocumento().getIdTipoDocumento(), cliente.getPersona().getDocumento())));
        }
    }

}
