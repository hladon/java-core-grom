package lesson19hw;

public class Controller {
    public void put(Storage storage, File file) {
        try {
            checkNull(storage, file);
            checkFormat(storage, file);
            checkSize(storage, file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
            }
        }

    }

    public void delete(Storage storage, File file) {

        try {
            checkNull(storage, file);
            findFile(storage,file);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        storage.getFiles()[0]=null;

    }

    public void transferAll(Storage storageFrom, Storage storageTo) {

    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {

    }

    private void checkNull(Storage storage, File file) throws Exception {
        if (storage == null || file == null) {
            throw new Exception("no prescribed file or storage ");
        }
    }

    private void checkFormat(Storage storage, File file) throws Exception {
        boolean check = false;
        if (file.getName().length() > 10) {
            throw new Exception("file " + file.getId() + " can not have such name");
        }
        for (String format : storage.getFormatsSupported()) {
            if (format.equals(file.getFormat())) {
                check = true;
            }
        }
        if (!check) {
            throw new Exception("file " + file.getId() + " has wrong format");

        }
    }


    private void checkSize(Storage storage, File file) throws Exception {
        long sizein = 0;
        boolean emptySpace = false;
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                emptySpace = true;
            } else {
                sizein += storage.getFiles()[i].getSize();
                if (storage.getFiles()[i].getId() == file.getId()) {
                    throw new Exception("file " + file.getId() + " existing in storage " + storage.getId());
                }
            }
        }
        if ((storage.getStorageSize() - sizein) < file.getSize()) {
            throw new Exception("file " + file.getId() + " to big for storage " + storage.getId());

        }
        if (!emptySpace) {
            throw new Exception(" no free space in storage " + storage.getId() + " array ");
        }
    }
    private void findFile(Storage storage, File file) throws Exception{
        File[] files=storage.getFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i]!=null&& files[i].getId()==file.getId()){
                return;
            }

        }
        throw new Exception("file " + file.getId() + "not existing in storage " + storage.getId());
    }

}
