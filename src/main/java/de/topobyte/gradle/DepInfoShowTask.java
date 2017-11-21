// Copyright 2017 Sebastian Kuerten
//
// This file is part of gradle-dependency-info-plugin.
//
// gradle-dependency-info-plugin is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// gradle-dependency-info-plugin is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with gradle-dependency-info-plugin. If not, see <http://www.gnu.org/licenses/>.

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
