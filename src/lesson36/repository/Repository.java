package lesson36.repository;


import lesson36.Exceptions.ExistInRepository;
import lesson36.model.IdEntity;

import java.io.*;
import java.util.*;


public abstract class Repository <T extends IdEntity>{
    protected  String repositoryLocation;

    abstract   T convert(String line) throws Exception;


    public Repository(String repositoryLocation) {
        this.repositoryLocation = repositoryLocation;
    }

    public List<T> getList() throws Exception {
        List<T> list = new ArrayList();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(repositoryLocation))) {
            while ((line = br.readLine()) != null) {
                if(line.isEmpty())
                    continue;
                list.add(convert(line));
            }
        } catch (IOException io) {
            throw new IOException("File " + repositoryLocation + " are missing");
        }
        return list;
    }

    public  void changeData(List<T> list) throws IOException {
        if (list==null)
            return;
        StringBuffer stringList = new StringBuffer();
        for (T line : list) {
            stringList.append(line.toString());
            stringList.append("\n");
        }
        try (BufferedWriter br = new BufferedWriter(new FileWriter(repositoryLocation, false))) {
            br.write(String.valueOf(stringList));
        } catch (IOException io) {
            throw new IOException("File " + repositoryLocation + " not exist!");
        }
    }

    public  T findById(long id) throws Exception {
        List<T> list = getList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)!=null&&list.get(i).getId() == id)
                return list.get(i);
        }
        return null;
    }

    public  T save(T profile) throws Exception {
        if (profile==null)
            return null;
        if (findById(profile.getId())!=null)
            throw new ExistInRepository();
        try (BufferedWriter br = new BufferedWriter(new FileWriter(repositoryLocation, true))) {
            br.append(profile.toString());
        } catch (IOException io) {
            throw new IOException("File " + repositoryLocation + " not exist!");
        }
        return profile;

    }

    public  void delete(long id) throws Exception {
        List<T> list = getList();
        list.remove(findById(id));
        changeData(list);
    }


}
