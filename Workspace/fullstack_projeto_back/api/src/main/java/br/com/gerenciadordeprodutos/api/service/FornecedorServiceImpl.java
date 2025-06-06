package br.com.gerenciadordeprodutos.api.service;

import br.com.gerenciadordeprodutos.api.dtos.CriarFornecedorRequest;
import br.com.gerenciadordeprodutos.api.dtos.FornecedorCriadoResponse;
import br.com.gerenciadordeprodutos.api.model.Endereco;
import br.com.gerenciadordeprodutos.api.model.Fornecedor;
import br.com.gerenciadordeprodutos.api.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    FornecedorRepository fornecedorRepository;


    @Override
    public FornecedorCriadoResponse criarFornecedor(CriarFornecedorRequest criarFornecedorRequest) {
        Endereco endereco = new Endereco(
                null,
                criarFornecedorRequest.endereco().logradouro(),
                criarFornecedorRequest.endereco().numero(),
                criarFornecedorRequest.endereco().complemento(),
                criarFornecedorRequest.endereco().bairro(),
                criarFornecedorRequest.endereco().cidade(),
                criarFornecedorRequest.endereco().estado(),
                criarFornecedorRequest.endereco().pais(),
                criarFornecedorRequest.endereco().cep()
        );

        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setNome(criarFornecedorRequest.nome());
        fornecedor.setCnpj(criarFornecedorRequest.cnpj());
        fornecedor.setEmail(criarFornecedorRequest.email());
        fornecedor.setTipoFornecedor(criarFornecedorRequest.tipoFornecedor());
        fornecedor.setCriadoEm(LocalDateTime.now());
        fornecedor.setEndereco(endereco);

        Fornecedor fornecedorCriado = fornecedorRepository.save(fornecedor);

        return new FornecedorCriadoResponse(
                 "Fornecedor criado com sucesso!",
                fornecedorCriado.getId()
        );

    }

    @Override
    public Fornecedor buscarFornecedorPeloId(Long id) {
       return fornecedorRepository.findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado."));

    }

    @Override
    public List<Fornecedor> buscarTodosFornecedores() {
        return fornecedorRepository.findAll();
    }

    @Override
    public Fornecedor atualizarFornecedor(Long id, CriarFornecedorRequest criarFornecedorRequest) {
        Fornecedor fornecedorExistente = fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado."));

        Endereco endereco = fornecedorExistente.getEndereco();
        if (endereco == null) {
            endereco = new Endereco();
        }

        endereco.setLogradouro(criarFornecedorRequest.endereco().logradouro());
        endereco.setNumero(criarFornecedorRequest.endereco().numero());
        endereco.setComplemento(criarFornecedorRequest.endereco().complemento());
        endereco.setBairro(criarFornecedorRequest.endereco().bairro());
        endereco.setCidade(criarFornecedorRequest.endereco().cidade());
        endereco.setEstado(criarFornecedorRequest.endereco().estado());
        endereco.setPais(criarFornecedorRequest.endereco().pais());
        endereco.setCep(criarFornecedorRequest.endereco().cep());

        fornecedorExistente.setNome(criarFornecedorRequest.nome());
        fornecedorExistente.setCnpj(criarFornecedorRequest.cnpj());
        fornecedorExistente.setEmail(criarFornecedorRequest.email());
        fornecedorExistente.setTipoFornecedor(criarFornecedorRequest.tipoFornecedor());
        fornecedorExistente.setEndereco(endereco);

        return fornecedorRepository.save(fornecedorExistente);
    }

    public void excluirFornecedorPeloId(Long id) {
        Fornecedor fornecedorExistente = fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado."));
        fornecedorRepository.delete(fornecedorExistente);
        //fornecedorRepository.deleteById(fornecedorExistente.getId());
    }



}
