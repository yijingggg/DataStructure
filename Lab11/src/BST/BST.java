package BST;

import java.util.ArrayList;

public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int size = 0;

    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) == 0)
                return true;
            current = e.compareTo(current.element) < 0 ? current.left : current.right;
        }
        return false;
    }

    public boolean insert(E e) {
        if (root == null)
            root = new TreeNode<>(e);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) == 0)
                    return false;
                parent = current;
                current = e.compareTo(current.element) < 0 ? current.left : current.right;
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = new TreeNode<>(e);
            else
                parent.right = new TreeNode<>(e);
        }
        size++;
        return true;
    }

    public int getSize() {
        return size;
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode<E> node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public E getRoot() {
        return root.element;
    }

    public E minValue() {
        TreeNode<E> min = root;
        while (min.left != null)
            min = min.left;
        return min.element;
    }

    public E maxValue() {
        TreeNode<E> max = root;
        while (max.right != null)
            max = max.right;
        return max.element;
    }

    public ArrayList<TreeNode<E>> path(E e) {
        if (root == null) return null;

        ArrayList<TreeNode<E>> path = new ArrayList<>();
        TreeNode<E> current = root;
        while (current != null) {
            path.add(current);
            if (current.element == e) break;
            current = e.compareTo(current.element) < 0 ? current.left : current.right;
        }
        return path.get(path.size() - 1).element == e ? path : null;
    }

    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) == 0) break;
            parent = current;
            current = e.compareTo(current.element) < 0 ? current.left : current.right;
        }
        if (current == null) return false;

        //Node to delete has no left child
        if (current.left == null) {
            if (parent == null) //NodeToDelete is root
                root = current.right;
            else if (e.compareTo(parent.element) < 0) //NodeToDelete is parent's left
                parent.left = current.right;
            else //NodeToDelete is parent's right
                parent.right = current.right;

        } else { // Node to delete has a left child
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;
            while (rightMost.right != null) { //find rightMost of left subtree
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element; //rightMost replace NodeToDelete

            if (parentOfRightMost.left == rightMost)
                parentOfRightMost.left = rightMost.left;
            else
                parentOfRightMost.right = rightMost.left;
        }
        size--;
        return true;
    }

    public boolean clear() {
        root = null;
        size = 0;
        return true;
    }

    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
