package app;


import java.util.List;

/**
 * @author Kalitko.Evgeny
 */
public class Main {

	public static void main(String[] args) {
		int maxTreeDepth = getMaxTreeDepth(NodeImpl.testCase01());
		System.out.println(maxTreeDepth);
	}

	private static int getMaxTreeDepth(Node arbitraryNode) {
		return calcLastNodeIndex(getRootNode(arbitraryNode), 0);
	}

	private static Node getRootNode(Node arbitraryNode) {
		Node parent = arbitraryNode.getParent();
		if (parent == null) {
			return arbitraryNode;
		}
		while (parent.getParent() != null) {
			parent = parent.getParent();
		}
		return parent;
	}

	private static int calcLastNodeIndex(Node rootNode, int currentNodeIndex) {
		int maxNodeIndex = currentNodeIndex;
		List<Node> children = rootNode.getChildren();

		for (Node child : children) {
			currentNodeIndex++;
			if (currentNodeIndex > maxNodeIndex) {
				maxNodeIndex = currentNodeIndex;
			}
			maxNodeIndex = Math.max(calcLastNodeIndex(child, currentNodeIndex), maxNodeIndex);
			currentNodeIndex--;
		}
		return maxNodeIndex;
	}

}
