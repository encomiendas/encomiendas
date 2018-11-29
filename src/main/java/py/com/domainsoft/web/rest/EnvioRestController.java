package py.com.domainsoft.web.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import py.com.domainsoft.entidad.dtos.EnvioDTO;
import py.com.domainsoft.envios.services.EnvioService;
import py.com.domainsoft.web.base.BaseViewController;

@RestController
@RequestMapping(value = "/api/v1/envio")
public class EnvioRestController extends BaseViewController {

    private final EnvioService envioService;

    public EnvioRestController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @PostMapping()
    public ModelAndView grabarGiro(@RequestParam("cabecera") String cabecera,
            Principal principal) {
        EnvioDTO dto = new Gson().fromJson(cabecera, EnvioDTO.class);
        envioService.grabarEnvio(dto, dto.getDetalles(),
                getUsuarioDTO(principal));
        return new ModelAndView("redirect:/persona-exitoso");

    }

    @PostMapping("/procesar")
    public ModelAndView procesarGiro(@RequestParam("cabecera") String cabecera,
            Principal principal) {
        System.out.println(cabecera);
        EnvioDTO dto = new GsonBuilder().setDateFormat("yyyy-MM-dd").create()
                .fromJson(cabecera, EnvioDTO.class);
        envioService.procesar(dto, getUsuarioDTO(principal));
        return new ModelAndView("redirect:/persona-exitoso");

    }

    @GetMapping("/find-by-params")
    public List<EnvioDTO> home(Principal principal,
            @RequestParam("cliente") String cliente,
            @RequestParam("fechadesde") String fechadesde,
            @RequestParam("fechahasta") String fechahasta) {
        return envioService.getByParams(fechadesde, fechahasta, cliente);
    }

}
