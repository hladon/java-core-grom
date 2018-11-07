package lesson19.lesson19hw;

public class Controller {

    public File put(Storage storage, File file) throws Exception {

        checkNull(storage, file);

        checkFormat(storage, file);

        checkSize(storage, file);

        emptySpace(storage);


        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                System.out.println("done");
                return file;
            }
        }

        return null;

    }

    public void delete(Storage storage, File file) {
        int index;
        try {
            checkNull(storage, file);
            index = findFile(storage, file.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        storage.getFiles()[index] = null;


    }

    public void transferAll(Storage storageFrom, Storage storageTo) {
        int transferFiles = 0;
        try {
            if (storageFrom == null || storageTo == null) {
                throw new Exception("no prescribed  storages ");
            }
            if (storageFrom.getId() == storageTo.getId()) {
                throw new Exception(" storages are the same");
            }
            for (File transfer : storageFrom.getFiles()) {
                if (transfer != null) {
                    transferFiles++;
                }

            }

            if (emptySpace(storageTo) < transferFiles) {
                throw new Exception("not enougth space in storage " + storageTo.getId() + "array");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        for (File transfer : storageFrom.getFiles()) {
            if (transfer != null) {
                transferFile(storageFrom, storageTo, transfer.getId());
            }

        }

    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {
        int transferIndex;
        try {
            if (storageFrom == null || storageTo == null) {
                throw new Exception("no prescribed  storages ");
            }
            transferIndex = findFile(storageFrom, id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        try {
            put(storageTo, storageFrom.getFiles()[transferIndex]);
        } catch (Exception e) {

        }


    }

    private void checkNull(Storage storage, File file) throws Exception {
        if (storage == null || file == null) {
            throw new Exception("no prescribed file or storage ");
        }
    }

    private void checkFormat(Storage storage, File file) throws Exception {
        boolean check = false;
        if (file.getName().length() > 10) {
            throw new Exception("file " + file.getId() + " can not have such name in storage " + storage.getId());
        }
        for (String format : storage.getFormatsSupported()) {
            if (format.equals(file.getFormat())) {
                check = true;
            }
        }
        if (!check) {
            throw new Exception("file " + file.getId() + " has wrong format for storage "+ storage.getId());

        }
    }

    private void checkSize(Storage storage, File file) throws Exception {
        long sizein = 0;

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null) {

                sizein += storage.getFiles()[i].getSize();
                if (storage.getFiles()[i].getId() == file.getId()) {
                    throw new Exception("file " + file.getId() + " existing in storage " + storage.getId());
                }
            }

        }
        if ((storage.getStorageSize() - sizein) < file.getSize()) {
            throw new Exception("file " + file.getId() + " to big for storage " + storage.getId());

        }

    }

    private int emptySpace(Storage storage) throws Exception {
        int emptySpace = 0;
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                emptySpace++;
            }
        }
        if (emptySpace < 1) {
            throw new Exception(" no free space in storage " + storage.getId() + " array ");
        }
        return emptySpace;
    }

    private int findFile(Storage storage, long id) throws Exception {
        File[] files = storage.getFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i] != null && files[i].getId() == id) {
                return i;
            }
        }
        throw new Exception("file " + id + "not existing in storage " + storage.getId());
    }

}
