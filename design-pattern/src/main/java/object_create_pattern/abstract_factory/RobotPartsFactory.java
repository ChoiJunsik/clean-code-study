package object_create_pattern.abstract_factory;

import object_create_pattern.abstract_factory.parts.Metal;
import object_create_pattern.abstract_factory.parts.NetworkModule;

public interface RobotPartsFactory {

	Metal createMetal();

	NetworkModule createNetworkModule();
}
