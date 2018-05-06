package ru.sm1le.util;

public class TextBuilder {

	private String outText;
	
	public TextBuilder(String text) {
		this(text, new Object[0]);
	}
	
	public TextBuilder(String text, Object... replaces) {
		String currentText = text;
		for(int i = 0; i<replaces.length; i++) {
			currentText = currentText.replace("{" + i + "}", String.valueOf(replaces[i]));
		}
		outText = currentText;
	}
	
	public TextBuilder append(String appendText) {
		outText = outText + appendText;
		return this;
	}
	
	public TextBuilder prefix(String prefixText) {
		outText = prefixText + outText;
		return this;
	}
	
	public TextBuilder clone() {
		return new TextBuilder(outText);
	}
	
	public TextBuilder reset() {
		outText = "";
		return this;
	}
	
	public TextBuilder replace(Object... replaces) {
		outText = new TextBuilder(outText, replaces).outText;
		return this;
	}
	
	@Override
	public String toString() {
		return outText;
	}
}
