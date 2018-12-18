package com.ab.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestMachineLearning {

	public static void main(String[] args) {
		String inputText = "The word engine derives from Old French engin, from the Latin ingenium–the root of the word ingenious. Pre-industrial weapons of war, such as catapults, trebuchets and battering rams, were called siege engines, and knowledge of how to construct them was often treated as a military secret. The word gin, as in cotton gin, is short for engine. Most mechanical devices invented during the industrial revolution were described as engines—the steam engine being a notable example. However, the original steam engines, such as those by Thomas Savery, were not mechanical engines but pumps. In this manner, a fire engine in its original form was merely a water pump, with the engine being transported to the fire by horses. In modern usage, the term engine typically describes devices, like steam engines and internal combustion engines, that burn or otherwise consume fuel to perform mechanical work by exerting a torque or linear force (usually in the form of thrust). Devices converting heat energy into motion are commonly referred to simply as engines.[3] Examples of engines which exert a torque include the familiar automobile gasoline and diesel engines, as well as turboshafts. Examples of engines which produce thrust include turbofans and rockets.When the internal combustion engine was invented, the term motor was initially used to distinguish it from the steam engine—which was in wide use at the time, powering locomotives and other vehicles such as steam rollers. The term motor derives from the Latin verb moto which means to set in motion, or maintain motion. Thus a motor is a device that imparts motion.Motor and engine later came to be used largely interchangeably in casual discourse. However, technically, the two words have different meanings. An engine is a device that burns or otherwise consumes fuel, changing its chemical composition, whereas a motor is a device driven by electricity, air, or hydraulic pressure, which does not change the chemical composition of its energy source.[4][5] However, rocketry uses the term rocket motor, even though they consume fuel.A heat engine may also serve as a prime mover—a component that transforms the flow or changes in pressure of a fluid into mechanical energy.[6] An automobile powered by an internal combustion engine may make use of various motors and pumps, but ultimately all such devices derive their power from the engine. Another way of looking at it is that a motor receives power from an external source, and then converts it into mechanical energy, while an engine creates power from pressure (derived directly from the explosive force of combustion or other chemical reaction, or secondarily from the action of some such force on other substances such as air, water, or steam)";
		String[] splits = inputText.split("\\.| |\\)|\\(|,|;|:|\\d|[|]");
		Map<String, Integer> keyCountMap = new HashMap<String, Integer>();

		splits = Arrays.asList(splits).stream().map(String::toLowerCase).toArray(String[]::new);
		for (String s : splits) {
			if (s.isEmpty())
				continue;
			if (keyCountMap.containsKey(s))
				keyCountMap.put(s, keyCountMap.get(s) + 1);
			else
				keyCountMap.put(s, 1);
		}

		System.out.println(keyCountMap);
	}
}
