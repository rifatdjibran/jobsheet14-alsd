public class BinaryTreeArray18 {
    Mahasiswa18[] dataMahasiswa;
    int idxLast;

    public BinaryTreeArray18() {
        this.dataMahasiswa = new Mahasiswa18[10];
    }

    void populateData(Mahasiswa18[] dataMhs, int idxLast) {
        this.dataMahasiswa = dataMhs;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                traverseInOrder(2 * idxStart + 1); 
                dataMahasiswa[idxStart].tampilInformasi();
                traverseInOrder(2 * idxStart + 2); 
            }
        }
    }

    // jawaban tugas nomer 4
    public void add(Mahasiswa18 data) {
        if (idxLast < dataMahasiswa.length - 1) {
            idxLast++;
            dataMahasiswa[idxLast] = data;
        } else {
            System.out.println("Tree penuh, tidak bisa menambahkan data.");
        }
    }

    // jawaban tugas nomer 4
    void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast && dataMahasiswa[idxStart] != null) {
            dataMahasiswa[idxStart].tampilInformasi();
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }
}