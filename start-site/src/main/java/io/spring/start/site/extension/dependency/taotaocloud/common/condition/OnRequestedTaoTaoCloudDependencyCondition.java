package io.spring.start.site.extension.dependency.taotaocloud.common.condition;

import io.spring.initializr.generator.condition.ProjectGenerationCondition;
import io.spring.initializr.generator.project.ProjectDescription;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Set;

public class OnRequestedTaoTaoCloudDependencyCondition extends ProjectGenerationCondition {

	@Override
	protected boolean matches(ProjectDescription description, ConditionContext context,
							  AnnotatedTypeMetadata metadata) {
		String id = (String) metadata.getAnnotationAttributes(ConditionalOnRequestedTaoTaoCloudDependency.class.getName())
			.get("value");
		Set<String> keySet = description.getRequestedDependencies().keySet();
		for (String key : keySet) {
			if(key.contains(id)){
				return true;
			}
		}
		return false;
	}

}
