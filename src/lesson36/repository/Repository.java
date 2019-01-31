package lesson36.repository;


import lesson36.model.IdEntity;

import java.io.*;
import java.util.*;


public class Repository {
    protected  String repositoryLocation;

    protected <T> T convert(String line) throws Exception {
        return null;
    }

    public Repository(String repositoryLocation) {
        this.repositoryLocation = repositoryLocation;
    }

    public List getList() throws Exception {
        List list = new ArrayList();
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

    public <T> void save(List<T> list) throws IOException {
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

    public <T extends IdEntity> T findById(long id) throws Exception {
        List<T> list = getList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)!=null&&list.get(i).getId() == id)
                return list.get(i);
        }
        return null;
    }

    public <T> T add(T profile) throws Exception {
        if (profile==null)
            return null;
        if (profile == null)
            return null;
        List<T> list = getList();
        list.add(profile);
        save(list);
        return profile;
    }

    public <T> void delete(long id) throws Exception {
        List<T> list = getList();
        list.remove(findById(id));
        save(list);
    }


}
