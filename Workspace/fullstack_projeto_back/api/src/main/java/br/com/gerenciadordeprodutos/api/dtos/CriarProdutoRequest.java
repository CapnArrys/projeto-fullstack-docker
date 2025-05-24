package br.com.gerenciadordeprodutos.api.dtos;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CriarProdutoRequest(
        @NotBlank(message = "O nome não pode estar em branco")
        @Size(max = 100, message = "O nome não pode ter mais do que 100 caracteres")
        String nome,

        @NotNull(message = "O preço é obrigatório")
        @Digits(integer = 13, fraction = 2, message = "O preço deve ter no máximo 13 digitos ")
        @DecimalMin(value = "0.0", inclusive = false, message = "O Preço deve ser maior que 0")
        BigDecimal preco,

        @Size(max = 255, message = "A descrição não pode ter mais que 255 caracteres")
        String descricao,

        @NotNull(message = "O forncedor é obrigatorio")
        Long fornecedorId

) {
}
