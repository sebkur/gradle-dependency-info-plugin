package de.topobyte.gradle;

import java.util.SortedSet;

import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.DependencySet;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.tasks.TaskAction;

public class DepInfoShowTask extends AbstractDepInfoTask
{

	public DepInfoShowTask()
	{
		dependsOn(JavaPlugin.CLASSES_TASK_NAME);
		setGroup("info");
	}

	@TaskAction
	protected void showInfo()
	{
		Project project = getProject();

		if (configuration.isDebug()) {
			SortedSet<String> names = project.getConfigurations().getNames();
			for (String name : names) {
				logger.lifecycle("configuration: " + name);
			}
		}

		String configName = getConfiguration().getConfiguration();

		Configuration configuration = project.getConfigurations()
				.getByName(configName);
		DependencySet dependencies = configuration.getAllDependencies();
		dependencies.all(d -> {
			String group = d.getGroup();
			String artifact = d.getName();
			String version = d.getVersion();
			logger.lifecycle(
					String.format("%s:%s:%s", group, artifact, version));
		});
	}

}
