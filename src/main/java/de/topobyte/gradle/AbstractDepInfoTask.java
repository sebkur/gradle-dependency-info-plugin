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

import org.gradle.api.internal.ConventionTask;
import org.gradle.api.logging.Logger;

public abstract class AbstractDepInfoTask extends ConventionTask
{

	protected final Logger logger = getLogger();

	protected DepInfoPluginExtension configuration;

	public DepInfoPluginExtension getConfiguration()
	{
		return configuration;
	}

	public void setConfiguration(DepInfoPluginExtension configuration)
	{
		this.configuration = configuration;
	}

}