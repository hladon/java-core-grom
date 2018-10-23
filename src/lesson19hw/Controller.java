package lesson19hw;

public class Controller {
    public void put (Storage storage, File file){
        try{
            checkFormat(storage,file);
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
            return;
        }

    }
    public void delete (Storage storage, File file){

    }
    public void transferAll(Storage storageFrom, Storage storageTo){

    }
    public void transferFile(Storage storageFrom, Storage storageTo,long id){

    }
    private  void checkFormat  (Storage storage, File file){
        boolean check=false;
        for (String format: storage.getFormatsSupported()){
            if (format.equals(file.getFormat())) {
                check=true;
            }
        }
        if(!check){
            throw new RuntimeException("file"+ file.getId()+"has wrong format");
        }
    }
    private  void checkSize  (Storage storage, File file){
        long size=0;
        for (File fileIn: storage.getFiles()){
            if(fileIn!=null){
                size+=fileIn.getSize();
            }
        }
        if((storage.getStorageSize()-size)< file.getSize()){
            throw new RuntimeException("file"+ file.getId()+"to big for storage"+storage.getId());
        }

    }


}
