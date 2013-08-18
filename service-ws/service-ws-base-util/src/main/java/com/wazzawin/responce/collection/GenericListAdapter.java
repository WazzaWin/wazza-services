package com.wazzawin.responce.collection;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "List")
public class GenericListAdapter<T> implements Serializable {

    private static final long serialVersionUID = -9002627076906911672L;
    protected List<T> list;

    public GenericListAdapter() {
    }

    public GenericListAdapter(List<T> list) {
        this.list = list;
    }

    @XmlElement(name = "Item")
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
