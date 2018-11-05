package com.learn.arithmetic.tree;

/**
 * Created by hechao on 2017/7/13.
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        Tree tree = createTree();
//        System.out.println("\n中序");
//        inorderTreeWalk(com.learn.arithmetic.tree.root);
//        System.out.println("\n先序");
//        preorderTreeWalk(com.learn.arithmetic.tree.root);
//        System.out.println("\n后序");
//        postorderTreeWalk(com.learn.arithmetic.tree.root);


        System.out.println("搜索5");
        System.out.println(search2(tree.root,7));
        System.out.println("最左边的值即使最小的值");
        System.out.println(minimum(tree.root));
        System.out.println("最右边的值即使最大的值");
        System.out.println(maximum(tree.root));



    }

    static class Tree {
        Node root;
        Tree(Node r) {
            this.root = r;
        }
    }

    static class Node{
        int key;
        Node left;
        Node right;
        Node p;

        Node(int k,Node l,Node r,Node p) {
            this.key = k;
            this.left = l;
            this.right = r;
            this.p = p;
        }
    }

    // 中序遍历二叉搜索树
    static void inorderTreeWalk(Node T) {
        Node x = T;
        if (x != null) {
            inorderTreeWalk(x.left);
            System.out.print(x.key + " ");
            inorderTreeWalk(x.right);
        }
    }

    // 先序遍历二叉搜索树
    static void preorderTreeWalk(Node T) {
        Node x = T;
        if (x != null) {
            System.out.print(x.key + " ");
            preorderTreeWalk(x.left);
            preorderTreeWalk(x.right);
        }
    }

    // 后序遍历二叉搜索树
    static void postorderTreeWalk(Node T) {
        Node x = T;
        if (x != null) {
            postorderTreeWalk(x.left);
            postorderTreeWalk(x.right);
            System.out.print(x.key + " ");
        }
    }

    static Tree createTree() {
        Tree tree = new Tree(null);
        insert(tree,6);
        insert(tree,8);
        insert(tree,5);
        insert(tree,1);
        insert(tree,7);
        insert(tree,3);
        insert(tree,2);
        insert(tree,4);
        insert(tree,0);
        return tree;
    }

    static void insert(Tree T,int key) {
        // 创建新的节点
        Node z = new Node(key,null,null,null);
        // 搜索该节点应该插入哪个位置
        Node y = null;
        Node x = T.root;
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.p = y;
        // 插入节点
        if (y == null) {
            T.root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

    static int search1(Node root,int key) {
        Node x = root;
        if (x == null) {
            return -1;
        } else if (key == x.key) {
            return key;
        }

        if (key < x.key) {
            return search1(x.left,key);
        } else {
            return search1(x.right,key);
        }
    }

    static int search2(Node root,int key) {
        Node x = root;
        while (x != null && key != x.key) {
            if (key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        if (x == null) {
            return -1;
        } else {
            return key;
        }
    }

    static int minimum(Node root) {
        Node x = root;
        while (x.left != null) {
            x = x.left;
        }
        return x.key;
    }

    static int maximum(Node root) {
        Node x = root;
        while (x.right != null) {
            x = x.right;
        }
        return x.key;
    }






}
