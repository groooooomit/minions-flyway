package minions.flyway.core;

import minions.flyway.core.dao.base.Operator;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * Entity 操作记录
 */
@Configuration
public class JpaConfig implements AuditorAware<Operator> {

	@NonNull
	@Override
	public Optional<Operator> getCurrentAuditor() {
		final Operator operator = new Operator();
		operator.setId(100L);
		operator.setName("付博");
		return Optional.of(operator);
	}

}
