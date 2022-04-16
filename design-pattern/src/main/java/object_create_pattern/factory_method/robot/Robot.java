package object_create_pattern.factory_method.robot;

import object_create_pattern.abstract_factory.parts.Metal;
import object_create_pattern.abstract_factory.parts.NetworkModule;

public class Robot {

	String name;
	String logo;

	Metal metal;
	NetworkModule networkModule;

	public void setMetal(Metal metal) {
		this.metal = metal;
	}

	public void setNetworkModule(NetworkModule networkModule) {
		this.networkModule = networkModule;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public String getLogo() {
		return logo;
	}

	public Metal getMetal() {
		return metal;
	}

	public NetworkModule getNetworkModule() {
		return networkModule;
	}
}
