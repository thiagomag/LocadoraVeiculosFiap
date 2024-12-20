package br.com.postechfiap.locadoraveiculosfiap.application.dto;

import br.com.postechfiap.locadoraveiculosfiap.domain.model.Endereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Endereco", description = "Representa um endereço", example = """
        {
          "id": 123,
          "logradouro": "Rua das Flores",
          "numero": "123",
          "complemento": "Apto 123",
          "bairro": "Jardim das Flores",
          "cidade": "São Paulo",
          "estado": "SP",
          "cep": "12345-678"
        }
        """)
public class EnderecoDto {

    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;


    public static EnderecoDto from(Endereco endereco) {
        return EnderecoDto.builder()
                .id(endereco.getId())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }

    public static List<EnderecoDto> from(List<Endereco> enderecos) {
        return enderecos.stream().map(EnderecoDto::from).toList();
    }

    public static Endereco to(EnderecoDto enderecoDto) {
        return Endereco.builder()
                .id(enderecoDto.getId())
                .logradouro(enderecoDto.getLogradouro())
                .numero(enderecoDto.getNumero())
                .complemento(enderecoDto.getComplemento())
                .bairro(enderecoDto.getBairro())
                .cidade(enderecoDto.getCidade())
                .estado(enderecoDto.getEstado())
                .cep(enderecoDto.getCep())
                .build();
    }

    public static List<Endereco> to(List<EnderecoDto> enderecoDtos) {
        return enderecoDtos.stream().map(EnderecoDto::to).toList();
    }
}
