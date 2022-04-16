	package object_create_pattern.abstract_factory;

	import object_create_pattern.abstract_factory.parts.HighPriceMetal;
	import object_create_pattern.abstract_factory.parts.HighPriceNetworkModule;
	import object_create_pattern.abstract_factory.parts.Metal;
	import object_create_pattern.abstract_factory.parts.NetworkModule;

	public class HighPricePartsFactory implements RobotPartsFactory{

		@Override
		public Metal createMetal() {
			return new HighPriceMetal();
		}

		@Override
		public NetworkModule createNetworkModule() {
			return new HighPriceNetworkModule();
		}
	}
