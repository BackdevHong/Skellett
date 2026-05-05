package me.limeglass.skellett.utils;

import org.bukkit.event.Event;
import org.skriptlang.skript.lang.converter.Converter;

import ch.njol.skript.registrations.EventValues;

public final class SkriptCompatibility {

	private SkriptCompatibility() {}

	public static <T, E extends Event> void registerEventValue(Class<E> eventClass, Class<T> valueClass, Converter<E, T> converter) {
		registerEventValue(eventClass, valueClass, converter, EventValues.TIME_NOW);
	}

	public static <T, E extends Event> void registerEventValue(Class<E> eventClass, Class<T> valueClass, Converter<E, T> converter, int time) {
		if (EventValues.getExactEventValueConverter(eventClass, valueClass, time) == null) {
			EventValues.registerEventValue(eventClass, valueClass, converter, time);
		}
	}
}
