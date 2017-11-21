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