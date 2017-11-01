package de.topobyte.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.logging.Logger;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.plugins.WarPlugin;

public class DepInfoPlugin implements Plugin<Project>
{

	@Override
	public void apply(final Project project)
	{
		Logger logger = project.getLogger();
		logger.info("applying dependency info plugin");

		if (!project.getPlugins().hasPlugin(JavaPlugin.class)
				&& !project.getPlugins().hasPlugin(WarPlugin.class)) {
			logger.error("Please enable java or war plugin.");
			throw new IllegalStateException("No java or war plugin detected.");
		}

		DepInfoPluginExtension extension = project.getExtensions()
				.create("depinfo", DepInfoPluginExtension.class);

		DepInfoShowTask task = project.getTasks().create("depinfo",
				DepInfoShowTask.class);
		task.setConfiguration(extension);
	}

}
