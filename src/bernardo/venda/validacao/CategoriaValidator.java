package bernardo.venda.validacao;

import bernardo.venda.pojo.Categoria;

import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static javax.validation.Validation.buildDefaultValidatorFactory;

/**
 * Implementa componente para validar os dados da entidade <code>Mercadoria</code>.
 * <p>
 * <p>A validação ocorre através do Bean Validations, mecanismo de validação
 * padrão do Java baseado em anotações.</p>
 *
 * @author YaW Tecnologia
 */
public class CategoriaValidator implements Validator<Categoria> {

    private static ValidatorFactory factory;

    static {
        factory = buildDefaultValidatorFactory();
    }

    @Override
    public String validate(Categoria m) {
        StringBuilder sb = new StringBuilder();
        if (m != null) {
            javax.validation.Validator validator = factory.getValidator();
            Set<ConstraintViolation<Categoria>> constraintViolations = validator.validate(m);

            if (!constraintViolations.isEmpty()) {
                sb.append("Validação da Categoria\n");
                for (ConstraintViolation<Categoria> constraint : constraintViolations) {
                    sb.append(String.format("%n%s: %s", constraint.getPropertyPath(), constraint.getMessage()));
                }
            }
        }
        return sb.toString();
    }
}
