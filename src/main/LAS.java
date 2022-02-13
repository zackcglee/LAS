package main;

import java.io.File;
import java.io.IOException;

import script.ScriptGenerator;
import script.model.EditOp;
import script.model.EditScript;
import tree.Tree;
import tree.TreeBuilder;

public class LAS {

	public static void main(String[] args) {
		File a, b;
		System.setProperty("las.dist.threshold", "0.5");
		System.setProperty("las.depth.threshold", "3");
		if(args.length == 0) {
			System.err.println("LAS argument not satisfied");
			System.exit(-1);
		}
			a = new File(args[0]);
			b = new File(args[1]);

		try {
			Tree before = TreeBuilder.buildTreeFromFile(a);
			Tree after = TreeBuilder.buildTreeFromFile(b);

			EditScript script = ScriptGenerator.generateScript(before, after);
			//			System.out.println(script);
			for(EditOp op : script.getEditOps()){
				System.out.println(op);
			}
			System.out.println(script.exactMatch);
			System.out.println(script.exactMatchCount);


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
