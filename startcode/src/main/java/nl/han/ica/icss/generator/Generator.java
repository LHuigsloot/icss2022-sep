package nl.han.ica.icss.generator;


import nl.han.ica.icss.ast.AST;
import nl.han.ica.icss.ast.ASTNode;
import nl.han.ica.icss.ast.Declaration;
import nl.han.ica.icss.ast.Stylerule;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.selectors.ClassSelector;
import nl.han.ica.icss.ast.selectors.IdSelector;
import nl.han.ica.icss.ast.selectors.TagSelector;

public class Generator {

	String string;

	public String generate(AST ast) {
		string = "";
		return printer(ast.root);
	}

	private String printer(ASTNode node){
		for(ASTNode stylerule : node.getChildren()) {
			if (stylerule instanceof Stylerule) {
				for (ASTNode selectors : ((Stylerule) stylerule).selectors){
					if(selectors instanceof ClassSelector){
						string += ((ClassSelector) selectors).cls;
					} else if(selectors instanceof IdSelector){
						string += ((IdSelector) selectors).id;
					} else if(selectors instanceof TagSelector){
						string += ((TagSelector) selectors).tag;
					}
				}
				string += " {";
				string += "\n";
				for (ASTNode declaration : stylerule.getChildren()) {
					if (declaration instanceof Declaration) {
						string += "  ";
						string += ((Declaration) declaration).property.name;
						string += ": ";
						if(((Declaration) declaration).expression instanceof PixelLiteral){
							string += ((PixelLiteral) ((Declaration) declaration).expression).value;
							string += "px";
						}
						if(((Declaration) declaration).expression instanceof PercentageLiteral){
							string += ((PercentageLiteral) ((Declaration) declaration).expression).value;
							string += "%";
						}
						if(((Declaration) declaration).expression instanceof ColorLiteral){
							string += ((ColorLiteral) ((Declaration) declaration).expression).value;
						}
						string += ";\n";
					}
				}
				string += "}";
				string += "\n";
			}
		}
		return string;
	}
}
