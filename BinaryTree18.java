public class BinaryTree18 {
    Node18  root;

    public BinaryTree18 () {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }

    public void add(Mahasiswa18 mahasiswa) {
        Node18 newNode = new Node18(mahasiswa);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node18  current = root;
            Node18  parent = null;
            while (true) {
                parent = current;
                if (mahasiswa.ipk < current.mahasiswa.ipk) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    boolean find(double ipk) {
        boolean result = false;
        Node18  current = root;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.mahasiswa.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    void traversePreOrder(Node18  node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traverseInOrder(Node18  node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    void traversePostOrder(Node18  node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    Node18 GetSuccessor(Node18  del) {
        Node18 successor = del.right;
        Node18 successorParent = del;

        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }

        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Binary tree kosong.");
            return;
        }

        Node18  parent = root;
        Node18  current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.mahasiswa .ipk == ipk) {
                break;
            } else if (ipk < current.mahasiswa.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (ipk > current.mahasiswa.ipk) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;
        } else {
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
                
            } else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else {
                Node18  successor = GetSuccessor(current);
                System.out.println("Jika 2 anak, current = ");
                successor.mahasiswa.tampilInformasi();
                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
                successor.left = current.left;
            }
        }
    }
    // jawaban tugas nomer 1
    public Node18 addRekursif(Node18 current, Mahasiswa18 data) {
        if (current == null) {
            return new Node18(data);
        }
        if (data.ipk < current.mahasiswa.ipk) {
            current.left = addRekursif(current.left, data);
        } else {
            current.right = addRekursif(current.right, data);
        }
        return current;
    }

    // jawaban tugas nomer 1
    public void addRekursif(Mahasiswa18 data) {
        root = addRekursif(root, data);
    }

    // jawaban tugas nomer 2
    public Mahasiswa18 cariMinIPK() {
        if (isEmpty()) return null;
        Node18 current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.mahasiswa;
    }

    // jawaban tugas nomer 2
    public Mahasiswa18 cariMaxIPK() {
        if (isEmpty()) return null;
        Node18 current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.mahasiswa;
    }

    // jawaban tugas nomer 3
    public void tampilMahasiswaIPKdiAtas(Node18 node, double ipkBatas) {
        if (node != null) {
            tampilMahasiswaIPKdiAtas(node.left, ipkBatas);
            if (node.mahasiswa.ipk > ipkBatas) {
                node.mahasiswa.tampilInformasi();
            }
            tampilMahasiswaIPKdiAtas(node.right, ipkBatas);
        }
    }

    // jawaban tugas nomer 3
    public void tampilMahasiswaIPKdiAtas(double ipkBatas) {
        tampilMahasiswaIPKdiAtas(root, ipkBatas);
    }
    
}