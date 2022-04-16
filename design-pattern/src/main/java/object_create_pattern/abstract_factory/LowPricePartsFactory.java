package object_create_pattern.abstract_factory;

import object_create_pattern.abstract_factory.parts.LowPriceMetal;
import object_create_pattern.abstract_factory.parts.LowPriceNetworkModule;
import object_create_pattern.abstract_factory.parts.Metal;
import object_create_pattern.abstract_factory.parts.NetworkModule;

public class LowPricePartsFactory implements RobotPartsFactory{

	@Override
	public Metal createMetal() {
		return new LowPriceMetal();
	}

	@Override
	public NetworkModule createNetworkModule() {
		return new LowPriceNetworkModule();
	}
}
